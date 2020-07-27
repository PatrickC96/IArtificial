import numpy as np
import cv2
import tkinter as tk
from PIL import Image
from PIL import ImageTk
import datetime
import os

#Set up GUI
window = tk.Tk()  #Makes main window
window.wm_title("Digital Microscope")
window.config(background="#FFFFFF")

#Graphics window
imageFrame = tk.Frame(window, width=400, height=300)
imageFrame.grid(row=0, column=0, padx=10, pady=2)

#Metodos de reconocimiento
#method = 'EigenFaces'
#method = 'FisherFaces'
method = 'LBPH'

if method == 'EigenFaces': emotion_recognizer = cv2.face.EigenFaceRecognizer_create()
if method == 'FisherFaces': emotion_recognizer = cv2.face.FisherFaceRecognizer_create()
if method == 'LBPH': emotion_recognizer = cv2.face.LBPHFaceRecognizer_create()

emotion_recognizer.read('modelo'+method+'.xml')
# --------------------------------------------------------------------------------

dataPath = './data'
imagePaths = os.listdir(dataPath)
print('imagePaths=',imagePaths)

faceClassif = cv2.CascadeClassifier(cv2.data.haarcascades+'haarcascade_frontalface_default.xml')
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades+'haarcascade_frontalface_default.xml')
eye_cascade = cv2.CascadeClassifier(cv2.data.haarcascades+'haarcascade_eye.xml')
smile_cascade = cv2.CascadeClassifier(cv2.data.haarcascades+'haarcascade_smile.xml')
current_image=None
cap = cv2.VideoCapture(0)

estado = False
class Application:
    def __init__(self):
        pass

def show_frame():
    _, frame = cap.read()
    frame = cv2.flip(frame, 1)    
    frame1 = frame.copy()

    #reconocimiento    
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    auxFrame = gray.copy()

    faces = faceClassif.detectMultiScale(gray,1.3,5)

    for (x,y,w,h) in faces:
        rostro = auxFrame[y:y+h,x:x+w]
        rostro = cv2.resize(rostro,(150,150),interpolation= cv2.INTER_CUBIC)
        result = emotion_recognizer.predict(rostro)

        cv2.putText(frame,'{}'.format(result),(x,y-5),1,1.3,(255,255,0),1,cv2.LINE_AA)

        # EigenFaces
        if method == 'EigenFaces':
            if result[1] < 5700:
                cv2.putText(frame,'{}'.format(imagePaths[result[0]]),(x,y-25),2,1.1,(0,255,0),1,cv2.LINE_AA)
                cv2.rectangle(frame, (x,y),(x+w,y+h),(0,255,0),2)
            else:
                cv2.putText(frame,'No identificado',(x,y-20),2,0.8,(0,0,255),1,cv2.LINE_AA)
                cv2.rectangle(frame, (x,y),(x+w,y+h),(0,0,255),2)
        
        # FisherFace
        if method == 'FisherFaces':
            if result[1] < 500:
                cv2.putText(frame,'{}'.format(imagePaths[result[0]]),(x,y-25),2,1.1,(0,255,0),1,cv2.LINE_AA)
                cv2.rectangle(frame, (x,y),(x+w,y+h),(0,255,0),2)
            else:
                cv2.putText(frame,'No identificado',(x,y-20),2,0.8,(0,0,255),1,cv2.LINE_AA)
                cv2.rectangle(frame, (x,y),(x+w,y+h),(0,0,255),2)
        
        # LBPHFace
        if method == 'LBPH':
            if result[1] < 75:
                cv2.putText(frame,'{}'.format(imagePaths[result[0]]),(x,y-25),2,1.1,(0,255,0),1,cv2.LINE_AA)
                cv2.rectangle(frame, (x,y),(x+w,y+h),(0,255,0),2)
            else:
                cv2.putText(frame,'No identificado',(x,y-20),2,0.8,(0,0,255),1,cv2.LINE_AA)
                cv2.rectangle(frame, (x,y),(x+w,y+h),(0,0,255),2)
    frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGBA)
    img = Image.fromarray(frame)
    imgtk = ImageTk.PhotoImage(image=img)    
    display1.imgtk = imgtk #Shows frame for display 1
    display1.configure(image=imgtk)
    # current_image = Image.fromarray(frame)
    # if(estado):
    #     output_path = "./"
    #     ts = datetime.datetime.now() # grab the current timestamp
    #     filename = "{}.jpg".format(ts.strftime("%Y-%m-%d_%H-%M-%S"))  # construct filename
    #     p = os.path.join(output_path, filename)  # construct output path
    #     current_image.save(p, "JPEG")  # save image as jpeg file
    #     print("[INFO] saved {}".format(filename))

    #face
    gray = cv2.cvtColor(frame1, cv2.COLOR_BGR2GRAY)
    faces = face_cascade.detectMultiScale(gray, 1.1, 5)

    for (x,y,w,h) in faces:
        cv2.rectangle(frame1,(x,y),(x+w,y+h),(255,0,0),2)
        roi_gray = gray[y:y+h, x:x+w]
        roi_color = frame1[y:y+h, x:x+w]
        eyes = eye_cascade.detectMultiScale(roi_gray,1.5,5)
        for (ex,ey,ew,eh) in eyes:
            cv2.rectangle(roi_color,(ex,ey),(ex+ew,ey+eh),(0,255,0),2)
        smile = smile_cascade.detectMultiScale(roi_gray,1.5,5)
        for (ex,ey,ew,eh) in smile:
            cv2.rectangle(roi_color,(ex,ey),(ex+ew,ey+eh),(0,0,255),2)
    frame1 = cv2.cvtColor(frame1, cv2.COLOR_BGR2RGBA)
    img = Image.fromarray(frame1)
    imgtk = ImageTk.PhotoImage(image=img)  
    display2.imgtk = imgtk #Shows frame for display 2
    display2.configure(image=imgtk)
    window.after(10, show_frame)

def take_snapshot():
    print("take photo here")
    estado=True

display1 = tk.Label(imageFrame)
display1.grid(row=0, column=0, padx=10, pady=2)  #Display 1
display2 = tk.Label(imageFrame)
display2.grid(row=0, column=1) #Display 2

#Slider window (slider controls stage position)
sliderFrame = tk.Frame(window, width=600, height=100)
sliderFrame.grid(row = 600, column=0, padx=10, pady=2)

tk.Button(window, text="Select an image", command=take_snapshot).grid(row=1,column=0)

show_frame() #Display
window.mainloop()  #Starts GUI
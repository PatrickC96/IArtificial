import numpy as np
import cv2
import tkinter as tk
from PIL import Image
from PIL import ImageTk
import datetime
import os

#esta es la ventana oficial
#Set up GUI
window = tk.Tk()  #Makes main window
window.wm_title("Digital Microscope")
window.config(background="#FFFFFF")

#Graphics window
imageFrame = tk.Frame(window, width=400, height=300)
imageFrame.grid(row=0, column=0, padx=10, pady=2)

#Capture video frames

#https://github.com/Itseez/opencv/blob/master/data/haarcascades/haarcascade_frontalface_default.xml
face_cascade = cv2.CascadeClassifier('haarcascade_frontalface_default.xml')
#https://github.com/Itseez/opencv/blob/master/data/haarcascades/haarcascade_eye.xml
eye_cascade = cv2.CascadeClassifier('haarcascade_eye.xml')
slime_cascade = cv2.CascadeClassifier('haarcascade_smile.xml')
current_image=None
cap = cv2.VideoCapture(0)

def show_frame():
    _, frame = cap.read()
    frame = cv2.flip(frame, 1)    
    cv2image = cv2.cvtColor(frame, cv2.COLOR_BGR2RGBA)
    current_image = Image.fromarray(cv2image) 
    img = Image.fromarray(cv2image)
    imgtk = ImageTk.PhotoImage(image=img)    
    display1.imgtk = imgtk #Shows frame for display 1
    display1.configure(image=imgtk)

    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    faces = face_cascade.detectMultiScale(gray, 1.1, 5)

    for (x,y,w,h) in faces:
        cv2.rectangle(frame,(x,y),(x+w,y+h),(255,0,0),2)
        roi_gray = gray[y:y+h, x:x+w]
        roi_color = frame[y:y+h, x:x+w]
        eyes = eye_cascade.detectMultiScale(roi_gray,1.5,5)
        for (ex,ey,ew,eh) in eyes:
            cv2.rectangle(roi_color,(ex,ey),(ex+ew,ey+eh),(0,255,0),2)
        smile = slime_cascade.detectMultiScale(roi_gray,1.5,5)
        for (ex,ey,ew,eh) in smile:
            cv2.rectangle(roi_color,(ex,ey),(ex+ew,ey+eh),(0,0,255),2)

    img = Image.fromarray(frame)
    imgtk = ImageTk.PhotoImage(image=img)  
    display2.imgtk = imgtk #Shows frame for display 2
    display2.configure(image=imgtk)
    window.after(10, show_frame) 

def take_snapshot():
    print("take photo here")
    # y,frame = cap.read()
    # frame = cv2.flip(frame, 1)    
    # cv2image = cv2.cvtColor(frame, cv2.COLOR_BGR2RGBA)
    # current_image = Image.fromarray(cv2image)
    # emotionsPath="/home/d/Documentos/proyectoIA/script/capturas/"
    # cv2.imwrite(emotionsPath+'rotro_{}.jpg'.format(str(10)),current_image)

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
import cv2
import os

imagesPath = "/home/d/Documentos/proyectoIA/script/recortePruebas"
imagesPathList = os.listdir(imagesPath)
#print('imagesPathList=',imagesPathList)
#crea la carptea si no existe.!!
#if not os.path.exists("recortePruebas"):
    #print('Carpeta creada: !!!!! ')
#    os.makedirs('recortePruebas')

faceClassif=cv2.CascadeClassifier(cv2.data.haarcascades+'haarcascade_frontalface_default.xml')
cuont = 0
for imageName in imagesPathList:
    #print('imageName='+imageName)
    image=cv2.imread(imagesPath+'/'+imageName)
    imageAux= image.copy()
    #cambia el color de la imagen
    gray = cv2.cvtColor(image,cv2.COLOR_BGR2GRAY)
    #para estos datos solo funciona con 1.1
    #usa haar para detectar la cara..
    faces = faceClassif.detectMultiScale(gray, 1.1,5)

    for (x,y,w,h) in faces:
        cv2.rectangle(image,(x,y),(x+w,y+h),(128,0,255),2)
    cv2.rectangle(image,(10,5),(450,25),(255,255,355),-1)
    cv2.putText(image,'Presione s, para almacenar la foto',(10,20),2,0.5,(128,0,255),1,cv2.LINE_AA)
    cv2.imshow('image',image)
    k = cv2.waitKey(0)
    if k == ord('s'):
        for (x,y,w,h) in faces:
            rostro = imageAux[y:y+h,x:x+w]
            rostro = cv2.resize(rostro,(150,150),interpolation=cv2.INTER_CUBIC)
            cv2.imwrite('encontrados/rostro_{}.jpg'.format(cuont),rostro)
            print('guardar corecto: ',cuont)
            cuont = cuont +1
    elif k==27:
        break

cv2.destroyAllWindows()
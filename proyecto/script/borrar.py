class Especie_maritima:
    vertebrado = False  # bool
    nombre_comun = None  # String
    oceano = None  # string
    promedio_vida = None  # Int
    tamanio_promedio = 0  # float

    def __init__(self, nombre_comun, oceano, promedio_vida, tamanio_promedio, vertebrado):
        self.nombre_comun = nombre_comun
        self.oceano = oceano
        self.promedio_vida = promedio_vida
        self.tamanio_promedio = tamanio_promedio
        self.vertebrado = vertebrado

    def __str__(self):
        return f"{self.nombre_comun},{self.oceano},{self.promedio_vida},{self.tamanio_promedio},{self.vertebrado}\n"
        

def menu_especies():
    while True:
        print("Menu especies \n")
        print("opciones ...")
        print("1. Agregar una especie")
        print("2. Actualizar una especie")
        print("3. Ver una especie")
        print("4. Eliminar una especie")
        print("5. Salir")
        accion = input("Escriba el numero de la accion que desea hacer: ")

        try:
            opcion = int(accion)
            if( opcion <1 or opcion > 6 ):
                print("Ingrese un numero entre 1 y 5")
                continue
            else:
                break

        except ValueError as err:
            print("ingrese un valor numerico")
            continue

    def agregar_esp():
        agregar_especie_marina()
    def actualizar():
        actualizar_especie_marina()
    def leer_esp():
        mostrar_especie_marina()
    def borrar():
        eliminar_especie_marina()
    def salir():
        exit()
    def llamada_funciones():
        opciones = {
            1:agregar_esp,
            2:actualizar,
            3:leer_esp,
            4:borrar,
            5:salir
        }


        return opciones[opcion]()

    return llamada_funciones()

def agregar_especie_marina():
    nombre_comun = input("Ingrese el nombre comun de la especie marina: ")
    oceano = input("Ingrese el nombre del oceano donde se encuentra a la especie:")
    promedio_vida = input("ingrese el promedio de vida de la especie marina: ")
    tamanio_promedio = input("ingrese el tamanio promedio de la especie marina: ")
    vertebrado = input("Escriba True en caso de que la especie sea vertebrado, caso contrario escriba False: ")
    especies.append(Especie_maritima(nombre_comun, oceano, promedio_vida, tamanio_promedio,vertebrado))

def eliminar_especie_marina():
    nombre = input("Ingrese el nombre de la especie que quiere eliminar ")
    encontrado = False
    for i in especies:
        a = i.split("-")
        if(nombre ):

            encontrado = True
            especies.remove(i)
            break
    if(encontrado ==  False):
        print("No hay esa especie")


def actualizar_especie_marina():
    nombre = input("Ingrese el nombre de la especie que quiere actualizar ")
    encontrado = False
    for i in especies:
        a = i.split("-")
        if (nombre == a[0]):
            encontrado = True
            especies.remove(i)
            agregar_especie_marina(especies)
            break
    if (encontrado == False):
        print("No hay esa especie")

def mostrar_especie_marina():
    for l in especies:
        print(l)

def escribir_archivo_especies():    
    try:
        path = "especies.txt"
        archivo_especies = open(path,'w')
        campos = ""
        for l in especies:
            campos += l.nombre_comun+";"+l.oceano+";"+l.promedio_vida+";"+l.tamanio_promedio+";"+l.vertebrado
        archivo_especies.write(campos)            
        archivo_especies.close()
    except Exception as err:
        print('eroro al escrivir1')

def leer_archivo_especies():    
    try:
        path = "especies.txt"
        archivo = open(path,'r')
        
        for l in archivo:
            e = l.split(";")
            especies.append(Especie_maritima(e[0],e[1],e[2],e[3],e[4]))
        archivo.close()
    except Exception as err:
        print(err)
        

if __name__=="__main__":
    especies = []
    #agregar_especie_marina()
    leer_archivo_especies()
    menu_especies()
    print(len(especies))
    escribir_archivo_especies()
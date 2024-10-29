def riempiLista():
    i= 0
    lung= len(valore)
    while i<lung:
        valore[i]= int(input("Inserire un valore: "))
        i= i+1
def stampaLista():
    i= 0
    lung= len(valore)
    while i<lung:
        print(valore[i])
    
    
    
def conteggio(magg):
    i= 0
    conteggio= 0
    lung= len(valore)
    while i<lung:
        if valore[i] < magg:
            i= i+1
        else:
            conteggio= conteggio+1
            i= i+1
    return conteggio
    
    
#MAIN
dimensione= int(input("Inserire la dimensione della lista: "))
valore= [None]*dimensione
x= 5
riempiLista()
stampaLista
conteggio(x)
print(conteggio)
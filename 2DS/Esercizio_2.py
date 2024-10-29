'''Esercizio 2'''
import random

def riempiLista(lung,rang):
    i = 0
    while i<lung: 
        lista[i] = random.randint(1,rang)
        i = i + 1
        
def stampaLista(lung):
    i = 0
    print("Lista di valori: ")
    while i<lung:
        print(lista[i], end=" ")
        i = i + 1
        

def numeriMagg(lung,x):
    i = 0
    xnum = 0
    print()
    while i<lung:
        if lista[i]>x:
            xnum = xnum + 1
            i = i + 1
        else:
            i = i + 1
    print("Numero di valori maggiori rispetto al numero inserito: ",xnum)
    

def numeriPari(lung):
    i = 0
    xpari = 0
    pari = lista
    while i<lung:
        if lista[i]%2==0:
            print(pari[i], end=" ")
            i = i + 1
        else:
            i = i + 1
            
def listaContrario(lung):
    i = 0
    count = -1
    while i<lung:
        print(lista[count], end=" ")
        i = i + 1
        count = count - 1
    

def numeriPosiPari(lung,xpari):
    i = 0
    while i<lung:
        if xpari%2==0:
            print(lista[xpari], end=" ")
            xpari = xpari + 1
        else:
            xpari = xpari + 1
        i = i + 1
    
    
    
            
def numeroMagg():
    magg = 0
    magg = max(lista)
    print(magg)
    
def numeroMin():
    mino = 0
    mino = min(lista)
    print(mino)

# bisogna convertire l'input da tastiera in (int) perchè altrimenti il programma prende quel valore come un carattere, non come un  numero

#MAIN

lung = int(input("Inserire la quantità di valori da inserire: "))

lista = [None]*lung
pari = [None]*lung

rang = int(input("Inserire il range massimo di numeri inseriti nella lista: "))
riempiLista(lung,rang)

stampaLista(lung)

print()
print("(Numeri maggiori)")
x = int(input("Inserisci un valore: "))
numeriMagg(lung,x)

print()
print("(Numeri pari)")
numeriPari(lung)

print()
print("(Lista inversa)")
listaContrario(lung)

print()
print("(Numeri posizione pari)")
xpari = 0
numeriPosiPari(lung,xpari)

print()
print("(Numero maggiore della lista)")
numeroMagg()

print()
print("(Numero minore della lista)")
numeroMin()
                                                                                                       
#DEFINIZIONE DI UNA LISTA VUOTA

def riempiLista(lunghezza):
    i= 0                  #indice
    while i<lunghezza:                            #Ciclo (Struttura Iterativa, precondizionata) che permette di aquisire da tastiera i valori e memorizzarli nelle posizioni della lista
                                                  #Le posizioni vanno da i= 0 a i= 4
        
        lista[i]= int(input("Inserire valore: ")) #Istruzione di assegnazione del valore acquisito da tastiera e memorizzato alla posizione i
        i= i+1                                    #Incremento della variabile indice per spostarsi alla cella di memoria successiva della lista
                                                  #Asseganzione
                    
def stampaLista(lunghezza):
    i= 0                  #indice
    while i<lunghezza:    
        print (" -", lista[i])  
                          
        i= i+1             

def ricercaValore(valoreDaCercare, lunghezza):   #I parametri formali sono delle copie dei parametri attuali, quindi non necessita lo stesso nome 
    i= 0                  #indice
    trovato= False                               #Ricerco il valore all'interno della lista e esco dal ciclo appena lo trovo almeno una volta
                                                 #Se non viene trovato, si scorre tutta la lista 
    
    while i<lunghezza and trovato==False:
        if (lista[i] == valoreDaCercare):
            trovato= True
        i= i+1
    return trovato

#MAIN

dimensione= int(input("Inserisci la dimensione della lista: "))           #LISTA: Celle contigue di memoria RAM
lista= [None]*dimensione  #Definisco una lista di lunghezza "dimensione"    #Le liste sono considerate funzioni GLOBALI
                          #Le posizioni vanno da 0 a 4
lunghezza= len(lista)     #lunghezza della lista  #La funzione len() retituisce la lunghezza della lista

riempiLista(lunghezza)       #Parametro attuale
print ("LISTA INIZIALE: ")

stampaLista(lunghezza)

valoreDaCercare= int(input("Inserire il valore da cercare: ")) #Aquisizione da tatiera il valore da cercare


risposta= ricercaValore(valoreDaCercare, lunghezza)            #Memorizzo nella variabile "risposta" il valore restituito dalla funzione ricercaValore()
                                                               #I valori che può restituire la funzione sono True o False
                                                               #Alla funzione ricercaValori passo i due parametri attuali: lunghezza e valoreDaCercare
                                                             
if (risposta == True):
    print ("Il valore", valoreDaCercare, "è stato trovato")
else:
    print ("Il valore", valoreDaCercare, "non è stato trovato")






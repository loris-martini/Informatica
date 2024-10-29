#Tutte le possibili combinazioni di due elementi senza ripetizione di 1,2,3. Output desiderato: [(1, 2), (1, 3), (2, 1), (2, 3), (3, 1), (3, 2)]
lun=6
lista=[None]*lun

i=0

n1=1
n2=1
print("Tutte le possibili combinazioni di due elementi senza ripetizione di 1,2,3.")
while lun>i:
    if n1 != n2:
        lista[i]=n1,n2
        i=i+1
    if n2 == 3:
        n1=n1+1
        n2=0
    n2=n2+1
    
print(lista)
#Tutte le possibili combinazioni di due elementi senza ripetizione dei caratteri ["A", "B", "C"], output desiderato: [('A', 'B'), ('A', 'C'), ('B', 'A'), ('B', 'C'), ('C', 'A'), ('C', 'B')]
lun=6
lista=[None]*lun

i=0
count=0
x=1

let=["A","B","C"]

print("Tutte le possibili combinazioni di due elementi senza ripetizione dei caratteri ['A', 'B', 'C'],")
while lun>i:    
    lista[i]=let[count],let[x]
    i=i+1
    
    
    
print(lista)
    
h = 100
a = 10

print("Profile:")
print("Heal = ", h)
print("Attack = ", a)

while 1 == 1:
    
    f = str(input("Rpg "))

    if f == "hunt":
        h = h - (100/a)
        print("found and killed a monster")
        print("Heal = ", h)
    elif f == "profile":
        print("Profile:")
        print("Heal = ", h)
        print("Attack = ", a)
    elif f == "training":
        print("quanto fa 147 + 73 ?")
        t = str(input(": "))
        if t == 220:
            print("Correct!")
            a = a + 5
    
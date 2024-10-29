
print("Tu sei un contadino e devi portare dall'altra parte del fiume i tuoi 3 beni: 1 cavolo, 1 capra, 1 lupo. Tu hai a disposizione una zattera che può contenere solo 1 di questi beni. Come porti tutto dall'altra?")
print("Problema: Ovviamente quando tu stai trasportando qualcosa: il lupo magia la capra o la capra mangia il cavolo")
print("Azioni: ")
print("'prendi' (capra, cavolo, lupo); 'lascia'; 'viaggia'")

a = str(input("Cosa fai?: "))

if a == "prendi lupo":
    print("La capra mangia il cavolo")
elif a == "prendi cavolo":
    print("Il lupo mangia la capra")
elif a == "lascia":
    print("Ma allora trovati un lavoro")
elif a == "viaggia":
    print("Ma allora trovati un lavoro")
elif a == "prendi capra":
    print("Ok")
    a1 = str(input("Cosa fai?: "))
    if a1 == "lascia":
        print("Ma allora ucciditi")
    elif a1 == ("prendi capra" or "prendi lupo" or "prendi cavolo"):
        print("Non puoi prendere più di un bene")
    elif a1 == "viaggia":
        print("Ok")
        a2 = str(input("Cosa fai?: "))
        if a2 == "viaggia":
            print("No")
        elif a2 == ("prendi capra" or "prendi lupo" or "prendi cavolo"):
            print("Non c'è niente qui da prendere")
        elif a2 == "lascia":
            print("Ok")
            a3 = str(input("Cosa fai?: "))
            if a3 == "lascia":
                print("No")
            elif a3 == ("prendi capra" or "prendi lupo" or "prendi cavolo"):
                print("Non puoi prendere più di un bene")
            elif a3 == "viaggia":
                print("Ok")
                a4 = str(input("Cosa fai?: "))
                if a4 == "prendi cavolo":
                    print("Facciamo che prendi il lupo la prossima volta")
                    a4 = str(input("Cosa fai?: "))
                elif a4 == "prendi capra":
                    print("La capra è dall'altra")
                elif a4 == "lascia":
                    print("Ma allora trovati un lavoro")
                elif a4 == "viaggia":
                    print("Ma allora trovati un lavoro")
                elif a4 == "prendi lupo":
                    print("Ok")
                    a5 = str(input("Cosa fai?: "))
                    if a5 == "lascia":
                        print("No")
                    elif a5 == ("prendi capra" or "prendi lupo" or "prendi cavolo"):
                        print("Non puoi prendere più di un bene")
                    elif a5 == "viaggia":
                        print("Ok")
                        a6 = str(input("Cosa fai?: "))
                        if a6 == "viaggia":
                            print("No")
                        elif a6 == ("prendi capra" or "prendi lupo" or "prendi cavolo"):
                            print("Non c'è niente qui da prendere")
                        elif a6 == "lascia":
                            print("Ok")
                            a7 = str(input("Cosa fai?: "))
                            if a7 == "prendi lupo":
                                print("No")
                            elif a7 == "lascia":
                                print("Ma allora trovati un lavoro")
                            elif a7 == "viaggia":
                                print("Ma allora trovati un lavoro")
                            elif a7 == "prendi cavolo":
                                print("Il cavolo è dall'atra parte")
                            elif a7 == "prendi capra":
                                print("Ok")
                                a8 = str(input("Cosa fai?: "))
                                if a8 == "lascia":
                                    print("No")
                                elif a8 == ("prendi capra" or "prendi lupo" or "prendi cavolo"):
                                    print("Non puoi prendere più di un bene")
                                elif a8 == "viaggia":
                                    print("Ok")
                                    a9 = str(input("Cosa fai?: "))
                                    if a9 == "viaggia":
                                        print("No")
                                    elif a9 == ("prendi capra" or "prendi lupo" or "prendi cavolo"):
                                        print("Non c'è niente qui da prendere")
                                    elif a9 == "lascia":
                                        print("Ok")
                                        a10 = str(input("Cosa fai?: "))
                                        if a10 == "prendi lupo":
                                            print("Il lupo è dall'atra parte")
                                        elif a7 == "lascia":    
                                            print("Ma allora trovati un lavoro")
                                        elif a10 == "viaggia":
                                            print("Ma allora trovati un lavoro")
                                        elif a10 == "prendi capra":
                                            print("Se dopo lasci la capra dall'altra il lupo si mangia la capra")
                                        elif a10 == "prendi cavolo":
                                            print("Ok")
                                            a11 = str(input("Cosa fai?: "))
                                            if a11 == "lascia":
                                                print("No")
                                            elif a11 == ("prendi capra" or "prendi lupo" or "prendi cavolo"):
                                                print("Non puoi prendere più di un bene")
                                            elif a11 == "viaggia":
                                                print("Ok")
                                                a12 = str(input("Cosa fai?: "))
                                                if a12 == "viaggia":
                                                    print("No")
                                                elif a12 == ("prendi capra" or "prendi lupo" or "prendi cavolo"):
                                                    print("Non c'è niente qui da prendere")
                                                elif a12 == "lascia":
                                                    print("Ok")
                                                    a13 = str(input("Cosa fai?: "))
                                                    if a13 == "lascia":
                                                        print("No")
                                                    elif a13 == ("prendi capra" or "prendi lupo" or "prendi cavolo"):
                                                        print("Non puoi prendere più di un bene")
                                                    elif a13 == "viaggia":
                                                        print("Ok")
                                                        a14 = str(input("Cosa fai?: "))
                                                        if a14 == "prendi lupo":
                                                            print("Il lupo è dall'atra parte")
                                                        elif a14 == "lascia":
                                                            print("Ma allora trovati un lavoro")
                                                        elif a14 == "viaggia":
                                                            print("Ma allora trovati un lavoro")
                                                        elif a14 == "prendi cavolo":
                                                            print("Il cavolo è dall'altra parte")
                                                        elif a14 == "prendi capra":
                                                            print("Ok")
                                                            a15 = str(input("Cosa fai?: "))
                                                            if a15 == "lascia":
                                                                print("No")
                                                            elif a15 == ("prendi capra" or "prendi lupo" or "prendi cavolo"):
                                                                print("Non puoi prendere più di un bene")
                                                            elif a15 == "viaggia":
                                                                print("Ok")
                                                                a16 = str(input("Cosa fai?: "))
                                                                if a16 == "viaggia":
                                                                    print("No")
                                                                elif a16 == ("prendi capra" or "prendi lupo" or "prendi cavolo"):
                                                                    print("Non c'è niente qui da prendere")
                                                                elif a16 == "lascia":
                                                                    print("Hai finito il gioco. Complimenti per la voglia di scrivere e ciao :)")
                                                                    
                                                                    
                                                                    
                                                                    
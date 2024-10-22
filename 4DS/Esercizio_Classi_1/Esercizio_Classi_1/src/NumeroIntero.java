public class NumeroIntero {
    private int num;

    public NumeroIntero(){
        this.num = 0;
    }

    public void setNum(int num){
        this.num = num;
    }

    public int stampa(){
        int num = this.num;

        while (num == 0){
            switch(num){  //eccezioni
                case 10:
                    System.out.println("dieci");
                    return 0;
                case 11:
                    System.out.println("undici");
                    return 0;
                case 12:
                    System.out.println("dodici");
                    return 0;
                case 13:
                    System.out.println("tredici");
                    return 0;
                case 14:
                    System.out.println("quattordici");
                    return 0;
                case 15:
                    System.out.println("quindici");
                    return 0;
                case 16:
                    System.out.println("sedici");
                    return 0;
                case 17:
                    System.out.println("diciasette");
                    return 0;
                case 18:
                    System.out.println("diciotto");
                    return 0;
                case 19:
                    System.out.println("diciannove");
                    return 0;
                case 100:
                    System.out.println("cento");
                    return 0;
                default:
                    if (num > 99){
                        switch(num / 100) {
                            case 1:
                                System.out.println("cento");
                                num -= 100;
                            case 2:
                                System.out.println("duecento");
                                num -= 200;
                            case 3:
                                System.out.println("trecento");
                                num -= 300;
                            case 4:
                                System.out.println("quattrocento");
                                num -= 400;
                            case 5:
                                System.out.println("cinquecento");
                                num -= 500;
                            case 6:
                                System.out.println("seicento");
                                num -= 600;
                            case 7:
                                System.out.println("settecento");
                                num -= 700;
                            case 8:
                                System.out.println("ottocento");
                                num -= 800;
                            case 9:
                                System.out.println("novecento");
                                num -= 900;
                            }
                        }
                    if (num > 19){
                        switch(num / 10){
                            case 2:
                                System.out.println("venti");
                                num -= 20;
                            case 3:
                                System.out.println("trenta");
                                num -= 30;
                            case 4:
                                System.out.println("quaranta");
                                num -= 40;
                            case 5:
                                System.out.println("cinquanta");
                                num -= 50;
                            case 6:
                                System.out.println("sessanta");
                                num -= 60;
                            case 7:
                                System.out.println("settanta");
                                num -= 70;
                            case 8:
                                System.out.println("ottanta");
                                num -= 80;
                            case 9:
                                System.out.println("novanta");
                                num -= 90;
                        }
                    }
                case 1:
                    System.out.println("uno");
                case 2:
                    System.out.println("due");
                case 3:
                    System.out.println("tre");
                case 4:
                    System.out.println("quattro");
                case 5:
                    System.out.println("cinque");
                case 6:
                    System.out.println("sei");
                case 7:
                    System.out.println("sette");
                case 8:
                    System.out.println("otto");
                case 9:
                    System.out.println("nove");
        }


        }

        return 0;
    }

    public boolean pari(int num){
        boolean res;
        if(num % 2 == 0){
            return true;
        }else{
            return false;
        }
    }

    public void aggiungi(int num){
        this.num += num;
    }

    public void togli(int num){
        this.num -= num;
    }

    public boolean primo(int num){
        if (num < 2){
            return false;
        }
        if (num <= 3){
            return true;
        }
        if (num % 2 == 0){
            return false;
        }
        for (int i = 3; i < num; i += 2){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }

}

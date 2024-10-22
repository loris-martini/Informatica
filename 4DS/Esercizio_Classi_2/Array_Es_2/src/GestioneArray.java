import java.util.Scanner;
class GestioneArray {
    Scanner input = new Scanner(System.in);
    
    int lun;
    int[] Array;

    GestioneArray(int a){
        this.lun = a;
        Array = new int[lun];
    }



    public void inser(){
        int n;
        for(int i = 0; i < Array.length; i++){
            System.out.println("Inserisci numero: ");
            n = input.nextInt();
            Array[i] = n;
        }
    }

    public int somma(){
        int sum = 0;
        for(int i = 0; i < Array.length; i++){
            sum += Array[i];
        }
        return sum;
    }

    public int nMag(){
        int mag = 0;
        for(int i = 0; i < Array.length; i++){
            if(Array[i] > mag){
                mag = Array[i];
            }                
        }
        return mag;
    }

    public boolean nCresc(){
        boolean flag = false;
        for(int i = 1; i < Array.length - 1; i++){
            if(Array[i-1]<Array[i]){
                flag = true;
            }  
            else{
                flag = false;
                break;
            }              
        }
        return flag;
    }

    public boolean riceN(int a){
        int n = a;
        boolean flag = false;
        for(int i = 1; i < Array.length - 1; i++){
            if(n == Array[i]){
                flag = true;
            }                
        }
        return flag;
    }
}

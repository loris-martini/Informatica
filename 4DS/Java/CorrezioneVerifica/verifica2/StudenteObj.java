import java.util.Arrays;

public class StudenteObj extends Studente{

    public StudenteObj()throws Exception{
        super();
    }

    public StudenteObj(Integer classe, Boolean isRipetente, String cognome, String nome, Data dataDinascita)throws Exception{
        super(classe, isRipetente, cognome, nome, dataDinascita);
    }

    protected StudenteObj clone() throws CloneNotSupportedException{
        numeroIstanze++;
        StudenteObj studenteObj = (StudenteObj) super.clone();
        return studenteObj;
    }

    public boolean equals(Object oggetto){
        if(!(oggetto instanceof StudenteObj)){
            return false;
        }
        if ((((StudenteObj) oggetto).getNome().equals(getNome())) && (((StudenteObj) oggetto).getCognome().equals(getCognome())) && (((StudenteObj) oggetto).getDataDiNascita().equals(getDataDiNascita())) && (((StudenteObj) oggetto).getClasse().equals(getClasse())) && (((StudenteObj) oggetto).getIsRipetente() == getIsRipetente()) && ((StudenteObj) oggetto).getVoti().equals(getVoti())) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        int hash = 0;

        if(getNome() != null){
            hash += getNome().hashCode();
        }
        if(getCognome() != null){
            hash += getCognome().hashCode();
        }
        try {
            if (getDataDiNascita() != null) {
                hash += getDataDiNascita().hashCode();
            }
        }catch (Exception e){
            //Data non valida
        }
        if(getClasse() != null){
            hash += getClasse().hashCode();
        }

        hash += getNome().hashCode();

        if(getVoti() != null){
            hash += Arrays.hashCode(getVoti());
        }

        return hash;
    }

    public String toString(){
        String s1 = "[", s2;
        for (int i = 0; i < getVoti().length; i++) {
            if(i == 0){
                s1 += getVoti()[i];
            }else{
                s1 = s1 + ", " + getVoti()[i];
            }
        }
        s1 += "]";

        if (getIsRipetente()) {
            s2 = "sì";
        } else {
            s2 = "no";
        }
        return "Scuola: " + getSCUOLA() + "\nClasse: " + getClasse() + super.info() + "\nRipetente: " + s2 + "\nVoti: " + s1;
    }

    protected void finalize()throws Throwable{
        try{
            numeroIstanze--;
        }finally {
            super.finalize();
        }
    }
}

import java.util.Arrays;

public class Rubrica {
    private Persona[] rubrica;
    private int dimLog;

    public Rubrica(int lun){
        rubrica = new Persona[lun];
        dimLog = 0;
    }

    public void inserimento(Persona user){
        rubrica[dimLog] = user;
        dimLog++;
    }

    private int ricerca(String nome)throws Exception{
        int i = 0;

        while(i < this.dimLog){
            if(nome.equals(rubrica[i].getNome())){
                return i;
            }
            i++;
        }
        throw new Exception("Nome non trovato! ");
    }

    public void modifica(String ric, Persona user) throws Exception{
        int i = ricerca(ric);

        rubrica[i].setEta(user.getEta());
        rubrica[i].setCitta(user.getCitta());
        rubrica[i].setNumero(user.getNumero());
    }


    public void elimina(Persona user) throws Exception{
        int count = ricerca(user.getNome());

        for(int i = count; i - 1 < dimLog; i++){
            rubrica[i].setNome(rubrica[i+1].getNome());
            rubrica[i].setEta(rubrica[i+1].getEta());
            rubrica[i].setCitta(rubrica[i+1].getCitta());
            rubrica[i].setNumero(rubrica[i+1].getNumero());
        }
        rubrica[dimLog - 1] = null;
        dimLog--;
    }
    public String minMaxToString(){
        String str = "";
        String tmpNom;
        int tmpEta;
        String tmpCit;
        String tmpNum;

        //Sort
        for(int i = 0; i < dimLog; i++){
            for(int j = i; j < dimLog; j++){
                if(rubrica[j].getEta() < rubrica[i].getEta()){
                    tmpNom = rubrica[i].getNome();
                    tmpEta = rubrica[i].getEta();
                    tmpCit = rubrica[i].getCitta();
                    tmpNum = rubrica[i].getNumero();

                    rubrica[i].setNome(rubrica[j].getNome());
                    rubrica[i].setEta(rubrica[j].getEta());
                    rubrica[i].setCitta(rubrica[j].getCitta());
                    rubrica[i].setNumero(rubrica[j].getNumero());

                    rubrica[j].setNome(tmpNom);
                    rubrica[j].setEta(tmpEta);
                    rubrica[j].setCitta(tmpCit);
                    rubrica[j].setNumero(tmpNum);
                }
            }
        }

        for(int i = 0; i < dimLog; i++){
            str += "Nome: " + rubrica[i].getNome() + " | Eta: " + rubrica[i].getEta() + " | Città: " + rubrica[i].getCitta() + " | Numero: " + rubrica[i].getEta() + "\n";
        }
        return str;
    }
}

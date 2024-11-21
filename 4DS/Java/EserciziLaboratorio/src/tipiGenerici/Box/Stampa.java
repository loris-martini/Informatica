package tipiGenerici.Box;

public class Stampa {
    public static <T> String stampaElemento(T elemento)throws Exception {
        //public static String stampaElemento (Integer elemento) throws Exception {
        String testo;

        if(elemento != null)
            testo = "[" + String.valueOf(elemento) + "]";
        else
            throw new Exception("L'oggetto non può essere null!");
        return testo;
    }
    //analogamente per tutte le altre classi wrapper e classi create da noi

    public static <T> String stampaElemento (T[] elemento) throws Exception {
        //public static String stampaElemento (Integer[] elemento) throws Exception {
        String testo = "";

        if(elemento != null){
            testo = "[";

            for(int i=0; i<elemento.length; i++)
                if (i == (elemento.length-1))
                    testo += elemento[i] + "";
                else
                    testo += elemento[i] +", ";

            testo += "]";
        } else
            throw new Exception("Il vettore non può essere null!");

        return testo;
    }
}
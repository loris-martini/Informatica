package library;

public abstract class Book implements IBorrowable{
    //attributi
    private String title;
    private String author;
    private String isbn;
    private boolean avalabilityStatus;
    protected User utente;

    //metodi
    public Book(String title, String author, String isbn){
        this.title=title;
        this.author=author;
        this.isbn=isbn;
        avalabilityStatus=true;
        utente=null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setAvalabilityStatus(boolean avalabilityStatus) {
        this.avalabilityStatus = avalabilityStatus;
    }

    public boolean getAvalabilityStatus() {
        return avalabilityStatus;
    }

    public void setUtente(User u){
        this.utente=u;
    }

    public String getDetails(){
        return "TITOLO: "+title+"\nAUTORE: "+author+"\nISBN: "+isbn+"\nSTATO: "+avalabilityStatus+"\nUTENTE: "+utente.toString();
    }

    /*public String toString(){
        return "TITOLO: "+title+"\nAUTORE: "+author+"\nISBN: "+isbn+"\nSTATO: "+avalabilityStatus+"\nUTENTE: "+utente.toString();
    }*/
}

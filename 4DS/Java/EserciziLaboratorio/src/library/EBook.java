package library;

public class EBook extends Book{
    private String audio; //mp3

    public EBook(String title, String author,String isbn, String audio){
        super(title, author, isbn);
        this.audio = audio;
    }

    public String getAudio(){
        return audio;
    }

    public void borrow (User u) {
        setAvalabilityStatus(false);
        utente = u;
    }

    public void ret() {
        setAvalabilityStatus(true);
        utente=null;
    }

    public String getDetails(){
        return super.getDetails() + "\n AUDIO: " + audio;
    }
}

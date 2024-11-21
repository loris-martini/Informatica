package library;

public class PhysicalBook extends Book{
    private String condition;

    public PhysicalBook(String title, String author,String isbn, String condition){
        super(title, author, isbn);
        this.condition=condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    public String getCondition() {
        return condition;
    }
    public void borrow (User u){
        setAvalabilityStatus(false);
        utente=u;
    }

    public void ret() {
        setAvalabilityStatus(true);
        utente=null;
    }

    public String getDetails(){
        return super.getDetails() + "\n CONDIZIONI: " + condition;
    }
}

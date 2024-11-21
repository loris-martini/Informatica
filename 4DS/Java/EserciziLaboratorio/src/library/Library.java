package library;

import java.lang.reflect.Array;

public class Library {
    private User[] users;
    private Book[] books;
    private int bDimLog, uDimLog;

    public Library(int nBooks, int nUsers) throws Exception{
        if(nUsers <= 0 || nBooks <= 0){
            throw new Exception("Parametri errati!");
        }
        users = new User[nUsers];
        books = new Book[nBooks];
        bDimLog = 0;
        uDimLog = 0;
    }

    public void registration(User u){
        users[uDimLog] = new User(u.getNome(), u.getCognome(), u.getId());
        uDimLog++;
    }

    public void borrow(User u, Book b){
        b.borrow(u);
    }

    public void ret(Book b){ //return
        b.ret();
    }

    public void addBook(Book b){
        books[bDimLog] = b;
        bDimLog++;
    }

    public void removeBook(Book b) throws Exception{
        int i = 0;
        boolean trovato = false;
        while (i < bDimLog && !trovato) {
            if(books[i].equals(b)){
                trovato = true;
            }
            i++;
        }

        if(!trovato){
            throw new Exception("Libro non trovato!");
        }

        for (int j = i-1; j < bDimLog-1; j++) {
            books[j] = books[j+1];
        }
        books[bDimLog] = null;
        bDimLog--;
    }

    public String toString(){
        String str = "Utenti: ";
        int count = 0;
        for (int i = 0; i < uDimLog; i++) {
            str += "\n" + (i+1) + users[i];
        }

        str += "\n\nLibri: ";
        for (int i = 0; i < bDimLog; i++) {
            str += "\n" + (i+1) + books[i];
        }

        return str;
    }
}

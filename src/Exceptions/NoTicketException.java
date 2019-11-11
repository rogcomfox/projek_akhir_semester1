package Exceptions;

public class NoTicketException extends Exception{
	  
    private String film;
    
    public NoTicketException(String film){
        this.film = film;
    }
    
    public String toString(){
        return "Anda Tidak Mempunyai Tiket Di Film "+film;
    }
}

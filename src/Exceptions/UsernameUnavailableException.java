package Exceptions;

public class UsernameUnavailableException extends Exception {
	private String username;
    
    public UsernameUnavailableException(String username){
    this.username = username;
    }
    
    public String toString(){
        return "Username "+'"'+username+'"'+" Sudah Terpakai.";
    }

}

package Exceptions;

public class UsernameNotRegisteredException extends Exception {
	private String username;
    
    public UsernameNotRegisteredException(String username){
    this.username = username;
}
    
    public String toString(){
        return "Username "+'"'+username+'"'+" tidak terdaftar.";
    }

}

package Exceptions;

public class WrongPasswordException extends Exception {
	 	private int passwordTries;
	    private String username;
	    
	    public WrongPasswordException(int passwordTries, String username){
	        this.passwordTries = passwordTries;
	        this.username = username;
	    }
	    
	    public String toString(){
	        if(passwordTries <= 0)
	        return "Akun Dengan Username "+'"'+username+'"'+" Telah Diblokir.";
	        else
	        return "Password salah. Akun Dengan Username "+'"'+username+'"'+" Memiliki "+passwordTries+"x Kesempatan Lagi.";
	    }
}

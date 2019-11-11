package Exceptions;

public class PasswordTooShortException extends Exception{
    
    public String toString(){
        return "Password harus memiliki panjang minimal 8 karakter.";
    }
}

package Exceptions;

public class TopUpAmountException extends Exception{
    
    public String toString(){
        return "Gagal. Nominal Top Up Minimal Rp 20.000.";
    }
      
}

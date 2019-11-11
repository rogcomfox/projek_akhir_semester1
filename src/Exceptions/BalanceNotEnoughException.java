package Exceptions;

public class BalanceNotEnoughException extends Exception {
	private double saldo;
    private int tiket;
    
    public BalanceNotEnoughException(double saldo, int tiket){
    this.saldo = saldo;
    this.tiket = tiket;
    }
    
    public String toString(){
        return "Saldo Anda Kurang. Mohon Top Up Sebesar Rp "+ ((20000*tiket)-saldo);
    }
}

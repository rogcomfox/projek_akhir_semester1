package Bioskop;

public class Platinum extends User {
	public Platinum(String username, String password, String tipeAkun, double topUpPerdana, int jumlahFilm){
        super(username, password, tipeAkun, topUpPerdana,  jumlahFilm);
    }
    
    public double cashback(double total){
        return total*0.1;
    }
    

}

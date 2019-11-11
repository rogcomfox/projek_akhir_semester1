package Bioskop;

public class Gold extends User {
	public Gold(String username, String password, String tipeAkun, double topUpPerdana, int jumlahFilm){
        super(username, password, tipeAkun, topUpPerdana, jumlahFilm);
    }
    
    public double cashback(double total){
        return total * 0.07;
    }

}

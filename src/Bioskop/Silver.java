package Bioskop;

public class Silver extends User {
	public Silver(String username, String password, String tipeAkun, double topUpPerdana, int jumlahFilm){
        super(username, password, tipeAkun, topUpPerdana, jumlahFilm);
    }
    
    public double cashback(double total){
        return total *0.05;
    }
}

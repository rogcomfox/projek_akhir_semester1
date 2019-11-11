package Bioskop;

public class Regular extends User {
	public Regular(String username, String password, String tipeAkun, double topUpPerdana, int jumlahFilm){
        super(username, password, tipeAkun, topUpPerdana, jumlahFilm);
    }
    
    public double cashback(double total){
        return 0;
    }

}

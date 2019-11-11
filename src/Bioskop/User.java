package Bioskop;
import java.util.ArrayList;
import java.util.List;
public abstract class User {
	private List<List<String>> tiketFilm = new ArrayList<List<String>>();

    private String username;
    private String password;
    private String tipeAkun;
    private double saldo;
    private int passwordTries = 3;
    
    public User(String username, String password, String tipeAkun, double topUpPerdana, int jumlahFilm){
        this.username = username;
        this.password = password;
        this.tipeAkun = tipeAkun;
        saldo += topUpPerdana;
        setDataFilm(jumlahFilm);
        
    }
    public double getSaldo(){
        return saldo;
    }
    
    public int getPasswordTries(){
        return passwordTries;
    }
    
    public void resetPasswordTries(){
        passwordTries = 3;
    }
    
    public void reducePasswordTries(){
        passwordTries--;
    }
       
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getTipeAkun() {
    	return this.tipeAkun;
    }
    
    public void topUp(double topUp){
        saldo += topUp;
    }
    
    
    public void setDataFilm(int jumlahFilm){
    //menyesuaikan dengan jumlah film yg tayang
        for (int i = 0; i < jumlahFilm; i++) {
          tiketFilm.add(new ArrayList<String>());
        }
    }
    
    public void saveKursi(int film, String kursi){      
                this.tiketFilm.get(film).add(kursi);      
    }

    public List<List<String>> getOwnedTiket(){
        return tiketFilm;
    }
    
    public String toString(){
        return
        "Username  : "+username+
        "\nTipe Akun : "+tipeAkun+
        "\nSaldo     : Rp "+saldo;
    }
    
    public abstract double cashback(double total);
}

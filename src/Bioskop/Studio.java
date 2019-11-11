package Bioskop;
import java.util.ArrayList;
public class Studio {
	 private String namaFilm;
	    ArrayList<boolean[][]> kursi = new ArrayList<>();
	    
	    public Studio(String namaFilm){
	    this.namaFilm = namaFilm;
	    kursi.add(new boolean[5][5]);
	    
	    }
	    
	    public String getNamaFilm(){
	        return namaFilm;
	    }
	    
	    public boolean[][] getKursi(int jam){
	        return kursi.get(jam);
	    }

}

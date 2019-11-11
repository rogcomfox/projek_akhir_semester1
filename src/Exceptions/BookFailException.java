package Exceptions;

public class BookFailException extends Exception {
    
    private String baris;
    private int kolom;
    
    public BookFailException(String baris, int kolom){
        this.baris = baris;
        this.kolom = kolom;
    }
    
    public String toString(){
        return "Kursi Pilihan Anda Di "+baris+kolom+" Tidak Tersedia, Silahkan Pilih Kursi Lain.";
    }
}
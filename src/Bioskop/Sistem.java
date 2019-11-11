package Bioskop;
import java.io.*;
import java.util.ArrayList;
import Exceptions.*;
public class Sistem {
	private int ID;

    ArrayList<User> accounts = new ArrayList<>();
    Studio studio[] = new Studio[4];

    public Sistem() {

        studio[0] = new Studio("The Avengers : End Game");
        studio[1] = new Studio("Spiderman : Far From Home");
        studio[2] = new Studio("Take the Ball , Pass the Ball");
        studio[3] = new Studio("New Avengers");

    }

    public boolean Login(String username, String password) throws UsernameNotRegisteredException, WrongPasswordException {
        int poin = 0;

        //Cek ArrayList accounts ada isinya apa nggak
        if (accounts.isEmpty()) {
            throw new UsernameNotRegisteredException(username);
        }

        //ngecek username inputan user ada di dalem database apa nggak
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().compareTo(username) == 0) {
                poin++;
                ID = i;
                break;
            }
        }

        //kalo username inputan user gaada dia ngethrow exception
        if (poin == 0) {
            throw new UsernameNotRegisteredException(username);
        }

        //kalo password salah ato percobaan password udh lebih dr 3x
        if (accounts.get(ID).getPassword().compareTo(password) != 0 || accounts.get(ID).getPasswordTries() <= 0) {
            accounts.get(ID).reducePasswordTries();
            throw new WrongPasswordException(accounts.get(ID).getPasswordTries(), username);
        }

        //kalo lulus pengecekan diatas^ baru ngerun ini ->
        accounts.get(ID).resetPasswordTries();
        return true;
    }

    public void register(String username, String password, double topUp) throws UsernameUnavailableException, PasswordTooShortException {

        //salah satu dr ini semua di run kalo udh lulus pengecekan di method MenuRegister di kelas Main
        if (topUp >= 20000 && topUp < 50000) {
            accounts.add(new Silver(username, password, "Silver", topUp, studio.length));
        } else if (topUp >= 50000 && topUp < 100000) {
            accounts.add(new Gold(username, password, "Gold", topUp, studio.length));
        } else if (topUp >= 100000) {
            accounts.add(new Platinum(username, password, "Platinum", topUp, studio.length));
        } else if(topUp >=10000 && topUp <20000) {
        	accounts.add(new Regular(username, password, "Regular", topUp, studio.length));
        	
        }

    }

    public boolean isUsernameAvailable(String username) throws UsernameUnavailableException {
        //buat ngecek username dah kepake apa blom
        int poin = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().compareTo(username) == 0) {
                poin++;
            }
        }

        if (poin != 0) {
            throw new UsernameUnavailableException(username);
        }

        return poin == 0;
    }

    public boolean isPassword8(String password) throws PasswordTooShortException {
        //ngecek password udh minimal 8 karakter blom
        if (password.length() < 8) {
            throw new PasswordTooShortException();
        } else {
            return true;
        }
    }

    public boolean isTopUpAbove10K(double topUp) throws TopUpAmountException {
        //top up minimal 20rb gak 
        if (topUp < 10000) {
            throw new TopUpAmountException();
        } else {
            return true;
        }
    }

    public void displayProfile() {
        System.out.println(accounts.get(ID).toString());
    }

    public void transaksi(double jumlah) {
        accounts.get(ID).topUp(jumlah);
    }

    public double cashbackValue(double jumlah) {
        return accounts.get(ID).cashback(jumlah);
    }

    public boolean isBalanceEnough(int tiket) throws BalanceNotEnoughException {
        if (accounts.get(ID).getSaldo() >= tiket * 20000) {
            return true;
        } else {
            throw new BalanceNotEnoughException(accounts.get(ID).getSaldo(), tiket);
        }
    }

    public void displayKursi(int i) throws InputErrorException {
        //buat ngeprint layat yg buat beli tiket kek di bioskop2
        if (i - 1 < 0 || i > studio.length) {
            throw new InputErrorException();
        }

        System.out.println(studio[i - 1].getNamaFilm());
        System.out.println("\\ 1 2 3 4 5");
        for (int j = 0; j < 5; j++) {
            switch (j) {
                case 0:
                    System.out.print("A");
                    break;
                case 1:
                    System.out.print("B");
                    break;
                case 2:
                    System.out.print("C");
                    break;
                case 3:
                    System.out.print("D");
                    break;
                case 4:
                    System.out.print("E");
                    break;
            }
            for (int k = 0; k < 5; k++) {
                if (studio[i - 1].kursi.get(0)[j][k] == false) {
                    System.out.print(" o");
                } else {
                    System.out.print(" X");
                }
            }
            System.out.println("");
        }
        System.out.println("---LAYAR---");
    }

    public void displayFilm() {
        for (int i = 0; i < studio.length; i++) {
            System.out.println((i + 1) + ". " + studio[i].getNamaFilm());
        }
        System.out.println("---------------------------------");
    }

    public String barisKursiConverter(int baris) throws InputErrorException {
        if (baris < 1 || baris > 5) {
            throw new InputErrorException();
        }

        String result = null;

        switch (baris) {
            case 1:
                result = "A";
                break;
            case 2:
                result = "B";
                break;
            case 3:
                result = "C";
                break;
            case 4:
                result = "D";
                break;
            case 5:
                result = "E";
                break;
        }

        return result;
    }

    public void bookKursi(int film, int baris, int kolom, String hurufBaris) throws BookFailException {

        if (studio[film - 1].kursi.get(0)[baris - 1][kolom - 1] == true) {
            throw new BookFailException(hurufBaris, kolom);
        }
        //update database kursi
        studio[film - 1].kursi.get(0)[baris - 1][kolom - 1] = true;

        //ngesave kursi yg udh kebeli di akun
        String kursi = hurufBaris + kolom;
        accounts.get(ID).saveKursi(film - 1, kursi);
    }

    public void ownedKursi(int film) throws NoTicketException, InputErrorException {

        if (film - 1 < 0 || film - 1 >= studio.length) {
            throw new InputErrorException();
        }

        if (accounts.get(ID).getOwnedTiket().get(film - 1).isEmpty()) {
            throw new NoTicketException(studio[film - 1].getNamaFilm());
        }

        System.out.println(studio[film - 1].getNamaFilm());
        for (int j = 0; j < accounts.get(ID).getOwnedTiket().get(film - 1).size(); j++) {
            System.out.println((j + 1) + ". " + accounts.get(ID).getOwnedTiket().get(film - 1).get(j));
        }
    }

    public void cancelKursi(int film, int pil) throws InputErrorException {

        if (pil - 1 < 0 || pil - 1 > accounts.get(ID).getOwnedTiket().get(film - 1).size()) {
            throw new InputErrorException();
        }

        String barisKursi = accounts.get(ID).getOwnedTiket().get(film - 1).get(pil - 1);
        int index0 = index0Reader(barisKursi);
        int index1 = index1Reader(barisKursi);

        studio[film - 1].kursi.get(0)[index0][index1] = false;
        accounts.get(ID).getOwnedTiket().get(film - 1).remove(pil - 1);

    }

    public int index0Reader(String a) {
        char index0 = a.charAt(0);
        int result = 0;

        switch (index0) {
            case 'A':
                result = 0;
                break;
            case 'B':
                result = 1;
                break;
            case 'C':
                result = 2;
                break;
            case 'D':
                result = 3;
                break;
            case 'E':
                result = 4;
                break;
        }
        return result;
    }

    public int index1Reader(String a) {
        int index1 = Character.getNumericValue(a.charAt(1));

        return index1 - 1;
    }

    public void cetakTiket() throws IOException, NothingToPrintException {
        String judul = null, kursi = null;
        int poin = 0;

        for (int i = 0; i < studio.length; i++) {
            if (accounts.get(ID).getOwnedTiket().get(i).isEmpty()) {
                poin++;
            }
        }

        if (poin >= studio.length) {
            throw new NothingToPrintException();
        }

        for (int i = 0; i < studio.length; i++) {
            if (!accounts.get(ID).getOwnedTiket().get(i).isEmpty())
                judul = studio[i].getNamaFilm();

            for (int j = 0; j < accounts.get(ID).getOwnedTiket().get(i).size(); j++) {
                kursi = accounts.get(ID).getOwnedTiket().get(i).get(j);
                try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Cetak Hasil\\" + judul.substring(0, 2) + "_eTicket(" + kursi + ").txt"), "utf-8"))) {
                    bw.write("Tiket Bioskop XXI | " + judul + " | " + kursi + " | " + accounts.get(ID).getUsername()+ " | " + accounts.get(ID).getTipeAkun());
                }

            }
        }
    }
}

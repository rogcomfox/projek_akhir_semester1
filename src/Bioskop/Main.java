package Bioskop;
import java.io.IOException;
import java.util.Scanner;
import Exceptions.*;
public class Main {

    public static void main(String[] args) {
        Sistem sistem = new Sistem();
        //

        //
        Scanner scnr = new Scanner(System.in);
        int input;
        System.out.print("Selamat Datang Di Bioskop XXI!\n");

        do {
            System.out.print("---------------------------------"
                    + "\n1. Login"
                    + "\n2. Register"
                    + "\n3. Keluar"
                    + "\n---------------------------------"
                    + "\nInput: ");
            input = scnr.nextInt();
            System.out.println("---------------------------------");

            switch (input) {
                case 1: {
                    menuLogin(scnr, sistem);

                }
                break;
                case 2: {
                    menuRegister(scnr, sistem);
                }
                break;
            }

        } while (input != 3);

    }

    static void menuRegister(Scanner scnr, Sistem sistem) {
        double topUp = 0;

        System.out.print("REGISTER:\n\n"
                + "Masukkan Username: ");
        String username = scnr.next();

        try {
            sistem.isUsernameAvailable(username);
        } catch (UsernameUnavailableException unav) {
            System.out.println("\n" + unav + "\n");
            return;
        }

        System.out.print("Masukkan Password: ");
        String password = scnr.next();

        try {
            sistem.isPassword8(password);
        } catch (PasswordTooShortException pts) {
            System.out.println("\n" + pts + "\n");
            return;

        }

        while (topUp <10000) {
            System.out.print("\nTOP UP PERDANA"
            		+ "\nRp.10.000 - Rp 19.999 | Regular"
                    + "\nRp 20.000 - Rp 49.999 | Silver"
                    + "\nRp 50.000 - Rp 99.999 | Gold"
                    + "\n>= Rp 100.000         | Platinum"
                    + "\n\nMasukkan Nominal Top Up: ");

            topUp = scnr.nextDouble();
            System.out.println("");

            try {
                sistem.isTopUpAbove10K(topUp);
            } catch (TopUpAmountException tua) {
                System.out.println("---------------------------------\n"+ tua + "\n");
            }
        }

        try {
            sistem.register(username, password, topUp);
        } catch (Exception ex) {
        }

        return;
    }

    static void menuLogin(Scanner scnr, Sistem sistem) {

        System.out.print("LOGIN:\n\n"
                + "Masukkan Username: ");
        String username = scnr.next();
        System.out.print("Masukkan Password: ");
        String password = scnr.next();

        try {
            sistem.Login(username, password);
        } catch (UsernameNotRegisteredException | WrongPasswordException me) {
            System.out.println("\n" + me + "\n");
            return;
        }

        MenuKeduaBioskop(scnr, sistem);
    }

    static void MenuKeduaBioskop(Scanner scnr, Sistem sistem) {
        int input;
        do {
            System.out.print("\n---------------------------------"
                    + "\n1. Akun"
                    + "\n2. Pemesanan Tiket"
                    + "\n3. Pembatalan Tiket"
                    + "\n4. Cetak Tiket"
                    + "\n5. Logout"
                    + "\n---------------------------------"
                    + "\nInput: ");
            input = scnr.nextInt();
            System.out.println("---------------------------------");

            switch (input) {
                case 1: {
                    sistem.displayProfile();
                    
                    System.out.print("\n1. Top Up"
                            + "\n2. Kembali"
                            + "\n\nInput: ");
                    int pil = scnr.nextInt();
                    if(pil == 1)
                    MenuTopUp(scnr, sistem);

                }
                break;
                case 2: {
                    MenuBerapaTiket(scnr, sistem);
                }
                break;
                case 3: {
                    MenuBatalTiket(scnr, sistem);
                }
                break;
                case 4: {
                    MenuCetak(sistem);
                }
                break;
            }
        } while (input != 5);
    }

    static void MenuTopUp(Scanner scnr, Sistem sistem){
        System.out.print("Masukkan Nominal Top Up: ");
        double jumlah = scnr.nextDouble();
        
        try{
            sistem.isTopUpAbove10K(jumlah);
        }catch (TopUpAmountException tua){
            System.out.print("---------------------------------\n"+tua+"\n");
            return;
        }
        System.out.println("\nTop Up Berhasil.");
        sistem.transaksi(jumlah);
    }
    
    static void MenuBerapaTiket(Scanner scnr, Sistem sistem) {
        System.out.print("Berapa Tiket Yang Ingin Anda Pesan? (Rp 20.000 /tiket)"
                + "\nInput: ");
        int tiket = scnr.nextInt();
        System.out.println("---------------------------------");

        try {
            sistem.isBalanceEnough(tiket);
        } catch (BalanceNotEnoughException bne) {
            System.out.println("\n" + bne);
            return;
        }

        MenuPilihFilmKursi(scnr, sistem, tiket);
    }

    static void MenuPilihFilmKursi(Scanner scnr, Sistem sistem, int tiket) {
        boolean sure;
//pilih film
        sistem.displayFilm();
        System.out.print("Input: ");
        int film = scnr.nextInt();
        System.out.println("---------------------------------\n");

//pilih kursi
        String hurufBaris = "";
        for (int i = 1; i <= tiket; i++) {
            sure = false;

            while (!sure) {
                try {
                    sistem.displayKursi(film);
                } catch (InputErrorException ie) {
                    System.out.print("---------------------------------\n" + ie + "\n");
                    return;
                }

                System.out.print("\n[TIKET " + i + "] Mohon Pilih BARIS:"
                        + "\n1. Baris A"
                        + "\n2. Baris B"
                        + "\n3. Baris C"
                        + "\n4. Baris D"
                        + "\n5. Baris E"
                        + "\n---------------------------------"
                        + "\nInput: ");
                int baris = scnr.nextInt();
                System.out.println("---------------------------------\n");

                try {
                    hurufBaris = sistem.barisKursiConverter(baris);
                    sistem.displayKursi(film);
                } catch (InputErrorException ie) {
                    System.out.println(ie);
                }

                System.out.print("\nBaris: " + hurufBaris
                        + "\n[TIKET " + i + "] Mohon Pilih KOLOM:"
                        + "\n1. Kolom 1"
                        + "\n2. Kolom 2"
                        + "\n3. Kolom 3"
                        + "\n4. Kolom 4"
                        + "\n5. Kolom 5"
                        + "\n---------------------------------"
                        + "\nInput: ");
                int kolom = scnr.nextInt();
                System.out.println("---------------------------------");

                try {
                    sistem.barisKursiConverter(kolom);
                } catch (InputErrorException ie) {
                    System.out.println(ie);
                }

                System.out.print("Apakah Anda Yakin Ingin Memesan Di " + hurufBaris + kolom + " Untuk TIKET " + i + "?"
                        + "\n1. Ya"
                        + "\n2. Batal"
                        + "\n\nInput: ");
                int yakin = scnr.nextInt();

                if (yakin == 1) {

                    try {
                        sistem.bookKursi(film, baris, kolom, hurufBaris);
                    } catch (BookFailException bf) {
                        System.out.println("---------------------------------"+bf+"---------------------------------");
                        i--;
                        break;
                    }
                    sure = true;
                }
            }
        }
        System.out.printf("\nAnda Mendapat Cashback Sebesar Rp %.0f " , sistem.cashbackValue(20000 * tiket));
        sistem.transaksi(-((20000 * tiket) - sistem.cashbackValue(20000 * tiket)));
        return;
    }

    static void MenuBatalTiket(Scanner scnr, Sistem sistem) {
        sistem.displayFilm();
        System.out.print("Input: ");
        int film = scnr.nextInt();
        System.out.println("---------------------------------\n");

        try {
            sistem.ownedKursi(film);
        } catch (InputErrorException | NoTicketException me) {
            System.out.println(me);
            return;
        }

        System.out.print("\nTiket Mana Yang Ingin Anda Batalkan?"
                + "\nInput: ");
        int pil = scnr.nextInt();

        System.out.print("\nSaldo Anda Hanya Akan Dikembalikan 90%, Apakah Anda Yakin?"
                + "\n1. Ya"
                + "\n2. Tidak"
                + "\n\nInput: ");
        int sure = scnr.nextInt();

        if (sure == 1) {
            try {
                sistem.cancelKursi(film, pil);
            } catch (InputErrorException ie) {
                System.out.println(ie);
                return;
            }
            sistem.transaksi((20000 * 9) / 10);
        } else {
            return;
        }

    }

    static void MenuCetak(Sistem sistem) {
        try {
            sistem.cetakTiket();
        } catch (IOException | NothingToPrintException io) {
            System.out.println(io);
            return;
        }
        System.out.print("...Mencetak Tiket...");
    }

}

package com.nusantarian.developer;

import java.util.ArrayList;
import java.util.Scanner;

public class BukuTelepon {
    private static Scanner in = new Scanner(System.in);
    private static ArrayList Nama = new ArrayList();
    private static ArrayList Alamat = new ArrayList();
    private static ArrayList Hp = new ArrayList();
    private static ArrayList Provider = new ArrayList();
    private static ArrayList Grup = new ArrayList();
    private static String nama,alamat,hp,provider,grup,tanya,sa,pil;
    private static int pilihan,i;
    private static boolean jalan = true,go;

    private static void showMenu(){
        do{
        System.out.println("1. Menambahkan Kontak Baru");
        System.out.println("2. Mencetak Kontak");
        System.out.println("3. Mencari Kontak Berdasarkan Nama");
        System.out.println("4. Mencari Kontak Berdasarkan Nomor Telepon");
        System.out.println("5. Mengubah Data pada Kontak");
        System.out.println("6. Menghapus Kontak dari Daftar");
        System.out.println("7. Keluar");
        System.out.println("----------------------------------");
        System.out.print("Masukkan Pilihan = ");
        pil = in.next();
        System.out.println("----------------------------------");
        switch (pil){
            case "1": tambahkontak();break;
            case "2": tampilkontak();break;
            case "3": carinama();break;
            case "4": caritelepon();break;
            case "5": editdata();break;
            case "6": hapuskontak();break;
            case "7": System.out.println("Terimakasih Telah Menggunakan Program Ini");System.out.println("----------------------------------");jalan = false;break;
            default: System.out.println("Masukkan Salah, Silahkan Coba Lagi!");break;
        }
    }while(jalan);
}
    private static void tambahkontak() {
        do{
            //menambah kontak melalui arraylist
            System.out.print("Masukkan Nama     : ");
            in.nextLine();
            nama = in.nextLine();
            System.out.print("Masukkan Alamat   : ");
            alamat = in.nextLine();
            System.out.print("Masukkan No. Hp   : ");
            hp = in.next();
            System.out.print("Masukkan Provider : ");
            provider = in.next();
            System.out.print("Masukkan Nama Grup: ");
            grup = in.next();
            Nama.add(nama);
            Alamat.add(alamat);
            Hp.add(hp);
            Grup.add(grup);
            Provider.add(provider);
            System.out.println("----------------------------------");
            //mengulang ke method tambahkontak dengan memanfaatkan method ulang
            System.out.print("Apakah Anda Ingin Menambahkan Kontak Lagi <y/n> ? ");
            ulang();
        }while (jalan);
    }
    private static void ulang(){
        //method rekursif
        tanya = in.next();
        System.out.println("----------------------------------");
        if("y".equalsIgnoreCase(tanya)){
            return;
        }
        if("n".equalsIgnoreCase(tanya)){
            showMenu();
        }else{
            System.out.println("Masukkan Salah");ulang();
        }
    }
    private static void tampilkontak(){
        do{
            System.out.println("1. Menampilkan Semua Kontak");
            System.out.println("2. Menampilkan Kontak yang Terdapat dalam Satu Grup");
            System.out.println("0. Keluar");
            System.out.println("----------------------------------");
            System.out.print("Masukkan Pilihan = ");
            pil = in.next();
            System.out.println("----------------------------------");
            switch(pil){
                case "1":
                    if(Nama.isEmpty()){
                        System.out.println("Silahkan Masukkan Data Terlebih Dahulu");tambahkontak();tampilkontak();break;
                    }else{
                        System.out.printf("|%-25s|%-20s|%-15s|%-15s|%-15s|\n","Nama","Alamat","No. Hp","Provider","Grup");
                        for(i = 0; i < Nama.size();i++) {
                            System.out.printf("|%-25s|%-20s|%-15s|%-15s|%-15s|\n", Nama.get(i), Alamat.get(i), Hp.get(i), Provider.get(i), Grup.get(i));
                        }
                    }System.out.println("----------------------------------");break;
                case "2":
                    if(Nama.isEmpty()){
                        System.out.println("Data Kosong, Silahkan Masukkan Data Terlebih Dahulu");tambahkontak();tampilkontak();break;
                    }else{
                        System.out.print("Masukkan Nama Grup = ");
                        tanya = in.next();
                        go = false;
                        System.out.printf("|%-25s|%-15s|%-20s|%-15s|%-15s|\n","Nama","Alamat","No. Hp","Provider","Grup");
                        for(i = 0; i < Grup.size();i++) {
                            sa = Grup.get(i).toString();
                            if (tanya.equalsIgnoreCase(sa)) {
                                go = true;
                                System.out.printf("|%-25s|%-15s|%-20s|%-15s|%-15s|\n", Nama.get(i), Alamat.get(i), Hp.get(i), Provider.get(i), Grup.get(i));
                            }
                        }
                        if(!tanya.equalsIgnoreCase(sa)){
                            go = false;
                            System.out.printf("|%-25s|%-15s|%-20s|%-15s|%-15s|\n","-","-","-","-","-");
                        }

                    }System.out.println("----------------------------------");break;
                case "0": showMenu();break;
                default:System.out.println("Masukkan Salah");break;
            }
        }while(jalan);
    }
    private static void carinama(){
        do{
            if(Nama.isEmpty()){
                System.out.println("Data Kosong, Silahkan Masukkan Data Terlebih Dahulu");tambahkontak();carinama();break;
            }else{
                System.out.print("Nama yang Dicari = ");
                in.nextLine();
                tanya = in.nextLine();
                System.out.println("----------------------------------");
                go = false;
                for(i = 0; i < Nama.size(); i++){
                    sa = Nama.get(i).toString();
                    if(tanya.equalsIgnoreCase(sa)){
                        go = true;
                        System.out.printf("Nama     : %s \nAlamat   : %s \nNo. Hp   : %s \nProvider : %s \nGrup     : %s\n",Nama.get(i), Alamat.get(i), Hp.get(i), Provider.get(i), Grup.get(i));
                        System.out.println();
                        System.out.println("----------------------------------");
                        System.out.print("Apakah Anda Ingin Mencari Nama Lagi <y/n> ? ");
                        ulang();break;
                    }
                }
                if(go = false){
                    System.out.println("Data Tidak Ditemukan");carinama();break;
                }
            }System.out.println("----------------------------------");
        }while (jalan);
    }
    private static void caritelepon(){
        do{
            if(Hp.isEmpty()){
                System.out.println("Data Kosong, Silahkan Masukkan Data Terlebih Dahulu");tambahkontak();carinama();break;
            }else{
                System.out.print("Nomor Telepon yang Dicari = ");
                tanya = in.next();
                go = false;
                System.out.println("----------------------------------");
                for(i = 0; i < Hp.size(); i++) {
                    sa = Hp.get(i).toString();
                    if (tanya.equalsIgnoreCase(sa)) {
                        go = true;
                        System.out.printf("Nama     : %s \nAlamat   : %s \nNo. Hp   : %s \nProvider : %s \nGrup     : %s\n", Nama.get(i), Alamat.get(i), Hp.get(i), Provider.get(i), Grup.get(i));
                        System.out.println();
                        System.out.println("----------------------------------");
                        System.out.print("Apakah Anda Ingin Mencari No.Hp Lagi <y/n> ? ");
                        ulang();break;
                    }
                }
                if(go = false){
                    System.out.println("Data Tidak Ditemukan");caritelepon();break;
                }
            }System.out.println("----------------------------------");
        }while(jalan);
    }
    private static void editdata(){
        if(Nama.isEmpty()){
            System.out.println("Data Kosong, Silahkan Masukkan Data Terlebih Dahulu");tambahkontak();
        }else{
            System.out.print("Masukkan Nama Kontak yang akan Diedit = ");
            in.nextLine();
            tanya = in.nextLine();
            System.out.println("----------------------------------");
            for(i = 0; i < Nama.size(); i++){
                sa = Nama.get(i).toString();
                if(tanya.equalsIgnoreCase(sa)){
                    go = true;
                    System.out.println("Data Ditemukan!");
                    do {
                        System.out.println("Data yang Ingin Diedit");
                        System.out.println("1. Nama");
                        System.out.println("2. Alamat");
                        System.out.println("3. No. Hp");
                        System.out.println("4. Provider");
                        System.out.println("5. Grup");
                        System.out.println("0. Keluar");
                        System.out.print("Masukkan Pilihan = ");
                        pil = in.next();
                        System.out.println("----------------------------------");
                        switch (pil){
                            case "1":
                                System.out.print("Masukkan Nama Baru = ");
                                in.nextLine();
                                nama = in.nextLine();
                                Nama.set(i, nama);
                                edit();break;
                            case "2":
                                System.out.print("Masukkan Alamat Baru = ");
                                in.nextLine();
                                alamat = in.nextLine();
                                Alamat.set(i, alamat);
                                edit();break;
                            case "3":
                                System.out.print("Masukkan No. Hp Baru = ");
                                hp = in.next();
                                Hp.set(i, hp);
                                edit();break;
                            case "4":
                                System.out.print("Masukkan Provider Baru = ");
                                provider = in.next();
                                Provider.set(i, provider);
                                edit();break;
                            case "5":
                                System.out.print("Masukkan Grup Baru = ");
                                grup = in.next();
                                Grup.set(i, grup);
                                edit();break;
                            case "0": showMenu();break;
                            default: System.out.println("Masukkan Salah");break;
                        }
                    }while(jalan);
                }
            }
            if(!tanya.equalsIgnoreCase(sa)){
                System.out.println("Masukkan Salah");editdata();
            }
        }
    }
    private static void edit(){
        System.out.println("----------------------------------");
        System.out.print("Apakah Anda Ingin Mengedit Data Lagi <y/n>? ");
        ulang();
    }
    private static void hapuskontak() {
        if (Nama.isEmpty()) {
            System.out.println("Data Kosong");
            tambahkontak();
        } else {
            do {
                System.out.println("1. Berdasarkan Nama");
                System.out.println("2. Berdasarkan No HP");
                System.out.println("0. Keluar");
                System.out.println("----------------------------------");
                System.out.print("Masukkan Pilihan = ");
                tanya = in.next();
                switch (tanya){
                    case "0": showMenu();break;
                    case "1":
                        System.out.print("Masukkan Nama yang ingin dihapus = ");
                        in.nextLine();
                        nama = in.nextLine();
                        go = false;
                        for(int i =0; i < Nama.size();i++){
                            sa = Nama.get(i).toString();
                            if(nama.equalsIgnoreCase(sa)){
                                go = true;
                                Nama.remove(i);Alamat.remove(i);Hp.remove(i);Provider.remove(i);Grup.remove(i);
                                System.out.println("Data Berhasil Dihapus");
                                System.out.println("----------------------------------");
                                System.out.print("Apakah Anda Ingin Menghapus Data Lagi <y/n>? ");
                                ulang();break;
                            }
                        }
                        if(!nama.equalsIgnoreCase(sa)){
                            System.out.println("Maaf Data Tidak Ditemukan");
                            System.out.println("----------------------------------");
                            hapuskontak();break;
                        }break;
                    case "2":
                        System.out.print("Masukkan No HP yang ingin dihapus = ");
                        hp = in.next();
                        for(int i =0; i < Hp.size();i++){
                            go = true;
                            sa = Hp.get(i).toString();
                            if(hp.equalsIgnoreCase(sa)){
                                go = true;
                                Nama.remove(i);Alamat.remove(i);Hp.remove(i);Provider.remove(i);Grup.remove(i);
                                System.out.println("Data Berhasil Dihapus");
                                System.out.println("----------------------------------");
                                System.out.print("Apakah Anda Ingin Menghapus Data Lagi <y/n>? ");
                                ulang();break;
                            }
                        }
                        if(!hp.equalsIgnoreCase(sa)){
                            System.out.println("Maaf Data Tidak Ditemukan");
                            System.out.println("----------------------------------");
                            hapuskontak();break;
                        }break;
                    default:
                        System.out.println("Masukkan Salah");
                        System.out.println("----------------------------------");hapuskontak();break;
                }
            }while(jalan);
        }
    }
    private static void def(ArrayList Nama, ArrayList Alamat, ArrayList Hp, ArrayList Provider, ArrayList Grup){
        Nama.add("Adi");Nama.add("Budi");Nama.add("Didin");Nama.add("Dodo");Nama.add("Candra");Nama.add("Lita");
        Nama.add("Nina");Nama.add("Citra");Nama.add("Tere");
        Alamat.add("Jl. Sumbersari");Alamat.add("Jl. Kertokertoan");Alamat.add("Jl. Jalan");Alamat.add("Jl. Sigura");
        Alamat.add("Jl. Veteran");Alamat.add("Griya Shanta");Alamat.add("Griya Brawijaya");Alamat.add("Rusunawa");Alamat.add("Dieng");
        Hp.add("082134568");Hp.add("088721381");Hp.add("087293819");Hp.add("081237821");Hp.add("098213458");Hp.add("081234111");Hp.add("089999222");
        Hp.add("086523246");Hp.add("088531516");
        Provider.add("XL");Provider.add("Indosat");Provider.add("Simpati");Provider.add("Axis");Provider.add("3");Provider.add("Simpati");
        Provider.add("XL");Provider.add("Indosat");Provider.add("3");
        Grup.add("Pemdas"); Grup.add("Pemlan");Grup.add("Pemdas");Grup.add("ASD");Grup.add("Pemlan");Grup.add("ASD");Grup.add("Pemdas");
        Grup.add("Jarkom");Grup.add("Pemdas");
    }
    public static void main(String[] args){
        def(Nama,Alamat,Hp,Provider,Grup);
        System.out.println("PROGRAM BUKU TELPON");
        System.out.println("----------------------------------");
        showMenu();
    }

    public static class ContohMethod003 {
        public static void main(String[] args){
            int[] a = {9,5,10,14,8,2,25,32,35,4};
            a = menuArrayInt1Dim(a);
            /*
            cariIndeksArrayInt1Dim(25, a);
            cariIndeksArrayInt1Dim1(25,a);
            cariIndeksArrayInt1Dim2(75,a);
            System.out.printf("Sigma = %d  Rata2 = %d/%d = %.2f\n",
                    sigmaArrayInt1Dim(a),sigmaArrayInt1Dim(a),a.length,
                    rata2ArrayInt1Dim(a));
            //min dan maks

            System.out.printf("Nilai Minimum = %d, dan Maksimum = %d\n",
                    minArrayInt1Dim(a),maksArrayInt1Dim(a));
            tampilArrayInt1Dim(a);
            a = tambahElemenArrayInt1Dim(a,65);
            tampilArrayInt1Dim(a);

            a=hapusElemenArrayInt1Dim(a,10);


            tampilArrayInt1Dim(a);
            */
        }

        static int[] menuArrayInt1Dim(int[] a){
            int pilih=0;
            Scanner inp = new Scanner(System.in);
            do{
                System.out.println("MENU PROGRAM ARRAY INT 1 DIMENSI");
                System.out.println("1. Tampil Elemen Array");
                System.out.println("2. Tambah Elemen Array");
                System.out.println("3. Hapus Elemen Array");
                System.out.println("4. Cari Elemen Array");
                System.out.println("5. Nilai Elemen Maksimum");
                System.out.println("6. Nilai Elemen Minimum");
                System.out.println("7. Nilai Sigma");
                System.out.println("8. Nilai Rata-rata");
                System.out.println("9. Sorting");
                System.out.println("10. Selesai");
                System.out.print("PILIH SALAH SATU <1..10>? ");
                pilih = inp.nextInt();
                switch (pilih){
                    case 1 : tampilArrayInt1Dim(a); break;
                    case 9 : sortArrayInt1Dim(a); break;
                }
            } while(pilih != 10);
            return a;
        }

        static void cariIndeksArrayInt1Dim(int cari, int[] a){
            //int cari = 25;
            int i;
            //for
            for(i=0; i<a.length; i++){
                if(cari==a[i]){
                    System.out.printf("Ketemu di indeks ke: %d\n", i);
                    break;
                }
            }
            if(i>=a.length) System.out.println("Tidak Ketemu");
        }
        static void cariIndeksArrayInt1Dim1(int cari, int[] a){
            //do-while
            int i=-1;
            do i++; while(i<a.length && a[i]!=cari);
            if(i>=a.length) System.out.println("Tidak Ketemu");
            else System.out.printf("Ketemu di indeks ke: %d\n", i);
        }

        static void cariIndeksArrayInt1Dim2(int cari, int[] a){
            //while
            int i=0;
            while(i<a.length && cari!=a[i]) i++;
            if(i>=a.length) System.out.println("Tidak Ketemu");
            else System.out.printf("Ketemu di indeks ke: %d\n", i);
        }
        static int sigmaArrayInt1Dim(int[] a){
            int sigma =0;
            for(int i=0;i<a.length;i++) sigma+=a[i];
            return sigma;
        }
        static double rata2ArrayInt1Dim(int[] a){
            //Rata2
            return (double)sigmaArrayInt1Dim(a)/a.length;
        }

        static int minArrayInt1Dim(int[] a){
            int min=a[0];
            for(int i=1;i<a.length;i++){
                if(min>a[i]) min=a[i];
            }
            return min;
        }
        static int maksArrayInt1Dim(int[] a){
            int maks=a[0];
            for(int i=1;i<a.length;i++){
                if(maks<a[i]) maks=a[i];
            }
            return maks;
        }

        static int[] tambahElemenArrayInt1Dim(int[] a, int tambah){
            //tambah elemen
            int[] t = new int[a.length+1];
            for(int i=0;i<a.length;i++) t[i]=a[i];
            t[t.length-1]=tambah;
            return t;
        }

        static void tampilArrayInt1Dim(int[] a){
            //tampil array a
            for(int j=0;j<a.length;j++) System.out.print(a[j]+" ");
            System.out.println();
        }

        static int[] hapusElemenArrayInt1Dim(int[] a, int hapus){
            //hapus data
            int[] t;
            int m=0;
            for(int j=0; j<a.length; j++)
                if(a[j]==hapus) { a[j]=0; m++; }
            if(m==0) System.out.printf("%d tidak ditemukan\n",hapus);
            else {
                //proses hapus
                t = new int[a.length-m];
                int k=0;
                for(int j=0; j<a.length; j++)
                    if(a[j]!=0) {
                        t[k]=a[j];
                        k++;
                    }
                a=t;
            }
            return a;
        }
        static void sortArrayInt1Dim(int[] a){
            //sorting buble-sort
            for(int i=0; i<a.length-1;i++)
                for(int j=i+1; j<a.length; j++)
                    if(a[i]>a[j]){
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
        }
    }
}

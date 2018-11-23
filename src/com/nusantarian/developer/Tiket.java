package com.nusantarian.developer;

import java.util.*;

public class Tiket {
    private static Scanner in = new Scanner(System.in);
    private static boolean jalan = true;
    private static int a,no,jumlah, harga = 0,sum = 0;
    private static int [][] isi = new int[4][4];
    private static String [][] TiketPesawat = {
            {"0001","27 Oktober 2018","Malang","Jakarta"},
            {"0002","28 Oktober 2018","Jakarta","Malang"},
            {"0003","29 Oktober 2018","Jakarta","Surabaya"},
            {"0004","30 Oktober 2018","Surabaya","Jakarta"},
    };
    private static String [][] TiketKereta = {
            {"1001","1 November 2018","300000","Malang","Jakarta"},
            {"1002","2 November 2018","350000","Jakarta","Malang"},
            {"1003","3 November 2018","400000","Surabaya","Jakarta"},
            {"1004","4 November 2018","450000","Jakarta","Surabaya"},
    };
    private static ArrayList user = new ArrayList();
    private static ArrayList pass = new ArrayList();
    private static String username,tanya,pil,password;

    private static void showMenu(){
        System.out.println("Program Tiket Transportasi");
        System.out.println("-------------------------------------------------");
        do{
            System.out.println("1. Cek Tiket Pesanan");
            System.out.println("2. Batalkan Pemesanan");
            System.out.println("3. Pesan Tiket");
            System.out.println("4. Ubah Password");
            System.out.println("5. Keluar");
            System.out.print("Masukkan Pilihan = ");
            pil = in.next();
            switch (pil){
                case "1": cek();break;
                case "3": pesan();break;
                case "5": System.out.println("Terimakasih Telah Menggunakan Program Kami");jalan = false;break;
                default:System.out.println("Masukkan Salah!");break;
            }
        }while (jalan);
    }
    private static void access(){
        do{
            System.out.println("1. Login");
            System.out.println("2. Daftar");
            System.out.println("3. Exit");
            System.out.println("-------------------------------------------------");
            System.out.print("Masukkan Pilihan = ");
            pil = in.next();
            System.out.println("-------------------------------------------------");
            switch (pil){
                case "1": login();break;
                case "2": daftar();break;
                case "3": System.out.println("Terimakasih Telah Menggunakan Program Kami");jalan = false;break;
                default:System.out.println("Masukkan Salah!");break;
            }
        }while (jalan);
    }

    private static void daftar() {
        System.out.print("Masukkan Username = ");
        username = in.next();
        System.out.print("Masukkan Password = ");
        password = in.next();
        user.add(username);
        pass.add(password);
        System.out.println("Data Tersimpan!");
        System.out.println("-------------------------------------------------");
        access();
    }

    private static void login() {
        if(user.isEmpty()&&pass.isEmpty()){
            System.out.println("Belum Ada Akun, Silahkan Daftar Akun Terlebih Dahulu");daftar();
        }else {
            System.out.print("Masukkan Username = ");
            username = in.next();
            System.out.print("Masukkan Password = ");
            password = in.next();
            System.out.println("-------------------------------------------------");
            for(int i = 0; i < user.size();i++){
                tanya = user.get(i).toString();
                if(username.equalsIgnoreCase(tanya)||password.equalsIgnoreCase(tanya)){
                    showMenu();
                }else{
                    System.out.println("Masukkan Salah");return;
                }
            }
        }
    }
    private static void cek(){
        do{
            for(int i = 0; i < isi.length;i++){
                for(int j = 0; j < isi[i].length;j++){
                    if(isi [i][j] == 0){
                        System.out.println("Anda Belum Melakukan Pemesanan, Silahkan Lakukan Pemesanan Terlebih Dahulu");pesan();
                    }
                }
            }
        }while (jalan);
    }
    private static void pesan(){
        System.out.println("Pilih Jenis Transportasi yang Diinginkan");
        System.out.println("-------------------------------------------------");
        System.out.println("1. Kereta");
        System.out.println("2. Pesawat");
        System.out.println("0. Keluar");
        System.out.print("Masukkan Pilihan = ");
        pil = in.next();
        System.out.println("-------------------------------------------------");
        switch (pil){
            case "0": showMenu();break;
            case "1": kereta();break;
        }
    }
    private static void kereta(){
        do{
            System.out.printf("|%-5s|%-5s|%-20s|%-10s|%-10s|%-10s|\n","No","Id","Tanggal Keberangkatan","Harga","Asal","Tujuan");
            for(int i = 0; i < TiketKereta.length;i++){
                System.out.printf("|%-3d|%-5s|%-20s|%-15s|%-10s|%-10s|\n",i+1,TiketKereta[i][0],TiketKereta[i][1],TiketKereta[i][2],TiketKereta[i][3],TiketKereta[i][4]);
            }
            System.out.print("Masukkan No Kereta    = ");
            no = in.nextByte();
            System.out.print("Masukkan Jumlah Tiket = ");
            jumlah = in.nextByte();
            a = Integer.parseInt(TiketKereta[no - 1][2]);
            harga = a * jumlah;
            if(no == 1){
                isi[0][0]+=jumlah;isi[0][1]+=harga;
            }
            if(no == 2){
                isi[1][0]+=jumlah;isi[1][1]+=harga;
            }
            if(no == 3){
                isi[2][0]+=jumlah;isi[2][1]+=harga;
            }
            if(no == 4){
                isi[3][0]+=jumlah;isi[3][1]+=harga;
            }
            sum = isi[0][1] + isi[1][1] + isi[2][1] + isi [3][1];
            System.out.print("Apakah Anda Ingin Melakukan Pemesanan Lagi <y/n> ? ");
            ulang();
        }while (jalan);
    }
    private static void ulang(){
        tanya = in.next();
        if("y".equalsIgnoreCase(tanya)){
            return;
        }
        if("n".equalsIgnoreCase(tanya)){
            showMenu();
        }else{
            System.out.print("Masukkan Salah");ulang();
        }
    }
    public static void main(String[] args){
        access();
    }
}

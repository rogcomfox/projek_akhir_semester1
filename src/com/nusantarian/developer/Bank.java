package com.nusantarian.developer;

import java.util.Scanner;

public class Bank {
    private static Scanner in = new Scanner(System.in);
    private static String username, pil, password;
    private static boolean jalan = true;
    private static int i;
    private static String[][] Bank ={
            {"Okza","123456","ABC","00000000","500000"},
            {"Farhan","234567","ABC","00000001","2000000"},
            {"Syarief","345678","Diriman","11111110","1500000"},
            {"Titus","456789","IBN","22222202","700000"},
            {"Darell","567890","IRB","33333303","100000000"}
    };
    private static void masuk(){
        do{
            System.out.print("Masukkan Username = ");
            username = in.next();
            System.out.print("Masukkan Password = ");
            password = in.next();
            for(i = 0; i < Bank.length;i++){
                if(username.equalsIgnoreCase(Bank[i][0]) && password.equalsIgnoreCase(Bank[i][1])){
                    System.out.println("-------------------------------------");menu();
                }
                if(!username.equalsIgnoreCase(Bank[i][0]) && !password.equalsIgnoreCase(Bank[i][1])) {
                    System.out.println("Masukkan Salah");masuk();
                }
            }
        }while (jalan);
    }
    private static void showMenu(){
        do{
            System.out.println("Program ATM Bank IBN");
            System.out.println("-------------------------------------");
            System.out.println("1. Daftar Rekening");
            System.out.println("2. Masuk");
            System.out.println("0. Keluar");
            System.out.println("-------------------------------------");
            System.out.print("Masukkan Pilihan = ");
            pil = in.next();
            System.out.println("-------------------------------------");
            switch(pil){
                case "1": tampil();break;
                case "2": masuk();break;
                case "0": System.out.println("Terimakasih Telah Menggunakan Program Kami");break;
                default:System.out.println("Masukkan Salah");break;
            }
        }while (!pil.equals("0"));
    }
    private static void tampil(){
        System.out.println("Daftar Rekening");
        System.out.printf("|%-10s|%-10s|%-11s|\n","Username","Bank","No Rekening");
        for(int i = 0; i < Bank.length; i++){
            System.out.printf("|%-10s|%-10s|%-11s|\n",Bank[i][0],Bank[i][2],Bank[i][3]);
        }
        System.out.println("-------------------------------------");
    }
    private static void menu(){
        do{
            System.out.println("1. Informasi Saldo");
            System.out.println("2. Penarikan Tunai");
            System.out.println("3. Transfer");
            System.out.println("    1. Sesama Bank X");
            System.out.println("    2. Selain Bank X");
            System.out.println("    3. Kembali");
            System.out.println("4. Ganti PIN");
            System.out.println("5. Keluar");
            System.out.println("-------------------------------------");
            System.out.print("Masukkan Pilihan = ");
            pil = in.next();
            System.out.println("-------------------------------------");
            switch (pil){
                case "4": ganti();break;
                case "5": System.out.println("Terimakasih Telah Menggunakan Program Ini");break;
            }
        }while (!pil.equals("5"));
    }
    private static void ganti(){
        System.out.print("Masukkan Username = ");
    }
    public static void main(String[] args){
        showMenu();
    }
}
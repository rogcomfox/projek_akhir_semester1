package com.nusantarian.developer;

import java.util.Scanner;

public class Bank {
    static Scanner in = new Scanner(System.in);
    static String username, pil, password;
    static boolean jalan = true;
    static String[][] Bank ={
            {"Okza","123456","ABC","00000000","500000"},
            {"Farhan","234567","ABC","00000001","2000000"},
            {"Syarief","345678","Diriman","11111110","1500000"},
            {"Titus","456789","IBN","22222202","700000"},
            {"Darell","567890","IRB","33333303","100000000"}
    };
    public static void masuk(){
        do{
            System.out.print("Masukkan Username = ");
            username = in.next();
            System.out.print("Masukkan Password = ");
            password = in.next();
            for(int i = 0; i < Bank.length;i++){
                if(username.equalsIgnoreCase(Bank[i][0]) && password.equalsIgnoreCase(Bank[i][1])){
                    System.out.println("-------------------------------------");menu();
                }else {
                    System.out.println("Masukkan Salah");break;
                }
            }
        }while (jalan);
    }
    public static void showMenu(){
        System.out.println("Program ATM Bank IBN");
        System.out.println("-------------------------------------");
        System.out.println("1. Daftar Rekening");
        System.out.println("2. Masuk");
        System.out.println("-------------------------------------");
        System.out.print("Masukkan Pilihan = ");
        pil = in.next();
        System.out.println("-------------------------------------");
        switch(pil){
            case "1":
                System.out.println("Daftar Rekening");
                System.out.printf("|%-10s|%-10s|%-11s|\n","Username","Bank","No Rekening");
                for(int i = 0; i < Bank.length; i++){
                    System.out.printf("|%-10s|%-10s|%-11s|\n",Bank[i][0],Bank[i][2],Bank[i][3]);
                }
                System.out.println("-------------------------------------");break;
            case "2": masuk();break;
            default:System.out.println("Masukkan Salah");break;
        }
    }
    public static void menu(){
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
                case "5": System.out.println("Terimakasih Telah Menggunakan Program Ini");jalan = false;break;
            }
        }while (jalan);
    }
    public static void main(String[] args){
        showMenu();
    }
}
package com.nusantarian.developer;

import java.util.*;

public class NilaiMahasiswa {
    private static Scanner in = new Scanner(System.in);
    private static String[] Nama = new String [30];
    private static int[][] angka = new int[30][2];
    private static boolean jalan = true,go;
    private static String pil,nama;
    private static int nim, nilai, count = 0;

    private static void showMenu(){
        System.out.println("Program Nilai Mahasiswa");
        System.out.println("---------------------------------------");
        do{
            System.out.println("1. Masukkan Nilai Mahasiswa");
            System.out.println("2. Ubah Nilai Mahasiswa");
            System.out.println("3. Lihat Nilai Mahasiswa");
            System.out.println("4. Cari Nilai Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Masukkan Pilihan = ");
            pil = in.next();
            System.out.println("---------------------------------------");
            switch (pil){
                case "1": tambahnilai();break;
                case "3": lihatnilai();break;
            }
        }while(jalan);
    }

    private static void tambahnilai() {
        do{
            System.out.print("Masukkan Nama  = ");
            nama = in.next();
            System.out.print("Masukkan Nim   = ");
            nim = in.nextInt();
            System.out.print("Masukkan Nilai = ");
            nilai = in.nextByte();
            for(int i = 0; i < count; i++){
                if (nama.equalsIgnoreCase(Nama[i])){
                    go = true;break;
                }
            }
            if(go = false){
                nim = angka[count][0];
                nilai = angka[count][1];
            }else{
                System.out.println("Maff Data Sudah Ada, Silahkan Masukkan Data Lain");
            }
        }while(jalan);
        count++;
        System.out.println("Data Berhasil Disimpan");
    }

    private static void lihatnilai() {
        if(Nama == null && angka == null){
            System.out.println("Data Kosong, Silahkan Isikan Data Terlebih Dahulu");tambahnilai();
        }
    }
}

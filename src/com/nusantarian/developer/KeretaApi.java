package com.nusantarian.developer;

import java.util.Scanner;

public class KeretaApi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int isi [][] = new int [4][5];
        String jadwal [][] ={

                {"Ekonomi","50000","2","Tidak Ada","Tidak Ada"},
                {"Bisnis","100000","5","Ada","Tidak Ada"},
                {"Eksekutif","200000","7","Ada","Tidak Ada"},
                {"Pariwisata","300000","10","Ada","Ada"},
        };
        int pilihan, no = 0,harga = 0,a,b,jumlah = 0,total = 0, sum = 0;
        boolean jalan = true;
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("JADWAL KERETA API DAN PEMESANAN TIKET");
        do{
            System.out.println("1. Melihat Daftar Kereta Api");
            System.out.println("2. Melihat Daftar Kereta Api yang ada AC");
            System.out.println("3. Melihat Daftar Kereta Api yang ada Colokan");
            System.out.println("4. Memesan Tiket Kereta Api");
            System.out.println("5. Melihat Pesanan Tiket");
            System.out.println("0. Keluar");
            System.out.println("-------------------------------------------------------------------------");
            System.out.print("Pilihan Anda : ");
            pilihan = input.nextInt();
            System.out.println("-------------------------------------------------------------------------");
            switch(pilihan){
                case 0 : System.out.print("Terimakasih telah menggunakan program ini");break;
                case 1 : System.out.println("Daftar Kereta Api");
                    System.out.println();
                    for(int bar = 0; bar < jadwal.length;bar++){
                        System.out.println("Jenis   : "+jadwal[bar][0]);
                        System.out.println("Harga   : "+jadwal[bar][1]);
                        System.out.println("Diskon  : "+jadwal[bar][2]+'%');
                        System.out.println("AC      : "+jadwal[bar][3]);
                        System.out.println("Colokan : "+jadwal[bar][4]);
                        System.out.println();
                    }
                    System.out.println("-------------------------------------------------------------------------");break;
                case 2 : System.out.println("Daftar Kereta dengan AC");
                    System.out.println();
                    for(int bar = 0; bar <jadwal.length;bar++){
                        if((jadwal[bar][3]) == "Ada"){
                            System.out.println("Jenis   : "+jadwal[bar][0]);
                            System.out.println("Harga   : "+jadwal[bar][1]);
                            System.out.println("Diskon  : "+jadwal[bar][2]+'%');
                            System.out.println("AC      : "+jadwal[bar][3]);
                            System.out.println("Colokan : "+jadwal[bar][4]);
                            System.out.println();
                        }
                    }
                    System.out.println("-------------------------------------------------------------------------");break;
                case 3 : System.out.println("Daftar Kereta dengan Colokan");
                    System.out.println();
                    for(int bar = 0;bar < jadwal.length;bar++){
                        if((jadwal[bar][4]) == "Ada"){
                            System.out.println("Jenis   : "+jadwal[bar][0]);
                            System.out.println("Harga   : "+jadwal[bar][1]);
                            System.out.println("Diskon  : "+jadwal[bar][2]+'%');
                            System.out.println("AC      : "+jadwal[bar][3]);
                            System.out.println("Colokan : "+jadwal[bar][4]);
                            System.out.println();
                        }
                    }
                    System.out.println("-------------------------------------------------------------------------");break;
                case 4 : System.out.println("Daftar Kereta");
                    for(int i = 0; i < jadwal.length; i++){
                        System.out.printf("%d. %s\n",i+1,jadwal[i][0]);
                    }
                    do{
                        System.out.print("Apakah ingin melakukan pemesanan (y/t)? ");
                        String tanya = input.next();
                        if(tanya.charAt(0) == 'y'||tanya.charAt(0) == 'Y'){
                            System.out.print("Pilih no Kereta = ");
                            no = input.nextInt();
                            System.out.print("Jumlah Tiket    = ");
                            jumlah = input.nextInt();
                            a = Integer.parseInt(jadwal[no-1][1]);
                            b = Integer.parseInt(jadwal[no-1][2]);
                            harga = ((a * jumlah)-((a * b / 100) * jumlah));
                            total = a * jumlah;
                            if(no == 1){
                                isi[0][0] += jumlah;isi[0][1]+=harga;isi[0][2]+=total;
                            }
                            if(no == 2){
                                isi[1][0] += jumlah;isi[1][1]+=harga;isi[1][2]+=total;
                            }
                            if(no == 3){
                                isi[2][0] += jumlah;isi[2][1]+=harga;isi[2][2]+=total;
                            }
                            if(no == 4){
                                isi[3][0] += jumlah;isi[3][1]+=harga;isi[3][2]+=total;
                            }
                            sum = isi[0][1] + isi[1][1] + isi[2][1] + isi[3][1];
                            System.out.println("-------------------------------------------------------------------------");
                        }
                        if(tanya.charAt(0) == 't'||tanya.charAt(0) == 'T'){
                            jalan = false;
                            System.out.println("-------------------------------------------------------------------------");
                        }
                    }while(jalan);break;
                case 5 : System.out.println("Daftar Pesanan Tiket");
                    System.out.printf("1. Ekonomi    = %d x Rp 50000  = Rp %d - Diskon 2%c  = Rp %d\n",isi[0][0],isi[0][2],'%',isi[0][1]);
                    System.out.printf("2. Bisnis     = %d x Rp 100000 = Rp %s - Diskon 5%c  = Rp %s\n",isi[1][0],isi[1][2],'%',isi[1][1]);
                    System.out.printf("3. Eksekutif  = %d x Rp 200000 = Rp %s - Diskon 7%c  = Rp %s\n",isi[2][0],isi[2][2],'%',isi[2][1]);
                    System.out.printf("4. Pariwisata = %d x Rp 300000 = Rp %s - Diskon 10%c = Rp %s\n",isi[3][0],isi[3][2],'%',isi[3][1]);
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.printf("                                        Total Pesanan  = Rp %d\n",sum);
                    System.out.println("-------------------------------------------------------------------------");break;
                default : System.out.println("Masukkan Salah");
            }
        } while(pilihan != 0);
        input.close();
    }
}
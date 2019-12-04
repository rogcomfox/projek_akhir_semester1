package RaportProjekAkhir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Raport {

    final static int MAX_SISWA = 10;
    final static int MAX_MATPEL = 10;
    final static int MAX_SEMESTER = 2;
    static String[] siswa = new String[MAX_SISWA];
    static String[][][] siswaMatpel = new String[MAX_SISWA][MAX_SEMESTER][MAX_MATPEL];
    static double[][][] siswaMatpelNilai = new double[MAX_SISWA][MAX_SEMESTER][MAX_MATPEL];
    static int banyakSiswa = 0;
    static int banyakSiswaMatpel = 0;

    public static String konversiNilai(double nilai) {
        String nilaiSiswa = "";
        if (nilai < 100 && nilai > 80) nilaiSiswa = "A";
        if (nilai <= 80 && nilai > 75) nilaiSiswa = "B+";
        if (nilai <= 75 && nilai > 69) nilaiSiswa = "B";
        if (nilai <= 69 && nilai > 65) nilaiSiswa = "C+";
        if (nilai <= 65 && nilai > 59) nilaiSiswa = "C";
        if (nilai <= 59 && nilai > 55) nilaiSiswa = "D+";
        if (nilai <= 55 && nilai > 40) nilaiSiswa = "D";
        if (nilai <= 40) nilaiSiswa = "E";
        return nilaiSiswa;
    }

    public static void tambahSiswa(String nama) {
        siswa[banyakSiswa] = nama;
        banyakSiswa++;
    }

    public static void tambahMatpel(String matpel) {
        siswaMatpel[banyakSiswa][0][banyakSiswaMatpel] = matpel;
        siswaMatpel[banyakSiswa][1][banyakSiswaMatpel] = matpel;
        banyakSiswaMatpel++;
    }

    public static int cariSiswa(String nama) {
        return 0;
    }

    public static int cariMatpel(String matpel) {
        return 0;
    }

    public static void isiDataSiswa(String nama, int semester, String matpel, int nilai) {
    }

    public static void printSiswa() {
        for (String s : siswa) {
            if (s != null) {
                System.out.print(s + " ");
            }
        }
        System.out.println();
    }

    public static void printMatpel() {
    }

    public static void printRaportSiswa(String nama) {
    }

    public static int cariJuara(int semester) {
        return 0;
    }

    public static void hitungNilai(int semester) {
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = in.readLine()).equals("")) {
            String[] arr = input.split(" ");
            switch (arr[0]) {
                case "SISWA":
                    tambahSiswa(arr[1]);
                    break;
                case "PRINT_SISWA":
                    printSiswa();
                    break;
                case "MATPEL":
                    tambahMatpel(arr[1]);
                    break;
                case "PRINT_MAPEL":
                    printMatpel();
                    break;
                case "NILAI":
                    int semester = 0;
                    int nilai = Integer.parseInt(arr[4]);
                    if (arr[2].equals("GANJIL")){
                        semester = 0;
                    }else if (arr[2].equals("GENAP")){
                        semester = 1;
                    }
                    isiDataSiswa(arr[1],semester,arr[3],nilai);
                    break;
                case "PRINT_RAPORT":
                    printRaportSiswa(arr[1]);
                    break;
                default:
                    break;
            }
        }
    }
}

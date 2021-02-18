package strukturdatadanlogika;
// @author Yusup Hidayat Winata

import java.util.Arrays;

public class StrukturDataDanLogika {
    public static void main(String[] args) {
        int X[] = {6,8,1,4,7,2};
        int temp;
        
        System.out.println("X = " + Arrays.toString(X));
        
        //Pengurutan bilangan dalam integer
        for (int i = 0; i < X.length; i++) {
            for (int j = i+1; j < X.length; j++) {
                if (X[i] > X[j]) {
                    temp = X[i];
                    X[i] = X[j];
                    X[j] = temp;
                }
            }
        }
        
        //Penjumlahan bilangan dalam integer
        temp = 0;
        for (int i = 0; i < X.length; i++) {
            temp += X[i];
        }
        
        //Cetak jawaban
        System.out.println("Total bilangan dalam kumpulan integer\t\t = " + temp);
        System.out.println("Urutan bilangan dari terkecil ke terbesar\t = " + Arrays.toString(X));
        System.out.println("Nilai terbesar dari kumpulan integer\t\t = " + X[X.length-1]);
        System.out.println("Nilai terbesar ke-3 dari kumpulan integer\t = " + X[X.length-3]);
    }
}
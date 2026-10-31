
import Model.Etkinlik;
import Veritabani.EtkinlikIslemleri;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== KAMPUS ETKINLIK YONETIM SISTEMI ===");

        System.out.print("Etkinlik ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Etkinlik adi: ");
        String ad = scanner.nextLine();

        System.out.print("Etkinlik turu: ");
        String tur = scanner.nextLine();

        System.out.print("Etkinlik tarihi (GG-AA-YYYY): ");
        String tarih = scanner.nextLine();

        System.out.print("Etkinlik yeri: ");
        String yer = scanner.nextLine();

        System.out.print("Kontenjan: ");
        int kontenjan = scanner.nextInt();

        Etkinlik yeniEtkinlik = new Etkinlik(
                id, ad, tur, tarih, yer, kontenjan
        );

        EtkinlikIslemleri.etkinlikEkle(yeniEtkinlik);

        System.out.println("\n=== KAYITLI ETKINLIKLER ===");

        EtkinlikIslemleri.etkinlikleriListele();

        scanner.close();
    }
}

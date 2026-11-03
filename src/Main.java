import model.Etkinlik;
import veritabani.EtkinlikIslemleri;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        EtkinlikIslemleri islemler = new EtkinlikIslemleri();

        System.out.print("Etkinlik ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Etkinlik adı: ");
        String ad = input.nextLine();

        System.out.print("Etkinlik türü: ");
        String tur = input.nextLine();

        System.out.print("Etkinlik tarihi (GG-AA-YYYY): ");
        String tarih = input.nextLine();

        System.out.print("Etkinlik yeri: ");
        String yer = input.nextLine();

        System.out.print("Kontenjan: ");
        int kontenjan = input.nextInt();

        Etkinlik etkinlik = new Etkinlik(
                id, ad, tur, tarih, yer, kontenjan
        );

        islemler.etkinlikKaydet(etkinlik);

        input.close();
    }
}
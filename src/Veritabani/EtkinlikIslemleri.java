
package Veritabani;

import Model.Etkinlik;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;

public class EtkinlikIslemleri {

    private static final String DOSYA = "Etkinlikler_Liste.txt";

    // Yeni etkinlik ekleme
    public static void etkinlikEkle(Etkinlik etkinlik) {

        try (BufferedWriter yazici = Files.newBufferedWriter(
                Path.of(DOSYA),
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {

            yazici.write(
                    etkinlik.getId() + ";" +
                            etkinlik.getAd() + ";" +
                            etkinlik.getTur() + ";" +
                            etkinlik.getTarih() + ";" +
                            etkinlik.getYer() + ";" +
                            etkinlik.getKontenjan()
            );

            yazici.newLine();

            System.out.println("Etkinlik basariyla eklendi.");

        } catch (IOException e) {

            System.out.println("Kayit hatasi: " + e.getMessage());

        }
    }

    // Etkinlikleri listeleme
    public static void etkinlikleriListele() {

        ArrayList<String> etkinlikler = new ArrayList<>();

        try (BufferedReader okuyucu = Files.newBufferedReader(
                Path.of(DOSYA), StandardCharsets.UTF_8)) {

            String satir;

            while ((satir = okuyucu.readLine()) != null) {
                etkinlikler.add(satir);
            }

            if (etkinlikler.isEmpty()) {
                System.out.println("Kayitli etkinlik bulunamadi.");
                return;
            }

            for (String etkinlik : etkinlikler) {

                String[] bilgiler = etkinlik.split(";");

                System.out.println("--------------------------");
                System.out.println("ID: " + bilgiler[0]);
                System.out.println("Ad: " + bilgiler[1]);
                System.out.println("Tur: " + bilgiler[2]);
                System.out.println("Tarih: " + bilgiler[3]);
                System.out.println("Yer: " + bilgiler[4]);
                System.out.println("Kontenjan: " + bilgiler[5]);

            }

        } catch (NoSuchFileException e) {

            System.out.println("Henuz etkinlik dosyasi olusturulmamis.");

        } catch (IOException e) {

            System.out.println("Okuma hatasi: " + e.getMessage());

        }
    }
}

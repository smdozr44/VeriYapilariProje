package VeriTabani;
import java.util.ArrayList;
import java.io.*;

public class EtkinlikDosyaIslemleri {
    private final String dosyaYolu = "etkinlikler.txt";

    public void EtkinlikKaydet(String veri) {

        try (BufferedWriter yazici = new BufferedWriter(new FileWriter(dosyaYolu, true))) {

            yazici.write(veri);
            yazici.newLine();

        } catch (IOException e) {

            System.out.println("Dosyaya kayıt yapılamadı: " + e.getMessage());

        }

    }

    public ArrayList<String[]> EtkinlikleriOku() {

        ArrayList<String[]> etkinlikler = new ArrayList<>();

        File dosya = new File(dosyaYolu);

        if (!dosya.exists()) {
            return etkinlikler;
        }

        try (BufferedReader okuyucu = new BufferedReader(new FileReader(dosyaYolu))) {

            String satir;

            while ((satir = okuyucu.readLine()) != null) {

                String[] bilgiler = satir.split(";", -1);

                if (bilgiler.length == 6) {
                    etkinlikler.add(bilgiler);
                }

            }

        } catch (IOException e) {

            System.out.println("Dosya okunamadı: " + e.getMessage());

        }

        return etkinlikler;
    }

    public void EtkinlikleriKaydet(ArrayList<String[]> etkinlikler) {

        try (BufferedWriter yazici = new BufferedWriter(new FileWriter(dosyaYolu))) {

            for (String[] etkinlik : etkinlikler) {

                String satir = String.join(";", etkinlik);

                yazici.write(satir);
                yazici.newLine();

            }

        } catch (IOException e) {

            System.out.println("Dosya güncellenemedi: " + e.getMessage());

        }

    }
}

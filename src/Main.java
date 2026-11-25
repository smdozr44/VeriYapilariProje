import Form.formUI;
import VeriTabani.EtkinlikDosyaIslemleri;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
      formUI calistir = new formUI();
      calistir.FormCalistir();

        EtkinlikDosyaIslemleri dosya = new EtkinlikDosyaIslemleri();

        ArrayList<String[]> etkinlikler = dosya.EtkinlikleriOku();

        for (String[] etkinlik : etkinlikler) {
            for (String bilgi : etkinlik) {
                System.out.print(bilgi + " | ");
            }

            System.out.println();

        }
    }
}
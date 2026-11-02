package Veritabani;

import Model.Etkinlik;
import java.io.FileWriter;
import java.io.IOException;

public class EtkinlikIslemleri {

    public void etkinlikKaydet(Etkinlik etkinlik) {

        try {

            FileWriter yazici = new FileWriter("etkinlikler.txt", true);


            yazici.write(
                                   "-----ETKİNLİK BİLGİLERİ----- \n"+
                            "Etkinlik NO: "                  + etkinlik.getId()  + "\n"+
                            "Etkinlik İsim: "                + etkinlik.getAd() + "\n"+
                            "Etkinlik Türü: "                 + etkinlik.getTur() + "\n"+
                            "Etkinlik Tarihi: "              + etkinlik.getTarih() + "\n"+
                            "Etkinlik Konum: "               + etkinlik.getYer() + "\n"+
                            "Kontenjan: "                    + etkinlik.getKontenjan() + "\n"+
                                   "---------------------------------- \n"
            );

            yazici.close();

        } catch (IOException e) {

            System.out.println("Kayıt sırasında hata oluştu.");

        }
    }
}
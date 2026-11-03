package service;

import model.Basvuru;
import model.Etkinlik;
import java.time.LocalDateTime;

public class BasvuruManager {


    public Basvuru basvuruYap(int basvuruId, Etkinlik etkinlik, int katilimciId) {
        String durum;


        if (etkinlik.getAsilKayitSayisi() < etkinlik.getKontenjan()) {
            durum = "ASIL";
            etkinlik.setAsilKayitSayisi(etkinlik.getAsilKayitSayisi() + 1);
            System.out.println("Başarılı! Asil listeye eklendiniz.");
        } else {
            durum = "YEDEK";
            System.out.println("Kontenjan dolu! Yedek sırasına alındınız.");
        }


        Basvuru yeniBasvuru = new Basvuru(basvuruId, etkinlik.getId(), katilimciId, LocalDateTime.now(), durum);


        if (durum.equals("YEDEK")) {
            etkinlik.getYedekListesi().ekle(yeniBasvuru);
        }

        return yeniBasvuru;
    }


    public void basvuruIptal(Basvuru iptalEdilenBasvuru, Etkinlik etkinlik) {

        System.out.println("Başvuru iptal ediliyor...");


        if (iptalEdilenBasvuru.getDurum().equals("ASIL")) {

            iptalEdilenBasvuru.setDurum("IPTAL");
            etkinlik.setAsilKayitSayisi(etkinlik.getAsilKayitSayisi() - 1);


            if (!etkinlik.getYedekListesi().isEmpty()) {


                Basvuru yeniAsil = etkinlik.getYedekListesi().cikar();
                yeniAsil.setDurum("ASIL");
                etkinlik.setAsilKayitSayisi(etkinlik.getAsilKayitSayisi() + 1);

                System.out.println("Yedek listedeki kişi ASİL listeye alındı. Katılımcı ID: " + yeniAsil.getKatilimciId());
            }
        }

        else if (iptalEdilenBasvuru.getDurum().equals("YEDEK")) {
            iptalEdilenBasvuru.setDurum("IPTAL");

            System.out.println("Yedek başvurunuz iptal edildi.");
        }
    }
}
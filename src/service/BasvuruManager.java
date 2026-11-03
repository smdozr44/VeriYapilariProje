package service;

import model.Basvuru;
import model.Etkinlik;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BasvuruManager {



    private ArrayList<Basvuru> tumBasvurular = new ArrayList<>();


    public Basvuru basvuruYap(int basvuruId, Etkinlik etkinlik, int katilimciId) {


        if (aktifBasvuruVarMi(etkinlik.getId(), katilimciId)) {
            System.out.println("Bu katılımcı bu etkinliğe zaten başvurmuş!");
            return null;
        }

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

        tumBasvurular.add(yeniBasvuru);
        return yeniBasvuru;
    }


    public void basvuruIptal(Basvuru iptalEdilenBasvuru, Etkinlik etkinlik) {

        System.out.println("Başvuru iptal ediliyor...");


        if (iptalEdilenBasvuru.getDurum().equals("ASIL")) {

            iptalEdilenBasvuru.setDurum("IPTAL");
            etkinlik.setAsilKayitSayisi(etkinlik.getAsilKayitSayisi() - 1);


            yedektenAsileAl(etkinlik);
        }

        else if (iptalEdilenBasvuru.getDurum().equals("YEDEK")) {
            iptalEdilenBasvuru.setDurum("IPTAL");



            etkinlik.getYedekListesi().sil(iptalEdilenBasvuru.getId());

            System.out.println("Yedek başvurunuz iptal edildi.");
        }

        else {
            System.out.println("Bu başvuru zaten iptal edilmiş.");
        }
    }




    public boolean kontenjanGuncelle(Etkinlik etkinlik, int yeniKontenjan) {

        if (yeniKontenjan <= 0) {
            System.out.println("Kontenjan 0'dan büyük olmalıdır.");
            return false;
        }

        if (yeniKontenjan < etkinlik.getAsilKayitSayisi()) {
            System.out.println("Kontenjan, mevcut asil katılımcı sayısının ("
                    + etkinlik.getAsilKayitSayisi() + ") altına düşürülemez!");
            return false;
        }

        etkinlik.setKontenjan(yeniKontenjan);
        yedektenAsileAl(etkinlik);
        return true;
    }




    private void yedektenAsileAl(Etkinlik etkinlik) {
        while (etkinlik.getAsilKayitSayisi() < etkinlik.getKontenjan()
                && !etkinlik.getYedekListesi().isEmpty()) {

            Basvuru yeniAsil = etkinlik.getYedekListesi().cikar();
            yeniAsil.setDurum("ASIL");
            etkinlik.setAsilKayitSayisi(etkinlik.getAsilKayitSayisi() + 1);

            System.out.println("Yedek listedeki kişi ASİL listeye alındı. Katılımcı ID: " + yeniAsil.getKatilimciId());
        }
    }


    private boolean aktifBasvuruVarMi(int etkinlikId, int katilimciId) {
        for (Basvuru b : tumBasvurular) {
            if (b.getEtkinlikId() == etkinlikId
                    && b.getKatilimciId() == katilimciId
                    && !b.getDurum().equals("IPTAL")) {
                return true;
            }
        }
        return false;
    }



    public ArrayList<Basvuru> getTumBasvurular() {
        return tumBasvurular;
    }
}
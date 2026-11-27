package model;

import datastructure.Kuyruk;

public class Etkinlik {
    private int id;
    private String ad;
    private String tur;
    private String tarih;
    private String konum;
    private int kontenjan;
    private String aciklama;

    private int asilKayitSayisi;
    private Kuyruk yedekListesi;


    public Etkinlik(int id, String ad, String tur, String tarih,
                    String konum, int kontenjan, String aciklama) {

        this.id = id;
        this.ad = ad;
        this.tur = tur;
        this.tarih = tarih;
        this.konum = konum;
        this.kontenjan = kontenjan;
        this.aciklama = (aciklama == null) ? "" : aciklama;
        this.asilKayitSayisi = 0;
        this.yedekListesi = new Kuyruk();
    }


    public int getId() { return id; }

    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getTur() { return tur; }
    public void setTur(String tur) { this.tur = tur; }

    public String getTarih() { return tarih; }
    public void setTarih(String tarih) { this.tarih = tarih; }

    public String getKonum() { return konum; }
    public void setKonum(String konum) { this.konum = konum; }

    public String getAciklama() { return aciklama; }
    public void setAciklama(String aciklama) {
        this.aciklama = (aciklama == null) ? "" : aciklama;5
    }

    public int getKontenjan() { return kontenjan; }
    public void setKontenjan(int kontenjan) { this.kontenjan = kontenjan; }

    public int getAsilKayitSayisi() { return asilKayitSayisi; }
    public void setAsilKayitSayisi(int asilKayitSayisi) {
        this.asilKayitSayisi = asilKayitSayisi;
    }

    public Kuyruk getYedekListesi() { return yedekListesi; }
}
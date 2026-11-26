package model;

import datastructure.Kuyruk;

public class Etkinlik {
    private int id;
    private String ad;
    private String tur;
    private String tarih;
    private String yer;
    private int kontenjan;
    private String aciklama;

    private int asilKayitSayisi;
    private Kuyruk yedekListesi;


    public Etkinlik(int id, String ad, String tur, String tarih, String yer, int kontenjan, String aciklama) {
        this.id = id;
        this.ad = ad;
        this.tur = tur;
        this.tarih = tarih;
        this.yer = yer;
        this.kontenjan = kontenjan;
        this.aciklama = (aciklama == null) ? "" : aciklama;
        this.asilKayitSayisi = 0;
        this.yedekListesi = new Kuyruk();
    }


    public Etkinlik(int id, String ad, String tur, String tarih, String yer, int kontenjan) {
        this(id, ad, tur, tarih, yer, kontenjan, "");
    }

    public int getId() { return id; }

    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getTur() { return tur; }
    public void setTur(String tur) { this.tur = tur; }

    public String getTarih() { return tarih; }
    public void setTarih(String tarih) { this.tarih = tarih; }

    public String getYer() { return yer; }
    public void setYer(String yer) { this.yer = yer; }

    public String getAciklama() { return aciklama; }
    public void setAciklama(String aciklama) { this.aciklama = (aciklama == null) ? "" : aciklama; }

    public int getKontenjan() { return kontenjan; }
    public void setKontenjan(int kontenjan) { this.kontenjan = kontenjan; }

    public int getAsilKayitSayisi() { return asilKayitSayisi; }
    public void setAsilKayitSayisi(int asilKayitSayisi) { this.asilKayitSayisi = asilKayitSayisi; }

    public Kuyruk getYedekListesi() { return yedekListesi; }
}
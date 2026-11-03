package model;

import datastructure.Kuyruk;

public class Etkinlik {
    private int id;
    private String ad;
    private String tur;
    private String tarih;
    private String yer;
    private int kontenjan;


    private int asilKayitSayisi;
    private Kuyruk yedekListesi;

    public Etkinlik(int id, String ad, String tur, String tarih, String yer, int kontenjan) {
        this.id = id;
        this.ad = ad;
        this.tur = tur;
        this.tarih = tarih;
        this.yer = yer;
        this.kontenjan = kontenjan;
        this.asilKayitSayisi = 0;
        this.yedekListesi = new Kuyruk();
    }


    public int getId() { return id; }
    public String getAd() { return ad; }
    public int getKontenjan() { return kontenjan; }
    public int getAsilKayitSayisi() { return asilKayitSayisi; }
    public void setAsilKayitSayisi(int asilKayitSayisi) { this.asilKayitSayisi = asilKayitSayisi; }
    public Kuyruk getYedekListesi() { return yedekListesi; }
}
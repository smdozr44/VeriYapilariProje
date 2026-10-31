package Model;

public class Etkinlik {

    private int id;
    private String ad;
    private String tur;
    private String tarih;
    private String yer;
    private int kontenjan;

    public Etkinlik(int id, String ad, String tur,
                    String tarih, String yer, int kontenjan) {

        this.id = id;
        this.ad = ad;
        this.tur = tur;
        this.tarih = tarih;
        this.yer = yer;
        this.kontenjan = kontenjan;

    }

    public int getId() {
        return id;
    }

    public String getAd() {
        return ad;
    }

    public String getTur() {
        return tur;
    }

    public String getTarih() {
        return tarih;
    }

    public String getYer() {
        return yer;
    }

    public int getKontenjan() {
        return kontenjan;
    }

}

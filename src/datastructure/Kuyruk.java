package datastructure;

import model.Basvuru;

public class Kuyruk {
    private Dugum bas;
    private Dugum son;
    private int boyut;

    public Kuyruk() {
        this.bas = null;
        this.son = null;
        this.boyut = 0;
    }


    public void ekle(Basvuru yeniBasvuru) {
        Dugum yeniDugum = new Dugum(yeniBasvuru);

        if (isEmpty()) {
            bas = yeniDugum;
            son = yeniDugum;
        } else {
            son.sonraki = yeniDugum;
            son = yeniDugum;
        }
        boyut++;
    }


    public Basvuru cikar() {
        if (isEmpty()) {
            return null;
        }

        Basvuru cikanVeri = bas.veri;
        bas = bas.sonraki;

        if (bas == null) {
            son = null;
        }

        boyut--;
        return cikanVeri;
    }


    public boolean isEmpty() {
        return bas == null;
    }


    public int getBoyut() {
        return boyut;
    }


    public boolean sil(int basvuruId) {
        Dugum onceki = null;
        Dugum gezgin = bas;

        while (gezgin != null && gezgin.veri.getId() != basvuruId) {
            onceki = gezgin;
            gezgin = gezgin.sonraki;
        }

        if (gezgin == null) {
            return false;
        }

        if (onceki == null) {
            bas = gezgin.sonraki;
        } else {
            onceki.sonraki = gezgin.sonraki;
        }

        if (gezgin == son) {
            son = onceki;
        }

        boyut--;
        return true;
    }
}
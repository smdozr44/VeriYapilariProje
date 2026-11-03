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
}

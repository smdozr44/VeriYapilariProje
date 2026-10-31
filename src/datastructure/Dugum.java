package datastructure;

import model.Basvuru;

public class Dugum {
    public Basvuru veri;
    public Dugum sonraki;

    public Dugum(Basvuru veri) {
        this.veri = veri;
        this.sonraki = null;
    }
}
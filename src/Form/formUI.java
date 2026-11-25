package Form;
import VeriTabani.EtkinlikDosyaIslemleri;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class formUI {

    JFrame form = new JFrame();

    JPanel baslikPanel = new JPanel();
    JPanel formPanel = new JPanel();
    JPanel tabloPanel = new JPanel();

    JLabel baslikLabel = new JLabel("KAMPÜS ETKİNLİK YÖNETİM SİSTEMİ");
    JLabel formBaslik = new JLabel("ETKİNLİK BİLGİLERİ");

    JLabel etkinlikIsimLabel = new JLabel("Etkinlik Adı");
    JLabel tarihLabel = new JLabel("Tarih");
    JLabel konumLabel = new JLabel("Konum");
    JLabel kontenjanLabel = new JLabel("Kontenjan");
    JLabel aciklamaLabel = new JLabel("Açıklama");

    JTextField etkinlikIsimField = new JTextField();
    JTextField tarihField = new JTextField();
    JTextField konumField = new JTextField();
    JTextField kontenjanField = new JTextField();

    JTextArea aciklamaArea = new JTextArea();
    JScrollPane aciklamaScroll = new JScrollPane(aciklamaArea);

    JButton ekleButonu = new JButton("Etkinlik Ekle");
    JButton guncelleButonu = new JButton("Etkinlik Güncelle");
    JButton silButonu = new JButton("Etkinlik Sil");

    JTable etkinlikTablosu;
    DefaultTableModel tabloModel;
    JScrollPane tabloScroll;

    int sonrakiID = 1;


    EtkinlikDosyaIslemleri dosyaIslemleri = new EtkinlikDosyaIslemleri();

    public void FormCalistir() {
        FormUi();
        paneller();
        labels();
        textFields();
        textArea();
        buttons();
        TabloOlustur();
        pencereBoyutuDegisti();

        form.setVisible(true);
    }


    public void FormUi() {
        form.setTitle("Kampüs Etkinlik Yönetim Sistemi");
        form.setExtendedState(JFrame.MAXIMIZED_BOTH);
        form.setResizable(false);
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        form.setLocationRelativeTo(null);
        form.setLayout(null);
    }


    public void paneller() {

        baslikPanel.setBounds(0, 0, 1200, 100);
        baslikPanel.setBackground(new Color(23, 43, 77));
        baslikPanel.setLayout(null);

        formPanel.setBounds(20, 120, 350, 590);
        formPanel.setBackground(new Color(240, 243, 247));
        formPanel.setLayout(null);

        tabloPanel.setBounds(390, 120, 790, 590);
        tabloPanel.setBackground(Color.WHITE);
        tabloPanel.setLayout(null);

        form.add(baslikPanel);
        form.add(formPanel);
        form.add(tabloPanel);
    }


    public void labels() {

        baslikLabel.setBounds(30, 25, 700, 50);
        baslikLabel.setFont(new Font("Arial", Font.BOLD, 25));
        baslikLabel.setForeground(Color.WHITE);

        baslikPanel.add(baslikLabel);

        formBaslik.setBounds(20, 15, 300, 35);
        formBaslik.setFont(new Font("Arial", Font.BOLD, 20));
        formBaslik.setForeground(new Color(23, 43, 77));

        formPanel.add(formBaslik);

        etkinlikIsimLabel.setBounds(20, 60, 300, 25);
        tarihLabel.setBounds(20, 130, 300, 25);
        konumLabel.setBounds(20, 200, 300, 25);
        kontenjanLabel.setBounds(20, 270, 300, 25);
        aciklamaLabel.setBounds(20, 340, 300, 25);

        JLabel[] etiketler = {etkinlikIsimLabel, tarihLabel, konumLabel, kontenjanLabel, aciklamaLabel};

        for (JLabel etiket : etiketler) {
            etiket.setFont(new Font("Arial", Font.BOLD, 15));
            etiket.setForeground(new Color(50, 50, 50));
            formPanel.add(etiket);
        }
    }


    public void textFields() {
        etkinlikIsimField.setBounds(20, 85, formPanel.getWidth() - 40, 32);
        tarihField.setBounds(20, 155, formPanel.getWidth() - 40, 32);
        konumField.setBounds(20, 225, formPanel.getWidth() - 40, 32);
        kontenjanField.setBounds(20, 295, formPanel.getWidth() - 40, 32);

        JTextField[] alanlar = {etkinlikIsimField, tarihField, konumField, kontenjanField};

        for (JTextField alan : alanlar) {
            alan.setFont(new Font("Arial", Font.PLAIN, 15));

            alan.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(200, 205, 215)),
                    BorderFactory.createEmptyBorder(5, 10, 5, 10)
            ));

            formPanel.add(alan);
        }
    }


    public void textArea() {
        aciklamaArea.setFont(new Font("Arial", Font.PLAIN, 15));
        aciklamaArea.setLineWrap(true);
        aciklamaArea.setWrapStyleWord(true);
        aciklamaArea.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));

        aciklamaScroll.setBounds(20, 365, formPanel.getWidth() - 40, 80);

        aciklamaScroll.setBorder(BorderFactory.createLineBorder(new Color(200, 205, 215)));

        formPanel.add(aciklamaScroll);
    }


    public void buttons() {

        ekleButonu.setBounds(20, 455, formPanel.getWidth() - 40, 40);

        ekleButonu.setBackground(new Color(23, 43, 77));
        ekleButonu.setForeground(Color.WHITE);
        ekleButonu.setFont(new Font("Arial", Font.BOLD, 15));
        ekleButonu.setFocusPainted(false);
        ekleButonu.setBorderPainted(false);
        ekleButonu.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ekleButonu.addActionListener(e -> {EtkinlikEkle();});

        formPanel.add(ekleButonu);

        guncelleButonu.setBounds(20, 505, formPanel.getWidth() - 40, 40);

        guncelleButonu.setBackground(new Color(230, 155, 45));
        guncelleButonu.setForeground(Color.WHITE);
        guncelleButonu.setFont(new Font("Arial", Font.BOLD, 15));
        guncelleButonu.setFocusPainted(false);
        guncelleButonu.setBorderPainted(false);
        guncelleButonu.setCursor(new Cursor(Cursor.HAND_CURSOR));

        formPanel.add(guncelleButonu);

        silButonu.setBounds(20, 555, formPanel.getWidth() - 40, 40);

        silButonu.setBackground(new Color(190, 55, 55));
        silButonu.setForeground(Color.WHITE);
        silButonu.setFont(new Font("Arial", Font.BOLD, 15));
        silButonu.setFocusPainted(false);
        silButonu.setBorderPainted(false);
        silButonu.setCursor(new Cursor(Cursor.HAND_CURSOR));

        silButonu.addActionListener(e -> {EtkinlikSil();});

        formPanel.add(silButonu);


        guncelleButonu.addActionListener(e -> EtkinlikGuncelle());
    }


    public void EtkinlikEkle() {
        String etkinlikIsim = etkinlikIsimField.getText().trim();
        String tarih = tarihField.getText().trim();
        String konum = konumField.getText().trim();
        String kontenjanMetin = kontenjanField.getText().trim();
        String aciklama = aciklamaArea.getText().trim();

        if (etkinlikIsim.isEmpty() || tarih.isEmpty() || konum.isEmpty() || kontenjanMetin.isEmpty()) {
            JOptionPane.showMessageDialog(
                    form,
                    "Lütfen zorunlu alanları doldurun!"
            );
            return;
        }

        int kontenjan;
        try {
            kontenjan = Integer.parseInt(kontenjanMetin);
            if (kontenjan <= 0) {
                JOptionPane.showMessageDialog(
                        form,
                        "Kontenjan sıfırdan büyük olmalıdır!"
                );
                return;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    form,
                    "Kontenjan alanına geçerli bir sayı girin!"
            );
            return;
        }
        dosyaIslemleri.EtkinlikKaydet(sonrakiID + ";" + etkinlikIsim + ";" + tarih + ";" + konum + ";" + kontenjan + ";" + aciklama);
        tabloModel.addRow(new Object[]{sonrakiID, etkinlikIsim, tarih, konum, kontenjan, aciklama});
        sonrakiID++;
        JOptionPane.showMessageDialog(
                form,
                "Etkinlik başarıyla eklendi!"
        );

        etkinlikIsimField.setText("");
        tarihField.setText("");
        konumField.setText("");
        kontenjanField.setText("");
        aciklamaArea.setText("");
    }

    public void EtkinlikSil() {
        int seciliSatir = etkinlikTablosu.getSelectedRow();

        if (seciliSatir == -1) {
            JOptionPane.showMessageDialog(
                    form,
                    "Lütfen silmek istediğiniz etkinliği seçin!"
            );
            return;
        }

        int cevap = JOptionPane.showConfirmDialog(
                form,
                "Seçili etkinliği silmek istediğinize emin misiniz?",
                "Etkinlik Sil",
                JOptionPane.YES_NO_OPTION
        );


        if (cevap == JOptionPane.YES_OPTION) {
            tabloModel.removeRow(seciliSatir);
            DosyayiGuncelle();
            JOptionPane.showMessageDialog(
                    form,
                    "Etkinlik başarıyla silindi!"
            );
        }
    }

    public void EtkinlikSec() {
        int seciliSatir = etkinlikTablosu.getSelectedRow();

        if (seciliSatir == -1) {
            return;
        }
        etkinlikIsimField.setText(tabloModel.getValueAt(seciliSatir, 1).toString());
        tarihField.setText(tabloModel.getValueAt(seciliSatir, 2).toString());
        konumField.setText(tabloModel.getValueAt(seciliSatir, 3).toString());
        kontenjanField.setText(tabloModel.getValueAt(seciliSatir, 4).toString());
        aciklamaArea.setText(tabloModel.getValueAt(seciliSatir, 5).toString());

    }

    public void EtkinlikGuncelle() {

        int seciliSatir = etkinlikTablosu.getSelectedRow();

        if (seciliSatir == -1) {
            JOptionPane.showMessageDialog(form, "Lütfen güncellenecek etkinliği seçiniz!");
            return;
        }

        String etkinlikIsim = etkinlikIsimField.getText().trim();
        String tarih = tarihField.getText().trim();
        String konum = konumField.getText().trim();
        String kontenjan = kontenjanField.getText().trim();
        String aciklama = aciklamaArea.getText().trim();

        if (etkinlikIsim.isEmpty() || tarih.isEmpty() || konum.isEmpty() || kontenjan.isEmpty()) {
            JOptionPane.showMessageDialog(form, "Lütfen zorunlu alanları doldurunuz!");
            return;
        }

        int kontenjanSayi;

        try {
            kontenjanSayi = Integer.parseInt(kontenjan);

            if (kontenjanSayi <= 0) {
                JOptionPane.showMessageDialog(form, "Kontenjan sıfırdan büyük olmalıdır!");
                return;
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(form, "Kontenjan sayısal bir değer olmalıdır!");
            return;
        }

        tabloModel.setValueAt(etkinlikIsim, seciliSatir, 1);
        tabloModel.setValueAt(tarih, seciliSatir, 2);
        tabloModel.setValueAt(konum, seciliSatir, 3);
        tabloModel.setValueAt(kontenjanSayi, seciliSatir, 4);
        tabloModel.setValueAt(aciklama, seciliSatir, 5);

        DosyayiGuncelle();

        JOptionPane.showMessageDialog(form, "Etkinlik başarıyla güncellendi!");

    }
    public void TabloOlustur() {
        String[] sutunlar = {"ID", "Etkinlik Adı", "Tarih", "Konum", "Kontenjan", "Açıklama"};

        tabloModel = new DefaultTableModel(sutunlar, 0);
        etkinlikTablosu = new JTable(tabloModel);
        etkinlikTablosu.setFont(new Font("Arial", Font.PLAIN, 14));
        etkinlikTablosu.setRowHeight(35);
        etkinlikTablosu.getTableHeader().setFont(
                new Font("Arial", Font.BOLD, 14)
        );
        etkinlikTablosu.getTableHeader().setBackground(
                new Color(23, 43, 77)
        );
        etkinlikTablosu.getTableHeader().setForeground(Color.WHITE);
        etkinlikTablosu.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );
        etkinlikTablosu.getColumnModel().getColumn(0).setMinWidth(0);
        etkinlikTablosu.getColumnModel().getColumn(0).setMaxWidth(0);
        etkinlikTablosu.getColumnModel().getColumn(0).setWidth(0);

        tabloScroll = new JScrollPane(etkinlikTablosu);

        tabloScroll.setBounds(15, 15, tabloPanel.getWidth() - 30, tabloPanel.getHeight() - 30);

        etkinlikTablosu.getSelectionModel().addListSelectionListener(e -> {

            if (!e.getValueIsAdjusting()) {
                EtkinlikSec();
            }

        });

        tabloPanel.add(tabloScroll);

        EtkinlikleriYukle();
    }


    public void pencereBoyutuDegisti() {

        form.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                int genislik = form.getContentPane().getWidth();
                int yukseklik = form.getContentPane().getHeight();

                baslikPanel.setBounds(0, 0, genislik, 100);
                formPanel.setBounds(20, 120, (int) (genislik * 0.30), yukseklik - 140);

                int tabloX = (int) (genislik * 0.33);

                tabloPanel.setBounds(tabloX, 120, genislik - tabloX - 20, yukseklik - 140);

                int etiketGenislik = formPanel.getWidth() - 40;

                formBaslik.setBounds(20, 15, etiketGenislik, 35);
                etkinlikIsimLabel.setBounds(20, 60, etiketGenislik, 25);
                tarihLabel.setBounds(20, 130, etiketGenislik, 25);
                konumLabel.setBounds(20, 200, etiketGenislik, 25);
                kontenjanLabel.setBounds(20, 270, etiketGenislik, 25);
                aciklamaLabel.setBounds(20, 340, etiketGenislik, 25);

                etkinlikIsimField.setBounds(20, 85, etiketGenislik, 32);
                tarihField.setBounds(20, 155, etiketGenislik, 32);
                konumField.setBounds(20, 225, etiketGenislik, 32);
                kontenjanField.setBounds(20, 295, etiketGenislik, 32);

                aciklamaScroll.setBounds(20, 365, etiketGenislik, 80);

                ekleButonu.setBounds(20, 455, etiketGenislik, 40);
                guncelleButonu.setBounds(20, 505, etiketGenislik, 40);
                silButonu.setBounds(20, 555, etiketGenislik, 40);

                tabloScroll.setBounds(15, 15, tabloPanel.getWidth() - 30, tabloPanel.getHeight() - 30);
            }
        });
    }

    public void EtkinlikleriYukle() {

        ArrayList<String[]> etkinlikler = dosyaIslemleri.EtkinlikleriOku();

        for (String[] etkinlik : etkinlikler) {

            tabloModel.addRow(new Object[]{
                    Integer.parseInt(etkinlik[0]),
                    etkinlik[1],
                    etkinlik[2],
                    etkinlik[3],
                    Integer.parseInt(etkinlik[4]),
                    etkinlik[5]
            });

            int id = Integer.parseInt(etkinlik[0]);

            if (id >= sonrakiID) {
                sonrakiID = id + 1;
            }

        }


    }

    public void DosyayiGuncelle() {

        ArrayList<String[]> etkinlikler = new ArrayList<>();

        for (int i = 0; i < tabloModel.getRowCount(); i++) {

            String[] etkinlik = new String[6];

            for (int j = 0; j < 6; j++) {

                etkinlik[j] = tabloModel.getValueAt(i, j).toString();

            }

            etkinlikler.add(etkinlik);

        }

        dosyaIslemleri.EtkinlikleriKaydet(etkinlikler);

    }
}

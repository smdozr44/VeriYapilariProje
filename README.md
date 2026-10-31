# VY-003 | Kampüs Etkinlik Yönetim Sistemi

## 1. Proje Hakkında

Kampüs Etkinlik Yönetim Sistemi; üniversite bünyesinde düzenlenen seminer, söyleşi, atölye ve kulüp etkinliklerinin yönetilmesini sağlayan Java tabanlı bir masaüstü uygulamasıdır.

Uygulama üzerinden etkinlikler oluşturulabilir, güncellenebilir, silinebilir ve listelenebilir. Kullanıcılar etkinliklere başvuru yapabilir. Kontenjanı dolan etkinliklere yapılan başvurular ise yedek listeye alınır.

Bir etkinlikte asil katılımcılardan biri başvurusunu iptal ettiğinde, yedek listedeki en eski başvuru otomatik olarak asil katılımcı durumuna geçirilir.

## 2. Proje Bilgileri

- **Proje Kodu:** VY-003
- **Proje Adı:** Kampüs Etkinlik Yönetim Sistemi
- **Programlama Dili:** Java
- **Geliştirme Ortamı:** IntelliJ IDEA
- **Arayüz Teknolojisi:** Java Swing
- **Veri Saklama Yöntemi:** Metin dosyası tabanlı veri saklama
- **Depo:** GitHub

## 3. Ekip Üyeleri

| Ekip Üyesi | Görevi |
| ---------- | ------------------------------ |
| Samed ÖZER | Veri tabanı ve dosya işlemleri |
| Ozan EROL  | Başvuru ve yedek sistemi |
| [Ad Soyad] | [Görev] |

## 4. Kullanılan Teknolojiler

- **Java:** Uygulamanın temel programlama dili.
- **Java Swing:** Kullanıcı arayüzünün oluşturulması.
- **IntelliJ IDEA:** Kod geliştirme ve hata ayıklama ortamı.
- **Git ve GitHub:** Kaynak kod yönetimi ve ekip çalışması.
- **TXT Dosyaları:** Verilerin kalıcı olarak saklanması.

## 5. Projenin Temel İşlevleri

### 5.1. Etkinlik Yönetimi

- Yeni etkinlik oluşturma.
- Mevcut etkinlikleri silme.
- Etkinlik bilgilerini güncelleme.
- Etkinlikleri listeleme.
- Etkinlikleri tarihe göre sıralama.
- Etkinlikleri doluluk oranına göre sıralama.
- Etkinlik adı ve türüne göre arama.

### 5.2. Katılımcı Yönetimi

- Yeni katılımcı kaydı oluşturma.
- Katılımcı bilgilerini güncelleme.
- Katılımcı kayıtlarını görüntüleme.
- Katılımcı numarasına göre arama.

### 5.3. Başvuru Yönetimi

- Katılımcının etkinliğe başvuru yapması.
- Başvurunun iptal edilmesi.
- Asil ve yedek başvuruların takip edilmesi.
- Başvuru durumunun görüntülenmesi.
- Başvuru tarihine göre yedek liste sıralaması.

### 5.4. Kontenjan ve Yedek Liste Yönetimi

- Etkinlik kontenjanının kontrol edilmesi.
- Kontenjan dolduğunda yeni başvuruların yedek listeye alınması.
- Asil katılımcı başvurusunu iptal ettiğinde en eski yedek başvurunun otomatik olarak asile geçirilmesi.
- Kontenjanın mevcut asil katılımcı sayısının altına düşürülmesinin engellenmesi.

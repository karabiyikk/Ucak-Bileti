package KosulluIfadeler;

import java.util.Scanner;
//Java ile mesafeye ve şartlara göre uçak bileti fiyatı hesaplayan programı yapın. Kullanıcıdan Mesafe (KM), yaşı
//ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgilerini alın. Mesafe başına ücret 0,10 TL / km olarak alın. İlk olarak
//uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki indirimleri uygulayın ;

//Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
// Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.
//Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
//Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
//Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
//Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
public class UcakBileti {
    public static void main(String[] args) {
        int KM, age, tip;
        double perKM = 0.1, tutar, gidis = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Yaşınız : ");
        age = input.nextInt();
        System.out.print("Gidilecek mesafe (KM) : ");
        KM = input.nextInt();
        System.out.println("Yolculuk tipi : Gidiş : 1\t Gidiş-Dönüş : 2");
        tip = input.nextInt();
        tutar = KM * perKM;
        double cocukIndirimi = (tutar * 50 / 100);
        double gencIndirimi = (tutar * 10 / 100);
        double yasliIndirimi = (tutar * 30 / 100);
        double gidisDonusIndirim = tutar - (tutar * 20 / 100);

        if ((KM > 0) && (age > 0)) {
            if (tip == 1) {
                if (age < 12) {
                    gidis = (tutar - cocukIndirimi);
                } else if (age < 24) {
                    gidis = (tutar - gencIndirimi);
                } else if (age < 65) {
                    gidis = tutar;
                } else {
                    gidis = (tutar - yasliIndirimi);
                }
            } else if (tip == 2) {
                if (age < 12) {
                    gidis = gidisDonusIndirim - cocukIndirimi;
                } else if (age < 24) {
                    gidis = gidisDonusIndirim - gencIndirimi;
                } else if (age < 65) {
                    gidis = gidisDonusIndirim;
                } else {
                    gidis = gidisDonusIndirim - yasliIndirimi;
                }
            } else {
                System.out.print("Hatalı Giriş Yaptınız. ");
            }
            System.out.print("Ödemeniz gereken ücret : " + gidis);
        } else {
            System.out.print("Lütfen Geçerli mesafe ve yaş giriniz. ");
        }
    }
}
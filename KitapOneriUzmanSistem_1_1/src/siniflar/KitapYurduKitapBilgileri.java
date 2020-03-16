/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siniflar;

/**
 *
 * @author ayse
 */

//Bu sınıf veri tabanınına yazmak , veri tabaından çekmek için tanımlanan constructor sınıfıdır 
public class KitapYurduKitapBilgileri {

    String count;
    String kitap_isim;
    String yazar;
    String tur;
    String fiyat;
    String yayinEvi;

    public KitapYurduKitapBilgileri() {
    }

    public KitapYurduKitapBilgileri(String count, String kitap_isim, String yazar, String tur, String fiyat, String yayinEvi) {
        this.count = count;
        this.kitap_isim = kitap_isim;
        this.yazar = yazar;
        this.tur = tur;
        this.fiyat = fiyat;
        this.yayinEvi = yayinEvi;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getKitap_isim() {
        return kitap_isim;
    }

    public void setKitap_isim(String kitap_isim) {
        this.kitap_isim = kitap_isim;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getFiyat() {
        return fiyat;
    }

    public void setFiyat(String fiyat) {
        this.fiyat = fiyat;
    }

    public String getYayinEvi() {
        return yayinEvi;
    }

    public void setYayinEvi(String yayinEvi) {
        this.yayinEvi = yayinEvi;
    }

    
}

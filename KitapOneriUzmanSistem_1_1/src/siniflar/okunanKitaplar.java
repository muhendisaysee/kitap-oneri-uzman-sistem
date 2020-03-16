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

//Bu sınıfta kullanıcının daha önceden okuduğu kitapları tutması için constructor tanımlayıp, gerekli yerlerde çekmek için getter setter fonks. tanımladım.
public class okunanKitaplar {
    private String kitap_ismi;
    private String yazar_ismi;
    private String tur;                 
    private String fiyat;
    private String yayinEvi;


    public okunanKitaplar(String kitap_ismi, String yazar_ismi, String tur, String fiyat, String yayinEvi) {
        this.kitap_ismi = kitap_ismi;
        this.yazar_ismi = yazar_ismi;
        this.tur = tur;
        this.fiyat = fiyat;
        this.yayinEvi = yayinEvi;
    }

    public String getKitap_ismi() {
        return kitap_ismi;
    }

    public void setKitap_ismi(String kitap_ismi) {
        this.kitap_ismi = kitap_ismi;
    }

    public String getYazar_ismi() {
        return yazar_ismi;
    }

    public void setYazar_ismi(String yazar_ismi) {
        this.yazar_ismi = yazar_ismi;
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

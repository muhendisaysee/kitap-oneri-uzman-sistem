/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siniflar;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ayse
 */
public class verileriAl {

    public static List<String> adresler = new ArrayList();  //Kitap bilgilerini sakladığımız dizi.
    public static List<String> tur = new ArrayList();   //Adresi split ettiğimde kitap türlerini sakladığım dizi
    public static List<String> link = new ArrayList();  //Adresi split ettiğimde html adreslerini sakladığım dizi

    public verileriAl() {

    }
    int count = 0;  //Kitap id lerini belirlediğim değişken

    public void path() throws Exception {
        
        // TODO code application logic here
        Elements rawProducts = null;    //Adresteki split edilmemiş istenen kısımları tutan Elements tipindeki değişken
        
        //Gidilmesi gereken adresleri belirlediğim kısım.10 sayfayı dolaşması için 10 luk döngü içinde.
        for(int i=1;i<10;i++){
            
        
        adresler.add("Anı(hatırat),https://www.kitapyurdu.com/index.php?route=product/category&path=128_140&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Anlatı,https://www.kitapyurdu.com/index.php?route=product/category&path=128_158&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Antoloji-Derleme,https://www.kitapyurdu.com/index.php?route=product/category&path=128_139&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Armağan,https://www.kitapyurdu.com/index.php?route=product/category&path=128_155&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Belgesel Roman,https://www.kitapyurdu.com/index.php?route=product/category&path=128_150&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Bilimkurgu-Fantazya,https://www.kitapyurdu.com/index.php?route=product/category&path=128_145&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Biyografi-Otobiyografi,https://www.kitapyurdu.com/index.php?route=product/category&path=128_141&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Çizgi Roman,https://www.kitapyurdu.com/index.php?route=product/category&path=128_159&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Deneme(çeviri),https://www.kitapyurdu.com/index.php?route=product/category&path=128_136&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Deneme(yerli),https://www.kitapyurdu.com/index.php?route=product/category&path=128_135&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Destan,https://www.kitapyurdu.com/index.php?route=product/category&path=128_160&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Diğer,https://www.kitapyurdu.com/index.php?route=product/category&path=128_154&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Divan Edebiyatı,https://www.kitapyurdu.com/index.php?route=product/category&path=128_148&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Doğu Klasikleri,https://www.kitapyurdu.com/index.php?route=product/category&path=128_146&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Edebiyat Tarihi,https://www.kitapyurdu.com/index.php?route=product/category&path=128_149&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Edebiyat Yazıları,https://www.kitapyurdu.com/index.php?route=product/category&path=128_157&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Eleştiri,https://www.kitapyurdu.com/index.php?route=product/category&path=128_137&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Günlük,https://www.kitapyurdu.com/index.php?route=product/category&path=128_142&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Halk Edebiyatı,https://www.kitapyurdu.com/index.php?route=product/category&path=128_147&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Hiciv-Mizah,https://www.kitapyurdu.com/index.php?route=product/category&path=128_156&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Hikaye(çeviri),https://www.kitapyurdu.com/index.php?route=product/category&path=128_132&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Hikaye(yerli),https://www.kitapyurdu.com/index.php?route=product/category&path=128_131&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Hitabet-Söyleşi,https://www.kitapyurdu.com/index.php?route=product/category&path=128_153&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("İnceleme,https://www.kitapyurdu.com/index.php?route=product/category&path=128_138&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Mektup,https://www.kitapyurdu.com/index.php?route=product/category&path=128_143&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Polemik,https://www.kitapyurdu.com/index.php?route=product/category&path=128_152&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Polisiye,https://www.kitapyurdu.com/index.php?route=product/category&path=128_144&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Roman(çeviri),https://www.kitapyurdu.com/index.php?route=product/category&path=128_130&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Roman(yerli),https://www.kitapyurdu.com/index.php?route=product/category&path=128_129&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Şiir(çeviri),https://www.kitapyurdu.com/index.php?route=product/category&path=128_134&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Şiir(yerli),https://www.kitapyurdu.com/index.php?route=product/category&path=128_133&filter_in_stock=1&limit=100"+"&page="+i);
        adresler.add("Tarihi Roman,https://www.kitapyurdu.com/index.php?route=product/category&path=128_151&filter_in_stock=1&limit=100"+"&page="+i);
        }
        int count = 0;

        for (int i = 0; i < adresler.size(); i++) {
            String dizi[] = adresler.get(i).split(",");
            tur.add(dizi[0]);                                   //Adresler dizisini tür ve html adreslerine split ettiğim kısım.
            link.add(dizi[1]);
        }

        for (int i = 0; i < link.size(); i++) {
            adres(link.get(i), tur.get(i));                         //İstenen kısımların çekilmesi için adres fonksiyonunu çağırıyoruzz.
        }

    }

    public void adres(String adres, String tur) throws IOException {
      dosyayaYaz y=new dosyayaYaz();                        //Veri tabanına yazmak için oluşturulan nesne
        try {
            Document doc = Jsoup.connect(adres).get();          //Document nesnesiyle html sayfasını okuyorum.
            Elements links = doc.select("div[itemtype=http://schema.org/Book]");    //İstediğim div lerin linkleri,adresleri elements e atanır.

            for (Element link : links) {            //Sıra geldi div i okumaya
                
                String name = link.select("img[itemprop=image]").first().attr("alt");           //Kitap ismini çekiyorum.
                String author = link.select("span[itemprop=author]").first().select("span[itemprop=name]").text();  //Yazar ismini çekiyorum.
                String price = link.select("div[class=price-new]").first().select("span[class=value]").first().text().replace(',', '.');   //Kitabın fiyatını çekiyorum
                String linki = link.select("a[itemprop=url]").first().attr("href"); //Kitabın bulunduğu link
                String publisher = link.select("span[itemprop=publisher]").first().select("span[itemprop=name]").text();    //Yayınevi ni çekiyorum.
                String deneme = link.select("div[class=product-info]").first().select("div[class=product-info]").text();    //Diğer değişkenler.
                System.out.println("Kitap ismi : " + name);
                System.out.println("Yazar ismi : " + author);
                System.out.println("Kitabın türü : " + tur);            //Test etmek için konsola yazdırdım.
                System.out.println("Fiyat : " + price);
                System.out.println("Linki : " + linki);
                System.out.println("Publisher : " + publisher);
                System.out.println("deneme : " + deneme);
                count++;//Her gelen kitap için id özelliği taşıyacağından 1 arttırdım.
                //Nesne oluşturup veri tabanına ekledim.
                KitapYurduKitapBilgileri kitap = new KitapYurduKitapBilgileri(String.valueOf(count), name, author, tur, price, publisher);  
                y.DosyaYaz(kitap);
                System.out.println("------------------------------");
                // System.out.println("text : " + link.text());
                // dizi=link.text().split(",");

                System.out.println("Count : " + count);
            }
        } catch (NullPointerException npe) {
            return;
        } catch (org.jsoup.HttpStatusException hse) {
            return;
        }

    }
}

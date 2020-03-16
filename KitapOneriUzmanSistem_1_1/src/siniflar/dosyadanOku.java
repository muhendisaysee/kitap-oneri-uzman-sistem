/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siniflar;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import kitaponeriuzmansistem.OneriSistemiController;
import static kitaponeriuzmansistem.OneriSistemiController.duyuruListele;
import kitaponeriuzmansistem.OnerileriAlController;

/**
 *
 * @author ayse
 */
public class dosyadanOku {
    public static List<KitapYurduKitapBilgileri> veriTabani = new ArrayList();  //Veri tabanında bulunan kitapları tutan dizi.

    int okunanKitaplar=0;       //Okunan kitap sayısını tutan değişken
    public dosyadanOku() {
    }                           //Constructor
    
    //Bu fonksiyon sistemin başarısını bulmaktadır.
  public void sistemBasarisi(){
       
        double total;   //Okunan toplam kitap
        total=0;
        
          try (Scanner scanner = new Scanner(new FileReader("VeriTabanı.txt"))) {       //Dosyayı aç oku
            while (scanner.hasNextLine()) {     //Satır satır okumaya başla
                String duyuruBilgisi = scanner.nextLine();  //Okuduğun satırı stringe at
                String[] tmp = duyuruBilgisi.split("<>");   //Parçala ve diziye at
                //Nesne oluştur,veri tabanı için oluşturduğun diziye at
                KitapYurduKitapBilgileri kayitlar = new KitapYurduKitapBilgileri(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]);
                veriTabani.add(kayitlar);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Dosya bulunamadi");
        }
   
   for(int j=0;j<OneriSistemiController.duyuruListele.size();j++){
      for(int i=0;i<veriTabani.size();i++){
          //Kullanıcının okuduğu kitaplardan veri tabanında olan kitap sayısı
              if(OneriSistemiController.duyuruListele.get(j).getKitap_ismi().equals(veriTabani.get(i).getKitap_isim())){
                  total++;      //Veri tabanında olan kitap sayısı;
              }
          }
      }
        System.out.println("total : "+total);   //Kontrol amaçlı yazdır.
       double veriTOlmayan=duyuruListele.size()-total;  //Veri tabanında olmayan kitap sayısını bul
       System.out.println("Öneri toplami : "+OnerileriAlController.oneriler.size());    //Sistemin önerdiği kitap sayısı
       System.out.println("Total(Veri tabanında olan) : "+total);   //Kontrol amaçlı veri tabanında olan kitap sayısını yazdır.
      double sysSuccess=(total*20)/OnerileriAlController.oneriler.size();   //Sistemin başarısını hesapla
      System.out.println("sistem basarisi :  "+((total*20)/(OnerileriAlController.oneriler.size())));   //Konsola yazdır.
  
    OnerileriAlController.basari=sysSuccess;    //Kontrol sınıfındaki başarı değişkenine ata

      
      
      
    }
    public void okunanKitaplariCek() {

        try (Scanner scanner = new Scanner(new FileReader("okunanKitaplar.txt"))) {     //Kullanıcının okuduğu kitapları tutan txt dosyasını aç
            while (scanner.hasNextLine()) { //Satır satır oku
                String kitapBilgisi = scanner.nextLine();   //Bir stringe at
                String[] tmp = kitapBilgisi.split("<>");    //Parçalayıp string dizisine at
                if (tmp[0].equals("@kitap")) {  //Eğer @kitap etiketiyle başlıyorsa kitap vardır.İf e gir.

                    okunanKitaplar kayitlar = new okunanKitaplar(tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]);   //Nesne oluşturup parçaları ata
                    okunanKitaplar++;   //Okunan kitap sayısını 1 arttır
                    //Kontrol amaçlı yazdır
                    System.out.println("Kitap ismi : " + tmp[1]);
                    System.out.println("Kitap yazar : " + tmp[2]);
                    System.out.println("Kitap tür : " + tmp[3]);
                    System.out.println("Kitap fiyat : " + tmp[4]);
                    System.out.println("Kitap yayinevi : " + tmp[5]);

                    OneriSistemiController.duyuruListele.add(kayitlar); //Kullanıcının okuduğu kitapları tutan kontrol sınıfındaki diziye ata
                }

            }
        } catch (FileNotFoundException e) {
            System.err.println("Dosya bulunamadi");
        }
   
    }
    
    
    public void onerileriAl(){
        okunanKitaplariCek();   //Okunan kitapları getir
       int kontrol=0;   //Aynı kitaptan 1 den fazla yazmaması için kontrol
    
        try (Scanner scanner = new Scanner(new FileReader("VeriTabanı.txt"))) { //Dosyayı oku
            while (scanner.hasNextLine()) { //Satır satır oku
                String duyuruBilgisi = scanner.nextLine();  //Satırı stringe çevir
                String[] tmp = duyuruBilgisi.split("<>");   //Parçala ve diziye ata
               // System.out.println("tmp[3] : "+tmp[3]);
               // System.out.println("tur : " +OneriSistemiController.duyuruListele.get(1).getYazar_ismi());
               /*
               Eğer kullanıcının okumuş olduğu kitabın yazarının başka bir kitabı varsa veya aynı fiyattan veya (tur&&yayınevinden) çek
               Öneri olarak kullancıya göster
               */
               for(int i=0;i<OneriSistemiController.duyuruListele.size();i++){
                   if(OneriSistemiController.duyuruListele.get(i).getKitap_ismi().equals(tmp[1]) || //Aynı isimli kitap
                      OneriSistemiController.duyuruListele.get(i).getYazar_ismi().equals(tmp[2]) || //Aynı isimli yazar
                      (OneriSistemiController.duyuruListele.get(i).getTur().equals(tmp[3]) &&   //Aynı tür && yayın evi
                            OneriSistemiController.duyuruListele.get(i).getYayinEvi().equals(tmp[5]))||
                      OneriSistemiController.duyuruListele.get(i).getFiyat().equals(tmp[4])     //Aynı fiyat
                     ){
                       //Nesne olustur
                       KitapYurduKitapBilgileri kayitlar = new KitapYurduKitapBilgileri(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]);
                       for(int j=0;j<OnerileriAlController.oneriler.size();j++){
                           if(tmp[0].equals(OnerileriAlController.oneriler.get(j).count)){
                               kontrol=1;                                                       //Aynı kitap yazılmış mı kontrol et
                       
                           }
                       }
                       if(kontrol==0){
                            OnerileriAlController.oneriler.add(kayitlar);   //Yazılmamışsa yaz.
                            
                       }
                       kontrol=0;
                      
                   }
               }

            }
        } catch (FileNotFoundException e) {
            System.err.println("Dosya bulunamadi");
        }
           
      sistemBasarisi();
    }


    public boolean dosyaBosMu() {
            /**
             * okunanKitapları aç ve @kitap etiketiyle mi başlıyor konrol et
             * Hayır sa bos
             * Evet se dolu
             */
        try (Scanner scanner = new Scanner(new FileReader("okunanKitaplar.txt"))) {
            while (scanner.hasNextLine()) {
                String kitapBilgisi = scanner.nextLine();
                String[] tmp = kitapBilgisi.split("<>");
                if (tmp[0].equals("@kitap")) {
                    return false;
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Dosya acilamadi");
        }
        return true;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siniflar;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import kitaponeriuzmansistem.OneriSistemiController;

/**
 *
 * @author ayse
 */

// txt dosyasında veri tabanı oluşturmak ve yazmak için oluşturduğum sınıf.
public class dosyayaYaz {
     FileWriter writer=null;        //Dosyaya yazmak için yazma değişkenim.

     // kitapyurdu.com dan bilgileri alıp , txt ye yazdığım fonksiyon.
    public void DosyaYaz(KitapYurduKitapBilgileri kitap){

        try{
            writer=new FileWriter("VeriTabanı.txt",true);   //Dosyayı aç komutu.
            if(kitap instanceof KitapYurduKitapBilgileri){  //Kontrol için eğer gönderilen nesne istediğim formattaysa yaz
                // exp : 541<>İçimden Göçenler<>Melek Mustafa<>Şiir(çeviri)<>18.61<>KIRMIZI YAYINLARI  formatta yaz.
                writer.write(kitap.count+"<>"+kitap.kitap_isim+"<>"+kitap.yazar+"<>"+kitap.tur+"<>"+kitap.fiyat+"<>"+kitap.yayinEvi+"\n");
                
            }
            
        } catch (IOException ex) {
            System.err.println("IO Exception");
        }finally{
            
            if(writer!=null){
                try{                        //try - catch ler hata kontrolleri
                    writer.close();
                }catch(IOException ex)
                {
                    System.err.println("Dosya kapatilamadi");
                }
            }
        }
        
    }
    //KUllanıcıdan sadece kitap ismini aldım.Veri tabanından o kitabın bilgilerini bulup veri tabanına eklediğim fonksiyon.
    public void VeriAra(String kitap_ismi){

       
        try (Scanner scanner = new Scanner(new FileReader("VeriTabanı.txt"))) { //Dosyayı aç,oku
            while (scanner.hasNextLine()) {         //Satır satır okumaya başla
                String kitapBilgisi = scanner.nextLine();   //Stringe çevir.
                String[] tmp = kitapBilgisi.split("<>");    //Bu stringi parçala ve diziye at
                
                if(kitap_ismi.equals(tmp[1])){      //kullanıcının verdiği kitap ismi, veri tabanındakine eşitse
                  
                    
              writer=new FileWriter("okunanKitaplar.txt",true);     //Kullanıcının okuduğu kitapları tutan dosyayı aç.
    
     
                    writer.write("\n");         //bir alt satıra geç
                   
                okunanKitaplar kitap=new okunanKitaplar(tmp[1], tmp[2], tmp[3], tmp[4],tmp[5]); //Kitap ismi, yazar,tür,fiyat,yayın evi olarak nesne oluştur.
                writer.write("@kitap<>"+tmp[1]+"<>"+tmp[2]+"<>"+tmp[3]+"<>"+tmp[4]+"<>"+tmp[5]);    //Bu nesneyi dosyaya yaz.
             
                
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Dosya bulunamadi");
        } catch (IOException ex) {                      //Hatalar.
            System.err.println("IO Exception");
        }finally{
            
            if(writer!=null){
                try{
                    writer.close();
                }catch(IOException ex)
                {
                    System.err.println("Dosya kapatilamadi");
                }
            }
        }
        
    }
    
}

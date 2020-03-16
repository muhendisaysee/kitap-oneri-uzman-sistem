/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitaponeriuzmansistem;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static kitaponeriuzmansistem.OneriSistemiController.duyuruListele;
import siniflar.KitapYurduKitapBilgileri;
import siniflar.dosyadanOku;
import siniflar.okunanKitaplar;

/**
 * FXML Controller class
 *
 * @author ayse
 */
//Bu controller sınıfı kullanıcıya okuduğu kitaplara göre öneriler veren sınıftır.
//Dosya oku,yaz metotları için tanımladığım abstractController 'ı extends ettim.
public class OnerileriAlController extends AbstractController implements Initializable {

    public static int count=0;
    public static List<KitapYurduKitapBilgileri> oneriler = new ArrayList();//Önerileri turmak için bir dizi oluşturdum
    public static double basari;   //Sistem başarısını tutan değişken
    public static double basariText; 
    @FXML
    private TableView<KitapYurduKitapBilgileri> onerilerTableView;  //Önerileri tutan textField
    @FXML
    private TableColumn<KitapYurduKitapBilgileri, String> countColumn; //Kitap id sini tutan column
    @FXML
    private TableColumn<KitapYurduKitapBilgileri, String> kitap_ismiColumn;//Kitap ismini tutan tablo sütunu
    @FXML
    private TableColumn<KitapYurduKitapBilgileri, String> yazar_ismiColumn;  //Yazar ismini tutan tablo sütunu
    @FXML
    private TableColumn<KitapYurduKitapBilgileri, String> turColumn;  //Tür bilgisini tutan tablo sütunu
    @FXML
    private TableColumn<KitapYurduKitapBilgileri, String> fiyatColumn;  //Fiyat bilgisini tutan tablo sütunu
    @FXML
    private TableColumn<KitapYurduKitapBilgileri, String> yayinEviColumn; //Yayın evi bilgisini tutan tablo sütunu

    @FXML
    private ChoiceBox choiceBox; //Kullanıcının sistem hakkında fikrini aldığım choiceBox
    @FXML
    private Label choiceBoxLabel;  //Görüş önerilerini içeren label

    @FXML
    private Label sistemBasarisiLabel;  //Sistem başarısını tutan label

    @FXML
    public void sistemBasarisiGor() {
   
      //double basari=basariBul.sistemBasarisi();
      count++;
      if(count<=1){
        sistemBasarisiLabel.setText(String.valueOf(basari));
        basariText=basari;
        System.out.println("count : "+count);
      }
       sistemBasarisiLabel.setText(String.valueOf(basariText));
       //basari=0;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        oneriler.removeAll(oneriler);       //Dizinin içini sil
        oku.onerileriAl();          //Önerileri sistemden al diziye at

        onerilerTableView.getItems().setAll(oneriler);      //Önerileri Tabloda göster
        oneriler.removeAll(oneriler);   //Kullanıcının işi bittiğinde sil
        choiceBoxLabel.setText("");     //choiceBoxLabel initialize değeri

        choiceBox.getItems().add("Çok beğendim");   //ChoiceBox'a görüşü ekleme
        choiceBox.getItems().add("İyiydi");         //ChoiceBox'a görüşü ekleme
        choiceBox.getItems().add("Fena değil");     //ChoiceBox'a görüşü ekleme
        choiceBox.getItems().add("Kötü");       //ChoiceBox'a görüşü ekleme
        choiceBox.getItems().add("Çok kötü");       //ChoiceBox'a görüşü ekleme

        countColumn.setCellValueFactory(new PropertyValueFactory<KitapYurduKitapBilgileri, String>("count"));   //Kitap id si intialize değeri
        kitap_ismiColumn.setCellValueFactory(new PropertyValueFactory<KitapYurduKitapBilgileri, String>("kitap_isim")); //Kitap ismi  intialize değeri
        yazar_ismiColumn.setCellValueFactory(new PropertyValueFactory<KitapYurduKitapBilgileri, String>("yazar"));  //Yazar ismi intialize değeri
        turColumn.setCellValueFactory(new PropertyValueFactory<KitapYurduKitapBilgileri, String>("tur"));   //Tür intialize değeri
        fiyatColumn.setCellValueFactory(new PropertyValueFactory<KitapYurduKitapBilgileri, String>("fiyat"));   //Fiyat intialize değeri
        yayinEviColumn.setCellValueFactory(new PropertyValueFactory<KitapYurduKitapBilgileri, String>("yayinEvi")); //Yayın evi intialize değeri

        /**
         * String fakulte, String bolum, String yayinlanmaTarihi, String
         * gecerlilikTarihi, String duyuran, String duyuru, String duyuruOnem
         */
    }

    @FXML
    public void choiceBox() {
        //ChoiceBox 'ta kullanıcının seçtiği görüşe göre sistemin geri dönüş mesajları
        choiceBoxLabel.setText(choiceBox.getValue().toString());
        if (choiceBox.getValue().toString().equals("Çok beğendim")) {       
            choiceBoxLabel.setText("Teşekkür ederim :) Mutlu oldum.");
        }
        if (choiceBox.getValue().toString().equals("İyiydi")) {
            choiceBoxLabel.setText("Teşekkür ederim :) Çok iyi olmaya çalışacağım.");
        }
        if (choiceBox.getValue().toString().equals("Fena değil")) {
            choiceBoxLabel.setText("Üzgünüm.Kendimi geliştirmeye devam etmeliyim.");
        }
        if (choiceBox.getValue().toString().equals("Kötü")) {
            choiceBoxLabel.setText("Üzgünüm.Kendimi geliştirmeye devam etmeliyim.");
        }
        if (choiceBox.getValue().toString().equals("Çok kötü")) {
            choiceBoxLabel.setText("Üzgünüm.Kendimi geliştirmeye devam etmeliyim.");
        }
    }

    @FXML
    public void geriGit(ActionEvent a) {
        //Geri git butonunun action u
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("oneriSistemi.fxml"));
            Scene tableview = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(OneriSistemiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void oneriDegerlendir(ActionEvent a) {
            //Önerileri gör 'ün action u
        try {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("oneriSistemi.fxml"));
            Scene tableview = new Scene(tableViewParent);
            Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
            window.setScene(tableview);
            window.show();
        } catch (IOException ex) {
            Logger.getLogger(OneriSistemiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

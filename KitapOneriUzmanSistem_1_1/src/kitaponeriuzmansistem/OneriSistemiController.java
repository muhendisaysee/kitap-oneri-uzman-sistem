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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import siniflar.dosyadanOku;
import siniflar.okunanKitaplar;

/**
 * FXML Controller class
 *
 * @author ayse
 */
//Bu controller sınıfı kullanıcıdan okuduğu kitap isminin bilgisini alır.
//Dosya oku,yaz metotları için tanımladığım abstractController 'ı extends ettim.
public class OneriSistemiController extends AbstractController implements Initializable {

    /**
     * Initializes the controller class.
     */
    //  TableView<AkademisyenDuyuru> table;
    public static List<okunanKitaplar> duyuruListele = new ArrayList();     //Okunan kitap bilgilerini tutan dizi

    @FXML
    public TextField kitap_ismi;    //Kitap ismini tutan textField
    

    @FXML
    private TableView<okunanKitaplar> tableView;    //TableView tanımlanması
    @FXML
    private TableColumn<okunanKitaplar, String> kitap_ismiColumn;   //Kitap ismini tutan tablo sütunu
    @FXML
    private TableColumn<okunanKitaplar, String> yazar_ismiColumn;      //Yazar ismini tutan tablo sütunu
    @FXML
    private TableColumn<okunanKitaplar, String> turColumn;          //Tür bilgisini tutan tablo sütunu
    @FXML
    private TableColumn<okunanKitaplar, String> fiyatColumn;        //Fiyat bilgisini tutan tablo sütunu
    @FXML
    private TableColumn<okunanKitaplar, String> yayinEviColumn;     //Yayın evi bilgisini tutan tablo sütunu
    //Kayıt ekle butonunun action ı
    @FXML
    public void kayitEkle(ActionEvent event) {

        String kitapIsmiText = kitap_ismi.getText();    //Kitap ismini string e çevir
        //Kullanıcı boş bırakıp ekle derse hata mesajı verir.
        if (kitapIsmiText.equals("")) {

            JOptionPane.showMessageDialog(null, "BOŞ ALAN BIRAKMAYINIZ !!");

        } else {
      
            yaz.VeriAra(kitapIsmiText); //Veriyi veri tabanında ara , sonrada yaz
            oku.okunanKitaplariCek();   //Yazılan dosyayı oku
            tableView.getItems().setAll(duyuruListele); //Tabloda göster
            duyuruListele.removeAll(duyuruListele); //Daha sonra aynı ekranda gösterildiğide 1 den fazla göstermemesi için diziyi boşalt
            tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); 
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        duyuruListele.removeAll(duyuruListele); //Dizi boş değilse sil.
        oku.okunanKitaplariCek();   //Okunan kitapları çek
        tableView.getItems().setAll(duyuruListele); //Table view de göster
        duyuruListele.removeAll(duyuruListele); //Kullanıcının işi bittiktan sonra Sil

        kitap_ismiColumn.setCellValueFactory(new PropertyValueFactory<okunanKitaplar, String>("kitap_ismi"));   //Column'un alabileceği değişken türleri tanımla
        yazar_ismiColumn.setCellValueFactory(new PropertyValueFactory<okunanKitaplar, String>("yazar_ismi"));//Column'un alabileceği değişken türleri tanımla
        turColumn.setCellValueFactory(new PropertyValueFactory<okunanKitaplar, String>("tur"));//Column'un alabileceği değişken türleri tanımla
        fiyatColumn.setCellValueFactory(new PropertyValueFactory<okunanKitaplar, String>("fiyat"));//Column'un alabileceği değişken türleri tanımla
        yayinEviColumn.setCellValueFactory(new PropertyValueFactory<okunanKitaplar, String>("yayinEvi"));//Column'un alabileceği değişken türleri tanımla

        /**
         * String fakulte, String bolum, String yayinlanmaTarihi, String
         * gecerlilikTarihi, String duyuran, String duyuru, String duyuruOnem
         */
    }

    @FXML
    private void onerileriGor(ActionEvent a) {
        dosyadanOku oku = new dosyadanOku();
        if (!oku.dosyaBosMu()) {    //Dosya boş değilse içeri gir ve önerileri göster , boşsa önerileri gösterme , hata ver

            try {
                //OnerileriAl.fxml e git.
                Parent tableViewParent = FXMLLoader.load(getClass().getResource("onerileriAl.fxml"));
                Scene tableview = new Scene(tableViewParent);
                Stage window = (Stage) ((Node) a.getSource()).getScene().getWindow();
                window.setScene(tableview);
                window.show();
            } catch (IOException ex) {
                Logger.getLogger(OnerileriAlController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            JOptionPane.showMessageDialog(null, "OKUDUĞUN EN AZ 1 KİTABI EKLEMELİSİN !"
                    + " YENİDEN DENEYİNİZ!!");
        }
    }
}

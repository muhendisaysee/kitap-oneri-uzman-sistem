/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitaponeriuzmansistem;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import siniflar.verileriAl;

/**
 *
 * @author ayse
 */

//İlk arayüzümün controller sınıfı
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    public void veriAl(ActionEvent a) {

       verileriAl v=new verileriAl();   //Kullanıcı verileri almak isterse başlangıçta bunu yapması için
        try {
            v.path();
        } catch (Exception ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    public void oneriSistemi(ActionEvent a) {
            //Öneri sistemi için olan butonun OneriSistemi.fxml e geçmesi için tanımlanan geçiş fonksiyonum
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitaponeriuzmansistem;

import siniflar.dosyadanOku;
import siniflar.dosyayaYaz;

/**
 *
 * @author hp
 */
//Her dosya yaz , oku metotlarında tanımlamak için bunu abstract sınıfta yaptım kullanmam gereken sınıflara extend ettim.
public abstract class AbstractController {
    public dosyayaYaz yaz = new dosyayaYaz();
    public dosyadanOku oku = new dosyadanOku();
}

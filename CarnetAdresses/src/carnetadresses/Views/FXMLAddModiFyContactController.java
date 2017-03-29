/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresses.Views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mamar
 */
public class FXMLAddModiFyContactController implements Initializable {

    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_prenom;
    @FXML
    private TextField tf_adresse;
    @FXML
    private TextField tf_complement;
    @FXML
    private TextField tf_codePostal;
    @FXML
    private TextField tf_ville;
    @FXML
    private TextField tf_telPro;
    @FXML
    private TextField tf_emailPro;
    @FXML
    private TextField tf_telPerso;
    @FXML
    private TextField tf_emailPerso;
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carnetadresses.Views;

import carnetadresses.Controllers.ControllerContact;
import carnetadresses.Controllers.VerifDatas;
import carnetadresses.Models.Contact;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    @FXML
    private Button buttonOk;
    @FXML
    private Button buttonCancel;
    
    private Contact contact;
    private Action action;
    private ControllerContact controller;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //this.buttonCancel.set
    }
    
    public Contact getContact()
    {
        return this.contact;
    }
    
    
    /**
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(Action action) {
        this.action = action;
    }
    
    /**
     * Init form before show it.
     * @param controller
     * @param action
     * @param contact 
     */
    public void InitBeforeShown(ControllerContact controller, Action action, Contact contact)
    {
        this.controller = controller;
        
        this.setAction(action);
        
        switch(action)
        {
            case Add:
                this.contact = new Contact();
                break;
            case Display:
                this.contact = contact;
                this.EnableTextField(false);
                this.FillFieldTexts();
                break;
            case Modify:
                this.contact = contact;
                this.FillFieldTexts();
                break;
            default:
        }
    }
    
    /**
     * Fill the text fields with the current contact.
     */
    private void FillFieldTexts()
    {
        this.tf_adresse.setText(this.contact.getRue());
        this.tf_codePostal.setText(this.contact.getCp());
        this.tf_complement.setText(this.contact.getComplement());
        this.tf_emailPerso.setText(this.contact.getMail1());
        this.tf_emailPro.setText(this.contact.getMail2());
        this.tf_nom.setText(this.contact.getNom());
        this.tf_prenom.setText(this.contact.getPrenom());
        this.tf_telPerso.setText(this.contact.getTel1());
        this.tf_telPro.setText(this.contact.getTel2());
        this.tf_ville.setText(this.contact.getVille());
    }
    
    /**
     * Fill contact with text fields values.
     */
    private void FillContact()
    {
        this.contact.setRue(this.tf_adresse.getText());
        this.contact.setCp(this.tf_codePostal.getText());
        this.contact.setComplement(this.tf_complement.getText());
        this.contact.setMail1(this.tf_emailPerso.getText());
        this.contact.setMail2(this.tf_emailPro.getText());
        this.contact.setNom(this.tf_nom.getText());
        this.contact.setPrenom(this.tf_prenom.getText());
        this.contact.setTel1(this.tf_telPerso.getText());
        this.contact.setTel2(this.tf_telPro.getText());
        this.contact.setVille(this.tf_ville.getText());
    }
    
    /**
     * dissable text fields => for display contact
     * @param enable 
     */
    private void EnableTextField(boolean enable)
    {
        this.tf_adresse.setEditable(enable);
        this.tf_codePostal.setEditable(enable);
        this.tf_complement.setEditable(enable);
        this.tf_emailPerso.setEditable(enable);
        this.tf_emailPro.setEditable(enable);
        this.tf_nom.setEditable(enable);
        this.tf_prenom.setEditable(enable);
        this.tf_telPerso.setEditable(enable);
        this.tf_telPro.setEditable(enable);
        this.tf_ville.setEditable(enable);
    }

    /**
     * Validate changes
     * @param e 
     */
    @FXML protected void OkClicked(MouseEvent e)
    {
        boolean correct = true;
        if(this.tf_nom.textProperty().get().isEmpty())
        {
            this.tf_nom.setStyle("-fx-background-color:lightpink");
            correct = false;
        }
        else
        {
            this.tf_nom.setStyle(null);
        }
        
        if(correct  && VerifDatas.VerifDataContact(this.contact))
        {
            this.FillContact();
            
            try
            {
                switch(this.action)
                {
                    case Add:
                    {
                        this.controller.AddContact(this.contact);
                        break;
                    }
                    case Modify:
                    {
                        this.controller.ModifyContact(this.contact);
                        break;
                    }
                    case Display:
                    {
                        break;
                    }
                }
            
                Stage stage = (Stage) this.buttonOk.getScene().getWindow();
                stage.close();
            } 
            catch (Exception ex)
            {
                UtilsView.ShowAlert(AlertType.ERROR, ex.getMessage(), "Erreur sur ajout");
            }
        }
    } 
    
    /**
     * Cancel changes
     * @param e 
     */
    @FXML protected void CancelClicked(MouseEvent e) 
    {
        Stage stage = (Stage) this.buttonOk.getScene().getWindow();
        stage.close();
    } 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemple_tableview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Unkof
 */
public class Exemple_TableView extends Application
    {
    
    @Override
    public void start(Stage stage) throws Exception
        {
            TableView<Contact> maTable=new TableView<Contact>();
            maTable.setEditable(false);
            maTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            TableColumn<Contact, String> tnom=new TableColumn<Contact, String>("nom");
            TableColumn<Contact, String> tprenom=new TableColumn<Contact, String>("prenom");;
            maTable.getColumns().setAll(tnom,tprenom);

            tnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            tprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            
            // La liste Observable pour les données de la table
            ObservableList<Contact> list=getUserList();
            maTable.setItems(list);
            
            // Le listener pour une sélection 
            maTable.setOnMousePressed(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event)
                    {
                         if(event.isPrimaryButtonDown() && event.getClickCount()==2)
                             {
                                 System.out.println(maTable.getSelectionModel().getSelectedItem().getNom()+" "+maTable.getSelectionModel().getSelectedItem().getPrenom());
                             }
                    }
            });
            
            System.out.println("Vous avez selectionné");
            
            final StackPane root=new StackPane();

            root.getChildren().add(maTable);
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.setWidth(1024);
            stage.setHeight(768);
            stage.setTitle("JavaFX Fxml");
            stage.show();
        }
     
     private ObservableList<Contact> getUserList()
        {
             Contact user1=new Contact("nom1","prenom1");
             Contact user2=new Contact("nom2","prenom2");
             
             ObservableList<Contact> list=FXCollections.observableArrayList(user1,user2);
             return list;
        }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
        {
        launch(args);
        }
    }

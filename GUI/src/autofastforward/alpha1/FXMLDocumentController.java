/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autofastforward.alpha1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import dosse.upnp.UPnP;
import javafx.scene.control.TextField;
/**
 *
 * @author niris
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    TextField portbox;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        int integer = Integer.parseInt(portbox.getText());
        UPnP.openPortTCP(integer);
        UPnP.openPortUDP(integer);
        label.setText("Opened Port " + integer);
    }
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        System.out.println("You clicked me!");
        int integer = Integer.parseInt(portbox.getText());
        UPnP.closePortTCP(integer);
        UPnP.closePortUDP(integer);
        label.setText("Closed Port " + integer);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

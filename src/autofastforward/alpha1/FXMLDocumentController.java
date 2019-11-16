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
/**
 *
 * @author niris
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        UPnP.openPortTCP(25565);
        UPnP.openPortUDP(25565);
        label.setText("Opened Port 25565");
    }
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        System.out.println("You clicked me!");
        UPnP.closePortTCP(25565);
        UPnP.closePortUDP(25565);
        label.setText("Closed Port 25565");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

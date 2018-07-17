package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by hp series on 23/03/2017.
 */
public class invoiceController {
    public void initialize(){

    }

    @FXML
    Label lblText;
    String text;

    public void getData(){
        lblText.setText(text);
    }
    public void setData(String txt){
        text=txt;
    }
}

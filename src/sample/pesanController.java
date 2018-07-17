package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by SULUH on 3/22/2017.
 */
public class pesanController {
    @FXML
    private TextField txtDewasa,txtAnak,txtBayi;



    @FXML
    public void handleBtnBeli(){
        int price = Integer.parseInt(txtDewasa.getText());
        //ObservableList<Data>
    }
}

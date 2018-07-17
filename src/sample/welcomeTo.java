package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by hp series on 22/03/2017.
 */
public class welcomeTo {

    @FXML
    Button btnWelcome;

    @FXML
    public void btnWelcome(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainFrame.fxml"));
            Parent entryForm = loader.load();
            Stage parentwindow = (Stage) btnWelcome.getScene().getWindow();
            parentwindow.close();
            Stage stage = new Stage();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("logoFix.png")));
            stage.setTitle("Ultimate Airlines");
            stage.setScene(new Scene(entryForm));
            stage.show();
            stage.requestFocus();

            //mainFrameController ec = loader.getController();
            //ec.setListData(Datas);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }


    }
}

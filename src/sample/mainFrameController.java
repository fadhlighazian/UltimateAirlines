package sample;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import static sample.global.temp;


public class mainFrameController {

    boolean flag=false;
    @FXML
    public ComboBox cboKeberangkatan,cboTujuan,cboKelas,cboTrip;

   public static ObservableList<Data> Datas ;

    private int idx;
    private int maxIdx;
    private Data[] datas = new Data[100];

    Data iniData;

    public void initialize(){
    }

    @FXML
    public void addtext(){
    }

    @FXML
    public void handleBtnJadwal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("jadwal.fxml"));
            Parent entryForm = loader.load();
            Stage entryStage = new Stage();
            entryStage.getIcons().add(new Image(getClass().getResourceAsStream("logoFix.png")));
            entryStage.resizableProperty().setValue(Boolean.FALSE);
            entryStage.setTitle("Jadwal Penerbangan");
            entryStage.setScene(new Scene(entryForm));
            entryStage.show();
            entryStage.requestFocus();
            //updateData();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void btnAbout(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("about.fxml"));
            Parent entryForm = loader.load();
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

    @FXML
    public void handleBtnPesan(){
       /*Alert s = new Alert(Alert.AlertType.INFORMATION);
        s.setTitle("Warning !");
        s.setContentText("asdas");
        s.show();*/
        for (Data x: Datas) {
            if(x.getKeberangkatan().equals(cboKeberangkatan.getValue().toString())){
                if(x.getTujuan().equals(cboTujuan.getValue().toString())){
                    if(x.getKelas().equals(cboKelas.getValue().toString())){
                        if(x.getTrip().equals(cboTrip.getValue().toString())){
                            flag = true;
                            iniData = x;
                            break;

                        }
                    }
                }
            }
        }
        if(flag) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("beliTiket.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                beliTiketController ec = fxmlLoader.getController();
                ec.getData(iniData);
                ec.setData();

                Stage stage = new Stage();

                stage.getIcons().add(new Image(getClass().getResourceAsStream("logoFix.png")));
                stage.resizableProperty().setValue(Boolean.FALSE);

                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initStyle(StageStyle.DECORATED);
                stage.setTitle("Item Orders");
                stage.setScene(new Scene(root1));
                stage.show();
                stage.requestFocus();

            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        else {
            Alert s = new Alert(Alert.AlertType.INFORMATION);
            s.setTitle("Warning !");
            s.setContentText("Jadwal yang anda pilih tidak ada !");
            s.show();
        }
    }

}



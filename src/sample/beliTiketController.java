package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;



/**
 * Created by SULUH on 3/21/2017.
 */
public class beliTiketController {
    @FXML
    TextField txtKeberangkatan, txtTujuan, txtKelas, txtTrip, txtPrice;

    @FXML
    ComboBox<String> cboDewasa,cboAnak,cboBayi;

    public static ObservableList<Data> Datas;

    Data iniData;

    private String text;

    public void initialize(){
        txtKeberangkatan.setDisable(true);
        txtTujuan.setDisable(true);
        txtKelas.setDisable(true);
        txtTrip.setDisable(true);
        txtPrice.setDisable(true);
    }

    public void getData(Data data){
        iniData = data;
    }

    public void setData(){
        txtKeberangkatan.setText(iniData.getKeberangkatan());
        txtTujuan.setText(iniData.getTujuan());
        txtKelas.setText(iniData.getKelas());
        txtTrip.setText(iniData.getTrip());
        txtPrice.setText(String.valueOf(iniData.getHarga()));
    }

    @FXML
    public void handleBtnBatal(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainFrame.fxml"));
            Parent entryForm = loader.load();
            Stage entryStage = new Stage();
            entryStage.getIcons().add(new Image(getClass().getResourceAsStream("logoFix.png")));
            entryStage.setTitle("Ultimate Airlines");
            entryStage.setScene(new Scene(entryForm));
            entryStage.show();
            entryStage.requestFocus();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    @FXML
    public void handleBtnBeli(){
        text = "Anda telah membeli tiket penerbangan dengan detail: \n\nKeberangkatan dari : ";
        text+= txtKeberangkatan.getText().toString();
        text+= "\n";
        text+= "Tujuan bandara \t: ";
        text+= txtTujuan.getText().toString();
        text+= "\nKelas \t\t: ";
        text+= txtKelas.getText().toString();
        text+= " \nTrip \t\t: ";
        text+= txtTrip.getText().toString();
        text+= " \nHarga \t\t: ";
        text+= iniData.getHarga()*Integer.parseInt(cboDewasa.getValue())+
                iniData.getHarga()*Integer.parseInt(cboAnak.getValue())*0.8+
                iniData.getHarga()*Integer.parseInt(cboBayi.getValue())*0;

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("invoice.fxml"));
            Parent entryForm = loader.load();
            invoiceController ec = loader.getController();
            ec.setData(text);
            ec.getData();
            Stage entryStage = new Stage();
            entryStage.getIcons().add(new Image(getClass().getResourceAsStream("logoFix.png")));
            entryStage.resizableProperty().setValue(Boolean.FALSE);
            entryStage.setTitle("Invoice");
            entryStage.setScene(new Scene(entryForm));
            entryStage.show();
            entryStage.requestFocus();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }
}


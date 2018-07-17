package sample;

/**
 * Created by SULUH on 3/17/2017.
 */


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.xml.soap.Text;

public class jadwalController {
    @FXML
    private TableView<Data> tableItem;
    @FXML
    private TableColumn colKode,colKeberangkatan,colTujuan,colKelas,colTrip,colHarga;
    @FXML
    private TextField txtKeyword;

    private ObservableList<Data> search = FXCollections.observableArrayList();
    private ObservableList<Data> Datas =
            FXCollections.observableArrayList(
                    new Data("AAA01","Jakarta(CGK)","Medan(KNO)","Bisnis","Sekali Pergi",2000),
                    new Data("AAA02","Medan(KNO)","Banda Aceh (BTJ)","Ekonomi","Pulang Pergi",5000),
                    new Data("AAA03","Bandung(BDO)","Lombok(LOP)","Bisnis","Sekali Pergi",7000),
                    new Data("AAA04","Jakarta(CGK)","Padang(PDG)","Bisnis","Pulang Pergi",2000),
                    new Data("AAA05","Bandung(BDO)","Medan(KNO)","Bisnis","Sekali Pergi",3000),
                    new Data("AAA06","Bali(DPS)","Pekanbaru(PKU)","Ekonomi","Sekali Pergi",3000),
                    new Data("AAA07","Balikpapan(BPN)","Palembang(PLM)","Eksekutif","Pulang Pergi",2300),
                    new Data("AAA08","Palembang(PLM)","Yogyakarta(YOG)","Eksekutif","Pulang Pergi",2300),
                    new Data("AAA09","Yogyakarta(YOG)","Medan(KNO)","Bisnis","Pulang Pergi",2300)
            );

    public void initialize(){
        colKode.setCellValueFactory(new PropertyValueFactory<Data, String>("Kode"));
        colKeberangkatan.setCellValueFactory(new PropertyValueFactory<Data, String>("Keberangkatan"));
        colTujuan.setCellValueFactory(new PropertyValueFactory<Data, String>("Tujuan"));
        colKelas.setCellValueFactory(new PropertyValueFactory<Data, String>("Kelas"));
        colTrip.setCellValueFactory(new PropertyValueFactory<Data, String>("Trip"));
        colHarga.setCellValueFactory(new PropertyValueFactory<Data, Integer>("Harga"));
        tableItem.setItems(Datas);
        mainFrameController.Datas = Datas;
    }

    @FXML
    public void handleBtnSearch(){
        search.clear();
        for(int i=0; i<Datas.size(); i++){
            if(Datas.get(i).getKeberangkatan().toLowerCase().contains(txtKeyword.getText().toLowerCase())){
                search.add(Datas.get(i));
            }
            tableItem.setItems(search);
        }
    }
}

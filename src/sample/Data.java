package sample;

import javafx.scene.control.ComboBox;

import java.lang.String;

/**
 * Created by SULUH on 3/18/2017.
 */
public class Data{
    private String Kode;
    private String Keberangkatan;
    private String Tujuan;
    private String Kelas;
    private String Trip;
    private int Harga;

    public Data(String Kode, String Keberangkatan, String Tujuan, String Kelas, String Trip,int Harga) {
        this.Kode = Kode;
        this.Keberangkatan = Keberangkatan;
        this.Tujuan = Tujuan;
        this.Kelas = Kelas;
        this.Trip = Trip;
        this.Harga = Harga;
    }

    public String getKode(){return Kode;}

    public String getKeberangkatan() {
        return Keberangkatan;
    }

    public String getTujuan() {
        return Tujuan;
    }

    public String getKelas() {
        return Kelas;
    }

    public String getTrip() {
        return Trip;
    }

    public int getHarga() {return Harga; }
}

package org.chinh.appquanlychitieu.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "nguoidung")

public class NguoiDung {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;
    @ColumnInfo(name = "hovaten")
    private String hovaten;
    @ColumnInfo(name = "taikhoan")
    private String taikhoan;
    @ColumnInfo(name = "matkhau")
    private String matkhau;
    @ColumnInfo(name = "sodienthoai")
    private String sodienthoai;

    public NguoiDung(String hovaten, String taikhoan, String matkhau, String sodienthoai) {
        this.hovaten = hovaten;
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.sodienthoai = sodienthoai;
    }

    public NguoiDung() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }
}

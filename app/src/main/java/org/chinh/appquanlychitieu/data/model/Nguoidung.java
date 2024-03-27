package org.chinh.appquanlychitieu.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nguoidung")
public class Nguoidung {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;
    @ColumnInfo(name = "hoVaTen")
    private String hoVaTen;
    @ColumnInfo(name = "taiKhoan")
    private String taiKhoan;
    @ColumnInfo(name = "matKhau")
    private String matKhau;
    @ColumnInfo(name = "soDienThoai")
    private String soDienThoai;
    @ColumnInfo(name = "anhDaiDien")
    private String anhDaiDien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getAnhDaiDien() {
        return anhDaiDien;
    }

    public void setAnhDaiDien(String anhDaiDien) {
        this.anhDaiDien = anhDaiDien;
    }

    public Nguoidung(int id, String hoVaTen, String taiKhoan, String matKhau, String soDienThoai, String anhDaiDien) {
        this.id = id;
        this.hoVaTen = hoVaTen;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.soDienThoai = soDienThoai;
        this.anhDaiDien = anhDaiDien;
    }

    public Nguoidung() {
    }
}

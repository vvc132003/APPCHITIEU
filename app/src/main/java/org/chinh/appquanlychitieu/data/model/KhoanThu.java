package org.chinh.appquanlychitieu.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import org.chinh.appquanlychitieu.data.DateConverter;

import java.util.Date;

@Entity(tableName = "khoanthu")
@TypeConverters(DateConverter.class)
public class KhoanThu {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;
    @ColumnInfo(name = "soTienThu")
    private double soTienThu;
    @ColumnInfo(name = "tenKhoanThu")
    private String tenKhoanThu;
    @ColumnInfo(name = "moTa")
    private String moTa;
    @ColumnInfo(name = "thoiGianThu")
    private Date thoiGianThu;
    @ColumnInfo(name = "idLoaiTienTe")
    private int idLoaiTienTe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSoTienThu() {
        return soTienThu;
    }

    public void setSoTienThu(double soTienThu) {
        this.soTienThu = soTienThu;
    }

    public String getTenKhoanThu() {
        return tenKhoanThu;
    }

    public void setTenKhoanThu(String tenKhoanThu) {
        this.tenKhoanThu = tenKhoanThu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getThoiGianThu() {
        return thoiGianThu;
    }

    public void setThoiGianThu(Date thoiGianThu) {
        this.thoiGianThu = thoiGianThu;
    }

    public int getIdLoaiTienTe() {
        return idLoaiTienTe;
    }

    public void setIdLoaiTienTe(int idLoaiTienTe) {
        this.idLoaiTienTe = idLoaiTienTe;
    }

    public KhoanThu(int id, double soTienThu, String tenKhoanThu, String moTa, Date thoiGianThu, int idLoaiTienTe) {
        this.id = id;
        this.soTienThu = soTienThu;
        this.tenKhoanThu = tenKhoanThu;
        this.moTa = moTa;
        this.thoiGianThu = thoiGianThu;
        this.idLoaiTienTe = idLoaiTienTe;
    }

    public KhoanThu() {
    }
}

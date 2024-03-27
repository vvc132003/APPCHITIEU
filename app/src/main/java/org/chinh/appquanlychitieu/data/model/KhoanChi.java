package org.chinh.appquanlychitieu.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import org.chinh.appquanlychitieu.data.DateConverter;

import java.util.Date;

@Entity(tableName = "khoanchi")
@TypeConverters(DateConverter.class)
public class KhoanChi {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;
    @ColumnInfo(name = "soTienChi")
    private double soTienChi;
    @ColumnInfo(name = "tenKhoanChi")
    private String tenKhoanChi;
    @ColumnInfo(name = "moTa")
    private String moTa;
    @ColumnInfo(name = "thoigianchi")
    private Date thoigianchi;
    @ColumnInfo(name = "idLoaiTienTe")
    private int idLoaiTienTe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSoTienChi() {
        return soTienChi;
    }

    public void setSoTienChi(double soTienChi) {
        this.soTienChi = soTienChi;
    }

    public String getTenKhoanChi() {
        return tenKhoanChi;
    }

    public void setTenKhoanChi(String tenKhoanChi) {
        this.tenKhoanChi = tenKhoanChi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }



    public int getIdLoaiTienTe() {
        return idLoaiTienTe;
    }

    public void setIdLoaiTienTe(int idLoaiTienTe) {
        this.idLoaiTienTe = idLoaiTienTe;
    }

    public Date getThoigianchi() {
        return thoigianchi;
    }

    public void setThoigianchi(Date thoigianchi) {
        this.thoigianchi = thoigianchi;
    }

    public KhoanChi(int id, double soTienChi, String tenKhoanChi, String moTa, Date thoigianchi, int idLoaiTienTe) {
        this.id = id;
        this.soTienChi = soTienChi;
        this.tenKhoanChi = tenKhoanChi;
        this.moTa = moTa;
        this.thoigianchi = thoigianchi;
        this.idLoaiTienTe = idLoaiTienTe;
    }

    public KhoanChi() {
    }
}

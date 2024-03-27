package org.chinh.appquanlychitieu.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "loaitiente")

public class LoaiTienTe {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Id")
    private int id;
    @ColumnInfo(name = "tenTienTe")
    private String tenTienTe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTienTe() {
        return tenTienTe;
    }

    public void setTenTienTe(String tenTienTe) {
        this.tenTienTe = tenTienTe;
    }

    public LoaiTienTe(int id, String tenTienTe) {
        this.id = id;
        this.tenTienTe = tenTienTe;
    }

    public LoaiTienTe() {
    }
}

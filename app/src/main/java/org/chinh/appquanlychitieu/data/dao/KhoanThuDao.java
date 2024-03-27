package org.chinh.appquanlychitieu.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import org.chinh.appquanlychitieu.data.model.KhoanThu;

import java.util.List;

@Dao
public interface KhoanThuDao {
    @Query("SELECT * FROM khoanthu")
    List<KhoanThu> getAllKhoanThu();

    @Insert
    void insertKhoanThu(KhoanThu khoanThu);

}

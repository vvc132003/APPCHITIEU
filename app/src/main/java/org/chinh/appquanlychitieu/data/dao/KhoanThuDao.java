package org.chinh.appquanlychitieu.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.data.model.KhoanThu;

import java.util.List;

@Dao
public interface KhoanThuDao {
    @Query("SELECT * FROM khoanthu")
    List<KhoanThu> getAllKhoanThu();

    @Insert
    void insertKhoanThu(KhoanThu khoanThu);
    @Delete
    void deleteKhoanThu(KhoanThu khoanThu);
    @Update
    void updateKhoanthu(KhoanThu khoanThu);
    @Query("SELECT * FROM khoanthu WHERE id=:khoanthuID")
    List<KhoanThu> getGetKhoanThuibyID(int khoanthuID);
}

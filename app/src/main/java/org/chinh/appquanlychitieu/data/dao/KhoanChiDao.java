package org.chinh.appquanlychitieu.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import org.chinh.appquanlychitieu.data.model.KhoanChi;

import java.util.List;

@Dao
public interface KhoanChiDao {
    @Query("SELECT * FROM khoanchi")
    List<KhoanChi> getAllKhoanChi();

    @Insert
    void insertKhoanChi(KhoanChi khoanChi);

    @Delete
    void deleteKhoanChi(KhoanChi khoanChi);
    @Update
    void updateKhoanChi(KhoanChi khoanChi);

    @Query("SELECT * FROM khoanchi WHERE id=:khoanChiID")
    List<KhoanChi> getGetKhoanChibyID(int khoanChiID);
}
    
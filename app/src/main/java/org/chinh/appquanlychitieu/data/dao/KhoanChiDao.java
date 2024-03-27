package org.chinh.appquanlychitieu.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import org.chinh.appquanlychitieu.data.model.KhoanChi;

import java.util.List;

@Dao
public interface KhoanChiDao {
    @Query("SELECT * FROM khoanchi")
    List<KhoanChi> getAllKhoanChi();

    @Insert
    void insertKhoanChi(KhoanChi khoanChi);

}

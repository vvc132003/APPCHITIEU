package org.chinh.appquanlychitieu.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import org.chinh.appquanlychitieu.data.model.LoaiTienTe;

import java.util.List;

@Dao
public interface LoaiTienTeDao {
    @Query("SELECT * FROM loaitiente")
    List<LoaiTienTe> getAllLoaiTienTe();

    @Insert
    void insertLoaiTienTe(LoaiTienTe loaiTienTe);
}

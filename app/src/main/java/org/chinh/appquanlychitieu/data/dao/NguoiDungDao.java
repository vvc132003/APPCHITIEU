package org.chinh.appquanlychitieu.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import org.chinh.appquanlychitieu.data.model.Nguoidung;

import java.util.List;

@Dao
public interface NguoiDungDao {
    @Query("SELECT * FROM nguoidung")
    List<Nguoidung> getAllNguoidung();

    @Insert
    void insertNguoidung(Nguoidung nguoidung);

    @Update
    void updateNguoidung(Nguoidung nguoidung);

    @Delete
    void deleteNguoidung(Nguoidung nguoidung);

}

package org.chinh.appquanlychitieu.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import org.chinh.appquanlychitieu.data.model.KhoanThu;
import org.chinh.appquanlychitieu.data.model.NguoiDung;

import java.util.List;

@Dao
public interface NguoiDungDao {
    @Query("SELECT * FROM nguoidung WHERE taikhoan = :taikhoan AND matkhau = :matkhau")
    NguoiDung login(String taikhoan, String matkhau);

    @Insert
    void InsertNguoiDung(NguoiDung nguoiDung);
    @Query("SELECT * FROM nguoidung")
    List<NguoiDung> getAllNguoiDung();

}

package org.chinh.appquanlychitieu.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import org.chinh.appquanlychitieu.data.dao.KhoanChiDao;
import org.chinh.appquanlychitieu.data.dao.KhoanThuDao;
import org.chinh.appquanlychitieu.data.dao.NguoiDungDao;
import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.data.model.KhoanThu;
import org.chinh.appquanlychitieu.data.model.NguoiDung;

@Database(entities = {KhoanThu.class, KhoanChi.class, NguoiDung.class}, version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    public abstract KhoanThuDao khoanThuDao();

    public abstract KhoanChiDao khoanChiDao();
    public abstract NguoiDungDao nguoiDungDao();

}
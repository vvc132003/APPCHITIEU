package org.chinh.appquanlychitieu.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import org.chinh.appquanlychitieu.data.dao.KhoanChiDao;
import org.chinh.appquanlychitieu.data.dao.KhoanThuDao;
import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.data.model.KhoanThu;

@Database(entities = {KhoanThu.class, KhoanChi.class}, version = 4)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    public  abstract KhoanThuDao khoanThuDao();
    public  abstract KhoanChiDao khoanChiDao();
}
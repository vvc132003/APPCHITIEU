package org.chinh.appquanlychitieu.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import org.chinh.appquanlychitieu.data.dao.KhoanChiDao;
import org.chinh.appquanlychitieu.data.dao.KhoanThuDao;
import org.chinh.appquanlychitieu.data.dao.LoaiTienTeDao;
import org.chinh.appquanlychitieu.data.dao.NguoiDungDao;
import org.chinh.appquanlychitieu.data.dao.ProductDao;
import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.data.model.KhoanThu;
import org.chinh.appquanlychitieu.data.model.LoaiTienTe;
import org.chinh.appquanlychitieu.data.model.Nguoidung;
import org.chinh.appquanlychitieu.data.model.Product;

@Database(entities = {Product.class, Nguoidung.class, LoaiTienTe.class, KhoanThu.class, KhoanChi.class}, version = 3)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProductDao productDao();
    public abstract NguoiDungDao nguoiDungDao();
    public abstract LoaiTienTeDao loaiTienTeDao();
    public  abstract KhoanThuDao khoanThuDao();
    public  abstract KhoanChiDao khoanChiDao();
}
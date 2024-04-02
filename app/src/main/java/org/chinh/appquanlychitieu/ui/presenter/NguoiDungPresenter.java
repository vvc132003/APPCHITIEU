package org.chinh.appquanlychitieu.ui.presenter;

import android.content.Context;

import androidx.room.Room;

import org.chinh.appquanlychitieu.data.AppDatabase;
import org.chinh.appquanlychitieu.data.model.NguoiDung;
import org.chinh.appquanlychitieu.ui.constract.NguoiDungConstract;
import org.chinh.appquanlychitieu.util.Constants;

import java.util.List;

public class NguoiDungPresenter implements NguoiDungConstract.IPresenter {
    private AppDatabase db;

    public NguoiDungPresenter(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
    }

    @Override
    public NguoiDung login(String taikhoan, String matkhau) {
        return db.nguoiDungDao().login(taikhoan, matkhau);
    }

    @Override
    public List<NguoiDung> getAllNguoiDung() {
        return db.nguoiDungDao().getAllNguoiDung();
    }
}

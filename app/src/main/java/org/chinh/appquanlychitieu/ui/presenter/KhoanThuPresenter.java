package org.chinh.appquanlychitieu.ui.presenter;

import android.content.Context;

import androidx.room.Room;

import org.chinh.appquanlychitieu.data.AppDatabase;
import org.chinh.appquanlychitieu.data.dao.KhoanChiDao;
import org.chinh.appquanlychitieu.data.dao.KhoanThuDao;
import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.data.model.KhoanThu;
import org.chinh.appquanlychitieu.ui.constract.IKhoanChiConstract;
import org.chinh.appquanlychitieu.ui.constract.IKhoanThuConstract;
import org.chinh.appquanlychitieu.util.Constants;

import java.util.Date;

public class KhoanThuPresenter implements IKhoanThuConstract.IPresenter {
    private IKhoanThuConstract.IView mView;
    private AppDatabase db;

    public KhoanThuPresenter(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
    }

    @Override
    public void loadKhoanThu() {
        KhoanThuDao khoanThuDao = db.khoanThuDao();
        mView.setKhoanThuToUI(khoanThuDao.getAllKhoanThu());
    }

    @Override
    public void setView(IKhoanThuConstract.IView view) {
        mView = view;
    }

    @Override
    public void onAddButtonClick() {

    }

    @Override
    public void AddKhoanThu(double soTienThu, String tenKhoanThu, String moTa, Date thoigianThu, int idLoaiTienTe) {
        KhoanThu khoanThu = new KhoanThu();
        khoanThu.setTenKhoanThu(tenKhoanThu);
        khoanThu.setSoTienThu(soTienThu);
        khoanThu.setThoiGianThu(thoigianThu);
        khoanThu.setMoTa(moTa);
        khoanThu.setIdLoaiTienTe(idLoaiTienTe);
        KhoanThuDao khoanThuDao = db.khoanThuDao();
        khoanThuDao.insertKhoanThu(khoanThu);
    }

    @Override
    public void deleteKhoanThu(KhoanThu khoanThu) {
        KhoanThuDao khoanThuDao = db.khoanThuDao();
        khoanThuDao.deleteKhoanThu(khoanThu);
        loadKhoanThu();
    }

    @Override
    public void loaidkhoanthuBYID(int khoanthuID) {
        KhoanThuDao khoanThuDao = db.khoanThuDao();
        mView.setKhoanThuToUI(khoanThuDao.getGetKhoanThuibyID(khoanthuID));
    }

    @Override
    public void updateKhoanThu(KhoanThu khoanThu) {
        KhoanThuDao khoanThuDao = db.khoanThuDao();
        khoanThuDao.updateKhoanthu(khoanThu);
    }
}

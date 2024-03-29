package org.chinh.appquanlychitieu.ui.presenter;

import android.content.Context;

import androidx.room.Room;

import org.chinh.appquanlychitieu.data.AppDatabase;
import org.chinh.appquanlychitieu.data.dao.KhoanChiDao;
import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.ui.constract.IKhoanChiConstract;
import org.chinh.appquanlychitieu.util.Constants;

import java.util.Date;

public class KhoanChiPresenter implements IKhoanChiConstract.IPresenter {
    private IKhoanChiConstract.IView mView;
    private AppDatabase db;

    public KhoanChiPresenter(Context context) {
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
    }

    @Override
    public void loadKhoanChi() {
        KhoanChiDao khoanChiDao = db.khoanChiDao();
        mView.setKhoanChiToUI(khoanChiDao.getAllKhoanChi());
    }

    @Override
    public void setView(IKhoanChiConstract.IView view) {
        mView = view;
    }

    @Override
    public void onAddButtonClick() {

    }

    @Override
    public void AddKhoanChi(double soTienChi, String tenKhoanChi, String moTa, Date thoigianchi, int idLoaiTienTe) {
        KhoanChi khoanChi = new KhoanChi();
        khoanChi.setSoTienChi(soTienChi);
        khoanChi.setTenKhoanChi(tenKhoanChi);
        khoanChi.setThoigianchi(thoigianchi);
        khoanChi.setMoTa(moTa);
        khoanChi.setIdLoaiTienTe(idLoaiTienTe);
        KhoanChiDao khoanChiDao = db.khoanChiDao();
        khoanChiDao.insertKhoanChi(khoanChi);
    }

    @Override
    public void deleteKhoanchi(KhoanChi khoanChi) {
        KhoanChiDao khoanChiDao = db.khoanChiDao();
        khoanChiDao.deleteKhoanChi(khoanChi);
        loadKhoanChi();
    }

    @Override
    public void loaidkhoanchiBYID(int khoanchiID) {
        KhoanChiDao khoanChiDao = db.khoanChiDao();
        mView.setKhoanChiToUI(khoanChiDao.getGetKhoanChibyID(khoanchiID));
    }

    @Override
    public void updateKhoanChi(KhoanChi khoanChi) {
        KhoanChiDao khoanChiDao = db.khoanChiDao();
        khoanChiDao.updateKhoanChi(khoanChi);
    }
}

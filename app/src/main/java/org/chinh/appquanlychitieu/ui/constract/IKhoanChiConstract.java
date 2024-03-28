package org.chinh.appquanlychitieu.ui.constract;


import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.data.model.Product;

import java.util.Date;
import java.util.List;

public interface IKhoanChiConstract {
    interface IView {
        void setKhoanChiToUI(List<KhoanChi> khoanChiList);
//        void showAddKhoanChiModal();

    }

    interface IPresenter {
        void loadKhoanChi();
        void setView(IView view);
        void onAddButtonClick();
        void AddKhoanChi(double soTienChi, String tenKhoanChi, String moTa, Date thoigianchi, int idLoaiTienTe);
        void deleteKhoanchi(KhoanChi khoanChi);
        void loaidkhoanchiBYID(int khoanchiID);
        void updateKhoanChi(KhoanChi khoanChi);
    }
    interface OnKhoanChiDeleteListener {
        void onDeleteKhoanChiClicked(KhoanChi khoanChi);
    }
}

package org.chinh.appquanlychitieu.ui.constract;


import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.data.model.KhoanThu;

import java.util.Date;
import java.util.List;

public interface IKhoanThuConstract {
    interface IView {
        void setKhoanThuToUI(List<KhoanThu> khoanThuList);
//        void showAddKhoanChiModal();

    }

    interface IPresenter {
        void loadKhoanThu();
        void setView(IView view);
        void onAddButtonClick();
        void AddKhoanThu(double soTienThu, String tenKhoanThu, String moTa, Date thoigianThu, int idLoaiTienTe);
        void deleteKhoanThu(KhoanThu khoanThu);
        void loaidkhoanthuBYID(int khoanthuID);
        void updateKhoanThu(KhoanThu khoanThu);
    }
    interface OnKhoanThuDeleteListener {
        void onDeleteKhoanThuClicked(KhoanThu khoanThu);
    }
}

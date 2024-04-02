package org.chinh.appquanlychitieu.ui.constract;

import org.chinh.appquanlychitieu.data.model.NguoiDung;

import java.util.List;

public interface NguoiDungConstract {
    interface IPresenter{
        NguoiDung login(String username, String password);
        List<NguoiDung> getAllNguoiDung();

    }
}

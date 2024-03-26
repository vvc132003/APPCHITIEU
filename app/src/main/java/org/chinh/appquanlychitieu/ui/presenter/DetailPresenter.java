package org.chinh.appquanlychitieu.ui.presenter;

import android.content.Context;

import androidx.room.Room;

import org.chinh.appquanlychitieu.data.AppDatabase;
import org.chinh.appquanlychitieu.data.dao.ProductDao;
import org.chinh.appquanlychitieu.ui.constract.IDetailConstract;
import org.chinh.appquanlychitieu.util.Constants;


public class DetailPresenter implements IDetailConstract.IPresenter {
    private IDetailConstract.IView mView; private AppDatabase db;
    public DetailPresenter(Context context){
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).build();
    }
    @Override
    public void setView(IDetailConstract.IView view) {
        mView = view;
    }

    @Override
    public void loadProduct(int productId) {
        ProductDao productDao = db.productDao();
        mView.setProductToUI(productDao.find(productId));
    }

    @Override
    public void addToCart(int productId, int quantity) {

    }
}
package org.chinh.appquanlychitieu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.chinh.appquanlychitieu.base.BaseActivity;
import org.chinh.appquanlychitieu.data.dao.ProductDao;
import org.chinh.appquanlychitieu.data.model.Product;
import org.chinh.appquanlychitieu.ui.constract.IDetailConstract;
import org.chinh.appquanlychitieu.ui.presenter.DetailPresenter;
import org.chinh.appquanlychitieu.util.Constants;

public class DetailActivity extends BaseActivity implements IDetailConstract.IView {
    private IDetailConstract.IPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initGUI();
        initData();
    }

    private void initGUI() {
    }
    private void initData() {
        mPresenter = new DetailPresenter(this);
        mPresenter.setView(this);

        int productId = getIntent().getIntExtra(Constants.PRODUCT_ID, 1);
        mPresenter.loadProduct(productId);
    }

    @Override
    public void setProductToUI(Product product) {
        //Dung Glide de load anh
    }

    @Override
    public void showMessage(Constants.CART_EVENT event, String message) {

    }
}
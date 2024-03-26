package org.chinh.appquanlychitieu.ui.presenter;

import android.content.Context;

import androidx.room.Room;

import org.chinh.appquanlychitieu.data.AppDatabase;
import org.chinh.appquanlychitieu.data.dao.ProductDao;
import org.chinh.appquanlychitieu.data.model.Product;
import org.chinh.appquanlychitieu.ui.constract.IProductConstract;
import org.chinh.appquanlychitieu.util.Constants;

import java.util.List;

public class ProductPresenter implements IProductConstract.IPresenter {
    private IProductConstract.IView mView;
    private AppDatabase db;
    public ProductPresenter(Context context){
        db = Room.databaseBuilder(context,
                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
    }

    @Override
    public void setView(IProductConstract.IView view) {
        mView = view;
    }

    @Override
    public void loadHotProducts() {
        ProductDao productDao = db.productDao();
        mView.setHotProductsToUI(productDao.getHotProducts());
    }

    @Override
    public void loadNewProducts() {
        ProductDao productDao = db.productDao();
        mView.setNewProductsToUI(productDao.getNewProducts());
    }

    // Trong ProductPresenter
    @Override
    public void deleteProduct(Product product) {
        ProductDao productDao = db.productDao();
        productDao.delete(product);
        // Kiểm tra sự tồn tại của sản phẩm sau khi xóa
        int productCount = productDao.getProductCountById(product.getId());
        loadHotProducts();
        loadNewProducts();
    }

    @Override
    public void addProduct(String name, String description, double price, int quantity) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        ProductDao productDao = db.productDao();
        productDao.insertAll(product);
    }

}

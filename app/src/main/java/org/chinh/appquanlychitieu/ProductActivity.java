package org.chinh.appquanlychitieu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import org.chinh.appquanlychitieu.data.AppDatabase;
import org.chinh.appquanlychitieu.data.model.Product;
import org.chinh.appquanlychitieu.ui.constract.IProductConstract;
import org.chinh.appquanlychitieu.ui.presenter.ProductPresenter;
import org.chinh.appquanlychitieu.ui.adapter.ProductAdapter;
import org.chinh.appquanlychitieu.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity implements IProductConstract.IView, IProductConstract.OnProductDeleteListener {
    private RecyclerView mRecyclerView;
    private ProductAdapter mProductAdapter;
    private ProductPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPresenter = new ProductPresenter(this);
        mPresenter.setView(this);
        mPresenter.loadHotProducts();
    }

    @Override
    public void onProductAdded() {

    }

    @Override
    public void onAddProductError(String errorMessage) {

    }

    @Override
    public void onDeleteProductClicked(Product product) {
        // Gọi phương thức xóa sản phẩm từ Presenter
        mPresenter.deleteProduct(product);
    }

    @Override
    public void setHotProductsToUI(List<Product> productList) {
        mProductAdapter = new ProductAdapter(this, productList, this);
        mRecyclerView.setAdapter(mProductAdapter);
    }

    @Override
    public void setNewProductsToUI(List<Product> productList) {
        // Not needed here, as this example only loads hot products
    }
}
//Test de chen du lieu
//        AppDatabase db = Room.databaseBuilder(this,
//                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
//        List<Product> productList = new ArrayList<>();
//        productList.add(new Product(1, "Product 1", "Description 1", "image1.jpg", 10.99, 100));
//        productList.add(new Product(2, "Product 2", "Description 2", "image2.jpg", 15.49, 80));
//        productList.add(new Product(3, "Product 3", "Description 3", "image3.jpg", 20.99, 120));
//        productList.add(new Product(4, "Product 4", "Description 4", "image4.jpg", 5.99, 150));
//        productList.add(new Product(5, "Product 5", "Description 5", "image5.jpg", 8.99, 90));
//        productList.add(new Product(6, "Product 6", "Description 6", "image6.jpg", 12.99, 110));
//        productList.add(new Product(7, "Product 7", "Description 7", "image7.jpg", 18.49, 70));
//        productList.add(new Product(8, "Product 8", "Description 8", "image8.jpg", 25.99, 130));
//        productList.add(new Product(9, "Product 9", "Description 9", "image9.jpg", 7.49, 95));
//        productList.add(new Product(10, "Product 10", "Description 10", "image10.jpg", 11.99, 85));
//        productList.forEach(x -> db.productDao().insertAll(x));
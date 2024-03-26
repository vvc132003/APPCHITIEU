package org.chinh.appquanlychitieu.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.chinh.appquanlychitieu.R;
import org.chinh.appquanlychitieu.base.BaseFragment;
import org.chinh.appquanlychitieu.data.model.Product;
import org.chinh.appquanlychitieu.ui.adapter.ProductAdapter;
import org.chinh.appquanlychitieu.ui.constract.IProductConstract;
import org.chinh.appquanlychitieu.ui.presenter.ProductPresenter;

import java.util.List;

public class ProductFragment extends BaseFragment implements IProductConstract.IView, IProductConstract.OnProductDeleteListener {
    private IProductConstract.IPresenter mPresenter;
    private RecyclerView rvHotProducts;
    private RecyclerView rvNewProducts;
    private RecyclerView rvCategories;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_product, container, false);
        initGUI(root);
        initData();

        return root;
    }

    private void initGUI(View root) {
        rvHotProducts = root.findViewById(R.id.recycler_view);
        rvHotProducts.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initData() {

        mPresenter = new ProductPresenter(getContext());
        mPresenter.setView(this);

        mPresenter.loadHotProducts();
        mPresenter.loadNewProducts();
    }


    @Override
    public void onProductAdded() {

    }

    @Override
    public void onAddProductError(String errorMessage) {

    }

    @Override
    public void onDeleteProductClicked(Product product) {
        mPresenter.deleteProduct(product);
    }

    @Override
    public void setHotProductsToUI(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(getContext(), productList, this);
        rvHotProducts.setAdapter(adapter);
    }

    @Override
    public void setNewProductsToUI(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(getContext(), productList, this);
        rvNewProducts.setAdapter(adapter);
    }

}

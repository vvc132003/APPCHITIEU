package org.chinh.appquanlychitieu.ui.constract;

import org.chinh.appquanlychitieu.data.model.Product;

import java.util.List;

public interface IProductConstract {
    interface IView {
        void onProductAdded();

        void onAddProductError(String errorMessage);

        void onDeleteProductClicked(Product product);

        void setHotProductsToUI(List<Product> productList);

        void setNewProductsToUI(List<Product> productList);

    }

    interface IPresenter {
        void setView(IView view);

        void loadHotProducts();

        void loadNewProducts();

        void deleteProduct(Product product);
        void addProduct(String name, String description, double price, int quantity);

    }

    interface OnProductDeleteListener {
        void onDeleteProductClicked(Product product);
    }
}
package org.chinh.appquanlychitieu.ui.constract;


import org.chinh.appquanlychitieu.data.model.Product;
import org.chinh.appquanlychitieu.util.Constants;

public interface IDetailConstract {
    interface IView{
        void setProductToUI(Product product);
        void showMessage(Constants.CART_EVENT event, String message);
    }
    interface IPresenter{
        void setView(IView view);
        void loadProduct(int productId);
        void addToCart(int productId, int quantity);
    }
}

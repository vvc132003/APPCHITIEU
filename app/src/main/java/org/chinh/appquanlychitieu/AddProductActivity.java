package org.chinh.appquanlychitieu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.chinh.appquanlychitieu.data.model.Product;
import org.chinh.appquanlychitieu.ui.constract.IProductConstract;
import org.chinh.appquanlychitieu.ui.presenter.ProductPresenter;

import java.util.List;

public class AddProductActivity extends AppCompatActivity implements IProductConstract.IView {
    private EditText editTextProductName, editTextProductDescription, editTextProductPrice, editTextProductQuantity;
    private Button buttonAddProduct;
    private ProductPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_product);

        // Initialize views
        editTextProductName = findViewById(R.id.editTextProductName);
        editTextProductDescription = findViewById(R.id.editTextProductDescription);
        editTextProductPrice = findViewById(R.id.editTextProductPrice);
        editTextProductQuantity = findViewById(R.id.editTextProductQuantity);
        buttonAddProduct = findViewById(R.id.buttonAddProduct);

        // Initialize presenter
        mPresenter = new ProductPresenter( this);

        // Add product button click listener
        buttonAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextProductName.getText().toString();
                String description = editTextProductDescription.getText().toString();
                double price = Double.parseDouble(editTextProductPrice.getText().toString());
                int quantity = Integer.parseInt(editTextProductQuantity.getText().toString());

                mPresenter.addProduct(name, description, price, quantity);
            }
        });
    }

    @Override
    public void onProductAdded() {
        // Product added successfully, do something like showing a toast or navigate back
        Toast.makeText(this, "Product added successfully", Toast.LENGTH_SHORT).show();
        finish(); // Finish the activity
    }

    @Override
    public void onAddProductError(String errorMessage) {
        // Show error message to the user
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteProductClicked(Product product) {

    }

    @Override
    public void setHotProductsToUI(List<Product> productList) {

    }

    @Override
    public void setNewProductsToUI(List<Product> productList) {

    }
}

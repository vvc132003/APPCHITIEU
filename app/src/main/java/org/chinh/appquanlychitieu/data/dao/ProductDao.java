package org.chinh.appquanlychitieu.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import org.chinh.appquanlychitieu.data.model.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM products WHERE Id=:productId LIMIT 1")
    Product find(int productId);
    @Query("SELECT * FROM products")
    List<Product> getAll();

    @Query("SELECT * FROM products")
    List<Product> getHotProducts();

    @Query("SELECT * FROM products")
    List<Product> getNewProducts();

    @Insert
    void insertAll(Product... products);
    @Query("SELECT COUNT(*) FROM products WHERE id = :productId")
    int getProductCountById(int productId);
    @Delete
    void delete(Product product);
}

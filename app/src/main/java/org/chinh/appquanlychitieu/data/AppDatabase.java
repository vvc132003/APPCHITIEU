package org.chinh.appquanlychitieu.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import org.chinh.appquanlychitieu.data.dao.ProductDao;
import org.chinh.appquanlychitieu.data.model.Product;

@Database(entities = {Product.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ProductDao productDao();
}
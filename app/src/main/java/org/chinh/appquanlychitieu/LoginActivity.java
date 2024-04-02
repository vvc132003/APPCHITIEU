package org.chinh.appquanlychitieu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.chinh.appquanlychitieu.data.AppDatabase;
import org.chinh.appquanlychitieu.data.model.NguoiDung;
import org.chinh.appquanlychitieu.ui.fragment.FragmentHome;
import org.chinh.appquanlychitieu.ui.presenter.NguoiDungPresenter;
import org.chinh.appquanlychitieu.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextTaiKhoan;
    private EditText editTextMatKhau;
    private Button loginButton;
    private NguoiDungPresenter nguoiDungPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        nguoiDungPresenter = new NguoiDungPresenter(this);

        editTextTaiKhoan = findViewById(R.id.editTextTaiKhoan);
        editTextMatKhau = findViewById(R.id.editTextMatKhau);
        loginButton = findViewById(R.id.btnSubmit);
//        AppDatabase db = Room.databaseBuilder(this,
//                AppDatabase.class, Constants.DB_NAME).allowMainThreadQueries().build();
//        List<NguoiDung> productList = new ArrayList<>();
//        productList.add(new NguoiDung(1, "Chính", "admin", "12345", "1234"));
//        productList.forEach(x -> db.nguoiDungDao().InsertNguoiDung(x));
        List<NguoiDung> nguoiDungList = nguoiDungPresenter.getAllNguoiDung();
        for (NguoiDung nguoiDung : nguoiDungList) {
            Log.d("NguoiDung", "Id: " + nguoiDung.getId());
            Log.d("NguoiDung", "Ho va ten: " + nguoiDung.getHovaten());
            Log.d("NguoiDung", "Tai khoan: " + nguoiDung.getTaikhoan());
            Log.d("NguoiDung", "Mat khau: " + nguoiDung.getMatkhau());
            Log.d("NguoiDung", "So dien thoai: " + nguoiDung.getSodienthoai());
        }
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextTaiKhoan.getText().toString();
                String password = editTextMatKhau.getText().toString();
                NguoiDung nguoiDung = nguoiDungPresenter.login(username, password);
                if (nguoiDung != null) {
                    if (nguoiDung.getTaikhoan().equals(username) && nguoiDung.getMatkhau().equals(password)) {
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Tên đăng nhập hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
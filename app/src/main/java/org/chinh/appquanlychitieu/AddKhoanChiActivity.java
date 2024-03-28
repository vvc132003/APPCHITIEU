package org.chinh.appquanlychitieu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.ui.adapter.KhoanChiAdapter;
import org.chinh.appquanlychitieu.ui.constract.IKhoanChiConstract;
import org.chinh.appquanlychitieu.ui.constract.IProductConstract;
import org.chinh.appquanlychitieu.ui.fragment.FragmentHome;
import org.chinh.appquanlychitieu.ui.presenter.KhoanChiPresenter;

import java.util.Date;
import java.util.List;

public class AddKhoanChiActivity extends AppCompatActivity implements IKhoanChiConstract.IView {
    private IKhoanChiConstract.IPresenter mPresenter;
    private EditText editTextSoTienChi;
    private EditText editTextTenKhoanChi;
    private EditText editTextMoTa;
    private DatePicker datePickerThoiGianChi;
    private Button buttonAddKhoanChi;
    private RecyclerView rvHotKhoanChi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_khoan_chi);
        editTextSoTienChi = findViewById(R.id.editTextSoTienChi);
        editTextTenKhoanChi = findViewById(R.id.editTextTenKhoanChi);
        editTextMoTa = findViewById(R.id.editTextMoTa);
        datePickerThoiGianChi = findViewById(R.id.datePickerThoiGianChi);
        buttonAddKhoanChi = findViewById(R.id.buttonAddKhoanChi);
        mPresenter = new KhoanChiPresenter(this);
        mPresenter.setView(this);
        buttonAddKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy dữ liệu từ các trường nhập
                double soTienChi = Double.parseDouble(editTextSoTienChi.getText().toString());
                String tenKhoanChi = editTextTenKhoanChi.getText().toString();
                String moTa = editTextMoTa.getText().toString();
                // Lấy ngày tháng năm từ DatePicker
                int day = datePickerThoiGianChi.getDayOfMonth();
                int month = datePickerThoiGianChi.getMonth();
                int year = datePickerThoiGianChi.getYear();
                Date thoigianchi = new Date(year, month, day);
                // Gọi phương thức thêm khoản chi từ Presenter
                mPresenter.AddKhoanChi(soTienChi, tenKhoanChi, moTa, thoigianchi, 1);
            }
        });
        ImageButton imageButton = findViewById(R.id.buttonBack);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentHome();
                FragmentManager fragmentManager = ((FragmentActivity) v.getContext()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public void setKhoanChiToUI(List<KhoanChi> khoanChiList) {
//        KhoanChiAdapter adapter = new KhoanChiAdapter(getContext(), khoanChiList, this);
//        rvHotKhoanChi.setAdapter(adapter);
    }
}
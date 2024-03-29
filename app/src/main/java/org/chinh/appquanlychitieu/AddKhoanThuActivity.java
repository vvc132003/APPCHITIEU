package org.chinh.appquanlychitieu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.data.model.KhoanThu;
import org.chinh.appquanlychitieu.ui.constract.IKhoanChiConstract;
import org.chinh.appquanlychitieu.ui.constract.IKhoanThuConstract;
import org.chinh.appquanlychitieu.ui.fragment.FragmentHome;
import org.chinh.appquanlychitieu.ui.fragment.FragmentKhoanThu;
import org.chinh.appquanlychitieu.ui.presenter.KhoanChiPresenter;
import org.chinh.appquanlychitieu.ui.presenter.KhoanThuPresenter;

import java.util.Date;
import java.util.List;

public class AddKhoanThuActivity extends AppCompatActivity implements IKhoanThuConstract.IView {
    private IKhoanThuConstract.IPresenter mPresenter;
    private EditText editTextSoTienChi;
    private EditText editTextTenKhoanChi;
    private EditText editTextMoTa;
    private DatePicker datePickerThoiGianChi;
    private Button buttonAddKhoanChi;
    private RecyclerView rvHotKhoanChi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_khoan_thu);
        editTextSoTienChi = findViewById(R.id.editTextSoTienChi);
        editTextTenKhoanChi = findViewById(R.id.editTextTenKhoanChi);
        editTextMoTa = findViewById(R.id.editTextMoTa);
        datePickerThoiGianChi = findViewById(R.id.datePickerThoiGianChi);
        buttonAddKhoanChi = findViewById(R.id.buttonAddKhoanThu);
        mPresenter = new KhoanThuPresenter(this);
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
                mPresenter.AddKhoanThu(soTienChi, tenKhoanChi, moTa, new Date(), 1);
                Intent intent = new Intent(AddKhoanThuActivity.this, FragmentKhoanThu.class);
                startActivity(intent);
            }
        });
        ImageButton imageButton = findViewById(R.id.buttonBack);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new FragmentKhoanThu();
                FragmentManager fragmentManager = ((FragmentActivity) v.getContext()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
        });

    }

    @Override
    public void setKhoanThuToUI(List<KhoanThu> khoanThuList) {
//        KhoanChiAdapter adapter = new KhoanChiAdapter(getContext(), khoanChiList, this);
//        rvHotKhoanChi.setAdapter(adapter);
    }
}
package org.chinh.appquanlychitieu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.data.model.KhoanThu;
import org.chinh.appquanlychitieu.ui.constract.IKhoanChiConstract;
import org.chinh.appquanlychitieu.ui.constract.IKhoanThuConstract;
import org.chinh.appquanlychitieu.ui.fragment.FragmentHome;
import org.chinh.appquanlychitieu.ui.fragment.FragmentKhoanThu;
import org.chinh.appquanlychitieu.ui.presenter.KhoanChiPresenter;
import org.chinh.appquanlychitieu.ui.presenter.KhoanThuPresenter;
import org.chinh.appquanlychitieu.util.Constants;

import java.util.List;

public class KhoanThu_updateActivity extends AppCompatActivity implements IKhoanThuConstract.IView {
    private IKhoanThuConstract.IPresenter mPresenter;
    private EditText mEditTextSoTienChi;
    private EditText mEditTextTenKhoanChi;
    private EditText mEditTextMoTa;
    private Button mButtonUpdateKhoanChi;
    private Button mButtonCancel;
    private int mKhoanThuID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoan_thu_update);
        initGUI();
        initData();
    }

    private void initData() {
        mPresenter = new KhoanThuPresenter(this);
        mPresenter.setView(this);
        mKhoanThuID = getIntent().getIntExtra(Constants.khoanThuID, 1);
        mPresenter.loaidkhoanthuBYID(mKhoanThuID);
    }

    private void initGUI() {
        mEditTextSoTienChi = findViewById(R.id.editTextSoTienChi);
        mEditTextTenKhoanChi = findViewById(R.id.editTextTenKhoanChi);
        mEditTextMoTa = findViewById(R.id.editTextMoTa);
        mButtonUpdateKhoanChi = findViewById(R.id.buttonUpdateKhoanThu);
        mButtonCancel = findViewById(R.id.buttonCancel);

        mButtonUpdateKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateKhoanThu();
            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    private void updateKhoanThu() {
        String soTienChi = mEditTextSoTienChi.getText().toString();
        String tenKhoanChi = mEditTextTenKhoanChi.getText().toString();
        String moTa = mEditTextMoTa.getText().toString();

        KhoanThu updatedKhoanThu = new KhoanThu();
        updatedKhoanThu.setId(mKhoanThuID);
        updatedKhoanThu.setSoTienThu(Double.parseDouble(soTienChi));
        updatedKhoanThu.setTenKhoanThu(tenKhoanChi);
        updatedKhoanThu.setMoTa(moTa);

        mPresenter.updateKhoanThu(updatedKhoanThu);
        Intent intent = new Intent(KhoanThu_updateActivity.this, FragmentKhoanThu.class);
        startActivity(intent);
    }

    @Override
    public void setKhoanThuToUI(List<KhoanThu> khoanThuList) {
        if (!khoanThuList.isEmpty()) {
            KhoanThu khoanThu = khoanThuList.get(0); // Assuming you only get one KhoanChi object
            mEditTextSoTienChi.setText(String.valueOf(khoanThu.getSoTienThu()));
            mEditTextTenKhoanChi.setText(khoanThu.getTenKhoanThu());
            mEditTextMoTa.setText(khoanThu.getMoTa());
        }
    }
}

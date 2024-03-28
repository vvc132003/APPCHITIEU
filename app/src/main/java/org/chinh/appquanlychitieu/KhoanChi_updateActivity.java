package org.chinh.appquanlychitieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.ui.constract.IKhoanChiConstract;
import org.chinh.appquanlychitieu.ui.fragment.FragmentHome;
import org.chinh.appquanlychitieu.ui.presenter.KhoanChiPresenter;
import org.chinh.appquanlychitieu.util.Constants;

import java.util.List;

public class KhoanChi_updateActivity extends AppCompatActivity implements IKhoanChiConstract.IView {
    private IKhoanChiConstract.IPresenter mPresenter;
    private EditText mEditTextSoTienChi;
    private EditText mEditTextTenKhoanChi;
    private EditText mEditTextMoTa;
    private Button mButtonUpdateKhoanChi;
    private Button mButtonCancel;
    private int mKhoanChiID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoan_chi_update);
        initGUI();
        initData();
    }

    private void initData() {
        mPresenter = new KhoanChiPresenter(this);
        mPresenter.setView(this);
        mKhoanChiID = getIntent().getIntExtra(Constants.khoanChiID, 1);
        mPresenter.loaidkhoanchiBYID(mKhoanChiID);
    }

    private void initGUI() {
        mEditTextSoTienChi = findViewById(R.id.editTextSoTienChi);
        mEditTextTenKhoanChi = findViewById(R.id.editTextTenKhoanChi);
        mEditTextMoTa = findViewById(R.id.editTextMoTa);
        mButtonUpdateKhoanChi = findViewById(R.id.buttonUpdateKhoanChi);
        mButtonCancel = findViewById(R.id.buttonCancel);

        mButtonUpdateKhoanChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateKhoanChi();
            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    private void updateKhoanChi() {
        String soTienChi = mEditTextSoTienChi.getText().toString();
        String tenKhoanChi = mEditTextTenKhoanChi.getText().toString();
        String moTa = mEditTextMoTa.getText().toString();

        KhoanChi updatedKhoanChi = new KhoanChi();
        updatedKhoanChi.setId(mKhoanChiID);
        updatedKhoanChi.setSoTienChi(Double.parseDouble(soTienChi));
        updatedKhoanChi.setTenKhoanChi(tenKhoanChi);
        updatedKhoanChi.setMoTa(moTa);

        mPresenter.updateKhoanChi(updatedKhoanChi);
        Intent intent = new Intent(KhoanChi_updateActivity.this, FragmentHome.class);
        startActivity(intent);
    }

    @Override
    public void setKhoanChiToUI(List<KhoanChi> khoanChiList) {
        if (!khoanChiList.isEmpty()) {
            KhoanChi khoanChi = khoanChiList.get(0); // Assuming you only get one KhoanChi object
            mEditTextSoTienChi.setText(String.valueOf(khoanChi.getSoTienChi()));
            mEditTextTenKhoanChi.setText(khoanChi.getTenKhoanChi());
            mEditTextMoTa.setText(khoanChi.getMoTa());
        }
    }
}

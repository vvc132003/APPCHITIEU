package org.chinh.appquanlychitieu.ui.fragment;

import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import org.chinh.appquanlychitieu.R;
import org.chinh.appquanlychitieu.base.BaseFragment;
import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.data.model.KhoanThu;
import org.chinh.appquanlychitieu.ui.constract.IKhoanChiConstract;
import org.chinh.appquanlychitieu.ui.constract.IKhoanThuConstract;
import org.chinh.appquanlychitieu.ui.presenter.KhoanChiPresenter;
import org.chinh.appquanlychitieu.ui.presenter.KhoanThuPresenter;

import java.util.List;
import java.util.Locale;

public class FragmentThongKe extends BaseFragment implements IKhoanThuConstract.IView, IKhoanChiConstract.IView {
    private IKhoanThuConstract.IPresenter mPresenterThu;
    private IKhoanChiConstract.IPresenter mPresenterChi;
    private RecyclerView recyclerView;
    private TextView textViewsotienchi;
    private TextView textViewsotienthu;
    private TextView textViewsotienconlai;
    private double totalSoTienThu=0,totalSoTienChi=0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenterChi = new KhoanChiPresenter(getContext());
        mPresenterChi.setView(this);

        mPresenterThu = new KhoanThuPresenter(getContext());
        mPresenterThu.setView(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.thongke, container, false);

        textViewsotienchi = root.findViewById(R.id.textViewsotienchi);
        textViewsotienthu = root.findViewById(R.id.textViewsotienthu);
        textViewsotienconlai = root.findViewById(R.id.textViewsotienconlai);
        mPresenterThu.loadKhoanThu();
        mPresenterChi.loadKhoanChi();
        return root;
    }

    private String formatCurrency(double amount) {
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnamLocale);
        return currencyFormatter.format(amount);
    }

    @Override
    public void setKhoanThuToUI(List<KhoanThu> khoanThuList) {
        for (KhoanThu khoanThu : khoanThuList) {
            totalSoTienThu += khoanThu.getSoTienThu();
        }
        textViewsotienthu.setText(" + " + formatCurrency(totalSoTienThu));
        textViewsotienthu.setTextColor(Color.parseColor("#007a33"));
    }

    @Override
    public void setKhoanChiToUI(List<KhoanChi> khoanChiList) {
        for (KhoanChi khoanChi : khoanChiList) {
            totalSoTienChi += khoanChi.getSoTienChi();
        }
        textViewsotienchi.setText(" - " + formatCurrency(totalSoTienChi));
        textViewsotienchi.setTextColor(Color.parseColor("#FF5722"));


        double tienconlai = totalSoTienThu - totalSoTienChi;
        textViewsotienconlai.setText(" " + formatCurrency(tienconlai));
    }


}

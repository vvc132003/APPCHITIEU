package org.chinh.appquanlychitieu.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.chinh.appquanlychitieu.AddKhoanChiActivity;
import org.chinh.appquanlychitieu.AddKhoanThuActivity;
import org.chinh.appquanlychitieu.R;
import org.chinh.appquanlychitieu.base.BaseFragment;
import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.data.model.KhoanThu;
import org.chinh.appquanlychitieu.ui.adapter.KhoanChiAdapter;
import org.chinh.appquanlychitieu.ui.adapter.KhoanThuAdapter;
import org.chinh.appquanlychitieu.ui.constract.IKhoanChiConstract;
import org.chinh.appquanlychitieu.ui.constract.IKhoanThuConstract;
import org.chinh.appquanlychitieu.ui.presenter.KhoanChiPresenter;
import org.chinh.appquanlychitieu.ui.presenter.KhoanThuPresenter;

import java.util.List;


public class FragmentKhoanThu extends BaseFragment implements IKhoanThuConstract.IView, IKhoanThuConstract.OnKhoanThuDeleteListener{
    private IKhoanThuConstract.IPresenter mPresenter;
    private RecyclerView rvHotKhoanThu;
    private RecyclerView rvNewProducts;
    private RecyclerView rvCategories;
    private List<KhoanThu> khoanThuList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_khoanthu, container, false);
        initGUI(root);
        initData();
        mPresenter = new KhoanThuPresenter(getContext());
        mPresenter.setView(this);
        ImageView addButton = root.findViewById(R.id.image_add_KhoanThu);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddKhoanThuActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }


    private void initGUI(View root) {
        rvHotKhoanThu = root.findViewById(R.id.recycler_view);
        rvHotKhoanThu.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initData() {
        mPresenter = new KhoanThuPresenter(getContext());
        mPresenter.setView(this);
        mPresenter.loadKhoanThu();
    }

    @Override
    public void setKhoanThuToUI(List<KhoanThu> khoanThuList) {
        KhoanThuAdapter adapter = new KhoanThuAdapter(getContext(),khoanThuList,this);
        rvHotKhoanThu.setAdapter(adapter);
    }

    @Override
    public void onDeleteKhoanThuClicked(KhoanThu khoanThu) {
        mPresenter.deleteKhoanThu(khoanThu);
    }
}
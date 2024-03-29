package org.chinh.appquanlychitieu.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import org.chinh.appquanlychitieu.AddKhoanChiActivity;
import org.chinh.appquanlychitieu.R;
import org.chinh.appquanlychitieu.base.BaseFragment;
import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.ui.adapter.KhoanChiAdapter;
import org.chinh.appquanlychitieu.ui.constract.IKhoanChiConstract;
import org.chinh.appquanlychitieu.ui.presenter.KhoanChiPresenter;

import java.util.List;


public class FragmentHome extends BaseFragment implements IKhoanChiConstract.IView, IKhoanChiConstract.OnKhoanChiDeleteListener{
    private IKhoanChiConstract.IPresenter mPresenter;
    private RecyclerView rvHotKhoanChi;
    private RecyclerView rvNewProducts;
    private RecyclerView rvCategories;
    private List<KhoanChi> khoanChiList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        initGUI(root);
        initData();
        mPresenter = new KhoanChiPresenter(getContext());
        mPresenter.setView(this);
        ImageView addButton = root.findViewById(R.id.image_add_product);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddKhoanChiActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }


    private void initGUI(View root) {
        rvHotKhoanChi = root.findViewById(R.id.recycler_view);
        rvHotKhoanChi.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initData() {
        mPresenter = new KhoanChiPresenter(getContext());
        mPresenter.setView(this);
        mPresenter.loadKhoanChi();
    }

    @Override
    public void onDeleteKhoanChiClicked(KhoanChi khoanChi) {
        mPresenter.deleteKhoanchi(khoanChi);
    }

    @Override
    public void setKhoanChiToUI(List<KhoanChi> khoanChiList) {
        KhoanChiAdapter adapter = new KhoanChiAdapter(getContext(), khoanChiList, this);
        rvHotKhoanChi.setAdapter(adapter);
    }


}
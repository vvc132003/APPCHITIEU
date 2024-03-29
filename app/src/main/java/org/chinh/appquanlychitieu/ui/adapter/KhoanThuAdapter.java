package org.chinh.appquanlychitieu.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.icu.text.NumberFormat;
import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.chinh.appquanlychitieu.KhoanChi_updateActivity;
import org.chinh.appquanlychitieu.KhoanThu_updateActivity;
import org.chinh.appquanlychitieu.R;
import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.data.model.KhoanThu;
import org.chinh.appquanlychitieu.ui.constract.IKhoanChiConstract;
import org.chinh.appquanlychitieu.ui.constract.IKhoanThuConstract;
import org.chinh.appquanlychitieu.util.Constants;

import java.util.Date;
import java.util.List;
import java.util.Locale;

public class KhoanThuAdapter extends RecyclerView.Adapter<KhoanThuAdapter.ViewHolder> {
    private Context mContext;
    private List<KhoanThu> khoanThuList;
    private IKhoanThuConstract.OnKhoanThuDeleteListener mListener;


    public KhoanThuAdapter(Context mContext, List<KhoanThu> khoanThuList, IKhoanThuConstract.OnKhoanThuDeleteListener mListener) {
        this.mContext = mContext;
        this.khoanThuList = khoanThuList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_khoanthu, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);

        return viewHolder;
    }

    private String formatCurrency(double amount) {
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnamLocale);
        if (amount >= 0) {
            return "+" + currencyFormatter.format(amount);
        } else {
            return currencyFormatter.format(amount);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KhoanThu khoanThu = khoanThuList.get(position);
        holder.text_sotienthu.setText(formatCurrency(khoanThu.getSoTienThu()));
        holder.text_tenkhoanthu.setText(khoanThu.getTenKhoanThu());
        Date thoigianchiDate = khoanThu.getThoiGianThu();
        if (thoigianchiDate != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String thoigianchiString = dateFormat.format(thoigianchiDate);
            holder.text_thoigianthu.setText(thoigianchiString);
        } else {
            holder.text_thoigianthu.setText("");
        }
        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDeleteKhoanThuClicked(khoanThu);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, KhoanThu_updateActivity.class);
                intent.putExtra(Constants.khoanThuID, khoanThu.getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return khoanThuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_sotienthu;
        private TextView text_tenkhoanthu;
        private ImageView buttonDelete;
        private TextView text_thoigianthu;
        private Button buttonAddKhoanChi;


        public ViewHolder(View heroView) {
            super(heroView);
            text_sotienthu = heroView.findViewById(R.id.text_sotienthu);
            text_tenkhoanthu = heroView.findViewById(R.id.text_tenkhoanthu);
            text_thoigianthu = heroView.findViewById(R.id.text_thoigianthu);

            buttonDelete = heroView.findViewById(R.id.button_delete); // Khởi tạo buttonDelete
            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        // Lấy sản phẩm tại vị trí được nhấn
                        KhoanThu khoanThudekete = khoanThuList.get(pos);
                        // Gọi phương thức để xử lý xóa sản phẩm
                        mListener.onDeleteKhoanThuClicked(khoanThudekete);
                    }
                }
            });
        }
    }
}

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
import org.chinh.appquanlychitieu.R;
import org.chinh.appquanlychitieu.data.model.KhoanChi;
import org.chinh.appquanlychitieu.ui.constract.IKhoanChiConstract;
import org.chinh.appquanlychitieu.util.Constants;

import java.util.Date;
import java.util.List;
import java.util.Locale;

public class KhoanChiAdapter extends RecyclerView.Adapter<KhoanChiAdapter.ViewHolder> {
    private Context mContext;
    private List<KhoanChi> khoanChiList;
    private IKhoanChiConstract.OnKhoanChiDeleteListener mListener;

    public KhoanChiAdapter(Context mContext, List<KhoanChi> khoanChiList, IKhoanChiConstract.OnKhoanChiDeleteListener mListener) {
        this.mContext = mContext;
        this.khoanChiList = khoanChiList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_khoanchi, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);

        return viewHolder;
    }

    private String formatCurrency(double amount) {
        Locale vietnamLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(vietnamLocale);
        if (amount >= 0) {
            return "-" + currencyFormatter.format(amount);
        } else {
            return currencyFormatter.format(amount);
        }    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        KhoanChi khoanChi = khoanChiList.get(position);
        holder.mTextsotienchi.setText(formatCurrency(khoanChi.getSoTienChi()));
        holder.mTextTenkhoanchi.setText(khoanChi.getTenKhoanChi());
        Date thoigianchiDate = khoanChi.getThoigianchi();
        if (thoigianchiDate != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String thoigianchiString = dateFormat.format(thoigianchiDate);
            holder.mTextThoiGianChi.setText(thoigianchiString);
        } else {
            holder.mTextThoiGianChi.setText("");
        }
        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDeleteKhoanChiClicked(khoanChi);
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, KhoanChi_updateActivity.class);
                intent.putExtra(Constants.khoanChiID, khoanChi.getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return khoanChiList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextsotienchi;
        private TextView mTextTenkhoanchi;
        private ImageView buttonDelete;
        private TextView mTextThoiGianChi;
        private Button buttonAddKhoanChi;


        public ViewHolder(View heroView) {
            super(heroView);
            mTextsotienchi = heroView.findViewById(R.id.text_sotienchi);
            mTextTenkhoanchi = heroView.findViewById(R.id.text_tenkhoanchi);
            mTextThoiGianChi = heroView.findViewById(R.id.text_thoigianchi);

            buttonDelete = heroView.findViewById(R.id.button_delete); // Khởi tạo buttonDelete
            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        // Lấy sản phẩm tại vị trí được nhấn
                        KhoanChi khoanChidelete = khoanChiList.get(pos);
                        // Gọi phương thức để xử lý xóa sản phẩm
                        mListener.onDeleteKhoanChiClicked(khoanChidelete);
                    }
                }
            });
        }
    }
}

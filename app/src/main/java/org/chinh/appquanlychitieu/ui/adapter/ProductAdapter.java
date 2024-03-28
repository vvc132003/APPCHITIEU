package org.chinh.appquanlychitieu.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import org.chinh.appquanlychitieu.DetailActivity;
import org.chinh.appquanlychitieu.R;
import org.chinh.appquanlychitieu.data.model.Product;
import org.chinh.appquanlychitieu.ui.constract.IProductConstract;
import org.chinh.appquanlychitieu.util.Constants;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
    private Context mContext;
    private List<Product> mProductList;
    private IProductConstract.OnProductDeleteListener mListener;

    public ProductAdapter(Context context, List<Product> productList, IProductConstract.OnProductDeleteListener listener) {
        this.mContext = context;
        this.mProductList = productList;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.item_product, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = mProductList.get(position);
        holder.mTextName.setText(product.getName());
        holder.mTextPricer.setText(String.valueOf(product.getPrice()));
        // Xử lý sự kiện khi người dùng nhấn vào nút xóa
        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onDeleteProductClicked(product);
            }
        });
    }

//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Product product = mProductList.get(position);
//        holder.mTextName.setText(product.name);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //KHoi dong Activty DetailActivity
//                Intent intent = new Intent(mContext, DetailActivity.class);
//                intent.putExtra(Constants.PRODUCT_ID, product.id);
//
//                mContext.startActivity(intent);
//            }
//        });
//    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageHero;
        private TextView mTextName;
        private TextView mTextPricer;
        private ImageView buttonDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextName = itemView.findViewById(R.id.text_product_name);
            mTextPricer = itemView.findViewById(R.id.text_product_price);

            buttonDelete = itemView.findViewById(R.id.button_delete); // Đặt id của nút xóa
            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lấy vị trí của mục trong danh sách
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        // Lấy sản phẩm tại vị trí được nhấn
                        Product productToDelete = mProductList.get(position);
                        // Gọi phương thức để xử lý xóa sản phẩm
                        mListener.onDeleteProductClicked(productToDelete);
                    }
                }
            });
        }
    }
}

package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.entity.ShopBean;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.VH> {
    private Context context;
    private List<ShopBean.ResultBean.RxxpBean.CommodityListBean> listBeans;

    public ShopAdapter(Context context, List<ShopBean.ResultBean.RxxpBean.CommodityListBean> listBeans) {
        this.context = context;
        this.listBeans = listBeans;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.rxxp, null);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(context).load(listBeans.get(position).getMasterPic()).into(holder.rxxp_img);
        holder.rxxp_name.setText(listBeans.get(position).getCommodityName());
    }

    @Override
    public int getItemCount() {
        return listBeans.size();
    }

    class VH extends RecyclerView.ViewHolder {

        private final ImageView rxxp_img;
        private final TextView rxxp_name;

        public VH(@NonNull View itemView) {
            super(itemView);
            rxxp_img = itemView.findViewById(R.id.rxxp_img);
            rxxp_name = itemView.findViewById(R.id.rxxp_name);
        }
    }
}

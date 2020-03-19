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
import com.example.myapplication.entity.DingdanBean;

import java.util.List;

public class DingdanAdapter extends RecyclerView.Adapter<DingdanAdapter.VH> {
    private Context context;
    private List<DingdanBean.ResultBean.MlssBean.CommodityListBeanXX> list;

    public DingdanAdapter(Context context, List<DingdanBean.ResultBean.MlssBean.CommodityListBeanXX> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.dingdan, null);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Glide.with(context).load(list.get(position).getMasterPic()).into(holder.img);
        holder.name.setText(list.get(position).getCommodityName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class VH extends RecyclerView.ViewHolder {

        private final TextView name;
        private final ImageView img;

        public VH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);
        }
    }
}

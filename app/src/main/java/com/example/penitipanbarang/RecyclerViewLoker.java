package com.example.penitipanbarang;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.penitipanbarang.model.Item_1;

import java.util.List;

public class RecyclerViewLoker extends RecyclerView.Adapter<RecyclerViewLoker.ViewHolder> {
    private final List<Item_1> item_1s;
    private ListernerClick listernerClick;


    public void setListernerClick(ListernerClick listernerClick) {
        this.listernerClick = listernerClick;
    }

    public RecyclerViewLoker(List<Item_1> item_1s) {
        this.item_1s = item_1s;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_barang, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Item_1 item1 = item_1s.get(position);
        holder.tvNamaBarang.setText(item1.getNamaBarang());
        holder.tvKategori.setText(item1.getCategory().getCategoryName());
        holder.tvNamaPemilik.setText(item1.getNamaCustomer());
        holder.tvPenitipan.setText(item1.getTglPenitipan());
        holder.tvPengambilan.setText(item1.getTglPengambilan());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listernerClick != null){
                    listernerClick.onClick(position, item1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.item_1s.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaBarang;
        TextView tvKategori;
        TextView tvNamaPemilik;
        TextView tvPenitipan;
        TextView tvPengambilan;
        ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaBarang = itemView.findViewById(R.id.tvNamaBarang);
            tvKategori = itemView.findViewById(R.id.tvKategori);
            tvNamaPemilik = itemView.findViewById(R.id.tvNamaPemilik);
            tvPenitipan = itemView.findViewById(R.id.tvPenitipan);
            tvPengambilan = itemView.findViewById(R.id.tvPengambilan);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }
    public interface ListernerClick {
        void onClick (int position, Item_1 item1);
    }
}

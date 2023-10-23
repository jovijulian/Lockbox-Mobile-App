package com.example.penitipanbarang;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.penitipanbarang.model.Item;
import com.example.penitipanbarang.model.Item_1;

import java.util.List;

public class RecyclerViewSearch extends RecyclerView.Adapter<RecyclerViewSearch.ViewHolder> {
    private final List<Item_1> item_1s;
    private ListernerClick listernerClick;


    public void setListernerClick(ListernerClick listernerClick) {
        this.listernerClick = listernerClick;
    }

    public RecyclerViewSearch(List<Item_1> item_1s) {
        this.item_1s = item_1s;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Item_1 item = item_1s.get(position);
        holder.edNamaBrg.setText(item.getNamaBarang());
        holder.edDesc.setText(item.getDeskripsiBarang());
        holder.edKondisi1.setText(item.getKondisi());
        holder.edTglNitip.setText(item.getTglPenitipan());
        holder.edTglAmbil.setText(item.getTglPengambilan());
        holder.edNama.setText(item.getNamaCustomer());
        holder.edKategori.setText(item.getCategory().getCategoryName());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listernerClick != null){
                    listernerClick.onClick(position, item);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.item_1s.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView edNamaBrg;
        TextView edDesc;
        TextView edKondisi1;
        TextView edTglNitip;
        TextView edTglAmbil;
        TextView edNama;
        TextView edKategori;
        ConstraintLayout constraintLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            edNamaBrg = itemView.findViewById(R.id.edNamaBrg);
            edDesc = itemView.findViewById(R.id.edDesc);
            edKondisi1 = itemView.findViewById(R.id.edKondisi1);
            edTglNitip = itemView.findViewById(R.id.edTglNitip);
            edTglAmbil = itemView.findViewById(R.id.edTglAmbil);
            edNama = itemView.findViewById(R.id.edNama);
            edKategori = itemView.findViewById(R.id.edKategori);
            constraintLayout = itemView.findViewById(R.id.clSearch);
        }
    }
    public interface ListernerClick {
        void onClick (int position, Item_1 item1);
    }
}

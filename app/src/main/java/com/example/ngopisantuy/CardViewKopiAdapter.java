package com.example.ngopisantuy;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewKopiAdapter extends RecyclerView.Adapter<CardViewKopiAdapter.CardViewViewHolder>{
    private ArrayList<Kopi> listKopi;

    public CardViewKopiAdapter(ArrayList<Kopi> list){
        this.listKopi = list;
    }


    @NonNull
    @Override
    public CardViewKopiAdapter.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kopi, parent, false);

        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewKopiAdapter.CardViewViewHolder holder, final int position) {
        final Kopi kopi = listKopi.get(position);

        Glide.with(holder.itemView.getContext())
                .load(kopi.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        Log.d("APP", kopi.getDetail());

        holder.tvDetail.setText(kopi.getDetail());
        holder.tvName.setText(kopi.getName());

        holder.btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Kopi kopi = listKopi.get(position);

                Intent intent = new Intent(view.getContext(), KopiDetail.class);
                intent.putExtra("kopi",kopi);
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listKopi.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        Button btnLihat;



        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnLihat = itemView.findViewById(R.id.btn_Lihat);

        }
    }
}

package com.example.animal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AnimalAdapterView extends RecyclerView.Adapter<AnimalAdapterView.MyHolder> {

    Context mContext;
    ArrayList<AnimalType> listRecycV;

    public AnimalAdapterView(Context mContext, ArrayList<AnimalType> listRecycV) {
        this.mContext = mContext;
        this.listRecycV = listRecycV;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.icon_layout,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.imageIcon.setImageBitmap(listRecycV.get(position).getIcon());
        holder.titleIcon.setText(listRecycV.get(position).getTitle());
        /**
         * hiển thị position của adapterview trong title của icon
         * holder.titleIcon.setText(listRecycV.get(position).getTitle()+" "+position);
         * */
    }

    @Override
    public int getItemCount() {
        return listRecycV.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView titleIcon;
        ImageView imageIcon;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            titleIcon = itemView.findViewById(R.id.tvcard);
            imageIcon = itemView.findViewById(R.id.ivcard);
        }
    }
}

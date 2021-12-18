package com.example.animal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class AnimalAdapterView extends RecyclerView.Adapter<AnimalAdapterView.MyHolder> {

    private Context mContext;
    private ArrayList<AnimalType> listRecycV;


    public AnimalAdapterView(Context mContext, ArrayList<AnimalType> listRecycV) {
        this.mContext = mContext;
        this.listRecycV = listRecycV;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.icon_layout, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.imageIcon.setImageBitmap(listRecycV.get(position).getIcon());
        holder.titleIcon.setText(listRecycV.get(position).getTitle());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "item " + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
                // taọ hiệu ứng mờ trên card khi click
                holder.card.setAlpha((float) 0.5);
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                FrgMH002 frg2 = new FrgMH002(holder.getAdapterPosition(),listRecycV);
                activity.getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.alpha,R.anim.alpha).replace(R.id.ln_main,frg2,null).commit();

            }
        });
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
        CardView card;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            titleIcon = itemView.findViewById(R.id.tvcard);
            imageIcon = itemView.findViewById(R.id.ivcard);
            card = itemView.findViewById(R.id.icon);
        }
    }
}

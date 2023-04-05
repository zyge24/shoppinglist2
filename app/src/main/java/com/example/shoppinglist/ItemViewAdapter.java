package com.example.shoppinglist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemViewAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private Context context;
    private ArrayList<Item> items = new ArrayList<>();

    public ItemViewAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }
    public void onBindViewHolder(ItemViewHolder holder, int position){
        holder.name.setText(items.get(position).getName());
        holder.note.setText(items.get(position).getNote());
        holder.editName.setText(items.get(position).getName());
        holder.editNote.setText(items.get(position).getNote());
        holder.delete.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            Storage.getInstance().deleteItem(items.get(pos));
            notifyItemRemoved(pos);
        });
        holder.edit.setOnClickListener(view ->{
            int pos = holder.getAdapterPosition();
            if(holder.editItem.getVisibility() == View.VISIBLE){
                Item item = Storage.getInstance().getItems().get(pos);
                item.setName(holder.editName.getText().toString());
                item.setNote(holder.editNote.getText().toString());
                holder.editItem.setVisibility(View.GONE);
                notifyDataSetChanged();
            }else {
                holder.editItem.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

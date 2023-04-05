package com.example.shoppinglist;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    TextView name, note;

    EditText editName, editNote;
    ImageView delete, edit;

    LinearLayout editItem;

    public ItemViewHolder(View itemView){
        super(itemView);
        name = itemView.findViewById(R.id.txtItemName);
        note = itemView.findViewById(R.id.txtItemNote);
        delete = itemView.findViewById(R.id.ivDelete);
        edit = itemView.findViewById(R.id.ivEdit);
        editName = itemView.findViewById(R.id.txtEditName);
        editNote = itemView.findViewById(R.id.txtEditNote);
        editItem = itemView.findViewById(R.id.editItem);
    }
}

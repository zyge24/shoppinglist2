package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {
    private EditText name, note;
    private Storage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        name = findViewById(R.id.txtAddItem);
        note = findViewById(R.id.txtAddNote);
        storage = Storage.getInstance();
    }

    public void addItem(View view) {
        storage.addItem(new Item(name.getText().toString(), note.getText().toString()));
        MainActivity.reload(getApplicationContext());
    }
}
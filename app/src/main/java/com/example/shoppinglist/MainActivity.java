package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class MainActivity extends AppCompatActivity {

    private Storage storage;
    private static RecyclerView recyclerView;
    private static ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        storage = Storage.getInstance();
        items = storage.getItems();
        recyclerView = findViewById(R.id.rvShoppingList);
        recyclerView.setLayoutManager(new LinearLayoutManager((this)));
        recyclerView.setAdapter(new ItemViewAdapter(getApplicationContext(), items));

    }
    public void switchToAddItem(View view){
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);
    }

    public static void reload(Context context){
        recyclerView.setAdapter(new ItemViewAdapter(context, items));
    }

    public void alphabeticalOrder(View view){
        Collections.sort(items, storage.nameComparator);
        reload(getApplicationContext());
    }

    public void timeOrder(View view){
        Collections.sort(items, Comparator.comparingLong(Item::getTimestamp));
        reload(getApplicationContext());
    }
}
package com.example.recycleview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final List<String> list = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private FloatingActionButton btnFloating ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0;i<50;i++){
            list.add("Word "+i);
        }
        mRecyclerView = findViewById(R.id.recycleView1);
        btnFloating = findViewById(R.id.btnFloating);
        mAdapter = new WordListAdapter(list,this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnFloating.setOnClickListener(view->{
            fabClick(view);
        });



    }

    public void fabClick(View view) {
        int wordListSize = list.size();
        // Add a new word to the wordList.
        list.add("Word " + wordListSize);
        Toast.makeText(this, "You add word "+wordListSize, Toast.LENGTH_SHORT).show();
        // Notify the adapter that the data has changed.
        mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
        // Scroll to the bottom.
        mRecyclerView.smoothScrollToPosition(wordListSize);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.action1:
                Toast.makeText(getApplicationContext(), "ACTION1", Toast.LENGTH_SHORT).show();
                for(int i=0;i<list.size();i++){
                    list.remove(i);
                }
                mAdapter.notifyDataSetChanged();
                return true ;
            case R.id.action2:
                Uri tel = Uri.parse("tel:0346311358");
                Intent i = new Intent(Intent.ACTION_DIAL, tel);
                Toast.makeText(getApplicationContext(), "ACTION2", Toast.LENGTH_SHORT).show();
                startActivity(i);
                return true ;
            case R.id.action3:
                Toast.makeText(getApplicationContext(), "ACTION3", Toast.LENGTH_SHORT).show();
                return true ;
            case R.id.action4:
                Toast.makeText(getApplicationContext(), "ACTION4", Toast.LENGTH_SHORT).show();
                return true ;
            case R.id.action5:
                Toast.makeText(getApplicationContext(), "ACTION5", Toast.LENGTH_SHORT).show();
                return true ;
            default:

        }
        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,   Toast.LENGTH_SHORT).show();
    }
}

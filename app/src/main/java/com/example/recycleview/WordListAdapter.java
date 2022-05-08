package com.example.recycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    List<String> list;
    Context context;

    public WordListAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WordViewHolder(LayoutInflater.from(context).inflate(R.layout.items,parent,false),this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {

        holder.wordItemView.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class WordViewHolder extends RecyclerView.ViewHolder{
        public TextView wordItemView;
        WordListAdapter mAdapter;
        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(view->{

                    int pos = getLayoutPosition();
                    String mes = list.get(pos);
                    list.set(pos,"CLicked "+ mes);
                    mAdapter.notifyDataSetChanged();
            });
        }
    }
}

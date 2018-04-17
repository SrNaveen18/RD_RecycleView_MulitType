package com.example.naveen.recycviewprt.ui.hidingtoolbar.business;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.naveen.recycviewprt.R;
import com.example.naveen.recycviewprt.ui.hidingtoolbar.HidingToolBarActivity;

import java.util.List;

public class HidingToolbarAdapter extends RecyclerView.Adapter<HidingToolbarViewHolder> {

    private HidingToolBarActivity hidingToolBarActivity;
    private List<String> list;

    public HidingToolbarAdapter(HidingToolBarActivity hidingToolBarActivity, List<String> list) {
        this.hidingToolBarActivity = hidingToolBarActivity;
        this.list = list;
    }

    @Override
    public HidingToolbarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_hiding_toolbar, parent, false);
        return new HidingToolbarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HidingToolbarViewHolder holder, int position) {
        Glide.with(hidingToolBarActivity).load(list.get(position)).centerCrop().into(holder.imgView);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

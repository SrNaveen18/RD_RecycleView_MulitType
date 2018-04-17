package com.example.naveen.recycviewprt.ui.hidingtoolbar.business;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.naveen.recycviewprt.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HidingToolbarViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.imgView)
    ImageView imgView;

    public HidingToolbarViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}

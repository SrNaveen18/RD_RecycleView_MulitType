package com.example.naveen.recycviewprt.ui.home.business;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.naveen.recycviewprt.R;

public class RecycViewHolder extends RecyclerView.ViewHolder {
    public TextView txtName;
    public ImageView imgShared;
    public CardView adaCardRoot;


    public RecycViewHolder(View view) {
        super(view);
        txtName = (TextView) view.findViewById(R.id.txtName);
        imgShared = (ImageView) view.findViewById(R.id.imgShared);
        adaCardRoot = (CardView) view.findViewById(R.id.ada_card_root);
    }
}

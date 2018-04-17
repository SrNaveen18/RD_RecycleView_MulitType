package com.example.naveen.recycviewprt.multimediarecycler.business;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.naveen.recycviewprt.R;
import com.example.naveen.recycviewprt.model.SampleList;
import com.example.naveen.recycviewprt.multimediarecycler.MultiMediaRecycler;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ImageTypeViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imageView)
    ImageView imageView;

    public ImageTypeViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void onBind(int position, SampleList.Data recycleLists, MultiMediaRecycler multiMediaRecycler) {
        Glide.with(multiMediaRecycler).load(recycleLists.Url).centerCrop().into(imageView);
    }
}

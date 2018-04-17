package com.example.naveen.recycviewprt.multimediarecycler.business;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.naveen.recycviewprt.R;

public class MultiMediaViewHolder extends RecyclerView.ViewHolder {
    TextView txtTitle;
    public MultiMediaViewHolder(View itemView) {
        super(itemView);
        txtTitle=(TextView)itemView.findViewById(R.id.txtTitle);
    }
}

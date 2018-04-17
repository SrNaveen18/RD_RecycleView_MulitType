package com.example.naveen.recycviewprt.ui.home.business;


import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bumptech.glide.Glide;
import com.example.naveen.recycviewprt.R;
import com.example.naveen.recycviewprt.ui.home.HomeFragment;

import java.util.List;

public class RecycAdapter extends RecyclerView.Adapter<RecycViewHolder> {
    private FragmentActivity fragmentActivity;
    private List<String> list;
    private View.OnClickListener listener;
    private int lastPosition = -1;

    public RecycAdapter(FragmentActivity fragmentActivity, List<String> list, View.OnClickListener listener) {
        this.fragmentActivity = fragmentActivity;
        this.list = list;
        this.listener = listener;
    }

    @Override
    public RecycViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        return new RecycViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycViewHolder holder, int position) {
        ViewCompat.setTransitionName(holder.imgShared, String.valueOf(position) + "_IMG");

        holder.txtName.setText("IMAGE" + String.valueOf(position));
        holder.imgShared.setOnClickListener(listener);
        holder.imgShared.setTag(R.id.imgShared, holder);

        Glide.with(fragmentActivity).load(list.get(position)).centerCrop().into(holder.imgShared);


/*        RecyclerView item animation  */


//        if (position > lastPosition) {
//            Animation animation = AnimationUtils.loadAnimation(fragmentActivity,
//                    R.anim.recyclerview_up);
//            holder.itemView.startAnimation(animation);
//            lastPosition = position;
//        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}

package com.example.naveen.recycviewprt.recyclermethods;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class PaddingItemDecortion extends RecyclerView.ItemDecoration {

    private int size;

    public PaddingItemDecortion(int size) {
        this.size = size;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) == 0) {
            outRect.left += size;
        }
    }
}

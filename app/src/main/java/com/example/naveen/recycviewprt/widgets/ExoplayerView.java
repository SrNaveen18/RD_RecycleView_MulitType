package com.example.naveen.recycviewprt.widgets;


import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.example.naveen.recycviewprt.R;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;

public class ExoplayerView extends FrameLayout {

    private SimpleExoPlayerView simpleExoPlayerView;

    public ExoplayerView(Context context) {
        super(context);
        initialize(context);
    }

    private void initialize(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.addView(layoutInflater.inflate(R.layout.exo_player_view,null));
        this.simpleExoPlayerView= this.findViewById(R.id.customExoPlayer);

    }
}

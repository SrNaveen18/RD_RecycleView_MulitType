package com.example.naveen.recycviewprt.multimediarecycler.youtube;

import android.os.Bundle;

import com.example.naveen.recycviewprt.helper.BundleKeys;
import com.example.naveen.recycviewprt.helper.YoutubeConfig;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubeThumbnailLoader;

public class RecyYoutubeFragment extends YouTubePlayerSupportFragment implements YouTubePlayer.OnInitializedListener {
    private YouTubePlayer activePlayer;

    private YouTubeThumbnailLoader youTubeThumbnailLoader;

    public static RecyYoutubeFragment newInstance(String url) {
        RecyYoutubeFragment recyYoutubeFragment = new RecyYoutubeFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BundleKeys.youTubeUrl, url);
        recyYoutubeFragment.setArguments(bundle);
        return recyYoutubeFragment;
    }

    public void init() {
        initialize(YoutubeConfig.YoutupeApi, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        this.activePlayer = youTubePlayer;
        activePlayer.setShowFullscreenButton(false);
        if (!b) {
            String url = getArguments().getString(BundleKeys.youTubeUrl);
            activePlayer.cueVideo(url);
            activePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
//            http://img.youtube.com/vi/GDFUdMvacI0/3.jpg
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}

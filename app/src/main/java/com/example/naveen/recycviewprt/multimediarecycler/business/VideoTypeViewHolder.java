package com.example.naveen.recycviewprt.multimediarecycler.business;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.naveen.recycviewprt.R;
import com.example.naveen.recycviewprt.multimediarecycler.MultiMediaRecycler;
import com.example.naveen.recycviewprt.widgets.CustomTextureView;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveVideoTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.youtube.player.YouTubePlayer;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

class VideoTypeViewHolder extends RecyclerView.ViewHolder  {
    //    @BindView(R.id.exoPlayer)
//    SimpleExoPlayerView exoPlayerView;
//    @BindView(R.id.imgPause)
//    ImageView imgPause;
    @BindView(R.id.customTextureView)
    public CustomTextureView customTextureView;

    //    private DataSource.Factory dataSourceFactory;
//    private MediaSource mediaSource;
//    private ExtractorsFactory extractorsFactory;
//
//    private YouTubePlayer activePlayer;
//    private SimpleExoPlayer simpleExoPlayer;
//
    private MultiMediaRecycler multiMediaRecycler;


    VideoTypeViewHolder(View itemView, MultiMediaRecycler multiMediaRecycler) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.multiMediaRecycler = multiMediaRecycler;
//
//        Handler mainHandler = new Handler();
//        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
//        TrackSelection.Factory videoTrackSelectionFactory =
//                new AdaptiveVideoTrackSelection.Factory(bandwidthMeter);
//        TrackSelector trackSelector =
//                new DefaultTrackSelector(mainHandler, videoTrackSelectionFactory);
//
////        Load Control
//        LoadControl loadControl = new DefaultLoadControl();
//
////        Create Player
//        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(multiMediaRecycler, trackSelector, loadControl);
//        exoPlayerView.setPlayer(simpleExoPlayer);
//
//
////        Preparing Video Player
//        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
//        dataSourceFactory = new DefaultDataSourceFactory(multiMediaRecycler,
//                Util.getUserAgent(multiMediaRecycler, "yourApplicationName"), defaultBandwidthMeter);
//        extractorsFactory = new DefaultExtractorsFactory();
    }

    void onBind(int position, MultiMediaRecycler multiMediaRecycler) {
       // textureView.setSurfaceTextureListener(this);
//        Handler mainHandler = new Handler();
//        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
//        TrackSelection.Factory videoTrackSelectionFactory =
//                new AdaptiveVideoTrackSelection.Factory(bandwidthMeter);
//        TrackSelector trackSelector =
//                new DefaultTrackSelector(mainHandler, videoTrackSelectionFactory);
//
////        Load Control
//        LoadControl loadControl = new DefaultLoadControl();
//
////        Create Player
//
//        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(multiMediaRecycler, trackSelector, loadControl);
//        exoPlayerView.setPlayer(simpleExoPlayer);
//
//
////        Preparing Video Player
//        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
//        dataSourceFactory = new DefaultDataSourceFactory(multiMediaRecycler,
//                Util.getUserAgent(multiMediaRecycler, "yourApplicationName"), defaultBandwidthMeter);
//        extractorsFactory = new DefaultExtractorsFactory();
        //    initialize(multiMediaRecycler);

    }

    void initialize(MultiMediaRecycler multiMediaRecycler) {

        // new Doback(this).execute();
        //fetchVideo("http://techslides.com/demos/sample-videos/small.mp4");
    }

    void fetchVideo(String videoUrl) {
//        if (mediaSource != null) {
//            mediaSource.releaseSource();
//        }
//
//        mediaSource = new ExtractorMediaSource(Uri.parse(videoUrl), dataSourceFactory, extractorsFactory, null, null);
//        simpleExoPlayer.prepare(mediaSource);
//        exoPlayerView.setUseController(true);
//        simpleExoPlayer.setPlayWhenReady(true);
//        exoPlayerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                exoPlayerView.setUseController(true);
//            }
//        });

    }

//    void onStop(){
//     if (mediaPlayer !=null){
//         mediaPlayer.stop();
//         mediaPlayer.release();
//         mediaPlayer.reset();
//     }
//    }

    void onStop(int lastPlayedPositon) {
        customTextureView.onStopPlayer();
    }

    void onPrepare(String url) {
        customTextureView.initialize(url);

//        if (surface != null) {
//            if (mediaPlayer.isPlaying()) {
//                mediaPlayer.stop();
//            }
//
//            try {
//                mediaPlayer.setDataSource(url);
//                mediaPlayer.setSurface(surface);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                mediaPlayer.prepare();
//                mediaPlayer.start();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            Toast.makeText(multiMediaRecycler, "Surface value null", Toast.LENGTH_LONG).show();
//        }

    }

    void checkIsplaying() {
//        Log.w("videoPlayer", simpleExoPlayer + "simpleExoplayer");
//        if (simpleExoPlayer != null) {
//            simpleExoPlayer.stop();
//        }
    }


}

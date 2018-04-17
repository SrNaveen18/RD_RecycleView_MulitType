package com.example.naveen.recycviewprt.multimediarecycler.business;

import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.naveen.recycviewprt.R;
import com.example.naveen.recycviewprt.model.SampleList;
import com.example.naveen.recycviewprt.multimediarecycler.MultiMediaRecycler;
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
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;

import java.util.List;

public class MultiMediaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private MultiMediaRecycler multiMediaRecycler;
    private List<SampleList.Data> recycleLists;

    private int TYPE_NONE = 0;
    private int TYPE_IMAGE = 1;
    private int TYPE_VIDEO = 2;
    private int TYPE_AUDIO = 3;

    private VideoTypeViewHolder videoTypeViewHolder;
    private VideoTypeViewHolder currentTypeVideoHolder;

    private int lastPlayedPositon = -1;


//Exoplayer Implementation

    private SimpleExoPlayer simpleExoPlayer;
    private DataSource.Factory dataSourceFactory;
    private MediaSource mediaSource;
    private ExtractorsFactory extractorsFactory;

    private TrackSelector trackSelector;
    private LoadControl loadControl;

    public MultiMediaAdapter(final MultiMediaRecycler multiMediaRecycler, final List<SampleList.Data> recycleLists, RecyclerView recyclerView) {
        this.recycleLists = recycleLists;
        this.multiMediaRecycler = multiMediaRecycler;


        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                int firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
                int firstCompletelyVisibleItem = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                Log.w("firstVisibleItem", firstVisibleItem + "=======" + firstCompletelyVisibleItem);

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (recyclerView.findViewHolderForAdapterPosition(firstCompletelyVisibleItem) instanceof VideoTypeViewHolder) {
                        videoTypeViewHolder = (VideoTypeViewHolder) recyclerView.findViewHolderForAdapterPosition(firstCompletelyVisibleItem);
                        if (lastPlayedPositon >= 0) {
//                            videoTypeViewHolder.checkIsplaying();
//                            videoTypeViewHolder.initialize(multiMediaRecycler);
                           // videoTypeViewHolder.onStop();
                            currentTypeVideoHolder.onStop(lastPlayedPositon);
                            currentTypeVideoHolder = null;


                        }
                        currentTypeVideoHolder = videoTypeViewHolder;
                        videoTypeViewHolder.onPrepare(recycleLists.get(firstCompletelyVisibleItem).Url);
                       // videoTypeViewHolder.fetchVideo(recycleLists.get(firstCompletelyVisibleItem).Url);
                        lastPlayedPositon = firstCompletelyVisibleItem;
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == TYPE_NONE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adap_none, parent, false);
            viewHolder = new NoneTypeViewHolder(view);
        } else if (viewType == TYPE_IMAGE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adap_image, parent, false);
            viewHolder = new ImageTypeViewHolder(view);
        } else if (viewType == TYPE_AUDIO) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adap_audio, parent, false);
            viewHolder = new AudioTypeViewHolder(view);
        } else if (viewType == TYPE_VIDEO) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adap_video, parent, false);
            viewHolder = new VideoTypeViewHolder(view,multiMediaRecycler);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VideoTypeViewHolder) {
            VideoTypeViewHolder videoTypeViewHolder = (VideoTypeViewHolder) holder;
            this.videoTypeViewHolder = videoTypeViewHolder;
            videoTypeViewHolder.onBind(position, multiMediaRecycler);
        } else if (holder instanceof ImageTypeViewHolder) {
            ImageTypeViewHolder imageTypeViewHolder = (ImageTypeViewHolder) holder;
            imageTypeViewHolder.onBind(position, recycleLists.get(position), multiMediaRecycler);
        }
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        super.onViewRecycled(holder);
        if (holder instanceof VideoTypeViewHolder) {
            VideoTypeViewHolder videoTypeViewHolder = (VideoTypeViewHolder) holder;
            if (videoTypeViewHolder == currentTypeVideoHolder){
                currentTypeVideoHolder.onStop(lastPlayedPositon);
                currentTypeVideoHolder = null ;
            }
          //  videoTypeViewHolder.checkIsplaying();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (recycleLists.get(position).Type.equalsIgnoreCase("None")) {
            return TYPE_NONE;
        } else if (recycleLists.get(position).Type.equalsIgnoreCase("Image")) {
            return TYPE_IMAGE;
        } else if (recycleLists.get(position).Type.equalsIgnoreCase("Audio")) {
            return TYPE_AUDIO;
        } else if (recycleLists.get(position).Type.equalsIgnoreCase("Video")) {
            return TYPE_VIDEO;
        } else {
            return 0;
        }
    }

    @Override
    public int getItemCount() {
        return recycleLists.size();
    }


//    private void initialize(MultiMediaRecycler multiMediaRecycler) {
//
//        Handler mainHandler = new Handler();
//        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
//        TrackSelection.Factory videoTrackSelectionFactory =
//                new AdaptiveVideoTrackSelection.Factory(bandwidthMeter);
//        trackSelector =
//                new DefaultTrackSelector(mainHandler, videoTrackSelectionFactory);
//
////        Load Control
//        loadControl = new DefaultLoadControl();
////        Create Player
//        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(multiMediaRecycler, trackSelector, loadControl);
//        videoTypeViewHolder.exoPlayerView.setPlayer(simpleExoPlayer);
//
////        Preparing Video Player
//        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
//        dataSourceFactory = new DefaultDataSourceFactory(multiMediaRecycler,
//                Util.getUserAgent(multiMediaRecycler, "yourApplicationName"), defaultBandwidthMeter);
//        extractorsFactory = new DefaultExtractorsFactory();
//        // new Doback(this).execute();
//        //fetchVideo("http://techslides.com/demos/sample-videos/small.mp4");
//    }
//
//    private void fetchVideo(String videoUrl) {
//        mediaSource = new ExtractorMediaSource(Uri.parse(videoUrl), dataSourceFactory, extractorsFactory, null, null);
//        simpleExoPlayer.prepare(mediaSource);
//        videoTypeViewHolder.exoPlayerView.setUseController(true);
//        simpleExoPlayer.setPlayWhenReady(true);
//        videoTypeViewHolder.exoPlayerView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                videoTypeViewHolder.exoPlayerView.setUseController(true);
//            }
//        });
//
//    }
//
//    private void checkIsplaying() {
//        Log.w("videoPlayer", simpleExoPlayer + "simpleExoplayer");
//        if (simpleExoPlayer != null) {
//            simpleExoPlayer.release();
//        }
//    }

    private void videoAnim(){}
}

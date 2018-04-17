package com.example.naveen.recycviewprt.customexoplayer;

import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.TextureView;

import com.example.naveen.recycviewprt.R;

import java.io.IOException;

public class CustomExoPlayer extends AppCompatActivity implements TextureView.SurfaceTextureListener,
        MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener {

    // private VideoView customTextureView;
    private Surface mSurface;
    private String url = "https://firebasestorage.googleapis.com/v0/b/fir-login-27238.appspot.com/o/Whatsapp_status_video%5B1%5D.mp4?alt=media&token=b8a01a2e-eabb-4c81-8e13-68811aa91720";
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_exo_player);
        TextureView ttView = (TextureView) findViewById(R.id.ttView);
        ttView.setSurfaceTextureListener(this);
        // init();

        //  customTextureView= (VideoView) findViewById(R.id.customTextureView);
        //  customTextureView.setVideoURI(Uri.parse("https://firebasestorage.googleapis.com/v0/b/fir-login-27238.appspot.com/o/Whatsapp_status_video%5B1%5D.mp4?alt=media&token=b8a01a2e-eabb-4c81-8e13-68811aa91720"));
    }

    private void init() {
        try {
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDataSource(url);
            mMediaPlayer.setSurface(mSurface);
            mMediaPlayer.prepare();
            mMediaPlayer.setOnBufferingUpdateListener(this);
            mMediaPlayer.setOnCompletionListener(this);
            mMediaPlayer.setOnPreparedListener(this);
            mMediaPlayer.setOnVideoSizeChangedListener(this);
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.start();
        } catch (IllegalArgumentException | SecurityException | IllegalStateException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
        mSurface = new Surface(surfaceTexture);
        new AsynchBack().execute();
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {}

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {return false;}

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {}

    @Override
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {

    }

    @Override
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {

    }

    private class AsynchBack extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            init();
            return null;
        }
    }
}


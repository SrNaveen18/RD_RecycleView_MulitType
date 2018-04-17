package com.example.naveen.recycviewprt.widgets;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.widget.Toast;
import java.io.IOException;


public class CustomTextureView extends TextureView implements TextureView.SurfaceTextureListener {

    MediaPlayer mediaPlayer;
    Surface mSurface;
    private Context context;

    public CustomTextureView(Context context) {
        super(context);
        this.context = context;
        initilizeSurfaceListner();
    }


    public CustomTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        initilizeSurfaceListner();
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
        mSurface = new Surface(surfaceTexture);
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }


    private void initilizeSurfaceListner() {
        this.setSurfaceTextureListener(this);
    }


    public void initialize(String url) {

        Log.w("MEDIAPLAYER",mediaPlayer+"================Media Player");
        if (mSurface != null) {
            try {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(url);
                mediaPlayer.setSurface(mSurface);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            Toast.makeText(context, "Surface null", Toast.LENGTH_LONG).show();
        }
    }

    public void onStopPlayer() {
        if (mediaPlayer !=null && mediaPlayer.isPlaying()) {
            Log.w("MEDIAPLAYER2",mediaPlayer+"================Media Player");
            mediaPlayer.stop();
            mediaPlayer.release();
//            mediaPlayer = null;
        }
    }
}

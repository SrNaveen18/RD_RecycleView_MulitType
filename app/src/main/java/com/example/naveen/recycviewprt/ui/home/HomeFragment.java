package com.example.naveen.recycviewprt.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.naveen.recycviewprt.R;
import com.example.naveen.recycviewprt.base.BaseFragment;
import com.example.naveen.recycviewprt.customexoplayer.CustomExoPlayer;
import com.example.naveen.recycviewprt.helper.BundleKeys;
import com.example.naveen.recycviewprt.helper.animation.DetailsTransition;
import com.example.naveen.recycviewprt.multimediarecycler.MultiMediaRecycler;
import com.example.naveen.recycviewprt.ui.hidingtoolbar.HidingToolBarActivity;
import com.example.naveen.recycviewprt.ui.home.business.RecycAdapter;
import com.example.naveen.recycviewprt.multimediarecycler.youtube.RecyYoutubeFragment;
import com.example.naveen.recycviewprt.recyclermethods.StartOffset;
import com.example.naveen.recycviewprt.ui.home.business.RecycViewHolder;
import com.example.naveen.recycviewprt.ui.sharedanim.SharedAnimFragment;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import jp.wasabeef.blurry.Blurry;

public class HomeFragment extends BaseFragment implements HomeView, View.OnClickListener {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    RecycAdapter adapter;
    @BindView(R.id.rootCardView)
    CardView rootCardView;
    @BindView(R.id.sampleImage)
    ImageView sampleImage;
    @BindView(R.id.btnHome)
    Button btnHome;
    @BindView(R.id.imgArrow)
    ImageView imgArrow;
    private List<String> list;

    @Override
    protected int getLayout() {
        return R.layout.home;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
    }

    @Override
    public void initialize() {
        //  initializeYoutubeVideo();

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MultiMediaRecycler.class);
                startActivity(intent);
            }
        });

        Glide.with(this).load("http://hdwallpapersrocks.com/wp-content/uploads/2013/09/Good-night-sweet-dream-dark-natural-300x250.jpg").asBitmap().centerCrop().into(new SimpleTarget<Bitmap>() {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                // you can do something with loaded bitmap here
                setBitmapBlur(resource);

            }
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int deviceWidth = displayMetrics.widthPixels / 2;

        // rootCardView.setBackgroundResource(R.drawable.dark);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new RecycAdapter(getActivity(), getList(), this);
        recyclerView.addItemDecoration(new StartOffset(deviceWidth));
        recyclerView.setAdapter(adapter);


        /*       RecyclerView Animation  */

//        recyclerView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
//            @Override
//            public boolean onPreDraw() {
//                recyclerView.getViewTreeObserver().removeOnPreDrawListener(this);
//
//                for (int i = 0; i < recyclerView.getChildCount(); i++) {
//                    View v = recyclerView.getChildAt(i);
//                    v.setAlpha(0.0f);
//                    v.animate().alpha(1.0f)
//                            .setDuration(300)
//                            .setStartDelay(i * 50)
//                            .start();
//                }
//
//                return true;
//            }
//        });

    }

    @Override
    public void moveSharedElementAnim(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof RecycViewHolder) {
            RecycViewHolder recycViewHolder = (RecycViewHolder) viewHolder;
            SharedAnimFragment sharedAnimFragment = new SharedAnimFragment();
            Bundle bundle = new Bundle();
            bundle.putString(BundleKeys.sharedAnimImageUrl, list.get(recycViewHolder.getAdapterPosition()));

            getActivity().postponeEnterTransition();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                sharedAnimFragment.setSharedElementEnterTransition(new DetailsTransition());
                sharedAnimFragment.setSharedElementReturnTransition(new DetailsTransition());
            }
            sharedAnimFragment.setArguments(bundle);
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.base_container, sharedAnimFragment).
                    addSharedElement(recycViewHolder.imgShared, "SHAREDANIM").addToBackStack(null).commit();

        }

    }

    private void initializeYoutubeVideo() {
        RecyYoutubeFragment recyYoutubeFragment = RecyYoutubeFragment.newInstance("NqlRg1_bCC4");
        android.support.v4.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frmVideo, recyYoutubeFragment).commit();
        recyYoutubeFragment.init();
    }

    private List<String> getList() {
        list = new ArrayList<>();
        list.add("http://users.eastlink.ca/~lutheranchurch/Images/ChurchSketch.jpg");
        list.add("http://penguin.unitingchurch.org.au/wp-content/uploads/2011/11/PB280119.jpg");
        list.add("https://www.muzirisheritage.org/images/Kottakkavu-church-L.jpg");
        list.add("http://www.stpeterswaverton.org.uk/new/wp-content/uploads/2012/10/IMG_0272-church-4-Copy-Copy.jpg");
        list.add("http://www.stmarysholliston.com/pics/Church.jpg");
        list.add("https://www.yourchurchwedding.org/wp-content/uploads/2015/07/church.jpg");
        list.add("http://www.sk.united-church.ca/wp-content/gallery/home-page-do-not-delete/Church-Winter.jpg");
        list.add("http://www.chch.ox.ac.uk/sites/default/files/welcome-3.jpg");
        list.add("http://www.escapehere.com/wp-content/uploads/2015/08/820x480xSt.-Augustine-Church-Philippines-820x480.jpg.pagespeed.ic.JSWPKXxZxd.jpg");
        list.add("http://archiseek.com/wp-content/gallery/canada-mb-winnipeg-riverheights/st_ignatius_lge.jpg");
        list.add("http://users.eastlink.ca/~lutheranchurch/Images/ChurchSketch.jpg");
        list.add("http://penguin.unitingchurch.org.au/wp-content/uploads/2011/11/PB280119.jpg");
        list.add("http://penguin.unitingchurch.org.au/wp-content/uploads/2011/11/PB280119.jpg");
        list.add("https://www.muzirisheritage.org/images/Kottakkavu-church-L.jpg");
        list.add("http://www.sk.united-church.ca/wp-content/gallery/home-page-do-not-delete/Church-Winter.jpg");
        list.add("http://www.stpeterswaverton.org.uk/new/wp-content/uploads/2012/10/IMG_0272-church-4-Copy-Copy.jpg");
//        for (int i = 0; i <= 100; i++) {
//            list.add(String.valueOf(i));
//        }
        return list;
    }

    public void setBitmapBlur(Bitmap bitmapBlur) {
        Blurry.with(getActivity()).radius(10)
                .sampling(8)
                .color(Color.argb(66, 255, 255, 0)).from(bitmapBlur).into(sampleImage);
//        Bitmap bitmap = BlurBitmap.blurRender(bitmapBlur,getApplicationContext());
//
//        Drawable drawable = new BitmapDrawable(getResources(), bitmap);
//
//        rootCardView.setBackground(drawable);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgShared:
                RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) view.getTag(R.id.imgShared);
                moveSharedElementAnim(viewHolder);
                break;
            default:
                break;
        }
    }
}

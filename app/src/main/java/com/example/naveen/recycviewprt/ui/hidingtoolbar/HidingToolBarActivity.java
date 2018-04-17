package com.example.naveen.recycviewprt.ui.hidingtoolbar;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.example.naveen.recycviewprt.R;
import com.example.naveen.recycviewprt.helper.HidingScrollListener;
import com.example.naveen.recycviewprt.helper.Utils;
import com.example.naveen.recycviewprt.recyclermethods.StartOffset;
import com.example.naveen.recycviewprt.ui.hidingtoolbar.business.HidingToolbarAdapter;
import com.example.naveen.recycviewprt.ui.home.business.RecycAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HidingToolBarActivity extends AppCompatActivity implements HidingToolBarView {
    @BindView(R.id.appBar)
    AppBarLayout appBarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private HidingToolbarAdapter hidingToolbarAdapter;
    private List<String> list = new ArrayList<>();
    private int toolBarHeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hiding_toolbar);
        ButterKnife.bind(this);
        initialize();
    }

    @Override
    public void initialize() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        hidingToolbarAdapter = new HidingToolbarAdapter(this, getList());
        recyclerView.setAdapter(hidingToolbarAdapter);

        int topHeight = Utils.getTabHeight(HidingToolBarActivity.this);
        recyclerView.setPadding(recyclerView.getPaddingLeft(), topHeight + 10 , recyclerView.getPaddingRight(), recyclerView.getPaddingBottom());
        toolBarHeight = Utils.getTabHeight(HidingToolBarActivity.this);

        recyclerView.addOnScrollListener(new HidingScrollListener(HidingToolBarActivity.this) {
            @Override
            public void onMoved(int distance) {
                appBarLayout.setTranslationY(-distance);
            }

            @Override
            public void onShow() {
                appBarLayout.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2)).start();
            }

            @Override
            public void onHide() {
                appBarLayout.animate().translationY(-toolBarHeight).setInterpolator(new AccelerateInterpolator(2)).start();

            }
        });
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
}

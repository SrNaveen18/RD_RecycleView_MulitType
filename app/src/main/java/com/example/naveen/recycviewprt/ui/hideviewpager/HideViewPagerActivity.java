package com.example.naveen.recycviewprt.ui.hideviewpager;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.naveen.recycviewprt.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HideViewPagerActivity extends AppCompatActivity implements HideViewPagerView {

    @BindView(R.id.txtButton)
    Button txtButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hide_view_pager);
        ButterKnife.bind(this);
        initialize();
    }

    @Override
    public void initialize() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]
                {
                        0xFF46C1C7,
                        0xFF4D979B
                });
        gradientDrawable.setCornerRadius(10);
        txtButton.setBackground(gradientDrawable);

    }
}

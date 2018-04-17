package com.example.naveen.recycviewprt.ui.sharedanim;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.naveen.recycviewprt.R;
import com.example.naveen.recycviewprt.base.BaseFragment;
import com.example.naveen.recycviewprt.helper.BundleKeys;
import butterknife.BindView;

public class SharedAnimFragment extends BaseFragment implements SharedAnimView {
    @BindView(R.id.imgDetails)
    ImageView imgDetails;
    @BindView(R.id.bottom_sheet)
    View bottomSheet;
    @BindView(R.id.root_image)
    FrameLayout frmImage;


    private String TAG = "SharedAnimFragment";
    private BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected int getLayout() {
        return R.layout.fragment_shared_anim;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize();
    }

    @Override
    public void initialize() {
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        bottomSheetBehavior.setPeekHeight(100);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String url = bundle.getString(BundleKeys.sharedAnimImageUrl);
            getActivity().supportPostponeEnterTransition();
            Glide.with(getActivity()).load(url).centerCrop().dontAnimate().listener(new RequestListener<String, GlideDrawable>() {
                @Override
                public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                    if (getActivity() != null)
                        getActivity().supportStartPostponedEnterTransition();
                    return false;
                }

                @Override
                public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                    if (getActivity() != null)
                        getActivity().supportStartPostponedEnterTransition();
                    startCircleRevealAnimation();

                    return false;
                }
            }).into(imgDetails);
        }


        imgDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        Log.d(TAG, "State Collapsed");
                        break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.d(TAG, "State Dragging");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        Log.d(TAG, "State Expanded");
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.d(TAG, "State Hidden");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.d(TAG, "State Settling");
                        break;
                }


            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

    }

    private void startCircleRevealAnimation() {
        try {
            Animator animator = ViewAnimationUtils.createCircularReveal(frmImage, frmImage.getWidth() / 2, frmImage.getHeight() / 2, 0, frmImage.getWidth());
            animator.setDuration(800);
            frmImage.setBackgroundColor(getActivity().getResources().getColor(R.color.colorPrimary));
            if (getActivity() != null) {
                animator.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}

package com.example.naveen.recycviewprt.helper;


import android.content.Context;
import android.content.res.TypedArray;

import com.example.naveen.recycviewprt.R;


public class Utils {

public static int getToolbarHeight(Context context){
final TypedArray typedArray=context.getTheme().obtainStyledAttributes(new int[]{R.attr.actionBarSize});
    int toolBarHeight=(int)typedArray.getDimension(0,0);
    typedArray.recycle();
    return toolBarHeight;
}

    public static int getTabHeight(Context context){
        return (int) context.getResources().getDimension(R.dimen.tabsHeight);
    }
}

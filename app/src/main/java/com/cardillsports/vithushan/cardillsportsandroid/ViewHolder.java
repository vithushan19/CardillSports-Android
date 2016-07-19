package com.cardillsports.vithushan.cardillsportsandroid;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by vithushan on 7/18/16.
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final ImageView mImageView;
    public Article mItem;

    public ViewHolder(View view) {
        super(view);
        mView = view;
        mImageView = (ImageView) view.findViewById(R.id.image);
    }

    @Override
    public String toString() {
        return super.toString() + " '";
    }
}
package com.cardillsports.vithushan.cardillsportsandroid.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cardillsports.vithushan.cardillsportsandroid.R;
import com.cardillsports.vithushan.cardillsportsandroid.models.CreatorModel;

/**
 * Created by vithushan on 7/18/16.
 */
public class CreatorViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final ImageView mImageView;
    public final TextView mArticleAuthorView;

    public CreatorModel mItem;

    public CreatorViewHolder(View view) {
        super(view);
        mView = view;
        mImageView = (ImageView) view.findViewById(R.id.image);
        mArticleAuthorView = (TextView) view.findViewById(R.id.creator_name);
    }

    @Override
    public String toString() {
        return super.toString() + " '";
    }
}
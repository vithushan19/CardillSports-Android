package com.cardillsports.vithushan.cardillsportsandroid.main;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cardillsports.vithushan.cardillsportsandroid.R;
import com.cardillsports.vithushan.cardillsportsandroid.models.CreatorModel;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vithushan on 7/18/16.
 */
public class CreatorAdapter extends RecyclerView.Adapter<CreatorViewHolder> {

    private final List<CreatorModel> mValues;

    private final Context mContext;
    private final Picasso mPicasso;

    public CreatorAdapter(List<CreatorModel> items, Context context, Picasso picasso) {
        mValues = items;
        mContext = context;
        mPicasso = picasso;
    }

    @Override
    public CreatorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.creator_list_item, parent, false);
        return new CreatorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CreatorViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        mPicasso.with(mContext)
                .load("http://s3.amazonaws.com/cardillsports/" + holder.mItem._id.userPicture)
                .placeholder(R.drawable.placeholder)
                .fit().centerInside()
                 .into(holder.mImageView);

        holder.mArticleAuthorView.setText(holder.mItem._id.firstName + " " +holder.mItem._id.lastName);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


}
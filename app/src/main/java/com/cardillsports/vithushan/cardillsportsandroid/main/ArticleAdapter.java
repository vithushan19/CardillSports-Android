package com.cardillsports.vithushan.cardillsportsandroid.main;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cardillsports.vithushan.cardillsportsandroid.R;
import com.cardillsports.vithushan.cardillsportsandroid.articleDetail.ArticleDetailActivity;
import com.cardillsports.vithushan.cardillsportsandroid.models.Article;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vithushan on 7/18/16.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ViewHolder> {

    private final List<Article> mValues;

    private final Context mContext;
    private final GradientDrawable gradientDrawable;
    private final Picasso mPicasso;

    private final FragmentManager mFragmentManager;

    public ArticleAdapter(List<Article> items, Context context, Picasso picasso) {
        mValues = items;
        mContext = context;
        mPicasso = picasso;
        gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(Color.BLUE);
        FragmentActivity a = (FragmentActivity) context;
        mFragmentManager = a.getSupportFragmentManager();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        mPicasso.with(mContext)
                .load("http://s3.amazonaws.com/cardillsports/" + holder.mItem.ImageLink)
                .placeholder(R.drawable.placeholder)
                .fit().centerInside()
                 .into(holder.mImageView);

        holder.mArticleAuthorView.setText(holder.mItem.Owner.firstName + " " +holder.mItem.Owner.lastName);
        holder.mArticleTitleView.setText(holder.mItem.Name);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ArticleDetailActivity.class);
                intent.putExtra("ARTICLE", holder.mItem);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


}
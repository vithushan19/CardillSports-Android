package com.cardillsports.vithushan.cardillsportsandroid.articleDetail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cardillsports.vithushan.cardillsportsandroid.R;
import com.cardillsports.vithushan.cardillsportsandroid.models.Article;
import com.cardillsports.vithushan.cardillsportsandroid.models.ArticleItem;
import com.squareup.picasso.Picasso;

public class ArticleDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    public Article mArticle;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ArticleDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArticle = getArguments().getParcelable("ARTICLE");
        Toast.makeText(getContext(), mArticle.Name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout rootView = (LinearLayout) inflater.inflate(R.layout.article_detail, container, false);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.article_image);
        Picasso.with(getContext())
                .load("http://s3.amazonaws.com/cardillsports/" + mArticle.ImageLink)
                .placeholder(R.drawable.placeholder)
                .fit().centerInside()
                .into(imageView);

        LinearLayout articleContent = (LinearLayout) rootView.findViewById(R.id.article_text);
        for (ArticleItem item : mArticle.ArticleItems) {
            AppCompatTextView textView = new AppCompatTextView(getContext());
            if ("Text".equals(item.Type) && item.Paragraph != null) {
                textView.setText(Html.fromHtml(item.Paragraph));
                textView.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                textView.setPadding(10,10,10,10);
            }
            articleContent.addView(textView);
        }
        return rootView;
    }

}

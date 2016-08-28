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
import com.cardillsports.vithushan.cardillsportsandroid.models.CardillContent;
import com.squareup.picasso.Picasso;

public class ArticleDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";
    public CardillContent mCardillContent;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ArticleDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCardillContent = getArguments().getParcelable("ARTICLE");
        Toast.makeText(getContext(), mCardillContent.Name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout rootView = (LinearLayout) inflater.inflate(R.layout.article_detail, container, false);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.article_image);
        Picasso.with(getContext())
                .load("http:" + mCardillContent.Image)
                .placeholder(R.drawable.placeholder)
                .fit().centerInside()
                .into(imageView);

        LinearLayout articleContent = (LinearLayout) rootView.findViewById(R.id.article_text);
        String body = mCardillContent.Body;


        AppCompatTextView textView = new AppCompatTextView(getContext());

        textView.setText(Html.fromHtml(body));
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        textView.setPadding(10,10,10,10);

        articleContent.addView(textView);



        return rootView;
    }

}

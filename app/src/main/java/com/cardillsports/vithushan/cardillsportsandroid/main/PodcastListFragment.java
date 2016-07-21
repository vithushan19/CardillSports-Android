package com.cardillsports.vithushan.cardillsportsandroid.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cardillsports.vithushan.cardillsportsandroid.R;
import com.cardillsports.vithushan.cardillsportsandroid.models.CardillContent;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vithushan on 7/18/16.
 */
public class PodcastListFragment extends Fragment implements AbstractViewBinder<List<CardillContent>> {


    private PodcastPresenter mPodcastPresenter;
    private RecyclerView mRecyclerView;
    private Picasso mPicasso;
    private OkHttpClient mOkHttpClient;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPodcastPresenter = new PodcastPresenter(this);

        mOkHttpClient = new OkHttpClient();
        mPicasso = new Picasso.Builder(getContext())
                .downloader(new OkHttpDownloader(mOkHttpClient))
                .build();

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.article_list);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPodcastPresenter.loadData();
    }

    @Override
    public void onDataLoaded(List<CardillContent> data) {
        ArticleAdapter adapter = new ArticleAdapter(data, getContext(), mPicasso);
        mRecyclerView.setAdapter(adapter);
    }
}

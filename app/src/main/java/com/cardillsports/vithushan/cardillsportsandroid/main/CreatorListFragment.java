package com.cardillsports.vithushan.cardillsportsandroid.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cardillsports.vithushan.cardillsportsandroid.R;
import com.cardillsports.vithushan.cardillsportsandroid.models.CreatorModel;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vithushan on 7/21/16.
 */
public class CreatorListFragment extends Fragment implements AbstractViewBinder<List<CreatorModel>> {


    private CreatorPresenter mCreatorPresenter;
    private RecyclerView mRecyclerView;
    private Picasso mPicasso;
    private OkHttpClient mOkHttpClient;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCreatorPresenter = new CreatorPresenter(this);

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
        mCreatorPresenter.loadData();
    }

    @Override
    public void onDataLoaded(List<CreatorModel> data) {
        CreatorAdapter adapter = new CreatorAdapter(data, getContext(), mPicasso);
        mRecyclerView.setAdapter(adapter);
    }
}

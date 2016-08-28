package com.cardillsports.vithushan.cardillsportsandroid.main;

import android.util.Log;

import com.cardillsports.vithushan.cardillsportsandroid.models.CardillContent;
import com.cardillsports.vithushan.cardillsportsandroid.service.CardillSportsClient;
import com.cardillsports.vithushan.cardillsportsandroid.service.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vithushan on 7/18/16.
 */
public class PodcastPresenter {

    private CardillSportsClient mClient;
    private AbstractViewBinder<List<CardillContent>> mViewBinder;


    PodcastPresenter(AbstractViewBinder<List<CardillContent>> viewBinder) {
        mClient = ServiceGenerator.createService(CardillSportsClient.class);
        mViewBinder = viewBinder;
    }

    public void loadData() {
        Call<List<CardillContent>> call = mClient.podcasts();
        call.enqueue(new Callback<List<CardillContent>>() {
            @Override
            public void onResponse(Call<List<CardillContent>> responseCall, Response<List<CardillContent>> response) {
                if (response.isSuccessful()) {
                    List<CardillContent> cardillContents = response.body();
                    mViewBinder.onDataLoaded(cardillContents);
                } else {
                    // error response, no access to resource?
                }
            }

            @Override
            public void onFailure(Call<List<CardillContent>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }


}

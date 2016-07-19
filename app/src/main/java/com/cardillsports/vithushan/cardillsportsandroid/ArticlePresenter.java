package com.cardillsports.vithushan.cardillsportsandroid;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vithushan on 7/18/16.
 */
public class ArticlePresenter {

    private CardillSportsClient mClient;
    private AbstractViewBinder<List<Article>> mViewBinder;


    ArticlePresenter(AbstractViewBinder<List<Article>> viewBinder) {
        mClient = ServiceGenerator.createService(CardillSportsClient.class);
        mViewBinder = viewBinder;
    }

    public void loadData() {
        Call<List<Article>> call = mClient.articles();
        call.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse(Call<List<Article>> responseCall, Response<List<Article>> response) {
                if (response.isSuccessful()) {
                    List<Article> articles = response.body();
                    mViewBinder.onDataLoaded(articles);
                } else {
                    // error response, no access to resource?
                }
            }

            @Override
            public void onFailure(Call<List<Article>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }


}

package com.cardillsports.vithushan.cardillsportsandroid.main;

import android.util.Log;

import com.cardillsports.vithushan.cardillsportsandroid.models.CreatorModel;
import com.cardillsports.vithushan.cardillsportsandroid.service.CardillSportsClient;
import com.cardillsports.vithushan.cardillsportsandroid.service.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by vithushan on 7/18/16.
 */
public class CreatorPresenter {

    private CardillSportsClient mClient;
    private AbstractViewBinder<List<CreatorModel>> mViewBinder;


    CreatorPresenter(AbstractViewBinder<List<CreatorModel>> viewBinder) {
        mClient = ServiceGenerator.createService(CardillSportsClient.class);
        mViewBinder = viewBinder;
    }

    public void loadData() {
        Call<List<CreatorModel>> call = mClient.creators();
        call.enqueue(new Callback<List<CreatorModel>>() {
            @Override
            public void onResponse(Call<List<CreatorModel>> responseCall, Response<List<CreatorModel>> response) {
                if (response.isSuccessful()) {
                    List<CreatorModel> cardillContents = response.body();
                    mViewBinder.onDataLoaded(cardillContents);
                } else {
                    // error response, no access to resource?
                }
            }

            @Override
            public void onFailure(Call<List<CreatorModel>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }


}

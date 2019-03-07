package com.ewalltech.apps.diabetes_solutions.git_api;

import com.ewalltech.apps.diabetes_solutions.constants.Constants;
import com.ewalltech.apps.diabetes_solutions.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET(Constants.config.URL_REPOSITORIES)
    Call<ItemResponse> getItems();
}

package com.ewalltech.apps.diabetes_solutions.git_api;

import com.ewalltech.apps.diabetes_solutions.constants.Constants;
import com.ewalltech.apps.diabetes_solutions.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitUserService {

    @GET(Constants.config.URL_USERS+"{username}")
    Call<User> getUser(@Path("username") String username);

//    @GET(Constants.config.URL_USERS)
//    Call<User> getUsers();
}

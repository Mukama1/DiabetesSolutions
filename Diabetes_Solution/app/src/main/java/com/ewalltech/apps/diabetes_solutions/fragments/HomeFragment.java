package com.ewalltech.apps.diabetes_solutions.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ewalltech.apps.diabetes_solutions.R;
import com.ewalltech.apps.diabetes_solutions.activities.ItemAdapter;
import com.ewalltech.apps.diabetes_solutions.db.SaveGitUser;
import com.ewalltech.apps.diabetes_solutions.git_api.Client;
import com.ewalltech.apps.diabetes_solutions.git_api.Service;
import com.ewalltech.apps.diabetes_solutions.model.Item;
import com.ewalltech.apps.diabetes_solutions.model.ItemResponse;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment{
    TextView disconnected;
    private RecyclerView recyclerView;
    //private Item item;

    private List<Item> items;//=new Item(login,avatar,html);
    ProgressDialog pd;
    View rootView;
    private SwipeRefreshLayout swipeContainer;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
       rootView = inflater.inflate(R.layout.home_fragment, container, false);
        initViews();
        swipeContainer = rootView.findViewById(R.id.swipeContainer);
        //configure refreshing column
        swipeContainer.setColorSchemeResources(android.R.color.holo_orange_dark);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadJSON();
               // Toast.makeText(this, "GitHub Diabetes Developers Refreshed", Toast.LENGTH_SHORT).show();

            }
        });

        return rootView;
    }


    //method initViews

    private void initViews(){
        pd=new ProgressDialog(getActivity());
        pd.setMessage("Fetching Github Diabetes Solution Developers ..............");
        pd.setCancelable(false);
        pd.show();
//        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager);
        recyclerView= rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.smoothScrollToPosition(0);
        loadJSON();
    }

    //load JSON Method

    private void loadJSON(){
        disconnected= rootView.findViewById(R.id.disconnected);
        try {
            //Client client = new Client();
            Service apiService= Client.getClient().create(Service.class);
            Call<ItemResponse> call = apiService.getItems();
            call.enqueue(new Callback<ItemResponse>() {
                @Override
                public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                    if(response!=null && response.isSuccessful()) {
                        items = response.body().getItems();
                        //testing the elements that are picked from the web
                        Log.e("TAG", "response 33-----------------------------------: " + new Gson().toJson(response.body()));
                        recyclerView.setAdapter(new ItemAdapter(getActivity().getApplicationContext(), items));
                        recyclerView.smoothScrollToPosition(0);
                        swipeContainer.setRefreshing(false);
                        pd.hide();
                    }else{
                        Toast.makeText(getActivity(), "No Data Picked From Response", Toast.LENGTH_LONG).show();
                        pd.hide();
                    }
                }

                @Override
                public void onFailure(Call<ItemResponse> call, Throwable t) {
                    Log.d("Error: ",t.getMessage());
                    Toast.makeText(getActivity(), "Error Fetching Data!", Toast.LENGTH_SHORT).show();
                    disconnected.setVisibility(View.VISIBLE);
                    pd.hide();

                }
            });

        }catch(Exception ex){
            Log.d("Error: ", ex.getMessage());
            Toast.makeText(getActivity(), ex.toString(), Toast.LENGTH_SHORT).show();
        }
    }



}

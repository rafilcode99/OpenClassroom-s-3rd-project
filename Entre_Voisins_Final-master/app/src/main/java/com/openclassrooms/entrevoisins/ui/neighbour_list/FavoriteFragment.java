package com.openclassrooms.entrevoisins.ui.neighbour_list;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



public class FavoriteFragment extends Fragment {


    private NeighbourApiService mApiService;
    private List<Neighbour> mNeighbours;
    private RecyclerView mRecyclerView;


    /**
     * Create and return a new instance
     *
     * @return @{@link FavoriteFragment}
     */

    public static FavoriteFragment myNewInstance() {
        FavoriteFragment fragment = new FavoriteFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = DI.getNeighbourApiService();
        loadPreferences();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_list, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        initList();


        return view;
    }

    private void loadPreferences() {
        List<Neighbour> myList;

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("myprefernces", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("favorite_list", null);
        Type type = new TypeToken<ArrayList<Neighbour>>() {
        }.getType();
        myList = gson.fromJson(json, type);
        if (myList != null) {
            int i;
            for (i = 0; i < myList.size(); i++){

                mApiService.addToNeighbourFavoriteList(myList.get(i).getId());
            }


        }
    }


    /**
     * Init the List of neighbours
     */
    private void initList() {
        mNeighbours = mApiService.getFavoriteNeighboursList();
        mRecyclerView.setAdapter(new MyFavoriteNeibourRecyclerViewAdapter(mNeighbours));

    }

    @Override
    public void onStart() {
        super.onStart();
        initList();

    }
}











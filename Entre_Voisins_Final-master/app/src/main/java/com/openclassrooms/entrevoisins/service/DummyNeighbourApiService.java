package com.openclassrooms.entrevoisins.service;

import android.content.SharedPreferences;
import android.widget.Toast;

import com.openclassrooms.entrevoisins.DetailsActivity;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    private List<Neighbour> mFavoriteList = new ArrayList<>();

    public List<Neighbour> getFavoriteNeighboursList() {
        return mFavoriteList;
    }


    public void addToNeighbourFavoriteList(int id) {
        int i = 0;


        while (i < neighbours.size()  && id != neighbours.get(i).getId() ) {
            i++;
            }
        if (mFavoriteList.contains(neighbours.get(i))) {
            mFavoriteList.remove(neighbours.get(i));

        }else mFavoriteList.add(neighbours.get(i));
        }





        }


















































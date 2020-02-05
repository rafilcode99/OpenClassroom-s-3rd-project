package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void addAndRemoveFromFavoriteListWithSuccess() {
        // create a new neighbour and add him to the favorite list
        Neighbour neighbourAdded = service.getNeighbours().get(0);
        service.addToNeighbourFavoriteList(neighbourAdded.getId());
        //tests if the neighbour is added to the fav list
        assertTrue(service.getFavoriteNeighboursList().contains(neighbourAdded));
        //tests if the neighbour is removed from the fav list
        service.addToNeighbourFavoriteList(neighbourAdded.getId());
        assertFalse(service.getFavoriteNeighboursList().contains(neighbourAdded));
    }

    @Test
    public void getFavoriteListWithSuccess() {
        assertTrue(service.getFavoriteNeighboursList().isEmpty());
        Neighbour newNeighbour = service.getNeighbours().get(0);
        Neighbour anotherNeighbour = service.getNeighbours().get(1);

        service.addToNeighbourFavoriteList(newNeighbour.getId());
        service.addToNeighbourFavoriteList(anotherNeighbour.getId());

        assertTrue(service.getFavoriteNeighboursList().size() == 2);
        assertTrue(service.getFavoriteNeighboursList().contains(newNeighbour));
        assertTrue(service.getFavoriteNeighboursList().contains(anotherNeighbour));




    }
}

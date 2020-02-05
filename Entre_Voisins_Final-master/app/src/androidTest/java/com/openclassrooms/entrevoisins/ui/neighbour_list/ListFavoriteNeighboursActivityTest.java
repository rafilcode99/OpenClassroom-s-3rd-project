package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.entrevoisins.utils.RecyclerViewItemCountAssertion.withItemCount;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ListFavoriteNeighboursActivityTest {
    private NeighbourApiService mNeighbourApiService;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule = new ActivityTestRule<>(ListNeighbourActivity.class);


    @Before
    public void setUP(){
        mNeighbourApiService = DI.getNeighbourApiService();
        if (!mNeighbourApiService.getFavoriteNeighboursList().contains(mNeighbourApiService.getNeighbours().get(0))){
            mNeighbourApiService.addToNeighbourFavoriteList(mNeighbourApiService.getNeighbours().get(0).getId());
        }



    }
    @Test
    public void checkIfFavoriteFragmentDisplaysFavoriteNeighboursOnly() {
        onView(
                allOf(withId(R.id.container),isDisplayed())).perform(swipeLeft());

        onView((ViewMatchers.withId(R.id.list_favorite_neighbours))).check(withItemCount(mNeighbourApiService.getFavoriteNeighboursList().size()));
        onView(allOf(withId(R.id.item_list_name), isDisplayed())).check(matches(withText(mNeighbourApiService.getNeighbours().get(0).getName())));


    }




}




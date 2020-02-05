package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.test.espresso.intent.Intents;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.openclassrooms.entrevoisins.DetailsActivity;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNull.notNullValue;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;



@LargeTest
@RunWith(AndroidJUnit4.class)
public class DetailsActivityTest {
    private ListNeighbourActivity mActivity;
    private NeighbourApiService mNeighbourApiService;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule = new ActivityTestRule<>(ListNeighbourActivity.class);

    @Before
    public void setUp() {
        mActivity = mActivityTestRule.getActivity();
        assertThat(mActivity, notNullValue());
        mNeighbourApiService = DI.getNeighbourApiService();
        assertThat(mNeighbourApiService, notNullValue());
    }


    @Test
    public void checkIfDetailsActivityIsLaunched() {
        Intents.init();
        onView((withId(R.id.list_neighbours)))
        .perform(actionOnItemAtPosition(0, click()));
        intended(hasComponent(DetailsActivity.class.getName()));

    }
    @Test
    public void checkIfNeighbourNameIsFilled() {
        onView((withId(R.id.list_neighbours)))
                .perform(actionOnItemAtPosition(0, click()));

        onView(withId(R.id.Name_txt)).check(matches(withText(mNeighbourApiService.getNeighbours().get(0).getName())));
    }
}

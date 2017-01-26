package com.example.tony.name_app.Activities;

import android.content.Intent;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.tony.name_app.GameEngine;
import com.example.tony.name_app.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.EditText;

import static android.R.id.list;
import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;

/**
 * Created by kimhe on 25.01.2017.
 */
@RunWith(AndroidJUnit4.class)
public class LearningModeTest {
    LearningMode n;
    GameEngine e;
    @Rule
    public final ActivityTestRule<LearningMode> mActivityRule =
            new ActivityTestRule<>(LearningMode.class, true, false);

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Before
    public void instance(){

         n = new LearningMode();
         e = new GameEngine(n);
    }


    @Test
    public void checkActivity(){

        mActivityRule.launchActivity(null);


        onView(withId(R.id.answer)).perform(click()).
                perform(typeText("toni"));

        onView(withId(R.id.sendAnswer)).perform(click());

        onView(withId(R.id.answer)).perform(click()).
                perform(replaceText(""));

        onView(withId(R.id.sendAnswer)).perform(click());

        onView(withId(R.id.answer)).perform(click()).
                perform(replaceText("1414"));

        onView(withId(R.id.sendAnswer)).perform(click());

    }
}

package sistemas.jd.gok.challenge.screen.home


import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import sistemas.jd.gok.challenge.base.BaseTest
import sistemas.jd.gok.challenge.ui.activities.MainActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import sistemas.jd.gok.challenge.R

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest : BaseTest() {

    @get:Rule
    val mainActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun whenActivityIsLaunched_shouldDisplayInitial() {
        Thread.sleep(1000)
        onView(withId(R.id.title)).waitUntilVisible(1000).check(matches(isDisplayed()))
        onView(withId(R.id.imageView)).waitUntilVisible(1000).check(matches(isDisplayed()))
        onView(withId(R.id.viewPagerSpotligth)).waitUntilVisible(1000).check(matches(isDisplayed()))
        onView(withId(R.id.cashFragment)).waitUntilVisible(1000).check(matches(isDisplayed()))
        onView(withId(R.id.productFragment)).waitUntilVisible(1000).check(matches(isDisplayed()))
    }
}
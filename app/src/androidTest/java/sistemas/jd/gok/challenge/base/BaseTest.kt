package sistemas.jd.gok.challenge.base

import android.content.res.Resources
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import java.util.concurrent.TimeoutException

open class BaseTest {

    fun ViewInteraction.waitUntilVisible(timeout: Long): ViewInteraction {
        val startTime = System.currentTimeMillis()
        val endTime = startTime + timeout
        do {
            try {
                check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                return this
            } catch (e: NoMatchingViewException) {
                Thread.sleep(5000)
            }
        } while (System.currentTimeMillis() < endTime)
        throw TimeoutException()
    }

    open fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher? {
        return RecyclerViewMatcher(recyclerViewId)
    }

    class RecyclerViewMatcher(val mRecyclerViewId: Int) {
        fun atPosition(position: Int): Any {
            return atPositionOnView(position, -1)
        }

        fun atPositionOnView(
            position: Int,
            targetViewId: Int
        ): Any {
            return object : TypeSafeMatcher<View?>() {
                var resources: Resources? = null
                var childView: View? = null
                override fun describeTo(description: Description) {
                    val id = if (targetViewId == -1) mRecyclerViewId else targetViewId
                    var idDescription = Integer.toString(id)
                    if (resources != null) {
                        idDescription = try {
                            resources!!.getResourceName(id)
                        } catch (var4: Resources.NotFoundException) {
                            String.format("%s (resource name not found)", id)
                        }
                    }
                    description.appendText("with id: $idDescription")
                }

                override fun matchesSafely(view: View?): Boolean {
                    resources = view?.resources
                    if (childView == null) {
                        val recyclerView =
                            view?.rootView?.findViewById<View>(mRecyclerViewId) as RecyclerView
                        childView = if (recyclerView != null) {
                            recyclerView.findViewHolderForAdapterPosition(position)!!.itemView
                        } else {
                            return false
                        }
                    }
                    return if (targetViewId == -1) {
                        view === childView
                    } else {
                        val targetView =
                            childView!!.findViewById<View>(targetViewId)
                        view === targetView
                    }
                }
            }
        }

    }
}
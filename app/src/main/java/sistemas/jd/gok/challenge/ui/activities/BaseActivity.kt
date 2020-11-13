package sistemas.jd.gok.challenge.ui.activities

import androidx.annotation.IdRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.jetbrains.annotations.NotNull

open class BaseActivity: AppCompatActivity() {

    protected fun addFragment(@IdRes containerViewId: Int,
                              @NotNull fragment: Fragment,
                              @NotNull fragmentTag: String) {

        supportFragmentManager
            .beginTransaction()
            .add(containerViewId, fragment, fragmentTag)
            .disallowAddToBackStack()
            .commit()
    }

    protected fun replaceFragment(@IdRes containerViewId: Int,
                                  @NotNull fragment: Fragment,
                                  @NotNull fragmentTag: String,
                                  @Nullable backStackStateName: String) {

        supportFragmentManager
            .beginTransaction()
            .replace(containerViewId, fragment, fragmentTag)
            .addToBackStack(backStackStateName)
            .commit()
    }

    protected fun hideActionBar() {
        supportActionBar?.hide();
    }
}
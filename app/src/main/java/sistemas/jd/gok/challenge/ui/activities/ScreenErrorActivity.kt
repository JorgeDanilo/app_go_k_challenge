package sistemas.jd.gok.challenge.ui.activities

import android.os.Bundle
import sistemas.jd.gok.challenge.R
import sistemas.jd.gok.challenge.ui.fragments.ScreenErrorFragment

class ScreenErrorActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_error)
        hideActionBar()
        showErrorFragmentScreen()
    }

    private fun showErrorFragmentScreen() {
        val screenError =
            ScreenErrorFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.errorFragment, screenError, "screenError")
            .addToBackStack(null)
            .commit()
    }
}
package sistemas.jd.gok.challenge.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import sistemas.jd.gok.challenge.R

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        hideActionBar()
        val handler = Handler()
        handler.postDelayed(Runnable { showActivity() }, 2000)
    }

    private fun showActivity() {
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left)
        finish()
    }
}
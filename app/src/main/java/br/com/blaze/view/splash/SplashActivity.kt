package br.com.blaze.view.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.blaze.R
import br.com.blaze.view.welcome.WelcomeActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onStart() {
        super.onStart()
        animateSplash()

        setSplashHandler()
    }

    fun animateSplash(){
        blaze_logo.animate().alpha(1F).translationY(-70F).setDuration(500)
        blaze_title.animate().alpha(1F).setDuration(500)
    }

    fun setSplashHandler(){
        Handler().postDelayed({

            startActivity(WelcomeActivity.newInstance(this))
            //finish this activity
            finish()
        },3000)
    }

}
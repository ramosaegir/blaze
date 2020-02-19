package br.com.blaze.view.splash

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.blaze.R
import br.com.blaze.constants.PreferenceKeys
import br.com.blaze.util.SharedPreferencesHelper
import br.com.blaze.view.welcome.WelcomeActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    private val sharedPreferencesHelper = SharedPreferencesHelper()

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

            isFirstAccess()

            startActivity(WelcomeActivity.newInstance(this))
            //finish this activity
            finish()
        },3000)
    }

    fun isFirstAccess(){
        if(sharedPreferencesHelper.getFirstAccess()){
            callWelcome()
        }else{
            callAuthentication()
        }
    }

    fun callWelcome(){
        startActivity(WelcomeActivity.newInstance(this))
    }

    fun callAuthentication(){
        print("Authentication triggered")
    }

}
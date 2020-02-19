package br.com.blaze.view.welcome

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import br.com.blaze.R

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

    companion object{

        fun newInstance(context: Context) : Intent {
            return Intent(context, WelcomeActivity::class.java)
        }
    }
}

package br.com.blaze.view.authentication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.blaze.R

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(R.id.frame_layout, StartAuthFragment.newInstance())
        transaction.commit()

    }

    companion object {
        fun newInstance(context: Context): Intent = Intent(context, AuthActivity::class.java)
    }
}

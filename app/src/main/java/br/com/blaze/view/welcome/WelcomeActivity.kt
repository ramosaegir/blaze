package br.com.blaze.view.welcome

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import br.com.blaze.R
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        var delay = DELAY_MILISECONDS
        val labelList: List<View> =
            listOf(label_1, label_2, label_3, label_4, proceedButton)

        labelList.map { view ->
            setAlphaHandler(delay, view)
            delay += DELAY_MILISECONDS
        }
    }

    private fun setAlphaHandler(delay: Long, view: View){
        Handler().postDelayed({
            view.animate().alpha(1F).duration = 500
        },delay)
    }

    companion object{
        fun newInstance(context: Context) : Intent {
            return Intent(context, WelcomeActivity::class.java)
        }
        private const val DELAY_MILISECONDS: Long = 1000
    }
}

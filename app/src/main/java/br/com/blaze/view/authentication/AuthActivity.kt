package br.com.blaze.view.authentication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import br.com.blaze.R
import br.com.blaze.base.BaseActivity
import kotlinx.android.synthetic.main.activity_auth.*
import java.util.*

class AuthActivity : BaseActivity() {

    lateinit var sliderAdapter: AuthSliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        initUi()

    }

    private fun initUi() {

        val sliderTitles = resources.getStringArray(R.array.auth_slider_titles)
        val sliderSubtitles = resources.getStringArray(R.array.auth_slider_subtitles)

        sliderAdapter = AuthSliderAdapter(
            context = this,
            titles = sliderTitles,
            subtitles = sliderSubtitles
        )
        slider_tips.adapter = sliderAdapter
        indicator.setupWithViewPager(slider_tips, true)

        val timer = Timer()
        timer.scheduleAtFixedRate(SliderTimer(this, slider_tips, sliderTitles),
            SLIDER_DELAY, SLIDER_PERIOD)

    }

    private class SliderTimer(
        private val activity: AuthActivity,
        private val slider: ViewPager,
        private val titles: Array<String>) : TimerTask() {
        override fun run() {
            activity.runOnUiThread {
                if (slider.currentItem < titles.size - 1) {
                    slider.currentItem = slider.currentItem + 1
                } else {
                    slider.currentItem = 0
                }
            }
        }
    }

    companion object {
        fun newInstance(context: Context): Intent = Intent(context, AuthActivity::class.java)
        private const val SLIDER_DELAY: Long = 3000
        private const val SLIDER_PERIOD: Long = 4000
    }
}

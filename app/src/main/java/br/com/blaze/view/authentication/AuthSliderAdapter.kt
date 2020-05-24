package br.com.blaze.view.authentication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import br.com.blaze.R

class AuthSliderAdapter(val context: Context,
                        private val titles: Array<String>,
                        private val subtitles: Array<String>): PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun getCount(): Int {
        return titles.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val titulo: TextView
        val texto: TextView

        val inflater = context
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView: View = inflater.inflate(
            R.layout.viewpagerwelcome_item, container,
            false
        )

        titulo = itemView.findViewById<View>(R.id.tituloWelcome) as TextView
        texto = itemView.findViewById<View>(R.id.textoWelcome) as TextView

        titulo.text = titles[position]
        texto.text = subtitles[position]

        (container as ViewPager).addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        (container as ViewPager).removeView(`object` as LinearLayout)
    }
}
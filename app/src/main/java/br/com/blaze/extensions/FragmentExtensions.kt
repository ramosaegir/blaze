package br.com.blaze.extensions

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun FragmentManager.replaceFragment(fragment: Fragment, @IdRes layout: Int){
    this.beginTransaction()
        .replace(layout, fragment)
        .commitAllowingStateLoss()
}

fun <T : Fragment> T.putArgs(bundle: Bundle.() -> Unit) = apply { arguments = Bundle().apply(bundle) }

fun FragmentManager.removeFragment(fragment: Fragment){
    this.beginTransaction()
        .remove(fragment)
        .commit()
}

//fun Fragment.notImplementedYet() {
//    this.activity?.error(R.string.function_not_implemented_yet)
//}

fun Fragment.replaceFragmentAndSetBackStack(
    @IdRes containerLayout: Int,
    fragment: Fragment
) {
    val fragmentTransaction  = this.fragmentManager?.beginTransaction()
    fragmentTransaction?.addToBackStack(null)
    fragmentTransaction?.setCustomAnimations(
        android.R.animator.fade_in, android.R.animator.fade_out,
        android.R.anim.slide_in_left, android.R.anim.slide_out_right)
    fragmentTransaction?.replace(containerLayout,fragment)
    fragmentTransaction?.commit()
}

fun Fragment.backStack(){
    this.fragmentManager?.popBackStackImmediate()
}
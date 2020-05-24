package br.com.blaze.base

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {

    protected fun startFragment(
        @IdRes frameContainerId: Int,
        fragment: BaseFragment
    ) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(frameContainerId,fragment)
        transaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()



    }

}
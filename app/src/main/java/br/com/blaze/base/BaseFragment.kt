package br.com.blaze.base

import androidx.fragment.app.Fragment

open class BaseFragment: Fragment() {

    protected var isTransactionSafe = false

    protected open fun replaceFragment(containerId: Int, fragment: BaseFragment, popCurrentFragment: Boolean = false) {
        fragmentManager?.let { manager ->
            if (popCurrentFragment && manager.backStackEntryCount > 0) {
                manager.popBackStack()
            }

            manager.beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss()
        }
    }

    protected fun validateSafeTransactionAndCall(transaction: (() -> Unit)?) {
        if(isTransactionSafe) {
            transaction?.invoke()
        }
    }

}
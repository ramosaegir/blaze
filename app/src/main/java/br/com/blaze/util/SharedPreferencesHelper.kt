package br.com.blaze.util

import android.content.SharedPreferences
import androidx.core.content.edit
import br.com.blaze.constants.PreferenceKeys
import br.com.blaze.view.welcome.WelcomeActivity

class SharedPreferencesHelper {

    lateinit var prefs: SharedPreferences

    fun getFirstAccess(): Boolean = prefs.getBoolean(PreferenceKeys.PREFS_IS_FIRST_ACCESS, true)

}
package kr.co.hanbit.sharedpreferences

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class SettingFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(saveInstanceState: Bundle?, rootkey: String?) {
        addPreferencesFromResource(R.xml.preferences)
    }
}
package fi.viware.aoc2024.day2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fi.viware.aoc2024.day2.ui.main.MainFragment

// Fragment Viewmodel
class MainActivity : AppCompatActivity() {

    // Fragment Viemodel template used
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}
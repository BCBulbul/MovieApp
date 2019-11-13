package burakcanbulbul.com.movieapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import burakcanbulbul.com.movieapp.R
import burakcanbulbul.com.movieapp.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
    }

    override fun getLayoutRes(): Int = R.layout.activity_main
}

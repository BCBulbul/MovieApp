package burakcanbulbul

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.multidex.MultiDex
import burakcanbulbul.com.movieapp.di.component.DaggerApplicationComponent
import dagger.android.*
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainApplication : DaggerApplication(), HasFragmentInjector, HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.builder().create(this@MainApplication)
    }


    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityInjector
    }


}
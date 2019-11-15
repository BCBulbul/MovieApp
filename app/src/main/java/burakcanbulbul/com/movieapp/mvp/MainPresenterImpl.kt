package burakcanbulbul.com.movieapp.mvp

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

abstract class MainPresenterImpl<Any>(): MainPresenterView, LifecycleObserver {

    private lateinit var mainPresenterView : MainPresenterView

    constructor(mainPresenterView: MainPresenterView) : this() {
        this.mainPresenterView = mainPresenterView
        (this.mainPresenterView as LifecycleOwner).lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    override fun onStart() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    override fun onResume() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    override fun onDestroy() {
        getLifeCycle().removeObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    override fun onPause() {

    }

    fun getLifeCycle(): Lifecycle {
        return (this.mainPresenterView as LifecycleOwner).lifecycle
    }


}
package burakcanbulbul.com.movieapp.di.component

import burakcanbulbul.MainApplication
import burakcanbulbul.com.movieapp.di.module.*
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [ApplicationModule::class, AndroidSupportInjectionModule :: class,
    ActivityBindingModule :: class, FragmentBindingModule :: class, DataSourceModule :: class,
    GsonModule::class, SerializerModule::class
])
interface ApplicationComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MainApplication>()

}
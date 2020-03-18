package ir.arashjahani.themovieapp

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ir.arashjahani.themovieapp.di.DaggerApplicationComponent
import ir.arashjahani.themovieapp.utils.ActivitiesLifecycleListener
import javax.inject.Inject

/**
 * Created By ArashJahani on 2020/03/12
 */
class MovieApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(ActivitiesLifecycleListener())

        DaggerApplicationComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

}
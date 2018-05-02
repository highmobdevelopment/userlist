package erevacation.com.userlist

import android.app.Activity
import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import erevacation.com.userlist.injection.DaggerAppComponent
import javax.inject.Inject
//import erevacation.com.userlist.injection.DaggerAppComponent

class MainActivity : Application(), HasActivityInjector {

    private val TAG: String = MainActivity::class.java.simpleName


    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)

    }


    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}

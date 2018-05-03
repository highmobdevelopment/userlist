package erevacation.com.userlist.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import erevacation.com.userlist.MainActivity
import erevacation.com.userlist.injection.builders.ActivityBuilder
import erevacation.com.userlist.injection.modules.AppModule
import erevacation.com.userlist.injection.modules.NetModule


@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (NetModule::class), (ActivityBuilder::class)])

interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: MainActivity)
}

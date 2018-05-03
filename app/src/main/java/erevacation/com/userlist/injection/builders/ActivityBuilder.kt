package erevacation.com.userlist.injection.builders

import dagger.Module
import dagger.android.ContributesAndroidInjector
import erevacation.com.userlist.injection.provider.FragmentProvider
import erevacation.com.userlist.ui.homescreen.HomeActivity
import erevacation.com.userlist.ui.homescreen.HomeActivityModule

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(HomeActivityModule::class), (FragmentProvider::class)])
    internal abstract fun bindHomeActivity(): HomeActivity

}
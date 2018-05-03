package erevacation.com.userlist.injection.provider

import dagger.Module
import dagger.android.ContributesAndroidInjector
import erevacation.com.userlist.ui.homescreen.list.ListFragment
import erevacation.com.userlist.ui.homescreen.list.ListFragmentModule

@Module
abstract class FragmentProvider {

    @ContributesAndroidInjector(modules = [(ListFragmentModule::class)])
    abstract fun provideListFragmentFactory(): ListFragment

}
package hackyeah.hackyeahlotto.injection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hackyeah.hackyeahlotto.HelloActivity
import hackyeah.hackyeahlotto.StateActivity
import hackyeah.hackyeahlotto.StateModule

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(DataModule::class)])
    abstract fun getHelloActivity(): HelloActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [(DataModule::class), (StateModule::class)])
    abstract fun getStateActivity(): StateActivity

}
package hackyeah.hackyeahlotto.injection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import hackyeah.hackyeahlotto.HelloActivity

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(DataModule::class)])
    abstract fun getHelloActivity(): HelloActivity

}
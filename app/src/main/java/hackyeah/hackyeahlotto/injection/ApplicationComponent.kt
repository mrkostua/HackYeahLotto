package hackyeah.hackyeahlotto.injection

import android.app.Application

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(ApplicationModule::class),
    (AndroidSupportInjectionModule::class),
    (ActivityBindingModule::class)])
interface ApplicationComponent : AndroidInjector<LottoApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): ApplicationComponent.Builder

        fun build(): ApplicationComponent
    }
}
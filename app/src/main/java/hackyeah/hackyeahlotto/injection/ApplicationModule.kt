package hackyeah.hackyeahlotto.injection

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module



@Module
abstract class ApplicationModule {
    @Binds
    abstract fun provideAppContext(app: Application): Context

}
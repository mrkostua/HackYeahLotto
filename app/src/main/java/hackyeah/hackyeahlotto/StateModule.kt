package hackyeah.hackyeahlotto

import dagger.Module
import dagger.Provides
import hackyeah.hackyeahlotto.db.DbHelper
import hackyeah.hackyeahlotto.injection.ActivityScope

/**
 * @author Kostiantyn Prysiazhnyi on 11/25/2018.
 */
@Module
class StateModule {
    @ActivityScope
    @Provides
    fun provideStateViewModel(dbHelper: DbHelper) = StateViewModel(dbHelper)
}
package hackyeah.hackyeahlotto.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import hackyeah.hackyeahlotto.db.DbHelper
import hackyeah.hackyeahlotto.db.LocalDB


@Module
class DataModule {
    @Provides
    fun provideDBHelper(context: Context): DbHelper = DbHelper(LocalDB.getInstance(context))
}
package hackyeah.hackyeahlotto.injection

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * @author Kostiantyn Prysiazhnyi on 11/24/2018.
 */
class LottoApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerApplicationComponent.builder().application(this).build()
}
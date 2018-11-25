package hackyeah.hackyeahlotto.db

import android.arch.persistence.room.*
import android.content.Context


@Database(entities = [(GPSDDo::class)], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class LocalDB : RoomDatabase() {
    abstract fun gpsDao() : GpsDao

    companion object {
        @Volatile
        private var instance: LocalDB? = null

        fun getInstance(context: Context): LocalDB {
            val inst = instance
            if (inst != null) {
                return inst
            } else {
                return synchronized(this) {
                    val inst2 = instance
                    if (inst2 != null) {
                        inst2
                    } else {
                        val created = Room.databaseBuilder(
                            context.applicationContext,
                            LocalDB::class.java, "LottoActive.db"
                        )
                            .build()
                        instance = created
                        created
                    }
                }
            }
        }
    }
}
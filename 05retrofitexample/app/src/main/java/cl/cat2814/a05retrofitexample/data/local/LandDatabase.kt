package cl.cat2814.a05retrofitexample.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LandEntity::class], version = 1)
abstract class LandDatabase : RoomDatabase() {

    abstract fun getLandsDao(): LandDao

    companion object {
        @Volatile
        private var INSTANCE: LandDatabase? = null

        fun getDatabase(context: Context): LandDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LandDatabase::class.java,
                    "land_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}
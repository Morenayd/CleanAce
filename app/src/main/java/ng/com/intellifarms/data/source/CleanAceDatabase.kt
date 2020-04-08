package ng.com.intellifarms.data.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ng.com.intellifarms.SignInResponse

@Database(entities = [SignInResponse::class], exportSchema = false, version = 1)
abstract class CleanAceDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: CleanAceDatabase? = null

        fun getDatabase(context: Context): CleanAceDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CleanAceDatabase::class.java,
                    "crypto_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
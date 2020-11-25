package com.webspider.webspidertest.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.webspider.webspidertest.model.UserEntity
import com.webspider.webspidertest.room.Dao.UsersDao


@Database(entities = [(UserEntity::class)], version = 3, exportSchema = false )
abstract class AppDatabase : RoomDatabase(){

    abstract fun UserDao(): UsersDao




    companion object {

        /**
         * The only instance
         */
        private var sInstance: AppDatabase? = null

        /**
         * Gets the singleton instance of SampleDatabase.
         *
         * @param context The context.
         * @return The singleton instance of SampleDatabase.
         */
        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (sInstance == null) {
                sInstance = Room
                    .databaseBuilder(context.applicationContext, AppDatabase::class.java, "userdb")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return sInstance!!
        }
    }

}
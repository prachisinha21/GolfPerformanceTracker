package com.prachisinha.golfperformancetracker.di

import android.content.Context
import androidx.room.Room
import com.prachisinha.golfperformancetracker.data.local.dao.PlayerDao
import com.prachisinha.golfperformancetracker.data.local.dao.ShotDao
import com.prachisinha.golfperformancetracker.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "golf_tracker_database"
        ).build()
    }

    @Provides
    fun providePlayerDao(
        database: AppDatabase
    ): PlayerDao {
        return database.playerDao()
    }

    @Provides
    fun provideShotDao(
        database: AppDatabase
    ): ShotDao {
        return database.shotDao()
    }
}
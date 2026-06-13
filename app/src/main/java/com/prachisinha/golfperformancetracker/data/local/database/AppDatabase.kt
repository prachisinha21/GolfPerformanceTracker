package com.prachisinha.golfperformancetracker.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prachisinha.golfperformancetracker.data.local.dao.PlayerDao
import com.prachisinha.golfperformancetracker.data.local.dao.ShotDao
import com.prachisinha.golfperformancetracker.data.local.entity.PlayerEntity
import com.prachisinha.golfperformancetracker.data.local.entity.ShotEntity

@Database( entities = [PlayerEntity::class, ShotEntity::class],
version = 1,
exportSchema = false)

abstract class AppDatabase : RoomDatabase() {
    abstract fun playerDao(): PlayerDao
    abstract fun shotDao(): ShotDao
}
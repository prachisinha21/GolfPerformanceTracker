package com.prachisinha.golfperformancetracker.di

import com.prachisinha.golfperformancetracker.data.repository.GolfRepositoryImpl
import com.prachisinha.golfperformancetracker.domain.repository.GolfRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindGolfRepository(
        golfRepositoryImpl: GolfRepositoryImpl
    ): GolfRepository
}
package com.meokq.di

import com.meokq.data.datasource.auth.AuthDataSource
import com.meokq.data.datasource.auth.AuthDataSourceImpl
import com.meokq.data.repositories.AuthRepositoryImpl
import com.meokq.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun bindAuthDataSource(
        source: AuthDataSourceImpl
    ): AuthDataSource

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        repository: AuthRepositoryImpl
    ): AuthRepository
}

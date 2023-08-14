package com.meokq.data.repositories

import com.meokq.data.datasource.auth.AuthDataSource
import com.meokq.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val authDataSource: AuthDataSource) : AuthRepository {
    override fun getCurrentUserId(): String {
        return authDataSource.getCurrentUserId()
    }
}
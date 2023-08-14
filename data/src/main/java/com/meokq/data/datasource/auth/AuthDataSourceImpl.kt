package com.meokq.data.datasource.auth

import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor() : AuthDataSource {
    override fun getCurrentUserId(): String {
        return "test"
    }
}
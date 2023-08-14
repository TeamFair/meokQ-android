package com.meokq.data.datasource.auth

interface AuthDataSource {
    fun getCurrentUserId() : String
}
package com.meokq.domain.repository

interface AuthRepository {
    fun getCurrentUserId() : String
}
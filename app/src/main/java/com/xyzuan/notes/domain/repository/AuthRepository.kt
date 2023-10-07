package com.xyzuan.notes.domain.repository

import com.xyzuan.notes.data.remote.dto.SignInDto
import com.xyzuan.notes.data.remote.dto.RegisterDto
import com.xyzuan.notes.domain.model.AuthModel
import retrofit2.Response

interface AuthRepository {
    suspend fun signIn(body: SignInDto): Response<AuthModel>? = null
    suspend fun signUp(body: RegisterDto): Response<AuthModel>? = null
}
package com.xyzuan.notes.data.remote

import com.xyzuan.notes.data.remote.dto.RegisterDto
import com.xyzuan.notes.data.remote.dto.SignInDto
import com.xyzuan.notes.domain.model.AuthModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("/api/register")
    suspend fun register(@Body body: RegisterDto): Response<AuthModel>

    @POST("/api/login")
    suspend fun login(@Body body: SignInDto): Response<AuthModel>
}
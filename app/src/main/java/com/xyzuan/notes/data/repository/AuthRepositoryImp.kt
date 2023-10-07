package com.xyzuan.notes.data.repository

import com.xyzuan.notes.data.remote.UserApi
import com.xyzuan.notes.data.remote.dto.SignInDto
import com.xyzuan.notes.data.remote.dto.RegisterDto
import com.xyzuan.notes.domain.model.AuthModel
import com.xyzuan.notes.domain.repository.AuthRepository
import retrofit2.Response
import javax.inject.Inject

class AuthRepositoryImp @Inject constructor(private val api: UserApi) : AuthRepository {
    override suspend fun signIn(body: SignInDto): Response<AuthModel> {
        return api.login(body)
    }

    override suspend fun signUp(body: RegisterDto): Response<AuthModel> {
        return api.register(body)
    }
}
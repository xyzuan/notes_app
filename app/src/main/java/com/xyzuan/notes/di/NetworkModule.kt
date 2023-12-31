package com.xyzuan.notes.di

import com.xyzuan.notes.common.Constants
import com.xyzuan.notes.data.remote.AuthInterceptor
import com.xyzuan.notes.data.remote.NotesApi
import com.xyzuan.notes.data.remote.UserApi
import com.xyzuan.notes.data.repository.AuthRepositoryImp
import com.xyzuan.notes.data.repository.NotesRepositoryImp
import com.xyzuan.notes.domain.repository.AuthRepository
import com.xyzuan.notes.domain.repository.NotesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(authInterceptor).build()
    }

    @Provides
    @Singleton
    fun providesUserApi(retrofitBuilder: Retrofit.Builder): UserApi {
        return retrofitBuilder.build().create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun providesNotesApi(retrofitBuilder: Builder, okHttpClient: OkHttpClient): NotesApi {
        return retrofitBuilder.client(okHttpClient).build().create(NotesApi::class.java)
    }


    @Provides
    @Singleton
    fun providesAuthRepository(api: UserApi): AuthRepository {
        return AuthRepositoryImp(api)
    }

    @Provides
    @Singleton
    fun providesNotesRepository(api: NotesApi): NotesRepository {
        return NotesRepositoryImp(api)
    }
}
package com.xyzuan.notes.presentation.screens.sign_in

import com.xyzuan.notes.domain.model.AuthModel

data class SignInState(
    val isLoading: Boolean = false,
    val data: AuthModel? = null,
    val errorMessage: String? = null
)
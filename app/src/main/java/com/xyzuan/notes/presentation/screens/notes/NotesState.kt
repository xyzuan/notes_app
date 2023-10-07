package com.xyzuan.notes.presentation.screens.notes

import com.xyzuan.notes.domain.model.Note

data class NotesState(
    val isLoading: Boolean = false,
    val data: List<Note>? = null,
    val errorMessage: String? = null
)
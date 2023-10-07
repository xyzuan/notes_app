package com.xyzuan.notes.presentation.screens.note_viewer

import com.xyzuan.notes.domain.model.NoteModel

data class NoteViewerState(
    val isLoading: Boolean = false,
    val data: NoteModel? = null,
    val errorMessage: String? = null
)
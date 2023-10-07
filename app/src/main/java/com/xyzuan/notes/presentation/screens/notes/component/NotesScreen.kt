package com.xyzuan.notes.presentation.screens.notes.component


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.hilt.navigation.compose.hiltViewModel
import com.xyzuan.notes.domain.model.Note
import com.xyzuan.notes.presentation.common.component.Toast
import com.xyzuan.notes.presentation.screens.notes.NotesState
import com.xyzuan.notes.presentation.screens.notes.NotesViewModel

@Composable
fun NotesScreen(
    viewModel: NotesViewModel = hiltViewModel(),
    agendaView: Boolean,
    toolbarOffsetHeightPx: MutableState<Float>,
    onItemClick: (Note) -> Unit
) {

    LaunchedEffect(Unit) {
        viewModel.getNotes()
    }

    val state: State<NotesState> = viewModel.state
    val notes: List<Note>? = state.value.data

    if (!state.value.errorMessage.isNullOrEmpty()) {
        Toast(message = state.value.errorMessage ?: "Something went wrong")
    }

    if (state.value.isLoading) {
        DefaultContent()
    } else if (!notes.isNullOrEmpty()) {
        NotesList(
            notes = notes,
            agendaView,
            toolbarOffsetHeightPx = toolbarOffsetHeightPx
        ) { clickedNote ->
            onItemClick(clickedNote)
        }
    } else {
        DefaultContent()
    }
}
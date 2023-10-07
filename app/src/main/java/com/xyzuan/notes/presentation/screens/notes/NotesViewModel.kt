package com.xyzuan.notes.presentation.screens.notes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xyzuan.notes.common.NetworkResponse
import com.xyzuan.notes.common.Preferences
import com.xyzuan.notes.domain.use_case.notes.NotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val notesUseCase: NotesUseCase,
    private val preferences: Preferences
) : ViewModel() {

    private val _state = mutableStateOf(NotesState())
    val state: State<NotesState> = _state


    fun getNotes() {
        notesUseCase.invoke().onEach { result ->
            when (result) {
                is NetworkResponse.Loading -> {
                    _state.value = NotesState(isLoading = true)
                }

                is NetworkResponse.Success -> {
                    _state.value = NotesState(data = result.data)
                }

                is NetworkResponse.Error -> {
                    _state.value = NotesState(errorMessage = result.message)
                }
            }
        }.launchIn(viewModelScope)

    }

}
package com.xyzuan.notes.presentation.graphs.notes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.xyzuan.notes.domain.model.Note
import com.xyzuan.notes.presentation.graphs.Graph
import com.xyzuan.notes.presentation.screens.note_viewer.component.NoteViewerScreen
import com.xyzuan.notes.presentation.screens.notes.component.NotesHomeScreen


fun NavGraphBuilder.notesNavGraph(navHostController: NavHostController) {
    var noteData: Note? = null
    navigation(
        startDestination = NotesRoutes.NotesScreen.route,
        route = Graph.NOTE
    ) {

        composable(NotesRoutes.NotesScreen.route) {
            NotesHomeScreen(onNoteClick = { note ->
                noteData = note
                navHostController.navigate(NotesRoutes.NoteViewerScreen.route)
            }, onNewNoteClick = {
                noteData = null
                navHostController.navigate(NotesRoutes.NoteViewerScreen.route)
            })
        }
        composable(NotesRoutes.NoteViewerScreen.route) {
            NoteViewerScreen(note = noteData, onBackPress = {
                navHostController.popBackStack()
            })
        }

    }
}
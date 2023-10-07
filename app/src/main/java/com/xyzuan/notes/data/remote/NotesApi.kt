package com.xyzuan.notes.data.remote

import com.xyzuan.notes.data.remote.dto.*
import com.xyzuan.notes.domain.model.Note
import com.xyzuan.notes.domain.model.NoteModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface NotesApi {
    @POST("/api/notes")
    suspend fun createNote(@Body body: CreateNoteDto): Response<NoteModel>

    @GET("/api/notes")
    suspend fun getNotes(): Response<List<Note>>

    @PUT("/api/notes/{noteId}")
    suspend fun updateNote(@Path("noteId")noteId:String,@Body body: UpdateNoteDto): Response<NoteModel>

    @DELETE("/api/notes/{noteId}")
    suspend fun deleteNote(@Path("noteId")noteId:String): Response<NoteModel>
}
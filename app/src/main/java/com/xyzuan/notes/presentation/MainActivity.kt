package com.xyzuan.notes.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.xyzuan.notes.presentation.graphs.RootNavigationGraph
import com.xyzuan.notes.presentation.theme.NotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //root graph
                    SetRootNavigationGraph()
                }
            }
        }
    }

    @Composable
    private fun SetRootNavigationGraph() {
        val navController = rememberNavController()
        val context = LocalContext.current
        RootNavigationGraph(navHostController = navController, context = context)
        
    }
}


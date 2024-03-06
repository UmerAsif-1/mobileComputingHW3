package com.example.composetutorial

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composetutorial.data.UserViewModel
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

@Composable
fun Conversation(navController: NavHostController, userViewModel: UserViewModel) {
    // Get first name and last name from UserViewModel
    val firstName = userViewModel.getFirstName().value ?: ""
    val lastName = userViewModel.getLastName().value ?: ""

    // LazyColumn to display messages
    LazyColumn {
        items(SampleData.conversationSample) { message ->
            // Pass firstName, lastName, and message.body to MessageCard
            MessageCard(firstName, lastName, message.body, navController)
        }
    }

    // Button to go to Second View
    Button(
        onClick = {
            navController.navigate("secondView")
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Insert Your Name")
    }
}

data class Message(val body: String)

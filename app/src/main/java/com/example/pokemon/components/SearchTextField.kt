package com.example.pokemon.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(text: String, onValueChanged: (String) -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp), contentAlignment = Alignment.Center)
     {
         TextField(
             value = text,
             onValueChange = { onValueChanged(it) },
             modifier = Modifier.fillMaxWidth(),
             shape = RoundedCornerShape(30.dp),
             leadingIcon = {Icon(Icons.Default.Search, contentDescription = "Search")},
             label = { Text("Search ...") },
             colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                 unfocusedIndicatorColor = Color.Transparent,
                 containerColor = Color(0xffC6AEC7)

             )
         )
    }
}
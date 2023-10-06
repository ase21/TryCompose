package com.asefactory.trycompose.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Greetings(name: String) {

    val isExpanded = remember {
        mutableStateOf(false)
    }

    val extraPadding = if (isExpanded.value) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier.weight(1f).padding(bottom = extraPadding)) {
                Text(text = "Hello,")
                Text(text = name)
            }
            ElevatedButton(onClick = {
                isExpanded.value = !isExpanded.value
            }) {
                Text(text = if(isExpanded.value) "Some less" else "Some more")
            }
        }
    }
}

@Preview
@Composable
fun GreetingsPreview(){
    Greetings(name = "Some text")
}
package com.example.hellocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hellocompose.ui.theme.HelloComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HelloComposeApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun HelloComposeApp(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("Студент") }

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            text = "Привіт, $name!",
            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            onClick = { name = "Світ" },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Натисни мене")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HelloComposePreview() {
    HelloComposeTheme {
        HelloComposeApp()
    }
}
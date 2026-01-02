package com.alorma.fireandforget.shared

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() {
  MaterialTheme {
    val runner = InMemoryFireAndForgetRunner()

    val fireOne = FireOne(runner)
    val fireTwo = FireTwo(runner)

    Scaffold { paddingValues ->
      Column(
        modifier = Modifier.padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(16.dp),
      ) {
        Text(text = "Fire one: ${fireOne.isEnabled()}")
        Text(text = "Fire two: ${fireTwo.isEnabled()}")
      }
    }
  }
}

package uk.ac.tees.w9601166.careercatalyst.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.ac.tees.w9601166.careercatalyst.ui.navigation.ChatNavigation
import uk.ac.tees.w9601166.careercatalyst.ui.ui.theme.JetChatAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatApp()
        }
    }
}

@Composable
fun ChatApp() {
    JetChatAppComposeTheme {
        ChatNavigation()
    }
}
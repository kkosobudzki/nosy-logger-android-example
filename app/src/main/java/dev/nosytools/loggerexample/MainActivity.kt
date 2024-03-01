package dev.nosytools.loggerexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.nosytools.loggerexample.ui.theme.NosyLoggerExampleTheme

class MainActivity : ComponentActivity() {

    private val logger by lazy { (application as LoggerExampleApp).logger }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NosyLoggerExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ReportLogs(onLog = { message -> })
                }
            }
        }
    }
}

@Composable
fun ReportLogs(onLog: (String) -> Unit) {
    var text by remember {
        mutableStateOf("")
    }

    Column {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("What would you like to log?") }
        )

        Button(onClick = { /*TODO*/ }) {
            Text("log as debug")
        }

        FilledTonalButton(onClick = { /*TODO*/ }) {
            Text("log as info")
        }

        OutlinedButton(onClick = { /*TODO*/ }) {
            Text("log as warning")
        }

        ElevatedButton(onClick = { /*TODO*/ }) {
            Text("log as error")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReportLogsPreview() {
    NosyLoggerExampleTheme {
        ReportLogs(onLog = { })
    }
}
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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ReportLogs(onLog = ::log)
                }
            }
        }
    }

    private fun log(message: String, level: Level) {
        when (level) {
            Level.Debug -> logger.debug(message)
            Level.Info -> logger.info(message)
            Level.Warning -> logger.warning(message)
            Level.Error -> logger.error(message)
        }
    }
}

@Composable
fun ReportLogs(onLog: (String, Level) -> Unit) {
    var text by remember {
        mutableStateOf("")
    }

    Column {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("What would you like to log?") }
        )

        Button(onClick = { onLog(text, Level.Debug) }) {
            Text("log as debug")
        }

        FilledTonalButton(onClick = { onLog(text, Level.Info) }) {
            Text("log as info")
        }

        OutlinedButton(onClick = { onLog(text, Level.Warning) }) {
            Text("log as warning")
        }

        ElevatedButton(onClick = { onLog(text, Level.Error) }) {
            Text("log as error")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReportLogsPreview() {
    NosyLoggerExampleTheme {
        ReportLogs(onLog = { _, _ -> })
    }
}
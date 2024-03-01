package dev.nosytools.loggerexample

import android.app.Application
import android.widget.Toast
import dev.nosytools.logger.Config
import dev.nosytools.logger.Logger
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class LoggerExampleApp : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    // TODO pass api key to logger without config
    private val logger = Logger(Config.create(BuildConfig.API_KEY))

    override fun onCreate() {
        super.onCreate()

        val handler = CoroutineExceptionHandler { _, throwable ->
            Toast.makeText(applicationContext, "Got an error: $throwable", Toast.LENGTH_LONG)
                .show()

            throwable.printStackTrace()
        }

        applicationScope.launch(handler) {
            logger.init()
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()

        applicationScope.cancel()
    }
}
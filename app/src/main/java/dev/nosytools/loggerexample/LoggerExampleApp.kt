package dev.nosytools.loggerexample

import android.app.Application
import dev.nosytools.logger.Config
import dev.nosytools.logger.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class LoggerExampleApp : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)

    // TODO pass api key to logger without config
    private val logger = Logger(Config.create("TODO api key"))

    override fun onCreate() {
        super.onCreate()

        applicationScope.launch {
            logger.init()
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()

        applicationScope.cancel()
    }
}
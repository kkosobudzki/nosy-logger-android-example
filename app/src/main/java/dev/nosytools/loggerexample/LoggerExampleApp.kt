package dev.nosytools.loggerexample

import android.app.Application
import dev.nosytools.logger.Config
import dev.nosytools.logger.Logger

class LoggerExampleApp : Application() {

    private lateinit var logger: Logger

    override fun onCreate() {
        super.onCreate()

        // TODO pass api key to logger without config
        logger = Logger(Config.create("TODO api key"))
    }
}
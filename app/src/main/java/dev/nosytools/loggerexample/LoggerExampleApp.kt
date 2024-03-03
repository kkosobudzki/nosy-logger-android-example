package dev.nosytools.loggerexample

import android.app.Application
import dev.nosytools.logger.Logger

class LoggerExampleApp : Application() {

    internal val logger by lazy {
        Logger(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()

        logger.init(BuildConfig.API_KEY)
    }
}
package com.paliy.fingerprint

import android.app.Application
import com.github.ajalt.reprint.core.Reprint
import com.paliy.fingerprint.di.ApplicationComponent
import com.paliy.fingerprint.di.ApplicationModule
import com.paliy.fingerprint.di.DaggerApplicationComponent

class App : Application() {
  val component: ApplicationComponent by lazy {
    DaggerApplicationComponent.builder()
        .applicationModule(ApplicationModule(this))
        .build()
  }

  override fun onCreate() {
    super.onCreate()
    Reprint.initialize(this)
  }


  companion object {
    private var instance: App? = null
    val component by lazy {
      instance?.component
    }
  }
}
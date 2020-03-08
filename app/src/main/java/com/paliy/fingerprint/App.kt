package com.paliy.fingerprint

import android.app.Application
import com.github.ajalt.reprint.core.Reprint
import com.paliy.fingerprint.di.applicationModule
import com.paliy.fingerprint.di.fingerprintModule
import com.paliy.fingerprint.di.loginModule
import com.paliy.fingerprint.di.registerModule
import org.koin.android.ext.android.startKoin

class App : Application() {
  override fun onCreate() {
    super.onCreate()
    Reprint.initialize(this)
    startKoin(this, listOf(applicationModule, loginModule, registerModule, fingerprintModule))
  }
}
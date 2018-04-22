package com.paliy.fingerprint.di

import android.content.Context
import dagger.Provides

class ApplicationModule(private val applicationContext: Context) {
  @Provides
  fun applicationContext() = applicationContext
}
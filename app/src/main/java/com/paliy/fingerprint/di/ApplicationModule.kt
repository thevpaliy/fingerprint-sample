package com.paliy.fingerprint.di

import android.content.Context
import com.paliy.fingerprint.ui.fingerprint.FingerprintClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val applicationContext: Context) {
  @Singleton
  @Provides
  fun applicationContext() = applicationContext

  @Singleton
  @Provides
  fun fingerprintClient() = FingerprintClient()
}
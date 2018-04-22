package com.paliy.fingerprint.di

import android.content.Context
import com.paliy.fingerprint.ui.fingerprint.FingerprintClient
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
  fun applicationContext(): Context
  fun fingerprintClient(): FingerprintClient
}
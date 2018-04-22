package com.paliy.fingerprint.di

import android.content.Context
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
  fun inject(any: Any)
  fun applicationContext(): Context
}
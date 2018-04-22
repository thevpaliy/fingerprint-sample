package com.paliy.fingerprint.di

import com.paliy.fingerprint.ui.fingerprint.FingerprintClient
import com.paliy.fingerprint.ui.fingerprint.FingerprintPresenter
import dagger.Module
import dagger.Provides

@Module
class FingerprintModule {
  @Provides
  fun presenter(fingerprintClient: FingerprintClient)
      = FingerprintPresenter(fingerprintClient)

  @Provides
  fun fingerprintClient() = FingerprintClient()
}
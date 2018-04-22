package com.paliy.fingerprint.di

import com.paliy.fingerprint.ui.fingerprint.FingerprintClient
import com.paliy.fingerprint.ui.fingerprint.FingerprintContract
import com.paliy.fingerprint.ui.fingerprint.FingerprintPresenter
import com.paliy.fingerprint.ui.login.LoginContract
import com.paliy.fingerprint.ui.login.LoginPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {
  @Presentation
  @Provides
  fun fingerprintPresenter(fingerprintClient: FingerprintClient): FingerprintContract.Presenter
      = FingerprintPresenter(fingerprintClient)

  @Presentation
  @Provides
  fun loginPresenter(fingerprintClient: FingerprintClient): LoginContract.Presenter
      = LoginPresenter(fingerprintClient)
}
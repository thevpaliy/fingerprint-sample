package com.paliy.fingerprint.di

import com.paliy.fingerprint.ui.fingerprint.FingerprintDialog
import com.paliy.fingerprint.ui.login.LoginActivity
import dagger.Component

@Presentation
@Component(modules = [PresenterModule::class],
    dependencies = [ApplicationComponent::class])
interface PresentationComponent {
  fun inject(loginActivity: LoginActivity)
  fun inject(fingerprintDialog: FingerprintDialog)
}
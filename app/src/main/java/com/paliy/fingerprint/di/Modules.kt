package com.paliy.fingerprint.di

import com.paliy.fingerprint.ui.fingerprint.FingerprintClient
import com.paliy.fingerprint.ui.fingerprint.FingerprintContract
import com.paliy.fingerprint.ui.fingerprint.FingerprintDialog
import com.paliy.fingerprint.ui.fingerprint.FingerprintPresenter
import com.paliy.fingerprint.ui.auth.login.LoginContract
import com.paliy.fingerprint.ui.auth.login.LoginPresenter
import com.paliy.fingerprint.ui.auth.register.RegisterContract
import com.paliy.fingerprint.ui.auth.register.RegisterPresenter
import org.koin.dsl.module.applicationContext

val fingerprintModule = applicationContext {
  bean { FingerprintDialog() }
  factory { FingerprintPresenter(get(), get<FingerprintDialog>()) } bind FingerprintContract.Presenter::class
}

val applicationModule = applicationContext {
  bean { FingerprintClient() }
}

val loginModule = applicationContext {
  factory { LoginPresenter(get()) } bind LoginContract.Presenter::class
}

val registerModule = applicationContext {
  factory { RegisterPresenter(get()) } bind RegisterContract.Presenter::class
}
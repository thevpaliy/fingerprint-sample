package com.paliy.fingerprint.di

import com.paliy.fingerprint.ui.fingerprint.FingerprintClient
import com.paliy.fingerprint.ui.fingerprint.FingerprintContract
import com.paliy.fingerprint.ui.fingerprint.FingerprintDialog
import com.paliy.fingerprint.ui.fingerprint.FingerprintPresenter
import com.paliy.fingerprint.ui.login.LoginContract
import com.paliy.fingerprint.ui.login.LoginPresenter
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


package com.paliy.fingerprint.ui.login

import com.paliy.fingerprint.ui.fingerprint.FingerprintClient

class LoginPresenter(
    private val fingerprintClient: FingerprintClient,
    private var view: LoginContract.View? = null
) : LoginContract.Presenter {

  override fun login(credentials: Credentials) {

  }

  override fun attach(view: LoginContract.View) {
    this.view = view
    if (fingerprintClient.isAvailable) {
      view.showFingerprint()
    } else {
      view.hideFingerprint()
    }
  }
}
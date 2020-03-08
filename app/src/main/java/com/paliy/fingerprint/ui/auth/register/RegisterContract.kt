package com.paliy.fingerprint.ui.auth.register

import com.paliy.fingerprint.ui.auth.Credentials

object RegisterContract {
  interface Presenter {
    fun register(credentials: Credentials)
    fun attach(view: View)
  }

  interface View {
    fun showFingerprint()
    fun hideFingerprint()
    fun showLoading()
    fun hideLoading()
    fun goToHome()
  }
}
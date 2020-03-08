package com.paliy.fingerprint.ui.auth.login

import com.paliy.fingerprint.ui.auth.Credentials

object LoginContract {
  interface Presenter {
    fun login(credentials: Credentials)
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
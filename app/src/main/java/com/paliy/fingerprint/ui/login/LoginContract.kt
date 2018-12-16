package com.paliy.fingerprint.ui.login

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
  }
}
package com.paliy.fingerprint.ui.login

object LoginContract {
  interface Presenter {
    fun login(credentials: Credentials)
  }

  interface View {

  }
}
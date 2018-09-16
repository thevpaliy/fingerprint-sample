package com.paliy.fingerprint.ui.fingerprint

import com.paliy.fingerprint.ui.login.Credentials

object FingerprintContract {
  interface Presenter {
    fun startScanning()
    fun stopScanning()
  }

  interface View {
    fun showLockedSensor()
    fun showSuccess(credentials: Credentials)
    fun showPrompt(prompt: String)
    fun showRegistration()
    fun hideRegistration()
  }
}
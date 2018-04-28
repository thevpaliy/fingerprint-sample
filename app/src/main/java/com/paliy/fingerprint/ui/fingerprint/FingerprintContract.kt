package com.paliy.fingerprint.ui.fingerprint

object FingerprintContract {
  interface Presenter {
    fun startScanning()
    fun stopScanning()
  }

  interface View {
    fun showLockedSensor()
    fun showSuccess()
    fun showPrompt(prompt: String)
    fun showRegistration()
    fun hideRegistration()
  }
}
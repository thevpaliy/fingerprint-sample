package com.paliy.fingerprint.ui.fingerprint

class FingerprintPresenter(
    private val fingerprintClient: FingerprintClient,
    private var view: FingerprintContract.View
) : FingerprintContract.Presenter {

  init {
    if (fingerprintClient.hasFingerprints) {
      view.showRegistration()
    } else {
      view.hideRegistration()
    }
  }

  private var passed = false

  override fun startScanning() {
    if (!passed) {
      fingerprintClient.authenticate({
        passed = true
        view.showSuccess(it)
      }, this::onError)
    }
  }

  private fun onError(error: AuthError) {
    when (error) {
      is Failed -> view.showPrompt(error.message)
      is Locked -> view.showLockedSensor()
    }
  }

  override fun stopScanning() {
    passed = false
    fingerprintClient.cancel()
  }

}
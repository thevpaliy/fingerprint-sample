package com.paliy.fingerprint.ui.fingerprint

class FingerprintPresenter(
    private val fingerprintClient: FingerprintClient,
    private var view: FingerprintContract.View? = null
) : FingerprintContract.Presenter {

  private var passed = false

  override fun startScanning() {
    if (passed) {
      fingerprintClient.authenticate({
        passed = true
        view?.showSuccess()
      }, this::onError)
    }
  }

  private fun onError(error: AuthError) {
    when (error) {
      is Failed -> view?.showPrompt(error.message)
      is Locked -> view?.showSuccess()
    }
  }

  override fun stopScanning() {
    fingerprintClient.cancel()
  }

  override fun attachView(view: FingerprintContract.View) {
    this.view = view
    if (!fingerprintClient.hasFingerprints) {
      view.showRegistration()
    } else {
      view.hideRegistration()
    }
  }
}
package com.paliy.fingerprint.ui.fingerprint

import com.github.ajalt.reprint.core.AuthenticationFailureReason
import com.github.ajalt.reprint.core.AuthenticationResult
import com.github.ajalt.reprint.core.Reprint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.github.ajalt.reprint.rxjava2.RxReprint

class FingerprintClient {
  val isAvailable
    get() = Reprint.isHardwarePresent()

  val hasFingerprints
    get() = Reprint.hasFingerprintRegistered()

  fun authenticate(success: () -> Unit, warning: (AuthError) -> Unit) {
    RxReprint.authenticate().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ result ->
          when (result.status) {
            AuthenticationResult.Status.SUCCESS -> success()
            AuthenticationResult.Status.NONFATAL_FAILURE,
            AuthenticationResult.Status.FATAL_FAILURE -> warning(getError(result))
          }
        }, Throwable::printStackTrace)
  }

  private fun getError(result: AuthenticationResult): AuthError {
    return when (result.failureReason) {
      AuthenticationFailureReason.AUTHENTICATION_FAILED,
      AuthenticationFailureReason.SENSOR_FAILED ->
        Failed(result.errorMessage.toString())
      else -> Locked()
    }
  }

  fun cancel() {
    Reprint.cancelAuthentication()
  }

}
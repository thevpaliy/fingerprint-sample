package com.paliy.fingerprint.ui.fingerprint

import com.github.ajalt.reprint.core.AuthenticationResult
import com.github.ajalt.reprint.core.Reprint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.github.ajalt.reprint.rxjava2.RxReprint

class FingerprintClient {
  fun authenticate(success: () -> Unit, warning: (AuthError) -> Unit) {
    RxReprint.authenticate().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ result ->
          val error = Failed(result.errorMessage.toString())
          when (result.status) {
            AuthenticationResult.Status.SUCCESS -> success()
            AuthenticationResult.Status.NONFATAL_FAILURE -> warning(error)
            AuthenticationResult.Status.FATAL_FAILURE -> warning(error)
            else -> {}
          }
        }, Throwable::printStackTrace)
  }


  fun cancel() {
    Reprint.cancelAuthentication()
  }
}
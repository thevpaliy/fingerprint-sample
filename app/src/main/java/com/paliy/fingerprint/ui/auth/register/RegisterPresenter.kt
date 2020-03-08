package com.paliy.fingerprint.ui.auth.register

import android.annotation.SuppressLint

import com.paliy.fingerprint.ui.auth.Credentials
import com.paliy.fingerprint.ui.fingerprint.FingerprintClient
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class RegisterPresenter(
    private val fingerprintClient: FingerprintClient,
    private var view: RegisterContract.View? = null
) : RegisterContract.Presenter {

  @SuppressLint("CheckResult")
  override fun register(credentials: Credentials) {
    view?.showLoading()
    Completable.timer(5, TimeUnit.SECONDS)
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { view?.hideLoading(); view?.goToHome() }
  }

  override fun attach(view: RegisterContract.View) {
    this.view = view
    if (fingerprintClient.isAvailable) {
      view.showFingerprint()
    } else {
      view.hideFingerprint()
    }
  }
}
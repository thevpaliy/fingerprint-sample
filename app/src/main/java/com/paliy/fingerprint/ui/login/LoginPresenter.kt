package com.paliy.fingerprint.ui.login

import com.paliy.fingerprint.ui.fingerprint.FingerprintClient
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class LoginPresenter(
    private val fingerprintClient: FingerprintClient,
    private var view: LoginContract.View? = null
) : LoginContract.Presenter {

  override fun login(credentials: Credentials) {
    view?.showLoading()
    Completable.timer(2, TimeUnit.SECONDS)
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe { view?.hideLoading() }
  }

  override fun attach(view: LoginContract.View) {
    this.view = view
    if (fingerprintClient.isAvailable) {
      view.showFingerprint()
    } else {
      view.hideFingerprint()
    }
  }
}
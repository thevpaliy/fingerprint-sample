package com.paliy.fingerprint.ui.fingerprint

import android.app.DialogFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mattprecious.swirl.SwirlView
import com.paliy.fingerprint.App
import com.paliy.fingerprint.R
import com.paliy.fingerprint.di.DaggerPresentationComponent
import com.paliy.fingerprint.di.PresenterModule
import kotlinx.android.synthetic.main.fingerprint_dialog.*
import kotlinx.android.synthetic.main.fingerprint_sign_in.*
import kotlinx.android.synthetic.main.fingerprint_success.*
import javax.inject.Inject

class FingerprintDialog : DialogFragment() , FingerprintContract.View {

  var presenter: FingerprintContract.Presenter ? =null
    @Inject set(value) {
      field = value
      field?.attachView(this)
    }

  override fun onCreateView(inflater: LayoutInflater?,
                            container: ViewGroup?,
                            savedInstanceState: Bundle?) : View? {
    DaggerPresentationComponent.builder()
        .applicationComponent(App.component)
        .presenterModule(PresenterModule())
        .build().inject(this)
    return inflater?.inflate(R.layout.fingerprint_dialog, container, false)
  }

  override fun onResume() {
    super.onResume()
    presenter?.startScanning()
  }

  override fun onPause() {
    super.onPause()
    presenter?.stopScanning()
  }

  override fun showLockedSensor() {
  }

  override fun showRegistration() {

  }

  override fun hideRegistration() {
  }

  override fun showPrompt(prompt: String) {
    fingerprintIcon.setState(SwirlView.State.ERROR)
    fingerprintStatus.text = prompt
  }

  override fun showSuccess() {
    fingerprintIcon.setState(SwirlView.State.ON)
    fingerprintStatus.setText(R.string.fingerprint_success)
    layoutSwitcher.showNext()
    successIcon.isChecked = true
  }
}

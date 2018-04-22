package com.paliy.fingerprint.ui.fingerprint

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mattprecious.swirl.SwirlView
import com.paliy.fingerprint.R
import kotlinx.android.synthetic.main.fingerprint_dialog.*
import kotlinx.android.synthetic.main.fingerprint_sign_in.*
import javax.inject.Inject

class FingerprintDialog : DialogFragment(), FingerprintContract.View {

  var presenter: FingerprintContract.Presenter ? =null
    @Inject set(value) {
      field = value
      field?.attachView(this)
    }

  override fun onCreateView(inflater: LayoutInflater?,
                            container: ViewGroup?,
                            savedInstanceState: Bundle?)
     = inflater?.inflate(R.layout.fingerprint_dialog, container, false)

  override fun onStart() {
    super.onStart()
    presenter?.startScanning()
  }

  override fun onStop() {
    super.onStop()
    presenter?.stopScanning()
  }

  override fun showLockedSensor() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun showRegistration() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun hideRegistration() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun showPrompt(prompt: String) {
    fingerprintIcon.setState(SwirlView.State.ERROR)
    fingerprintStatus.text = prompt
  }

  override fun showSuccess() {
    fingerprintIcon.setState(SwirlView.State.ON)
    fingerprintStatus.setText(R.string.fingerprint_success)
    layoutSwitcher.showNext()
  }
}

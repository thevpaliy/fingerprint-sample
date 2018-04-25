package com.paliy.fingerprint.ui.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.paliy.fingerprint.R
import com.paliy.fingerprint.ui.fingerprint.FingerprintDialog
import com.paliy.fingerprint.ui.hide
import com.paliy.fingerprint.ui.show
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginContract.View {

  var presenter: LoginContract.Presenter? = null
    @Inject set(value) {
      field = value
      field?.attach(this)
    }

  private val dialog by lazy {
    FingerprintDialog()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)
    fingerprintOption.setOnClickListener {
      dialog.show(fragmentManager, null)
    }
  }

  override fun showFingerprint() {
    fingerprintOption.show()
  }

  override fun hideFingerprint() {
    fingerprintOption.hide()
  }
}

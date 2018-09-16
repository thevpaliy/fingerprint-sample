package com.paliy.fingerprint.ui.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.paliy.fingerprint.R
import com.paliy.fingerprint.ui.fingerprint.FingerprintDialog
import com.paliy.fingerprint.ui.hide
import com.paliy.fingerprint.ui.show
import kotlinx.android.synthetic.main.layout_login.*
import org.koin.android.ext.android.inject

class LoginActivity : AppCompatActivity(), LoginContract.View {

  private val presenter: LoginContract.Presenter by inject()
  private val dialog: FingerprintDialog by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_container)
    dialog.callback = this::handleCredentials
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

  private fun handleCredentials(credentials: Credentials) {
    emailInput.setText(credentials.email)
    passwordInput.setText(credentials.password)
    presenter.login(credentials)
  }
}

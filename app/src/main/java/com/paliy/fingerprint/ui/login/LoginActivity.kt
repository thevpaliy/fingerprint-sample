package com.paliy.fingerprint.ui.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.paliy.fingerprint.R
import com.paliy.fingerprint.ui.fingerprint.FingerprintDialog
import com.paliy.fingerprint.ui.hide
import com.paliy.fingerprint.ui.home.HomeActivity
import com.paliy.fingerprint.ui.show
import kotlinx.android.synthetic.main.layout_login.*
import org.koin.android.ext.android.inject
import com.paliy.fingerprint.ui.views.LoadingDialog


class LoginActivity : AppCompatActivity(), LoginContract.View {

  private val presenter: LoginContract.Presenter by inject()
  private val dialog: FingerprintDialog by inject()

  private val loadingDialog by lazy {
    LoadingDialog.create(this, root)
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_container)
    dialog.callback = this::handleCredentials
    presenter.attach(this)
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

  override fun hideLoading() {
    loadingDialog.hide()
  }

  override fun showLoading() {
    loadingDialog.show()
  }

  override fun goToHome() {
   startActivity(Intent(this, HomeActivity::class.java))
  }

  private fun handleCredentials(credentials: Credentials) {
    emailInput.setText(credentials.email)
    passwordInput.setText(credentials.password)
    presenter.login(credentials)
  }
}

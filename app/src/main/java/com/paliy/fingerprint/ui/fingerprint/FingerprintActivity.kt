package com.paliy.fingerprint.ui.fingerprint

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.paliy.fingerprint.R

class FingerprintActivity : AppCompatActivity(), FingerprintContract.View {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_fingerprint)
  }

  override fun showLockedSensor() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun showPrompt(prompt: String) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun showSuccess() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}

package com.paliy.fingerprint.ui.auth

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.paliy.fingerprint.R
import kotlinx.android.synthetic.main.activity_container.*


class AuthActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_container)
    pager.adapter = AuthAdapter(supportFragmentManager,pager)
  }
}

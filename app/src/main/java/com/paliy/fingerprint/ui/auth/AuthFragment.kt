package com.paliy.fingerprint.ui.auth

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import com.paliy.fingerprint.ui.fingerprint.FingerprintDialog
import com.paliy.fingerprint.ui.home.HomeActivity
import com.paliy.fingerprint.ui.views.LoadingDialog
import kotlinx.android.synthetic.main.activity_container.*
import org.koin.android.ext.android.inject
import java.util.*

abstract class AuthFragment : Fragment() {

  protected val dialog: FingerprintDialog by inject()

  private val loadingDialog by lazy {
    LoadingDialog.create(context!!, root)
  }

  var callback: Callback? = null

  abstract fun fireAnimation()

  abstract fun cleaFocus()

  abstract fun handleCredentials(credentials: Credentials)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    dialog.callback = this::handleCredentials
  }

  open fun mergeColoredText(leftPart: String, rightPart: String, leftColor: Int, rightColor: Int): SpannableStringBuilder? {
    val builder = SpannableStringBuilder()
    val leftPartSpannable = SpannableString(leftPart.toUpperCase(Locale.ROOT))
    val rightPartSpannable = SpannableString(rightPart.toUpperCase(Locale.ROOT))
    leftPartSpannable.setSpan(ForegroundColorSpan(leftColor), 0, leftPart.length, 0)
    rightPartSpannable.setSpan(ForegroundColorSpan(rightColor), 0, rightPart.length, 0)
    return builder.append(leftPartSpannable).append("  ").append(rightPartSpannable)
  }

  fun goToHome() {
    startActivity(Intent(context, HomeActivity::class.java))
  }

  fun makeTransition() {
    callback?.remove(this)
  }

  fun hideLoading() {
    loadingDialog.hide()
  }

  fun showLoading() {
    loadingDialog.show()
  }

  interface Callback {
    fun remove(fragment: AuthFragment?)
  }
}
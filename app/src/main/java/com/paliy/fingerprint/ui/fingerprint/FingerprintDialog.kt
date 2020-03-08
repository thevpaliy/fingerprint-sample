package com.paliy.fingerprint.ui.fingerprint

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.DialogFragment
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mattprecious.swirl.SwirlView
import com.paliy.fingerprint.R
import com.paliy.fingerprint.ui.hide
import com.paliy.fingerprint.ui.auth.Credentials
import com.paliy.fingerprint.ui.show
import kotlinx.android.synthetic.main.fingerprint_dialog.*
import kotlinx.android.synthetic.main.fingerprint_sign_in.*
import kotlinx.android.synthetic.main.fingerprint_success.*
import org.koin.android.ext.android.inject

class FingerprintDialog : DialogFragment(), FingerprintContract.View {

  var callback: ((Credentials) -> Unit)? = null
  private val presenter: FingerprintContract.Presenter by inject()

  override fun onCreateView(inflater: LayoutInflater?,
                            container: ViewGroup?,
                            savedInstanceState: Bundle?)
      = inflater?.inflate(R.layout.fingerprint_dialog, container, false)

  override fun onResume() {
    super.onResume()
    presenter.startScanning()
  }

  override fun onPause() {
    super.onPause()
    presenter.stopScanning()
  }

  override fun showLockedSensor() {
    fingerprintStatus.setText(R.string.fingerprint_error_lockout)
    fingerprintIcon.hide(isGone = false).post {
      lockedIcon.show().post {
        lockedIcon.animate()
            .scaleX(1f)
            .scaleY(1f)
            .alpha(1f)
            .start()
      }
    }
  }

  override fun showPrompt(prompt: String) {
    fingerprintIcon.setState(SwirlView.State.ERROR)
    fingerprintStatus.text = prompt
  }

  override fun showSuccess(credentials: Credentials) {
    fingerprintIcon.setState(SwirlView.State.ON)
    fingerprintStatus.setText(R.string.fingerprint_success)
    layoutSwitcher.showNext()
    successIcon.postDelayed({
      successIcon.playAnimation()
      successIcon.addAnimatorListener(object : AnimatorListenerAdapter() {
        override fun onAnimationEnd(animation: Animator?) {
          Handler().postDelayed({
            callback?.invoke(credentials); this@FingerprintDialog.dismiss()
          }, 300)
        }
      })
    }, 50)
  }
}

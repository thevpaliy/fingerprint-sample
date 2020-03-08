package com.paliy.fingerprint.ui.auth.register

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.paliy.fingerprint.R
import com.paliy.fingerprint.ui.BounceOvershootInterpolator
import com.paliy.fingerprint.ui.auth.AuthFragment
import com.paliy.fingerprint.ui.auth.Credentials
import com.paliy.fingerprint.ui.views
import kotlinx.android.synthetic.main.fragment_sign_up.*
import org.koin.android.ext.android.inject


class RegisterFragment : AuthFragment(), RegisterContract.View {

  private val presenter: RegisterContract.Presenter by inject()

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_sign_up, container, false)
  }

  override fun cleaFocus() {
    parent.views.map { it.clearFocus() }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    controller.setOnClickListener { makeTransition() }
  }

  override fun fireAnimation() {
    val offsetX = parent.width - (parent.width - first.left + resources.getDimension(R.dimen.option_size))
    val firstAnimator: ObjectAnimator = ObjectAnimator.ofFloat(first, View.TRANSLATION_X, 0f)
    val secondAnimator: ObjectAnimator = ObjectAnimator.ofFloat(second, View.TRANSLATION_X, 0f)
    val lastAnimator: ObjectAnimator = ObjectAnimator.ofFloat(last, View.TRANSLATION_X, 0f)
    val buttonAnimator = ObjectAnimator.ofFloat(controller, View.TRANSLATION_X, controller.translationX)

    first.translationX = -offsetX
    second.translationX = -offsetX
    last.translationX = -offsetX
    controller.translationX = (-controller.width).toFloat()
    buttonAnimator.interpolator = BounceOvershootInterpolator(4f)

    val buttonSet = AnimatorSet()
    buttonSet.playTogether(firstAnimator, secondAnimator, lastAnimator)
    buttonSet.interpolator = BounceOvershootInterpolator(2f)

    val animatorSet = AnimatorSet()
    animatorSet.startDelay = 500
    animatorSet.playTogether(buttonSet, buttonAnimator)
    animatorSet.start()
  }

  override fun handleCredentials(credentials: Credentials) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun hideFingerprint() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun showFingerprint() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }
}

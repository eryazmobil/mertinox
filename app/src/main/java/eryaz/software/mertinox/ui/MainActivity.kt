package eryaz.software.mertinox.ui

import android.os.Bundle
import eryaz.software.mertinox.databinding.ActivityMainBinding
import eryaz.software.mertinox.ui.base.BaseActivity
import eryaz.software.mertinox.util.KeyboardEventListener
import eryaz.software.mertinox.util.StatusBarUtil

class MainActivity : BaseActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setTranslucent(this)
        setContentView(binding.root)
        keyboardListener()
    }

    private fun keyboardListener() {
        KeyboardEventListener(
            activity = this,
            root = binding.root,
            resizeableView = binding.navHost,
            bottomView = null
        )
    }

    override fun getContentView() = binding.root
}

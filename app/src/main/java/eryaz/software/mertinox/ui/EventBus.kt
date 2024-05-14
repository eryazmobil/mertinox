package eryaz.software.mertinox.ui

import eryaz.software.mertinox.util.SingleLiveEvent

object EventBus {
    val navigateToSplash = SingleLiveEvent<Boolean>()
}

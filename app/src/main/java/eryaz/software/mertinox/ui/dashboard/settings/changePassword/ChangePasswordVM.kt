package eryaz.software.mertinox.ui.dashboard.settings.changePassword

import androidx.lifecycle.LiveData
import eryaz.software.mertinox.data.api.utils.onSuccess
import eryaz.software.mertinox.data.models.remote.request.ChangePasswordRequest
import eryaz.software.mertinox.data.repositories.UserRepo
import eryaz.software.mertinox.ui.base.BaseViewModel
import eryaz.software.mertinox.util.CombinedStateFlow
import eryaz.software.mertinox.util.SingleLiveEvent
import eryaz.software.mertinox.util.extensions.isValidPassword
import kotlinx.coroutines.flow.MutableStateFlow

class ChangePasswordVM (private val repo: UserRepo) : BaseViewModel() {

    val oldPassword = MutableStateFlow("")
    val newPassword = MutableStateFlow("")
    val againPassword = MutableStateFlow("")

    private val _wasChangePassword = SingleLiveEvent<Boolean>()
    val wasChangedPassword: LiveData<Boolean> = _wasChangePassword

    val loginEnable = CombinedStateFlow(oldPassword, newPassword, againPassword) {
        oldPassword.value.isValidPassword() && newPassword.value.isValidPassword()
                && againPassword.value.isValidPassword()
    }

    val passwordMatching = CombinedStateFlow(newPassword, againPassword) {
        newPassword.value == againPassword.value
    }

    fun changePassword() = executeInBackground() {
        val request = ChangePasswordRequest(
            oldPassword = oldPassword.value,
            newPassword = newPassword.value
        )
        repo.changePassword(request).onSuccess {
            _wasChangePassword.value = true
        }
    }


}

package eryaz.software.mertinox.ui.auth

import eryaz.software.mertinox.R
import eryaz.software.mertinox.data.api.utils.onError
import eryaz.software.mertinox.data.api.utils.onSuccess
import eryaz.software.mertinox.data.enums.UiState
import eryaz.software.mertinox.data.models.dto.ErrorDialogDto
import eryaz.software.mertinox.data.models.remote.request.LoginRequest
import eryaz.software.mertinox.data.persistence.SessionManager
import eryaz.software.mertinox.data.persistence.TemporaryCashManager
import eryaz.software.mertinox.data.repositories.AuthRepo
import eryaz.software.mertinox.data.repositories.UserRepo
import eryaz.software.mertinox.ui.base.BaseViewModel
import eryaz.software.mertinox.util.CombinedStateFlow
import eryaz.software.mertinox.util.extensions.isValidPassword
import eryaz.software.mertinox.util.extensions.isValidUserId
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow

class LoginViewModel(
    private val authRepo: AuthRepo,
    private val userRepo: UserRepo
) : BaseViewModel() {
    val email = MutableStateFlow("")
    val password = MutableStateFlow("")

    private val _navigateToMain = MutableSharedFlow<Boolean>()
    val navigateToMain = _navigateToMain.asSharedFlow()

    val loginEnable = CombinedStateFlow(email, password) {
        email.value.isValidUserId() && password.value.isValidPassword()
    }

    init {
        _uiState.value = UiState.EMPTY
    }

    fun login() = executeInBackground(_uiState, hasNextRequest = true) {
        val request = LoginRequest(
            email = email.value,
            password = password.value
        )

        authRepo.login(request).onSuccess {
            SessionManager.token = it.accessToken

            fetchWorkActionTypeList()
        }.onError { message, _ ->
            showError(
                ErrorDialogDto(
                    titleRes = R.string.error,
                    message = message
                )
            )
        }
    }

    private fun fetchWorkActionTypeList() = executeInBackground(_uiState) {
        userRepo.fetchWorkActionTypeList().onSuccess {
            TemporaryCashManager.getInstance().workActionTypeList = it
            _navigateToMain.emit(true)
        }
    }
}




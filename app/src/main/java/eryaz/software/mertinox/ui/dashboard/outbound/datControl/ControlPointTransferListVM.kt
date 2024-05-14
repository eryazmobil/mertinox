package eryaz.software.mertinox.ui.dashboard.outbound.datControl

import androidx.lifecycle.MutableLiveData
import eryaz.software.mertinox.R
import eryaz.software.mertinox.data.api.utils.onError
import eryaz.software.mertinox.data.api.utils.onSuccess
import eryaz.software.mertinox.data.models.dto.ErrorDialogDto
import eryaz.software.mertinox.data.models.dto.WarningDialogDto
import eryaz.software.mertinox.data.models.dto.WorkActivityDto
import eryaz.software.mertinox.data.persistence.SessionManager
import eryaz.software.mertinox.data.repositories.WorkActivityRepo
import eryaz.software.mertinox.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow

class ControlPointTransferListVM(private val repo: WorkActivityRepo) : BaseViewModel() {

    val search = MutableLiveData("")

    private val _workActivityList = MutableStateFlow(listOf<WorkActivityDto>())
    val workActivityList = _workActivityList.asSharedFlow()

    fun getTransferWorkActivityList() {
        executeInBackground(_uiState) {
            repo.getTransferWarehouseWorkActivityListForPdaControl(
                warehouseId = SessionManager.warehouseId,
                companyId = SessionManager.companyId
            ).onSuccess {
                if (it.isNotEmpty()) {
                    _workActivityList.emit(it)
                } else {
                    showWarning(
                        WarningDialogDto(
                            title = stringProvider.invoke(R.string.not_found_work_activity),
                            message = stringProvider.invoke(R.string.list_is_empty)
                        )
                    )
                }
            }.onError { message, _ ->
                showError(
                    ErrorDialogDto(
                        titleRes = R.string.error,
                        message = message
                    )
                )
            }
        }
    }
}
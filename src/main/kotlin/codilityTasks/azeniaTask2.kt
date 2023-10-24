/*
 *  Created by tommunyiri on 09/10/2023, 11:44
 *  Phone: +254715361229
 *  Company: Eclectics International Ltd
 *//*


package com.eclectics.mobilemoney.ourtelekom


*/
/**
 * Created by Tom Munyiri on 09/10/2023.
 * Company: Eclectics International Ltd
 * Email: munyiri.thomas@eclectics.io
 */


/*import androidx.databinding.ObservableField
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import android.text.TextUtils //Experiencing some errors in codility platform for this import
import android.util.Patterns //Experiencing some errors in codility platform for this import

//TODO - Use android studio or any other IDE setup with the android sdk so that the imports are fetched from the android sdk. I am not sure if android.* is available on codility classpath

class SignUpToNewsletterViewModel(
    private val submitEmailUseCase: SubmitEmailUseCase,
    private val router: SubmitEmailRouter,
    private val schedulerFacade: SchedulerFacade
) : ViewModel() {

    var buttonEnabled = ObservableField<Boolean>()
    var input = ObservableField<String>("")
    var loading = ObservableField<Boolean>(false)
    var errorMessage = ObservableField<@StringRes Int>()

    private val disposables = CompositeDisposable()

    init {
        input.addOnPropertyChangedCallback(object :
            androidx.databinding.Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(
                sender: androidx.databinding.Observable?,
                propertyId: Int
            ) {
                updateButtonEnabled()
            }
        })
    }

    private fun updateButtonEnabled() {
        val email = input.get()
        val isEmailValid =
            !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        buttonEnabled.set(isEmailValid)
    }

    fun onSubmitClick() {
        val email = input.get()
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            loading.set(true)

            val disposable = submitEmailUseCase.execute(email)
                .subscribeOn(schedulerFacade.background)
                .observeOn(schedulerFacade.main)
                .subscribe({
                    loading.set(false)
                    router.showSuccess()
                }, { error ->
                    loading.set(false)
                    handleApiError(error)
                })

            disposables.add(disposable)
        }
    }

    private fun handleApiError(error: Throwable) {
        errorMessage.set(
            when (error) {
                is SubmitEmailError.EmailAlreadyInUse -> R.string.email_already_in_use
                is SubmitEmailError.NetworkError -> R.string.network_error
                else -> R.string.network_error //handles any other unexpected case. A string resource to be provided for this case
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }

    interface SubmitEmailRouter {
        fun showSuccess()
    }

    interface SubmitEmailUseCase {
        fun execute(email: String?): Completable
    }

    sealed class SubmitEmailError : Throwable() {
        object EmailAlreadyInUse : SubmitEmailError()
        object NetworkError : SubmitEmailError()
    }

    interface SchedulerFacade {
        val main: Scheduler
        val background: Scheduler
    }

}


/**
 *## Classes available in package:
 *package com.codility
 *
 *interface SubmitEmailRouter {
 *  fun showSuccess()
 *}
 *
 *import io.reactivex.Completable
 *
 *interface SubmitEmailUseCase {
 *  fun execute(email: String): Completable
 *}
 *
 *sealed class SubmitEmailError : Throwable() {
 *  object EmailAlreadyInUse : SubmitEmailError()
 *  object NetworkError : SubmitEmailError()
 *}
 *
 *import io.reactivex.Scheduler
 *
 *interface SchedulerFacade {
 *  val main: Scheduler
 *  val background: Scheduler
 *}
 *
 *## strings.xml available via `com.codility.android.R`:
 *<resources>
 *  <string name="email_already_in_use">Email already in use</string>
 *  <string name="network_error">Network error</string>
 *</resources>
 **//*



*/
/**
 *## Classes available in package:
 *package com.codility
 *
 *interface SubmitEmailRouter {
 *  fun showSuccess()
 *}
 *
 *import io.reactivex.Completable
 *
 *interface SubmitEmailUseCase {
 *  fun execute(email: String): Completable
 *}
 *
 *sealed class SubmitEmailError : Throwable() {
 *  object EmailAlreadyInUse : SubmitEmailError()
 *  object NetworkError : SubmitEmailError()
 *}
 *
 *import io.reactivex.Scheduler
 *
 *interface SchedulerFacade {
 *  val main: Scheduler
 *  val background: Scheduler
 *}
 *
 *## strings.xml available via `com.codility.android.R`:
 *<resources>
 *  <string name="email_already_in_use">Email already in use</string>
 *  <string name="network_error">Network error</string>
 *</resources>
 **/

 */


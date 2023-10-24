/*
 *  Created by tommunyiri on 09/10/2023, 12:04
 *  Phone: +254715361229
 *  Company: Eclectics International Ltd
 */


/**
 * Created by Tom Munyiri on 09/10/2023.
 * Company: Eclectics International Ltd
 * Email: munyiri.thomas@eclectics.io
 */

import io.reactivex.disposables.CompositeDisposable

class Presenter(view: ListContract.View, elementsProvider: ElementsProvider, schedulerFacade: SchedulerFacade) {
    val disposables = CompositeDisposable()

    init {
        disposables.add(
            elementsProvider.loadElements()
                .subscribeOn(schedulerFacade.background)
                .observeOn(schedulerFacade.main)
                .doOnSubscribe { view.showLoading() }
                .doFinally { view.hideLoading() }
                .subscribe(
                    { elements ->
                        if (elements.isEmpty()) {
                            view.showError()
                        } else {
                            view.setElements(elements)
                        }
                    },
                    { error -> view.showError() }
                )
        )
    }
}

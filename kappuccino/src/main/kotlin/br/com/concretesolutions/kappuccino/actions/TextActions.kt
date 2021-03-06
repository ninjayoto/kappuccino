package br.com.concretesolutions.kappuccino.actions

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import br.com.concretesolutions.kappuccino.BaseViewInteractions
import br.com.concretesolutions.kappuccino.BaseMatchersImpl
import br.com.concretesolutions.kappuccino.extensions.scroll
import br.com.concretesolutions.kappuccino.extensions.type


object TextActions {

    fun typeText(text: String, scroll: Boolean = false, pressActionButton: Boolean = false, closeKeyboard: Boolean = true, func: BaseMatchersImpl.() -> Unit) {
        val matchList = BaseMatchersImpl().apply { func() }.matchList()
        for (matcher in matchList)
            Espresso.onView(matcher).scroll(scroll).type(text, pressActionButton, closeKeyboard)
    }

    fun clearText(scroll: Boolean = false, func: BaseMatchersImpl.() -> Unit) {
        val matchList = BaseMatchersImpl().apply { func() }.matchList()
        BaseViewInteractions(scroll, matchList).action(ViewActions.clearText())
    }

}
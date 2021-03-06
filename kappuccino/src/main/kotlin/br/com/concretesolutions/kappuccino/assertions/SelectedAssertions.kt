package br.com.concretesolutions.kappuccino.assertions

import android.support.test.espresso.ViewAssertion
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isSelected
import br.com.concretesolutions.kappuccino.BaseMatchersImpl
import br.com.concretesolutions.kappuccino.BaseViewInteractions
import org.hamcrest.Matchers.not

object SelectedAssertions {

    fun selected(scroll: Boolean = false, func: BaseMatchersImpl.() -> Unit) {
        val matchList = BaseMatchersImpl().apply { func() }.matchList()
        BaseViewInteractions(scroll, matchList).check(selected(true))
    }

    fun notSelected(scroll: Boolean = false, func: BaseMatchersImpl.() -> Unit) {
        val matchList = BaseMatchersImpl().apply { func() }.matchList()
        BaseViewInteractions(scroll, matchList).check(selected(false))
    }

    private fun selected(selected: Boolean): ViewAssertion {
        if (selected) return matches(isSelected())
        else return matches(not(isSelected()))
    }
}


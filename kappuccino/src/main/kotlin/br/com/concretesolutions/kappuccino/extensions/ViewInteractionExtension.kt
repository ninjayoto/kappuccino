package br.com.concretesolutions.kappuccino.extensions

import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.v7.widget.RecyclerView.ViewHolder
import br.com.concretesolutions.kappuccino.custom.recyclerView.RecyclerViewUtils

fun ViewInteraction.scroll(scroll: Boolean): ViewInteraction {
    if (scroll) return this.perform(scrollTo())
    return this
}

fun ViewInteraction.type(text: String, pressActionButton: Boolean = false, closeKeyboard: Boolean = true): ViewInteraction {
    if (pressActionButton) return perform(typeText(text), pressImeActionButton())
    if (closeKeyboard) return perform(typeText(text), closeSoftKeyboard())
    return perform(typeText(text))
}

fun ViewInteraction.clickItem(position: Int): ViewInteraction {
    return this.perform(RecyclerViewActions
        .actionOnItemAtPosition<ViewHolder>(position, click()))
}

fun ViewInteraction.longClickItem(position: Int): ViewInteraction {
    return this.perform(RecyclerViewActions
        .actionOnItemAtPosition<ViewHolder>(position, longClick()))
}

fun ViewInteraction.clickChildView(position: Int, viewId: Int): ViewInteraction {
    return this.perform(RecyclerViewUtils.actionOnItemViewAtPosition(position, viewId, click()))
}

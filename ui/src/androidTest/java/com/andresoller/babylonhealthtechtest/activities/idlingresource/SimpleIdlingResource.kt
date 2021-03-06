package com.andresoller.babylonhealthtechtest.activities.idlingresource

import android.support.v7.widget.RecyclerView
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.IdlingResource.ResourceCallback


class SimpleIdlingResource constructor(val recycler: RecyclerView) : IdlingResource {

    private var callback: ResourceCallback? = null

    override fun isIdleNow(): Boolean {
        if (recycler.adapter != null && recycler.adapter!!.itemCount > 0) {
            if (callback != null) {
                callback!!.onTransitionToIdle()
            }
            return true
        }
        return false
    }


    override fun registerIdleTransitionCallback(callback: ResourceCallback) {
        this.callback = callback
    }

    override fun getName(): String {
        return "Recycler idling resource"
    }
}
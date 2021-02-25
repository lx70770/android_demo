package org.devio.`as`.proj.common.flutter

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import io.flutter.embedding.android.FlutterTextureView
import io.flutter.embedding.android.FlutterView
import io.flutter.embedding.engine.FlutterEngine
import org.devio.`as`.proj.common.R
import org.devio.`as`.proj.common.ui.component.HiBaseFragment
import org.devio.`as`.proj.util.AppGlobals

abstract class HiFlutterFragment : HiBaseFragment() {
    private val flutterEngine: FlutterEngine?
    private var flutterView: FlutterView? = null

    abstract val moduleName: String?

    init {
        flutterEngine =
            HiFlutterCacheManager.instance!!.getCachedFlutterEngine(moduleName!!, AppGlobals.get())
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_flutter
    }

    fun setTitle(titleStr: String) {
//        title.text = titleStr
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val lp: FrameLayout.LayoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        (layoutView as ViewGroup).addView(createFlutterView(activity!!), lp)
    }

    private fun createFlutterView(context: Context): FlutterView {
        val flutterTextureView = FlutterTextureView(activity!!)
        flutterView = FlutterView(context, flutterTextureView)
        return flutterView!!
    }

    override fun onStart() {
        flutterView!!.attachToFlutterEngine(flutterEngine!!)
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        flutterEngine!!.lifecycleChannel.appIsResumed()
    }

    override fun onPause() {
        super.onPause()
        flutterEngine!!.lifecycleChannel.appIsInactive()
    }

    override fun onDetach() {
        super.onDetach()
        flutterEngine!!.lifecycleChannel.appIsDetached()
    }

    override fun onStop() {
        super.onStop()
        flutterEngine!!.lifecycleChannel.appIsPaused()
    }

//    override fun onDestroy() {
//        try {
//            super.onDestroy()
//        } catch (e: Exception) {
//
//        }
//    }
}
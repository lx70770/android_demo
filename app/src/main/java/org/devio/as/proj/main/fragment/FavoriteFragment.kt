package org.devio.`as`.proj.main.fragment

import android.os.Bundle
import android.view.View
import org.devio.`as`.proj.common.flutter.HiFlutterCacheManager
import org.devio.`as`.proj.common.flutter.HiFlutterFragment
import org.devio.`as`.proj.main.R


class FavoriteFragment : HiFlutterFragment() {
    override val moduleName: String?
        get() = HiFlutterCacheManager.MODULE_NAME_FAVORITE

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(getString(R.string.title_favorite))
    }
}
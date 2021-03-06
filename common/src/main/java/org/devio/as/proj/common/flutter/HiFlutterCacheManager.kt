package org.devio.`as`.proj.common.flutter

import android.content.Context
import android.os.Looper
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.view.FlutterMain

/**
 * Flutter 优化提升加载速度 实现秒开flutter模块
 * 1.预加载不损失首页性能
 * 2.实例化多个flutter引擎，并分别加载不同的dart入口文件
 */
class HiFlutterCacheManager private constructor() {

    //preload
    fun preload(context: Context) {
        Looper.myQueue().addIdleHandler {
            initFlutterEngine(context, MODULE_NAME_FAVORITE)
            initFlutterEngine(context, MODULE_NAME_RECOMMEND)
            false
        }
    }

    // 获取flutter engine
    fun getCachedFlutterEngine(moduleName: String, context: Context?): FlutterEngine {
        var engine = FlutterEngineCache.getInstance()[moduleName]
        if (engine == null && context != null) {
            engine = initFlutterEngine(context, moduleName)
        }
        return engine!!
    }

    // init
    private fun initFlutterEngine(context: Context, moduleName: String): FlutterEngine {
        val flutterEngine = FlutterEngine(context)
        HiFlutterBridge.init(flutterEngine)
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint(
                FlutterMain.findAppBundlePath(),
                moduleName
            )
        )
        FlutterEngineCache.getInstance().put(moduleName, flutterEngine)
        return flutterEngine
    }

    companion object {
        const val MODULE_NAME_FAVORITE = "main"
        const val MODULE_NAME_RECOMMEND = "recommend"

        @JvmStatic
        @get: Synchronized
        var instance: HiFlutterCacheManager? = null
            get() {
                if (field == null) {
                    field = HiFlutterCacheManager()
                }
                return field
            }
            private set
    }

}
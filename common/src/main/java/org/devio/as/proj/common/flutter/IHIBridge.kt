package org.devio.`as`.proj.common.flutter

interface IHIBridge<P, CallBack> {
    fun onBack(p: P?)
    fun gotoNative(p: P?)
    fun getHeaderParams(callBack: CallBack)
}
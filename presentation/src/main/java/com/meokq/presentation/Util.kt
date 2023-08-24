package com.meokq.presentation

fun getResourceId(name: String, clazz: Class<*>): Int {
    val resId = try {
        val field = clazz.getField(name)
        field.getInt(null)
    } catch (e: Exception) {
        e.printStackTrace()
        -1
    }

    return resId
}
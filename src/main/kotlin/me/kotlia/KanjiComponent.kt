package me.kotlia

import java.lang.Exception


class KanjiComponent (private var component: String = "") {
    override fun toString(): String {
        return this.component
    }
    fun format(): String {
        var temp = this.component
        var counter: Int? = null
        temp = temp.substring(1, temp.length-1)
        temp.trim().split("").forEachIndexed { index, s ->
            if (counter == null) {
                counter = 0
            } else if (s == "[") {
                counter = counter!! + 1
            } else if (s == "]") {
                counter = counter!! - 1
            } else if (counter == 0) {
                temp = try {
                    temp.substring(0, index-1) + ";" + temp.substring(index)
                } catch (e: Exception) {
                    temp
                }
            }
        }
        val arr = temp.split(";")
        var res = ""
        var inner = ""
        arr.forEach {
            inner = it.substring(it.indexOf(",") + 2, it.length - 1)
            res += inner.split(",")[0].replace("\"", "")
        }
        return res
    }
}
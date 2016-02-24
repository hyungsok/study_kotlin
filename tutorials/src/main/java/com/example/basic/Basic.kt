package com.example.basic

import java.util.*

/**
 * Created by hyungsoklee on 2016. 2. 24..
 */
fun main(args: Array<String>) {
    println(max(10, 12))
    println(max(parseInt("100"), parseInt("200")))
    println(getStringLength("abcdefg"))

    var numbers = arrayListOf(20, 19, 7, 12)
    for(n in numbers) {
        print(n)
    }
    println();

    var arrays = ArrayList<String>()
    arrays.add("A")
    arrays.add("B")
    arrays.add("C")
    for(s in arrays) {
        print(s)
    }
}

fun max(a: Int, b: Int) = if (a > b) a else b

fun parseInt(str: String): Int {
    try {
        return Integer.parseInt(str);
    } catch (e: NumberFormatException) {
        println("One of the arguments isn't Int")
    }
    return -1;
}

fun getStringLength(obj: Any): Int? {
    if (obj is String)
        return obj.length;
    return null;
}

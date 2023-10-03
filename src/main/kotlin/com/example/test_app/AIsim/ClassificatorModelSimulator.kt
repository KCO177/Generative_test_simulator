package com.example.test_app.AIsim

import kotlin.random.Random

class ClassificatorModelSimulator {
    fun generateRandomCategories(numberOfCategories: Int, rangeStart: Double, rangeEnd: Double): List<ClosedRange<Double>> {
        return (0 until numberOfCategories).map {
            val start = Random.nextDouble(rangeStart, rangeEnd)
            val end = Random.nextDouble(start, rangeEnd)
            start..end
        }
    }

}
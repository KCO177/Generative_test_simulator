package com.example.test_app.genTest

class SimilarityCalculator {
    fun calculateSimilarity(list1: List<Double>, list2: List<Double>, threshold: Double): Double {
        require(list1.size == list2.size) { "Both lists must have the same size." }

        val size = list1.size
        var matchingCount = 0

        for (i in 0 until size) {
            val diff = Math.abs(list1[i] - list2[i])
            if (diff <= threshold) {
                matchingCount++
            }
        }

        return (matchingCount.toDouble() / size) * 100.0
    }



}
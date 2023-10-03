package com.example.test_app.AIsim

import com.example.test_app.genTest.SimilarityCalculator


class AImodelSimulator {

    fun callMatching(): Double{
        val numberOfVectors = 500
        val vektor = VectorSimulator()
        val list1 = vektor.generateRandomVectorList(numberOfVectors)
        val list2 = vektor.generateRandomVectorList(numberOfVectors)

        val thresholdV = 0.81

        val matching = SimilarityCalculator()
        val similarityVectors = matching.calculateSimilarity(list1, list2, thresholdV)

        println("Similarity with threshold $thresholdV for matching two sets of $numberOfVectors random vectors is: $similarityVectors%")

        return similarityVectors
    }
}
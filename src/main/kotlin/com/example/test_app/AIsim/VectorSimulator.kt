package com.example.test_app.AIsim

import kotlin.random.Random

class VectorSimulator {
    fun generateRandomVectorList(listSize: Int): MutableList<Double> {
        val listOfVectors: MutableList<Double> = mutableListOf()
        for (i in 1..listSize) {
            val ranVector = Random.nextDouble(0.0, 1.0)
            listOfVectors.add(ranVector)
        }
        //print(listOfVectors)
        return listOfVectors
    }
}
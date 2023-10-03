package com.example.test_app.genTest


import java.time.LocalDateTime
import kotlin.random.Random

class DataGenerator {
    val random = Random.Default

    //kolikrát se má provést
    val listSize = 1


    val testID: List<Int> = (1..listSize).toList()

    // now čas a datum
    val currentDateTime = LocalDateTime.now()
    val dateTime = List<String>(listSize){java.sql.Timestamp.valueOf(currentDateTime).toString()}

    // binární výsledek proběhnutí run testu
    val testResult = List(listSize){ this.random.nextBoolean() } // TODO provedení testů

    //procentuální výsledek generativního testu verze AI proti mock datům
    val generativeTest = GenerativeTestMatching()
    val result = generativeTest.generativeTestMatchingAI(0.1)
    val testResultPercentage = List<Double>(listSize) { this.result}

    //procentuální výsledek generativního testu verze AI proti mock datům
    val categoryTestResult = List<Double>(listSize) {this.random.nextDouble()}

}

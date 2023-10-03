package com.example.test_app.genTest

//Generativní testy pro kontrolu verzování - provádí se na identických datech
class GenerativeTestMatching {

    val mockData = MockData()
    //Procentuální generativní ověření AI na identických datech

    fun generativeTestMatchingAI(AIversion : Double):Double {

        val mockVectorCV = mockData.mockVectorCV
        val mockVectorJob = mockData.mockVectorJob

        val matching = SimilarityCalculator() //simulator AI modelu (verzovani)

        val result = matching.calculateSimilarity(mockVectorCV, mockVectorJob, 0.75)//0.81
        // AI version

        return result
    }
}
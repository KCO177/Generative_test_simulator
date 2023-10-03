package com.example.test_app.genTest

import com.example.test_app.AIsim.CategorySimulator
import com.example.test_app.AIsim.ClassificatorModelSimulator

class GenerativeTestCategories {
    fun generativeTestCategories(){
        val mockData = MockData()

        // pokud jsou nové kategorie určité CVvektory musí vždy spadat do stejného ranku
        val mockCategories = mockData.mockCategories
        val mockVektorCV= mockData.mockVectorCV

        val categoriesClass = CategorySimulator()
        val cat01 = categoriesClass.calculateCategoryCounts(mockVektorCV, mockCategories).values.toList()

        val testedCategoryClass = ClassificatorModelSimulator()
        val newTestedCategories = testedCategoryClass.generateRandomCategories(20, 0.0, 1.0)
        val cat02 = categoriesClass.calculateCategoryCounts(mockVektorCV, newTestedCategories).values.toList()


        val matching = SimilarityCalculator()


        val result = matching.calculateSimilarity(cat01, cat02, 0.98)//0.81

        println("tested new categories matched in $result")


    }
}
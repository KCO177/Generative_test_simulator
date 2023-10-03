package com.example.test_app.AIsim

import com.example.test_app.genTest.MockData

class CategorySimulator {


    fun calculateCategoryCounts(listOfVectors: List<Double>, categories: List<ClosedRange<Double>>): Map<String, Double> {
        val categoryCountsValues = mutableListOf<Int>()
        val categoryCountsPercent = mutableListOf<Double>()

        // volej mockData názvy kategorií
        val mockData = MockData()
        val categoryName = mockData.categoryName

        // kolik vektorů je v jednotlivých kategoriích
        for (category in categories) {
            val matchedValues = listOfVectors.filter { it in category }
            categoryCountsValues.add(matchedValues.size)
        }
        // procentuální zastoupení kategorií ("normalizace")
        val sumOfMatchedVectors = categoryCountsValues.sum()
        for (n in categoryCountsValues) {
            val percentage = (n.toDouble() / sumOfMatchedVectors) * 100
            categoryCountsPercent.add(percentage)
        }
        //vytvoř hashMapu s kategoriemi
        val categoryResults = categoryName.zip(categoryCountsPercent).toMap()

        return categoryResults
    }

    fun GetResultsSimulateCategory(vectorMethod: List<Double>, categoriesMethod: List<ClosedRange<Double>>) {
        val simulatedCounts = calculateCategoryCounts(vectorMethod, categoriesMethod)
        val sortedCategory = simulatedCounts.toList()
        val sortedMapOfCategories = sortedCategory.sortedByDescending { it.second }.toMap()
        for (category in sortedMapOfCategories) {
            println(category)
        }
    }
}



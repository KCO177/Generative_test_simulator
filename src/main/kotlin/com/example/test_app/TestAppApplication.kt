
package com.example.test_app

import com.example.test_app.AIsim.AImodelSimulator
import com.example.test_app.AIsim.CategorySimulator
import com.example.test_app.AIsim.VectorSimulator
import com.example.test_app.genTest.DataCollector
import com.example.test_app.genTest.GenerativeTestCategories
import com.example.test_app.genTest.MockData
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestAppApplication

fun main(args: Array<String>) {
    runApplication<TestAppApplication>(*args)

    ///// ------ simulace testů ------//////
    //spuštění simulačních dat do dd
    ///*
    val dataCollector = DataCollector()
    dataCollector.postTestResults()
    //*/
    val gen = GenerativeTestCategories()
    gen.generativeTestCategories()




    //// --------simulace služby AI--------/////
    // spuštění simulátoru kategorií
    val genVector = VectorSimulator()
    val simulatedVectors = genVector.generateRandomVectorList(500)
    val mockData = MockData()
    val mockCategories = mockData.mockCategories
    val callCategorySimulation = CategorySimulator()
    callCategorySimulation.GetResultsSimulateCategory(simulatedVectors, mockCategories)

    // spuštění simulátoru matchingu
    val AImodelSimulator = AImodelSimulator()
    AImodelSimulator.callMatching()

}


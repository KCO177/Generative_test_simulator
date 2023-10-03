package com.example.test_app.genTest
import org.springframework.web.client.RestTemplate

data class Test_data(
    val testID: Int,
    val dateTime: String,
    val singleTestResult: Boolean,
    val percentageResult: Double,
    val categoryResult: Double
)

class DataCollector{
    //převádí data z generátoru do listu
    fun testDataCollector(): MutableList<Test_data> {
        val listOfTests = mutableListOf<Test_data>()
        val mData = DataGenerator()

        for (i in mData.testID.indices) {
            val singleTestData =
                Test_data(mData.testID[i], mData.dateTime[i], mData.testResult[i], mData.testResultPercentage[i], mData.categoryTestResult[i])
            //println(singleTestData)
            listOfTests.add(singleTestData)
        }
        print(listOfTests)
        return listOfTests
    }

    //post results to db
    fun postTestResults() {
        val restTemplate = RestTemplate()
        val listOfTests = testDataCollector()
        val convertedTests = listOfTests.map { it.toCreateTest() }

        val url = "http://localhost:8081/table/post" // lze postnout napřímo bez http ???

        for (test in convertedTests) {
            restTemplate.postForObject(url, test, ViewTest::class.java)
        }
    }


    fun Test_data.toCreateTest(): CreateTest {
        return CreateTest(
            datetime = this.dateTime,
            passed = this.singleTestResult,
            percResultMatch = this.percentageResult,
            percResultCategory = this.categoryResult
        )
    }
}



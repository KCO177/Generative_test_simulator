package com.example.test_app.genTest

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.repository.CrudRepository
import org.springframework.web.bind.annotation.*

@Entity
data class DbTableController (
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    val id: Long = 0,
    val datetime: String,
    val passed : Boolean,
    val percResultMatch : Double,
    val percResultCategory: Double
)

data class ViewTest(
    val id: Long,
    val datetime: String,
    val passed : Boolean,
    val percResultMatch : Double,
    val percResultCategory: Double
)

fun DbTableController.toView()=
    ViewTest(id, datetime, passed, percResultMatch, percResultCategory)

interface TestTableRepository: CrudRepository<DbTableController, Long>{

}

data class CreateTest(
    val datetime: String,
    val passed: Boolean,
    val percResultMatch: Double,
    val percResultCategory: Double
)

    @RestController
    @RequestMapping("table")
    class TestTableController(
        val testTableRepository: TestTableRepository
    ) {
        @GetMapping()
        fun findAll(): Iterable<ViewTest> =
            testTableRepository.findAll().map { it.toView() }

        @PostMapping("post")
        fun create(@RequestBody createTest: CreateTest) =
            testTableRepository.save(
                DbTableController(
                    datetime = createTest.datetime,
                    passed = createTest.passed,
                    percResultMatch = createTest.percResultMatch,
                    percResultCategory = createTest.percResultCategory
                )
            ).toView()

    }



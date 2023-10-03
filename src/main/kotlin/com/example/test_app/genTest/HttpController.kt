package com.example.test_app.genTest

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class HttpController(
    val testTableRepository : TestTableRepository
){
@GetMapping("results")
    fun index(model: Model): String{
        val testResult = testTableRepository.findAll() // fetch data
        //print(testResult)
        model.addAttribute("testResult",testResult)
        return "index"
    }
}
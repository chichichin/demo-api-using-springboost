package com.example.demo.controller;

import com.example.demo.algorithms.numbers.Integers;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/integers")
public class IntegersController {


    @GetMapping("/toBinaryUsingDivideAndModulus")
    public String toBinaryUsingDivideAndModulus(@RequestParam int number) {
        return Integers.toBinaryUsingDivideAndModulus(number);
    }

    @GetMapping("/toBinaryUsingShiftsAndModulus")
    public String toBinaryUsingShiftsAndModulus(@RequestParam int number) {
        return Integers.toBinaryUsingShiftsAndModulus(number);
    }

    @GetMapping("/toBinaryUsingBigDecimal")
    public String toBinaryUsingBigDecimal(@RequestParam int number) {
        return Integers.toBinaryUsingBigDecimal(number);
    }

    @GetMapping("/toBinaryUsingDivideAndDouble")
    public String toBinaryUsingDivideAndDouble(@RequestParam int number) {
        return Integers.toBinaryUsingDivideAndDouble(number);
    }

    @GetMapping("/powerOfTwoUsingLoop")
    public boolean powerOfTwoUsingLoop(@RequestParam int number) {
        return Integers.powerOfTwoUsingLoop(number);
    }

    @GetMapping("/powerOfTwoUsingRecursion")
    public boolean powerOfTwoUsingRecursion(@RequestParam int number) {
        return Integers.powerOfTwoUsingRecursion(number);
    }

    @GetMapping("/powerOfTwoUsingLog")
    public boolean powerOfTwoUsingLog(@RequestParam int number) {
        return Integers.powerOfTwoUsingLog(number);
    }

    @GetMapping("/powerOfTwoUsingBits")
    public boolean powerOfTwoUsingBits(@RequestParam int number) {
        return Integers.powerOfTwoUsingBits(number);
    }

    @GetMapping("/toEnglish")
    public String toEnglish(@RequestParam int number) {
        return Integers.toEnglish(number);
    }
    @GetMapping("/toBinary")
    public Map<String, String> toBinary(
            @RequestParam("number1") int number1,
            @RequestParam("number2") int number2,
            @RequestParam("number3") int number3,
            @RequestParam("number4") int number4) {

        Map<String, String> results = new HashMap<>();

//         Gọi các phương thức trong Integers
        results.put("divideAndModulus", Integers.toBinaryUsingDivideAndModulus(number1));
        results.put("shiftsAndModulus", Integers.toBinaryUsingShiftsAndModulus(number2));
        results.put("bigDecimal", Integers.toBinaryUsingBigDecimal(number3));
        results.put("divideAndDouble", Integers.toBinaryUsingDivideAndDouble(number4));

        RestTemplate restTemplate = new RestTemplate();
        String anotherApiUrl = "http://localhost:9090/api/anotherBinary?number=" + number1;
        String anotherApiResult = restTemplate.getForObject(anotherApiUrl, String.class);
        results.put("anotherBinary", anotherApiResult);

        return results;
    }
}

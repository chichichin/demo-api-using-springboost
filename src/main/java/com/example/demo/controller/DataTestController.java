package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DataTestController {

    // Endpoint for factorial
    @GetMapping("/factorial/{x}")
    public int factorial(@PathVariable int x) {
        if (x <= 1) {
            return 1;
        }
        int res = 1;
        for (int i = 2; i <= x; i++) {
            res *= i;
        }
        return res;
    }

    // Endpoint for grade
    @GetMapping("/grade/{averageGrade}")
    public char grade(@PathVariable int averageGrade) {
        if (averageGrade > 90 && averageGrade < 100)
            return 'A';
        else if (averageGrade > 80 && averageGrade < 90)
            return 'B';
        else if (averageGrade > 70 && averageGrade < 80)
            return 'C';
        else if (averageGrade > 60 && averageGrade < 70)
            return 'D';
        else if (averageGrade > 0 && averageGrade < 60)
            return 'F';
        return 'I';
    }

    // Endpoint for getFare
    @GetMapping("/fare")
    public ResponseEntity<FareResponse> getFare(@RequestParam int age, @RequestParam int distance) {
        int fare = 0;

        if (age >= 4 && age <= 14) {
            if (distance >= 10) {
                fare = 130;
            } else {
                fare = 100;
            }
        } else if (age >= 15) {
            if (distance < 10 && age >= 60) {
                fare = 160;
            } else if (distance >= 10 && age < 60) {
                fare = 250;
            } else {
                fare = 200;
            }
        }

        FareResponse response = new FareResponse(fare);
        return ResponseEntity.ok(response);
    }

    // Định nghĩa lớp FareResponse
    public static class FareResponse {
        private int fare;

        public FareResponse(int fare) {
            this.fare = fare;
        }

        public int getFare() {
            return fare;
        }

        public void setFare(int fare) {
            this.fare = fare;
        }
    }

    // Endpoint for i4Power
    @GetMapping("/i4power")
    public int i4Power(@RequestParam int i, @RequestParam int j) {
        int value;

        if (j < 0) {
            if (i == 1) {
                value = 1;
            } else if (i == 0) {
                return -1;
            } else {
                value = 0;
            }
        } else if (j >= 0) {
            if (i == 0) {
                return -1;
            } else {
                value = 1;
            }
        } else if (j >= 1) {
            value = i;
        } else {
            value = 1;
            for (int k = 1; k <= j; k++) {
                value *= i;
            }
        }
        return value;
    }

    // Other methods can be similarly mapped to endpoints
    // ...

    // Endpoint for CheckValidDate
    @GetMapping("/check-valid-date")
    public int checkValidDate(@RequestParam int day, @RequestParam int month, @RequestParam int year) {
        if (day > 1 && month > 1 && year > 1 && day < 31 && month < 12 && year < 2020) {
            if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
                    && (day <= 31))
                return 1;
            if ((month == 4 || month == 6 || month == 9 || month == 11) && (day <= 30))
                return 1;
            if ((month == 2) && (day < 28))
                return 1;
            if ((month == 2) && (day == 29) && (year % 4 == 0) && (year % 400 != 0))
                return 1;
        }
        return 0;
    }

    // Add similar endpoints for all other methods
}


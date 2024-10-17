package com.ddmtchr.naukatesttask.controller;

import com.ddmtchr.naukatesttask.dto.CountEmployeeByNameDTO;
import com.ddmtchr.naukatesttask.dto.EmployeeDTO;
import com.ddmtchr.naukatesttask.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/groupByName")
    public ResponseEntity<List<CountEmployeeByNameDTO>> groupEmployeesByName() {
        return new ResponseEntity<>(employeeService.groupByName(), HttpStatus.OK);
    }

    @GetMapping("/sortByName")
    public ResponseEntity<List<EmployeeDTO>> sortEmployeesByName() {
        return new ResponseEntity<>(employeeService.sortByName(), HttpStatus.OK);
    }

    @GetMapping("/findBetween")
    public ResponseEntity<List<EmployeeDTO>> findBirthDateBetween(@RequestParam String start, @RequestParam String end) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date startDate = format.parse(start);
        Date endDate = format.parse(end);

        return new ResponseEntity<>(employeeService.findBetween(startDate, endDate), HttpStatus.OK);
    }
}

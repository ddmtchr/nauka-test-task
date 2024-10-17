package com.ddmtchr.naukatesttask.service;

import com.ddmtchr.naukatesttask.domain.Employee;
import com.ddmtchr.naukatesttask.dto.CountEmployeeByNameDTO;
import com.ddmtchr.naukatesttask.dto.EmployeeDTO;
import com.ddmtchr.naukatesttask.exception.NotFoundException;
import com.ddmtchr.naukatesttask.mapper.EmployeeMapper;
import com.ddmtchr.naukatesttask.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeDTO findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found"));
        return EmployeeMapper.INSTANCE.toDto(employee);
    }

    public List<CountEmployeeByNameDTO> groupByName() {
        return employeeRepository.groupByName();
    }

    public List<EmployeeDTO> sortByName() {
        return employeeRepository.sortByName().stream().map(EmployeeMapper.INSTANCE::toDto).toList();
    }

    public List<EmployeeDTO> findBetween(Date start, Date end) {
        return employeeRepository.findBirthDateBetween(start, end).stream().map(EmployeeMapper.INSTANCE::toDto).toList();
    }
}

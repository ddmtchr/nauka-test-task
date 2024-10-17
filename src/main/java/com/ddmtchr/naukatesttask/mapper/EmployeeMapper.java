package com.ddmtchr.naukatesttask.mapper;

import com.ddmtchr.naukatesttask.domain.Employee;
import com.ddmtchr.naukatesttask.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDTO toDto(Employee employee);
}

package com.ddmtchr.naukatesttask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountEmployeeByNameDTO {
    private String name;
    private Long count;
}

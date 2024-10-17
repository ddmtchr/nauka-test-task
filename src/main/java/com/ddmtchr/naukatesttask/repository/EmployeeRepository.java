package com.ddmtchr.naukatesttask.repository;

import com.ddmtchr.naukatesttask.domain.Employee;
import com.ddmtchr.naukatesttask.dto.CountEmployeeByNameDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query(value = "select * from employee e where e.id=?1", nativeQuery = true)
    Optional<Employee> findById(Long id);

    @Query(value = "select e.name, count(e.name) from employee e group by e.name", nativeQuery = true)
    List<Object[]> groupByNameNative();

    @Query(value = "select * from employee e order by e.name asc", nativeQuery = true)
    List<Employee> sortByName();

    @Query(value = "select * from employee e where e.birth_date between ?1 and ?2", nativeQuery = true)
    List<Employee> findBirthDateBetween(Date start, Date end);

    default List<CountEmployeeByNameDTO> groupByName() {
        List<Object[]> results = groupByNameNative();
        return results.stream()
                .map(result -> new CountEmployeeByNameDTO((String) result[0], (Long) result[1]))
                .toList();
    }
}

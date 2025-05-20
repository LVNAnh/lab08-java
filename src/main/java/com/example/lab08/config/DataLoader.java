package com.example.lab08.config;

import com.example.lab08.model.Employee;
import com.example.lab08.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.deleteAll();

        employeeRepository.save(new Employee(null, "Thomas Hardy", "thomashardy@mail.com",
                "89 Chiaroscuro Rd, Portland, USA", "(171) 555-2222"));
        employeeRepository.save(new Employee(null, "Dominique Perrier", "dominiqueperrier@mail.com",
                "Obere Str. 57, Berlin, Germany", "(313) 555-5735"));
        employeeRepository.save(new Employee(null, "Maria Anders", "mariaanders@mail.com",
                "25, rue Lauriston, Paris, France", "(503) 555-9931"));
        employeeRepository.save(new Employee(null, "Fran Wilson", "franwilson@mail.com",
                "C/ Araquil, 67, Madrid, Spain", "(204) 619-5731"));
        employeeRepository.save(new Employee(null, "Martin Blank", "martinblank@mail.com",
                "Via Monte Bianco 34, Turin, Italy", "(480) 631-2097"));
    }
}
package com.arun.cucumber.employee;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Employee {
    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NonNull
    private LocalDate dateOfBirth;
    @NonNull
    private LocalDate startDate;

    private LocalDate endDate;
    @NotEmpty
    private String employmentType;
    @NotEmpty
    private String email;
    @NotNull
    private List<Phone> phones;
}

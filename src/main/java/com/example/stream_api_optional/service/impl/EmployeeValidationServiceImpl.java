package com.example.stream_api_optional.service.impl;

import com.example.stream_api_optional.exception.InvalidEmployeeDataException;
import com.example.stream_api_optional.service.EmployeeValidationService;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.*;
@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService {
    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }

    private void validateName(String name) {
        if (!isAlpha(name)) throw new InvalidEmployeeDataException("Некорректное значение имени: " + name);
    }
}

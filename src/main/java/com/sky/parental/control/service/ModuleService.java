package com.sky.parental.control.service;

import com.sky.parental.exception.TechnicalFailureException;
import com.sky.parental.exception.TitleNotFoundException;

public interface ModuleService {
    String getParentalControlLevel(String movieId) throws TitleNotFoundException, TechnicalFailureException;

}

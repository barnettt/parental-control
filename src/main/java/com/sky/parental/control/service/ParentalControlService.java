package com.sky.parental.control.service;

import java.util.function.BiPredicate;

import com.sky.parental.control.enums.ParentalControlLevel;

import org.springframework.beans.factory.annotation.Autowired;

public class ParentalControlService {

    @Autowired
    ModuleService moduleService;

    BiPredicate<ParentalControlLevel, ParentalControlLevel> isTheMovieAllowed = (a , b )  ->  a != null && b != null && a.ordinal() >= b.ordinal();

    public String getParentalControlLevelForMovie(final String movieId) {
        return moduleService.getParentalControlLevel(movieId);
    }


    public boolean checkCustomerParentalPreferenceForMovie(final String customerParentalControlPreference, final String movieId) {
        String movieControlLevel = getParentalControlLevelForMovie(movieId);

        ParentalControlLevel movieParentalControlLevel = ParentalControlLevel.getGetControlLevelFor(movieControlLevel);

        if(isTheMovieAllowed.test(ParentalControlLevel.getGetControlLevelFor(customerParentalControlPreference),  movieParentalControlLevel)) {
            return true;
        }
        return false;
    }
}

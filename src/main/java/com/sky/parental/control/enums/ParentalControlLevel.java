package com.sky.parental.control.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum ParentalControlLevel {

    U("U"), PG("PG"), TWELVE("12"), FIFTEEN("15"), EIGHTEEN("18");

    private String controlLevel;

    ParentalControlLevel(String controlLevel) {
        this.controlLevel = controlLevel;
    }

    public static ParentalControlLevel getGetControlLevelFor(final String movieControlLevel) {
            List<ParentalControlLevel> values = Arrays.asList(values());
            Optional<ParentalControlLevel> level = values
                                                    .stream()
                                                    .filter(val -> val.name().equalsIgnoreCase(movieControlLevel)
                                                            || val.controlLevel.equalsIgnoreCase(movieControlLevel))
                                                    .findFirst();
            return level.orElse(null);
    }
}

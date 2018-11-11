package com.sky.parental.control;


import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.sky.parental.control.enums.ParentalControlLevel;
import com.sky.parental.control.service.ModuleService;
import com.sky.parental.control.service.ParentalControlService;
import com.sky.parental.exception.TechnicalFailureException;
import com.sky.parental.exception.TitleNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ParentalControlServiceTest {

    @Mock
    private ModuleService moduleService;

    @InjectMocks
    ParentalControlService parentalControlService;

    @Test(expected=TitleNotFoundException.class)
    public void shouldThrowTitleNotFoundException() {
        when(moduleService.getParentalControlLevel(anyString())).thenThrow(new TitleNotFoundException());
        parentalControlService.getParentalControlLevelForMovie("movieId");
    }

    @Test(expected=TechnicalFailureException.class)
    public void shouldThrowException() {
        when(moduleService.getParentalControlLevel(anyString())).thenThrow(new TechnicalFailureException());
        parentalControlService.getParentalControlLevelForMovie("movieId");
    }

    @Test
    public void shouldReturnParentControlLevelForMovie() {
        when(moduleService.getParentalControlLevel(anyString())).thenReturn("PG");
        assertThat(parentalControlService.getParentalControlLevelForMovie("movieId"),is("PG"));
    }

    @Test
    public void shouldAcceptParnetalControlLevelAndMovieId_thenReturnTrueForValid() {
         when(moduleService.getParentalControlLevel(anyString())).thenReturn("12");
         assertThat(parentalControlService.checkCustomerParentalPreferenceForMovie("TWELVE","movieId" ),is(true)) ;
    }

    @Test
    public void shouldAcceptParnetalControlLevelAndMovieId_thenReturnTrueForFalse() {
        when(moduleService.getParentalControlLevel(anyString())).thenReturn("12");
        assertThat(parentalControlService.checkCustomerParentalPreferenceForMovie("PG","movieId" ),is(false)) ;
    }

    @Test
    public void shouldAcceptParnetalControlLevelAndMovieId_thenReturnTrueForEighteen() {
        when(moduleService.getParentalControlLevel(anyString())).thenReturn("18");
        assertThat(parentalControlService.checkCustomerParentalPreferenceForMovie("EIGHTEEN","movieId" ),is(true)) ;

    }

    @Test
    public void shouldAcceptParnetalControlLevelAndMovieId_thenReturnTrueForU() {
        when(moduleService.getParentalControlLevel(anyString())).thenReturn("U");
        assertThat(parentalControlService.checkCustomerParentalPreferenceForMovie("U","movieId" ),is(true)) ;

    }

    @Test
    public void shouldAcceptParnetalControlLevelAndMovieId_thenReturnTrueForUAndPG() {
        when(moduleService.getParentalControlLevel(anyString())).thenReturn("PG");
        assertThat(parentalControlService.checkCustomerParentalPreferenceForMovie("U","movieId" ),is(false)) ;
    }

    @Test
    public void shouldAcceptParnetalControlLevelAndMovieId_thenReturnTrueForValid12() {
        when(moduleService.getParentalControlLevel(anyString())).thenReturn("12");
        assertThat(parentalControlService.checkCustomerParentalPreferenceForMovie("12","movieId" ),is(true)) ;
    }

    @Test
    public void shouldAcceptParnetalControlLevelAndMovieId_thenReturnTrueForPG() {
        when(moduleService.getParentalControlLevel(anyString())).thenReturn("12");
        assertThat(parentalControlService.checkCustomerParentalPreferenceForMovie("PG","movieId" ),is(false)) ;
    }

    @Test
    public void shouldAcceptParnetalControlLevelAndMovieId_thenReturnTrueFor18() {
        when(moduleService.getParentalControlLevel(anyString())).thenReturn("18");
        assertThat(parentalControlService.checkCustomerParentalPreferenceForMovie("18","movieId" ),is(true)) ;

    }

}

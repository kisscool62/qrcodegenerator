package fr.qrcodegenerator.ui.validators;

import fr.qrcodegenerator.ui.Errors;
import org.junit.Test;

import javax.swing.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * User: Pascal AUREGAN
 * Date: 10/3/14
 */
public class URLFieldValidatorTest {

    @Test
    public void shouldValidate(){
        //given
        URLFieldValidator testedURLFieldValidator = new URLFieldValidator();
        JTextField mockedTextField = mock(JTextField.class);
        when(mockedTextField.getText()).thenReturn("http://www.ubuntu.com/");

        //when
        String actualValue = testedURLFieldValidator.validates(mockedTextField);

        //then
        assertEquals("http://www.ubuntu.com/", actualValue);
    }

    @Test
    public void validateShouldAdd(){
        //given
        URLFieldValidator testedURLFieldValidator = new URLFieldValidator();
        JTextField mockedTextField = mock(JTextField.class);
        when(mockedTextField.getText()).thenReturn("http://www.ubuntu.com");

        //when
        String actualValue = testedURLFieldValidator.validates(mockedTextField);

        //then
        assertEquals("http://www.ubuntu.com/", actualValue);
    }

    @Test
    public void validateShouldErr400WhenNullField(){
        //given
        URLFieldValidator testedURLFieldValidator = new URLFieldValidator();
        JTextField mockedTextField = null;

        //when
        try{
            testedURLFieldValidator.validates(mockedTextField);
            fail();
        }catch(IllegalArgumentException iae){
            assertTrue(iae.getMessage().contains(Errors.ERR_400.name()));
        }

    }

    @Test
    public void validateShouldErr410WhenInvalid(){
        //given
        URLFieldValidator testedURLFieldValidator = new URLFieldValidator();
        JTextField mockedTextField = null;

        //when
        try{
            testedURLFieldValidator.validates(mockedTextField);
            fail();
        }catch(IllegalArgumentException iae){
            assertTrue(iae.getMessage().contains(Errors.ERR_400.name()));
        }

    }

}

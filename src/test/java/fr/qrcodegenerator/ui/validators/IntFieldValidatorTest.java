package fr.qrcodegenerator.ui.validators;

import fr.qrcodegenerator.ui.Errors;
import org.junit.Test;

import javax.swing.*;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * User: Pascal AUREGAN
 * Date: 9/29/14
 */
public class IntFieldValidatorTest {

    @Test
    public void shouldValidate(){
        //given
        IntFieldValidator testedINIntFieldValidator = new IntFieldValidator();
        JTextField mockedTextField = mock(JTextField.class);
        when(mockedTextField.getText()).thenReturn("1230");

        //when
        Integer actualValue = testedINIntFieldValidator.validates(mockedTextField);

        //then
        assertEquals((Integer)1230, actualValue);
    }

    @Test
    public void shouldNotValidateWhenNullTextFieldGiven(){
        //given
        IntFieldValidator testedINIntFieldValidator = new IntFieldValidator();
        JTextField mockedTextField = null;

        //when
        try{
            testedINIntFieldValidator.validates(mockedTextField);
            fail();
        } catch(IllegalArgumentException iae){
            assertTrue(iae.getMessage().contains(Errors.ERR_201.name()));
        }

    }

    @Test
    public void shouldNotValidateWhenNullGiven(){
        //given
        IntFieldValidator testedINIntFieldValidator = new IntFieldValidator();
        JTextField mockedTextField = mock(JTextField.class);
        when(mockedTextField.getText()).thenReturn(null); // Null Given

        //when
        try{
            testedINIntFieldValidator.validates(mockedTextField);
            fail();
        } catch(IllegalArgumentException iae){
            assertTrue(iae.getMessage().contains(Errors.ERR_202.name()));
        }

    }

    @Test
    public void shouldNotValidateWhenEmptyGiven(){
        //given
        IntFieldValidator testedINIntFieldValidator = new IntFieldValidator();
        JTextField mockedTextField = mock(JTextField.class);
        when(mockedTextField.getText()).thenReturn("");// Empty String

        //when
        try{
            testedINIntFieldValidator.validates(mockedTextField);
            fail();
        } catch(IllegalArgumentException iae){
            assertTrue(iae.getMessage().contains(Errors.ERR_210.name()));
        }

    }

    @Test
    public void shouldNotValidateWhenNotANumberGiven(){
        //given
        IntFieldValidator testedINIntFieldValidator = new IntFieldValidator();
        JTextField mockedTextField = mock(JTextField.class);
        when(mockedTextField.getText()).thenReturn("12aa");// Not a number(aa)

        //when
        try{
            testedINIntFieldValidator.validates(mockedTextField);
            fail();
        } catch(IllegalArgumentException iae){
            assertTrue(iae.getMessage().contains(Errors.ERR_211.name()));
        }

    }
}

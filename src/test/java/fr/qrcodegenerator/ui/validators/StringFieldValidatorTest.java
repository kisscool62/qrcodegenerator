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
 * Date: 10/2/14
 */
public class StringFieldValidatorTest {

    @Test
    public void shouldValidate(){
        //given
        StringFieldValidator testedStringFieldValidator = new StringFieldValidator();
        JTextField mockedTextField = mock(JTextField.class);
        when(mockedTextField.getText()).thenReturn("toto");

        //when
        String actualValue = testedStringFieldValidator.validates(mockedTextField);

        //then
        assertEquals("toto", actualValue);
    }

    @Test
    public void shouldNotValidateWhenNullTextFieldGiven(){
        //given
        StringFieldValidator testedStringFieldValidator = new StringFieldValidator();
        JTextField mockedTextField = null;

        //when
        try{
            testedStringFieldValidator.validates(mockedTextField);
            fail();
        } catch(IllegalArgumentException iae){
            assertTrue(iae.getMessage().contains(Errors.ERR_300.name()));
        }

    }


    @Test
    public void shouldNotValidateWhenNullGiven(){
        //given
        StringFieldValidator testedStringFieldValidator = new StringFieldValidator();
        JTextField mockedTextField = mock(JTextField.class);
        when(mockedTextField.getText()).thenReturn(null); // Null Given

        //when
        try{
            testedStringFieldValidator.validates(mockedTextField);
            fail();
        } catch(IllegalArgumentException iae){
            assertTrue(iae.getMessage().contains(Errors.ERR_301.name()));
        }

    }

    @Test
    public void shouldNotValidateWhenEmptyGiven(){
        //given
        StringFieldValidator testedStringFieldValidator = new StringFieldValidator();
        JTextField mockedTextField = mock(JTextField.class);
        when(mockedTextField.getText()).thenReturn("");// Empty String

        //when
        try{
            testedStringFieldValidator.validates(mockedTextField);
            fail();
        } catch(IllegalArgumentException iae){
            assertTrue(iae.getMessage().contains(Errors.ERR_310.name()));
        }

    }
}

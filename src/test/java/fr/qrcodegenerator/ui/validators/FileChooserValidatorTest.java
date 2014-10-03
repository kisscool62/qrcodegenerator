package fr.qrcodegenerator.ui.validators;

import fr.qrcodegenerator.ui.Errors;
import org.junit.Test;

import javax.swing.*;
import java.io.File;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * User: Pascal AUREGAN
 * Date: 9/28/14
 */
public class FileChooserValidatorTest {

    @Test
    public void shouldValidate(){
        //given
        final FileChooserValidator fileChooserValidator = new FileChooserValidator();
        final JFileChooser mockedFileChooser = mock(JFileChooser.class);
        final File mockedFile = mock(File.class);
        when(mockedFile.exists()).thenReturn(true);
        when(mockedFile.getAbsolutePath()).thenReturn("SUPER_PATH");
        when(mockedFileChooser.getSelectedFile()).thenReturn(mockedFile);

        //when
        String validatedString = fileChooserValidator.validates(mockedFileChooser);


        //then
        assertEquals("SUPER_PATH", validatedString);
    }

    @Test
    public void shouldNotValidateWhenNullFileChooser(){
        //given
        final FileChooserValidator fileChooserValidator = new FileChooserValidator();

        final JFileChooser nullFileChooser = null;//file chooser is null

        //when
        try{
            fileChooserValidator.validates(nullFileChooser);
            fail("Should have thrown IllegalArgumentException");
        }catch (IllegalArgumentException iae){
            //then
            assertTrue(iae.getMessage().contains(Errors.ERR_101.name()));

        }

    }

    @Test
    public void shouldNotValidateWhenNullFile(){
        //given
        final FileChooserValidator fileChooserValidator = new FileChooserValidator();
        final JFileChooser mockedFileChooser = mock(JFileChooser.class);

        final File nullFile = null;// file is null

        when(mockedFileChooser.getSelectedFile()).thenReturn(nullFile);

        //when
        try{
            fileChooserValidator.validates(mockedFileChooser);
            fail("Should have thrown IllegalArgumentException");
        }catch (IllegalArgumentException iae){
            //then
            assertTrue(iae.getMessage().contains(Errors.ERR_102.name()));

        }

    }

    @Test
    public void shouldNotValidateWhenFileDoesNotExist(){
        //given
        final FileChooserValidator fileChooserValidator = new FileChooserValidator();
        final JFileChooser mockedFileChooser = mock(JFileChooser.class);
        final File mockedFile = mock(File.class);

        when(mockedFile.exists()).thenReturn(false);// file does not exist

        when(mockedFileChooser.getSelectedFile()).thenReturn(mockedFile);

        //when
        try{
            fileChooserValidator.validates(mockedFileChooser);
            fail("Should have thrown IllegalArgumentException");
        }catch (IllegalArgumentException iae){
            //then
            assertTrue(iae.getMessage().contains(Errors.ERR_110.name()));

        }

    }


}

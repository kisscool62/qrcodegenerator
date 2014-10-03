package fr.qrcodegenerator.ui.validators;

import com.google.common.base.Preconditions;
import fr.qrcodegenerator.services.itf.validators.UIInformationValidator;
import fr.qrcodegenerator.ui.Errors;

import javax.swing.*;

/**
 * User: Pascal AUREGAN
 * Date: 9/21/14
 */
public class IntFieldValidator implements UIInformationValidator<JTextField, Integer> {

    @Override
    public Integer validates(JTextField field) {
        Preconditions.checkArgument(field != null, Errors.ERR_201);
        String fieldText = field.getText();
        Preconditions.checkArgument(fieldText != null, Errors.ERR_202);
        fieldText = fieldText.trim();
        Preconditions.checkArgument(fieldText.length() != 0, Errors.ERR_210);
        Integer integer;
        try{
            integer = Integer.valueOf(fieldText); 
        }catch (NumberFormatException nfe){
            throw new NumberFormatException(fieldText + Errors.ERR_211);
        }
        return integer;
    }
}

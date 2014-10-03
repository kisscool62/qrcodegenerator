package fr.qrcodegenerator.ui.validators;

import com.google.common.base.Preconditions;
import fr.qrcodegenerator.services.itf.validators.UIInformationValidator;
import fr.qrcodegenerator.ui.Errors;
import org.apache.commons.validator.routines.UrlValidator;

import javax.swing.*;

/**
 * User: Pascal AUREGAN
 * Date: 9/21/14
 */
public class StringFieldValidator implements UIInformationValidator<JTextField, String> {

    @Override
    public String validates(JTextField field) {
        String filePattern;
        Preconditions.checkArgument(field != null, Errors.ERR_300);
        filePattern = field.getText();
        Preconditions.checkArgument(filePattern != null, Errors.ERR_301);
        filePattern = filePattern.trim();
        Preconditions.checkArgument(!filePattern.isEmpty(), Errors.ERR_310);

        return filePattern;
    }
}

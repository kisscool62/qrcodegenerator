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
public class URLFieldValidator implements UIInformationValidator<JTextField, String> {

    @Override
    public String validates(JTextField field) {
        Preconditions.checkArgument(field != null, Errors.ERR_400);
        String url = field.getText();
        org.apache.commons.validator.routines.UrlValidator validator = new UrlValidator();
        Preconditions.checkArgument(validator.isValid(url), Errors.ERR_410);
        if(!url.endsWith("/")){
            url += "/";
        }
        return url;
    }
}

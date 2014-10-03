package fr.qrcodegenerator.ui.validators;

import com.google.common.base.Preconditions;
import fr.qrcodegenerator.services.itf.validators.UIInformationValidator;
import fr.qrcodegenerator.ui.Errors;

import javax.swing.*;
import java.io.File;

/**
 * User: Pascal AUREGAN
 * Date: 9/21/14
 */
public class FileChooserValidator implements UIInformationValidator <JFileChooser, String>{

    @Override
    public String validates(JFileChooser fileChooser) {
        Preconditions.checkArgument(fileChooser != null, Errors.ERR_101);
        File file = fileChooser.getSelectedFile();
        Preconditions.checkArgument(file != null, Errors.ERR_102);
        Preconditions.checkArgument(file.exists(), Errors.ERR_110.toString(), file.getAbsolutePath());
        return file.getAbsolutePath();
    }
}

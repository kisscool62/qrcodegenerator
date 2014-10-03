package fr.qrcodegenerator.ui.listeners;

import com.google.common.base.Preconditions;
import fr.qrcodegenerator.model.QRCodeRangeInformation;
import fr.qrcodegenerator.services.impl.actions.CreateQRCodeGeneratorAction;
import fr.qrcodegenerator.services.itf.actions.QRCodeGeneratorAction;
import fr.qrcodegenerator.services.itf.validators.UIInformationValidator;
import fr.qrcodegenerator.ui.validators.FileChooserValidator;
import fr.qrcodegenerator.ui.validators.IntFieldValidator;
import fr.qrcodegenerator.ui.validators.StringFieldValidator;
import fr.qrcodegenerator.ui.validators.URLFieldValidator;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: Pascal AUREGAN
 * Date: 9/20/14
 */
@Slf4j
public class GenerateQRCodeButtonListener implements ActionListener {
    private static final String DEFAULT_FILE_PATTERN = "qrcode-";
    private final JTextField urlField;
    private final JTextField numberOfQRCodesField;
    private final JFileChooser pathForQRCodesChooser;
    private final JTextField filePatternField;
    private final QRCodeGeneratorAction qrCodeGeneratorAction = new CreateQRCodeGeneratorAction();
    private final UIInformationValidator<JTextField, Integer> intFieldValidator = new IntFieldValidator();
    private final UIInformationValidator<JTextField, String> urlFieldValidator = new URLFieldValidator();
    private final UIInformationValidator<JFileChooser, String> fileChooserValidator = new FileChooserValidator();
    private final UIInformationValidator<JTextField, String> stringFieldValidator = new StringFieldValidator();


    public GenerateQRCodeButtonListener(JTextField urlField, JTextField numberQRCodesField, JFileChooser pathForQRCodesChooser, JTextField filePatternField) {
        this.pathForQRCodesChooser = pathForQRCodesChooser;
        this.filePatternField = filePatternField;
        Preconditions.checkArgument(urlField != null, "URL field should not be null");
        Preconditions.checkArgument(numberQRCodesField != null, "Number of QRCodes field should not be null");
        this.urlField = urlField;
        this.numberOfQRCodesField = numberQRCodesField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String urlRoot = urlFieldValidator.validates(urlField);
        int numberOfQRCodes = intFieldValidator.validates(numberOfQRCodesField);
        String pathForQRCodes = fileChooserValidator.validates(pathForQRCodesChooser);
        String filePattern;
        try{
            filePattern = stringFieldValidator.validates(filePatternField);
        }catch (IllegalArgumentException iae){
            iae.printStackTrace();
            log.error("Default value 'qrcode-' will be used");
            filePattern = DEFAULT_FILE_PATTERN;
        }

        QRCodeRangeInformation qrCodeRangeInformation = new QRCodeRangeInformation(urlRoot, numberOfQRCodes, pathForQRCodes, filePattern);
        qrCodeGeneratorAction.perform(qrCodeRangeInformation);
    }
}

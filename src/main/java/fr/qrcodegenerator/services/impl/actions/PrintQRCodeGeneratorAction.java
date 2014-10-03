package fr.qrcodegenerator.services.impl.actions;

import fr.qrcodegenerator.model.QRCodeRangeInformation;
import fr.qrcodegenerator.services.itf.actions.QRCodeGeneratorAction;

/**
 * User: Pascal AUREGAN
 * Date: 9/20/14
 */
public class PrintQRCodeGeneratorAction implements QRCodeGeneratorAction {
    @Override
    public void perform(QRCodeRangeInformation qrCodeRangeInformation) {
        System.out.println(qrCodeRangeInformation.toString());
    }
}

package fr.qrcodegenerator.services.itf.actions;

import fr.qrcodegenerator.model.QRCodeRangeInformation;

/**
 * User: Pascal AUREGAN
 * Date: 9/20/14
 */
public interface  QRCodeGeneratorAction {
    void perform(QRCodeRangeInformation qrCodeRangeInformation);
}

package fr.qrcodegenerator.services.impl.actions;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import fr.qrcodegenerator.model.QRCodeRangeInformation;
import fr.qrcodegenerator.services.impl.encoders.EncoderServiceImpl;
import fr.qrcodegenerator.services.impl.generators.SimpleQRCodeGenerator;
import fr.qrcodegenerator.services.impl.io.ImageWriterImpl;
import fr.qrcodegenerator.services.itf.actions.QRCodeGeneratorAction;
import fr.qrcodegenerator.services.itf.encoders.EncoderService;
import fr.qrcodegenerator.services.itf.generators.QRCodeGenerator;
import fr.qrcodegenerator.services.itf.io.ImageWriter;
import lombok.extern.slf4j.Slf4j;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * User: Pascal AUREGAN
 * Date: 9/20/14
 */
@Slf4j
public class CreateQRCodeGeneratorAction implements QRCodeGeneratorAction {
    private QRCodeGenerator qrCodeGenerator = new SimpleQRCodeGenerator();
    private ImageWriter imageWriter = new ImageWriterImpl();
    private EncoderService encoderService = new EncoderServiceImpl();

    @Override
    public void perform(QRCodeRangeInformation qrCodeRangeInformation) {

        BitMatrix bitMatrix = null;
        int numberOfQRCodes = qrCodeRangeInformation.getNumberOfQRCodes();
        for (int i = 1; i <= numberOfQRCodes; i++) {
            String encoded = encoderService.encode(i);
            log.info("starting qr code {}, {}/{}", encoded, i, numberOfQRCodes);
            try {
                bitMatrix = qrCodeGenerator.generatesMatrix(qrCodeRangeInformation.getUrlRoot() + encoded, 400);
            } catch (WriterException e) {
                e.printStackTrace();
            }
            BufferedImage image = qrCodeGenerator.createsQRCodeImage(bitMatrix);

            try {
                String qrCodeEmplacement = qrCodeRangeInformation.getPathForQRCodes() + File.separator + qrCodeRangeInformation.getFilePattern();
                log.info("QRCodes will be created : {}", qrCodeEmplacement);
                imageWriter.writeImageToDisk(qrCodeEmplacement + encoded, "png", image);
            } catch (IOException e) {
                e.printStackTrace();
            }
            log.info("ending qr code {}, {}/{}", encoded, i, numberOfQRCodes);
        }

    }
}

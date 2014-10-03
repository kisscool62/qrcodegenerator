package fr.qrcodegenerator.services;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import fr.qrcodegenerator.services.impl.generators.SimpleQRCodeGenerator;
import fr.qrcodegenerator.services.impl.io.ImageWriterImpl;
import fr.qrcodegenerator.services.itf.generators.QRCodeGenerator;
import fr.qrcodegenerator.services.itf.io.ImageWriter;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * User: Pascal AUREGAN
 * Date: 9/20/14
 */
public class SimpleQRCodeGeneratorMain {

    public static void main(String[] args) {
        final String data = "http://kisscool62.com";
        final int size = 400;
        final QRCodeGenerator simpleQRCodeGenerator = new SimpleQRCodeGenerator();
        final ImageWriter imageWriter = new ImageWriterImpl();
        BitMatrix bitMatrix = null;

        // encode
        try {
            bitMatrix = simpleQRCodeGenerator.generatesMatrix(data, size);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        String imageFormat = "png";
        String outputFileName = "test." + imageFormat;

        BufferedImage image = simpleQRCodeGenerator.createsQRCodeImage(bitMatrix);

        // write in a file
        try {
            imageWriter.writeImageToDisk(outputFileName, imageFormat, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

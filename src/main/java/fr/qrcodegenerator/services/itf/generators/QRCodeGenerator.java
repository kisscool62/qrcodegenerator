package fr.qrcodegenerator.services.itf.generators;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * User: Pascal AUREGAN
 * Date: 9/20/14
 */
public interface QRCodeGenerator {

    BitMatrix generatesMatrix(String data, int size) throws WriterException;

    BufferedImage createsQRCodeImage(BitMatrix bitMatrix, int foreGround, int backGround);

    BufferedImage createsQRCodeImage(BitMatrix bitMatrix);

}

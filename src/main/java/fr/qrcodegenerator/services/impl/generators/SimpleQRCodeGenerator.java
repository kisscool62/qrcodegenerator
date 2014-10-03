package fr.qrcodegenerator.services.impl.generators;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import fr.qrcodegenerator.services.itf.generators.QRCodeGenerator;

import java.awt.image.BufferedImage;

/**
 * User: Pascal AUREGAN
 * Date: 9/20/14
 */
public class SimpleQRCodeGenerator implements QRCodeGenerator {
    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;


    @Override
    public BitMatrix generatesMatrix(String data, int size) throws WriterException {
        return new QRCodeWriter().encode(data, BarcodeFormat.QR_CODE, size, size);
    }


    /**
     * copied from com.google.zxing.client.j2se.MatrixToImageWriter.toBufferedImage
     */
    private BufferedImage toBufferedImage(BitMatrix matrix, int foreGround, int backGround) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? foreGround : backGround);
            }
        }
        return image;
    }

    /**
     *
     * @param bitMatrix
     * @param foreGround color
     * @param backGround color
     * @return a buffered image where 1 is colored with foreground color and 0 is colored with background color
     */
    @Override
    public BufferedImage createsQRCodeImage(BitMatrix bitMatrix, int foreGround, int backGround) {
        return toBufferedImage(bitMatrix, foreGround, backGround);
    }


    /**
     *
     * @param bitMatrix
     * @return a buffered Image in black (1 in bitmatrix) in white (0 in bitmatrix) as default colors
     */
    @Override
    public BufferedImage createsQRCodeImage(BitMatrix bitMatrix) {
        return toBufferedImage(bitMatrix, BLACK, WHITE);
    }


}

package fr.qrcodegenerator.services.itf.io;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * User: Pascal AUREGAN
 * Date: 9/28/14
 */
public interface ImageWriter {
    void writeImageToDisk(String outputFileName, String imageFormat, BufferedImage im) throws IOException;
}

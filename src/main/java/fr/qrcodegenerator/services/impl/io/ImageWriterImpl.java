package fr.qrcodegenerator.services.impl.io;

import fr.qrcodegenerator.services.itf.io.ImageWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * User: Pascal AUREGAN
 * Date: 9/28/14
 */
public class ImageWriterImpl implements ImageWriter{

    @Override
    public void writeImageToDisk(String outputFileName, String imageFormat, BufferedImage image) throws IOException {
        // Ecriture sur le disque
        File f = new File(outputFileName);
        f.setWritable(true);
        ImageIO.write(image, imageFormat, f);
        f.createNewFile();
    }
}

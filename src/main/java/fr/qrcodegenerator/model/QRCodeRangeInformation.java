package fr.qrcodegenerator.model;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.ToString;

/**
 * User: Pascal AUREGAN
 * Date: 9/20/14
 */
@Getter
@ToString
public class QRCodeRangeInformation {
    private final String urlRoot;
    private final int numberOfQRCodes;
    private final String pathForQRCodes;
    private final String filePattern;

    public QRCodeRangeInformation(String urlRoot, int numberOfQRCodes, String pathForQRCodes, String filePattern) {
        this.pathForQRCodes = pathForQRCodes;
        this.filePattern = filePattern;
        Preconditions.checkArgument(urlRoot != null, "URL root should not be null");
        this.urlRoot = urlRoot;
        this.numberOfQRCodes = numberOfQRCodes;
    }

}

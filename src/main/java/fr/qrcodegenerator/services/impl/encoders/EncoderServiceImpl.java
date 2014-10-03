package fr.qrcodegenerator.services.impl.encoders;

import fr.qrcodegenerator.services.itf.encoders.EncoderService;

/**
 * User: Pascal AUREGAN
 * Date: 9/21/14
 */
public class EncoderServiceImpl implements EncoderService {
    @Override
    public String encode(int raw) {
        String encodedString = "";
        char[] chars = String.format("%06d", raw).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            c += 17;
            encodedString += c;
        }
        return encodedString;
    }
}

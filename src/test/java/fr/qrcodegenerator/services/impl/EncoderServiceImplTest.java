package fr.qrcodegenerator.services.impl;

import fr.qrcodegenerator.services.impl.encoders.EncoderServiceImpl;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * User: Pascal AUREGAN
 * Date: 9/21/14
 */
public class EncoderServiceImplTest {

    @Test
    public void encodeAnInt(){
        //given
        EncoderServiceImpl encoderService = new EncoderServiceImpl();
        int raw = 1498;

        //when
        String actualEncoded = encoderService.encode(raw);

        //then
        assertEquals("AABEJI", actualEncoded);
    }
}

package fr.qrcodegenerator.services.itf.validators;

import javax.swing.*;

/**
 * User: Pascal AUREGAN
 * Date: 9/21/14
 */
public interface UIInformationValidator <INPUT extends JComponent, OUTPUT>{

    public OUTPUT validates(INPUT field);
}

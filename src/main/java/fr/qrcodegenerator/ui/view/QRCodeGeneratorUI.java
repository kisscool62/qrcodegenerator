package fr.qrcodegenerator.ui.view;

import fr.qrcodegenerator.ui.events.EventQueueProxy;
import fr.qrcodegenerator.ui.listeners.GenerateQRCodeButtonListener;

import javax.swing.*;
import java.awt.*;

/**
 * User: Pascal AUREGAN
 * Date: 9/20/14
 */
public class QRCodeGeneratorUI {
    private JButton generateQRCodesButton;
    private JPanel mainPanel;
    private JTextField urlField;
    private JLabel urlLabel;
    private JTextField numberQRCodesField;
    private JLabel numberQRCodeLabel;
    private JTextField filePatternField;
    private JLabel filePatternLabel;
    private JFileChooser fileChooser;
    private JLabel fileChooserLabel;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public QRCodeGeneratorUI() {
        GenerateQRCodeButtonListener generateQRCodeButtonListener = new GenerateQRCodeButtonListener(urlField, numberQRCodesField, fileChooser, filePatternField);
        generateQRCodesButton.addActionListener(generateQRCodeButtonListener);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("QRCodeGeneratorUI");
        QRCodeGeneratorUI qrCodeGeneratorUI = new QRCodeGeneratorUI();
        frame.setContentPane(qrCodeGeneratorUI.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        EventQueue systemEventQueue = Toolkit.getDefaultToolkit().getSystemEventQueue();
        systemEventQueue.push(new EventQueueProxy());
    }
}

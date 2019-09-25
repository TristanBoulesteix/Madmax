package com.madmax.view.file;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FileManagerFrame extends JFrame implements KeyListener {
    private static final Dimension BUTTON_DIMENSIONS = new Dimension(300, 25);
    private static final String SELECT_BUTTON_LABEL = "Sélectionnez un fichier crypté";
    private static final String SAVE_BUTTON_LABEL = "Enregistrer sous...";
    private static final FileManagerFrame INSTANCE = new FileManagerFrame();

    private String encryptedFilePath;
    private String savePath;
    private JButton validate;

    public static FileManagerFrame getINSTANCE() {
        return INSTANCE;
    }

    private FileManagerFrame() {
        this.setSize(500, 375);
        this.setUndecorated(false);
        this.setTitle("DECRYPT");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());

        this.initComponents();
    }

    private void initComponents() {
        // Panel to show the files selector form
        JPanel filePanel = new JPanel();
        filePanel.setFocusable(true);
        filePanel.setLayout(new GridBagLayout());
        filePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        GridBagConstraints cLoginPanel = new GridBagConstraints();
        cLoginPanel.insets = new Insets(20, 20, 20, 20);
        this.add(filePanel, cLoginPanel);

        // Button to select encrypted file
        JButton selectFileButton = new JButton(SELECT_BUTTON_LABEL);
        selectFileButton.setPreferredSize(BUTTON_DIMENSIONS);
        selectFileButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                this.encryptedFilePath = chooser.getSelectedFile().getAbsolutePath();
                selectFileButton.setText(this.encryptedFilePath);
            } else {
                this.encryptedFilePath = null;
                selectFileButton.setText(SELECT_BUTTON_LABEL);
            }

            this.checkValidation();
        });
        GridBagConstraints cSelectFileButton = new GridBagConstraints();
        cSelectFileButton.gridx = 0;
        cSelectFileButton.gridy = 0;
        cSelectFileButton.insets = new Insets(10, 20, 20, 20);
        filePanel.add(selectFileButton, cSelectFileButton);

        // Button save as
        JButton selectSaveAsLocation = new JButton(SAVE_BUTTON_LABEL);
        selectSaveAsLocation.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                this.savePath = chooser.getSelectedFile().getAbsolutePath();
                selectSaveAsLocation.setText(this.savePath);
            } else {
                this.savePath = null;
                selectSaveAsLocation.setText(SAVE_BUTTON_LABEL);
            }

            this.checkValidation();
        });
        selectSaveAsLocation.setPreferredSize(BUTTON_DIMENSIONS);
        GridBagConstraints cSelectSaveAsLocation = new GridBagConstraints();
        cSelectSaveAsLocation.gridx = 0;
        cSelectSaveAsLocation.gridy = 1;
        cSelectSaveAsLocation.insets = new Insets(10, 20, 20, 20);
        filePanel.add(selectSaveAsLocation, cSelectSaveAsLocation);

        // Button validate
        this.validate = new JButton("Valider");
        this.validate.addActionListener(e -> {

        });
        this.validate.setPreferredSize(BUTTON_DIMENSIONS);
        this.validate.setEnabled(false);
        GridBagConstraints cValidate = new GridBagConstraints();
        cValidate.gridy = 0;
        cValidate.gridy = 2;
        cValidate.insets = new Insets(10, 20, 20, 20);
        filePanel.add(this.validate, cValidate);
    }

    private void checkValidation() {
        if(this.encryptedFilePath != null && this.savePath != null) {
            this.validate.setEnabled(true);
        } else {
            this.validate.setEnabled(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
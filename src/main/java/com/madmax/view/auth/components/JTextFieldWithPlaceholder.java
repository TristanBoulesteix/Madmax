package com.madmax.view.auth.components;

import javax.swing.FocusManager;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class JTextFieldWithPlaceholder extends JTextField implements DocumentListener {
    private String placeHolder = "";

    public JTextFieldWithPlaceholder() {
        super();
        this.getDocument().addDocumentListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (getText().isEmpty() && FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() != this ) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setBackground(Color.GRAY);
            g2.setFont(getFont().deriveFont(Font.ITALIC));
            g2.drawString(placeHolder, 5, 15);
            g2.dispose();
        }
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
       this.reloadPlaceHolder();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.reloadPlaceHolder();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        this.reloadPlaceHolder();
    }

    private void reloadPlaceHolder() {
        this.removeAll();
        this.repaint();
    }
}
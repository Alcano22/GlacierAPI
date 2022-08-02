package com.alcano.glacier.window;

import com.alcano.gamemath.Vector2;
import com.alcano.glacier.core.GlacierAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Window extends JFrame {

    public static final List<Window> ACTIVE_WINDOWS = new ArrayList<>();

    public Window(Vector2 size, String title, int defaultCloseOperation) {
        super(title);

        Dimension sizeDim = size.toDimension();
        this.setMinimumSize(sizeDim);
        this.setMaximumSize(sizeDim);
        this.setPreferredSize(sizeDim);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(defaultCloseOperation);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                ACTIVE_WINDOWS.remove(Window.this);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        this.setVisible(true);

        ACTIVE_WINDOWS.add(this);
    }

    public Window(Vector2 size, String title) {
        this(size, title, DO_NOTHING_ON_CLOSE);
    }

}

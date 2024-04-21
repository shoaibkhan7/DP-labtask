/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.demo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



/**
 * Common interface for all buttons.
 */
interface Button {
    void render();
    void onClick();
}

/**
 * HTML button implementation.
 */
 class HtmlButton implements Button {

    @Override
    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    @Override
    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}

/**
 * Windows button implementation.
 */
class WindowsButton implements Button {
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JButton button;

    @Override
     public void render() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello World!");
        label.setOpaque(true);
        label.setBackground(new Color(235, 233, 126));
        label.setFont(new Font("Dialog", Font.BOLD, 44));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(panel);
        panel.add(label);
        onClick();
        panel.add(button);

        frame.setSize(320, 200);
        frame.setVisible(true);
        onClick();
    }

    @Override
    public void onClick() {
        button = new JButton("Exit");
        button.addActionListener((ActionEvent e) -> {
            frame.setVisible(false);
            System.exit(0);
        });
    }
}




abstract class Dialog {

    public void renderWindow() {
       

        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}


/**
 * HTML Dialog will produce HTML buttons.
 */
class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}


 class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}


public class Demo {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}

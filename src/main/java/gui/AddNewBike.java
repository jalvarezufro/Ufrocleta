/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JTextField;

/**
 *
 * @author JAVIER
 */
    public class AddNewBike extends JFrame implements ActionListener {

        private String title;
        private JTextField brand;
        private JTextField color;

        private JButton add;
        private JButton cancel;

        /**
         * Constructor of this window.
         *
         * @param title
         * @throws HeadlessException
         */
        public AddNewBike(String title) throws HeadlessException {
            super(title);
            this.setLayout(null);

            this.title = title;

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            setSize(480, 270);
            this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
            this.setResizable(false);
            crearText();
            crearButtons();
            // rut.setBounds(16, 9, 192, 27);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }

        public void crearText() {
            //text nombre
            brand = new JTextField("Nombre");
            brand.setBounds(16, 27, 192, 27);
            this.add(brand);
            //text rut
            color = new JTextField("Rut");
            color.setBounds(16, 77, 192, 27);
            this.add(color);

        }

        public void crearButtons() {

            //boton aceptar usuario
            add = new JButton("Agregar");
            add.setBounds(240, 90, 192, 27);
            this.add(add);
            add.addActionListener(this);
            //boton cancelar
            cancel = new JButton("Cancelar");
            cancel.setBounds(240, 150, 192, 27);
            this.add(cancel);
            cancel.addActionListener(this);

        }

        /**
         * Detects user actions on this window and executes accordingly.
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == add) {
                MainWindow mWindow = new MainWindow();
                dispose();

            }
            
            if (e.getSource() == cancel) {
                UserManagement userMan = new UserManagement();
                dispose();

            }

        }

    }


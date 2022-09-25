/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appController;

import appModel.Header;
import appView.appFrame;
import appView.createNewInvoice;
import com.sun.media.sound.SoftMixingMixer;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ahmed
 */
public class Controller implements ActionListener {
  
    private appFrame frame;

    public Controller(appFrame frame) {
        this.frame = frame;
    }
    
    
  
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "New Invoice":
                newInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
            case "New Item":
                newItem();
                break;
            case "Delete Item":
                deleteItem();
                break;
            case "Load Files":
               // loadfiles();
                break;
            case "Save Files":
               // savefiles();
                break;
        }
    }

    private void newInvoice() {

    }

    private void deleteInvoice() {

    }

    private void newItem() {

    }

    private void deleteItem() {

    }

    private void loadfiles(String headerPath, String linePath) {
        File headerFile = null;
        File lineFile = null;
        if (headerFile == null && lineFile == null) {
            JFileChooser fc = new JFileChooser();
            int result = fc.showOpenDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                headerFile = fc.getSelectedFile();
                result = fc.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    lineFile = fc.getSelectedFile();
                }
              }
            } else {
                headerFile = new File(headerPath);
                lineFile = new File(linePath);
            }

            if (headerFile != null && lineFile != null) {
                try {
                    /*
                    1,22-11-2020,Ali;
                    2,13-10-2021,saleh
                     */
                    List<String> headerlines = Files.lines(Paths.get(headerFile.getAbsolutePath())).collect(Collectors.toList());

                    List<String> linelines = Files.lines(Paths.get(lineFile.getAbsolutePath())).collect(Collectors.toList());

                    frame.getInvoices().clear();

                    for (String headerline : headerlines) {
                        String[] parts = headerline.split(",");
                        int invoiceNum = Integer.parseInt(parts[0]);
                        Date date = frame.sdf.parse(parts[1]);
                        String name = parts[2];
                        Header invoice = new Header(invoiceNum, name, date);

                        frame.getInvoices().add(Inv);
                    }
                    for(String lineline:linelines){
                        String[] parts = lineline.split(",");
                        int num = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        double price = Double.parseDouble(parts[2]);
                        int count = Integer.parseInt(parts[3]);
                        Inoivce Inv = getInvoiceByNum(num);
                        Line line = new Line(name,price,count,inv);
                        inv.getLines().add(line);
                    }
                    frame.getInvoiceTable().setModel(new HeaderTableModel(frame.getInvoices()));
                    
                } catch (IOException e) {
                    e.printStackTrace();

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    
    
    private Invoice getInvoiceByNum(int num){
    for(Invoice inv : frame:getInvoices())
        if(num==inv.getNum()){
        return inv;
        }
    
    }
    
    
    }

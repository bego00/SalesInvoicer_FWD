/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ahmed
 */
public class HeaderTableModel extends AbstractTableModel
{
    private String[] cols = {"Num" ,"Customer",
        "Date","Total"};
    private List<Invoice> invoices;
    
    public HeaderTableModel(List<Invoice>invoices){
        this.invoices=invoices;
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
}

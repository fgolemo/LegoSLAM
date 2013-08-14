/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.meicogsci.legobot1.map;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.AbstractTableModel;
import org.meicogsci.legobot1.BotSingleton;

/**
 *
 * @author gust
 */
public class MapTableModel extends AbstractTableModel implements ActionListener {

    public BotSingleton bot;

    public MapTableModel() {
        bot = BotSingleton.getInstance();
    }

    @Override
    public int getRowCount() {
        return Map.MAP_HEIGHT;
    }

    @Override
    public int getColumnCount() {
        return Map.MAP_WIDTH;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Field field = bot.map.fields[rowIndex][columnIndex];
        return field.getChar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("mapUpdate")) {
            this.fireTableDataChanged();
        } else {
            System.out.println("sorry, don't know that event:" + e.paramString());
        }
    }
}

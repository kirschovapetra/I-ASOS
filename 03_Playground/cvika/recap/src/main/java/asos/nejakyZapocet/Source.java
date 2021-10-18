/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asos.nejakyZapocet;

/**
 *
 * @author petra
 */
public class Source {
    int count = 0;
    
    String[] rows = new String[]{"riadok 1", "riadok 2", "Greta", "riadok 4"};

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String[] getRows() {
        return rows;
    }

    public void setRows(String[] rows) {
        this.rows = rows;
    }
 
    
    
    public String getMessage(){
        
        return count>rows.length-1? null : rows[count++];
    }
}

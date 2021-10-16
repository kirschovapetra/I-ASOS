
package asos.uloha1;


import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author petra
 */
public class Source {
    private final String filePath = "src/main/resources/data1.txt";
    static long rowIndex = 0;
    
    public String getMessage(){
        
        try {   
            RandomAccessFile raf = new RandomAccessFile(filePath, "r");
            raf.seek(rowIndex);
            
            String cur_line;
            while ((cur_line = raf.readLine()) != null) {
                rowIndex = raf.getFilePointer();
                return cur_line;
            }
        } catch(IOException e) {return null;}
        
        return null;
    }
}

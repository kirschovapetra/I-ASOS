/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Jedlo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author petra
 */
@Local
public interface JedloFacadeLocal {

    void create(Jedlo jedlo);

    void edit(Jedlo jedlo);

    void remove(Jedlo jedlo);

    Jedlo find(Object id);

    List<Jedlo> findAll();

    List<Jedlo> findRange(int[] range);

    int count();
    
}

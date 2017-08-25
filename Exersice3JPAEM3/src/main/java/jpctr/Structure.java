/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpctr;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author vfgya_000
 */
public class Structure {
    public static void main(String[] args)
    {
        
        HashMap puproperties = new HashMap();
        
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/clear.sql");
        Persistence.generateSchema("jpaEM3", puproperties);
        
        puproperties.remove("javax.persistence.sql-load-script-source");
        Persistence.generateSchema("jpaEM3", puproperties);
        
    }
}

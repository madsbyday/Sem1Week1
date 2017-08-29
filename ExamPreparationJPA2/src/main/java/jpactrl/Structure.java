/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpactrl;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author vfgya
 */
public class Structure
{
    public static void main(String[] args)
    {
        HashMap pup = new HashMap();
        
        pup.put("javax.persistence.sql-load-script-source", "scripts/clearDB.sql");
        Persistence.generateSchema("jpaem2", pup);
        
        pup.remove("javax.persistence.sql-load-script-source");
        Persistence.generateSchema("jpaem2", pup);
    }
    
}

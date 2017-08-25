/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontrol;

import java.util.HashMap;
import javax.persistence.Persistence;

/**
 *
 * @author Alexander
 */
public class Structure {
    public static void main(String[] args) {
        
        HashMap puproperties = new HashMap();
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
        Persistence.generateSchema("jpaPU", puproperties);

        puproperties.remove("javax.persistence.sql-load-script-source");
        Persistence.generateSchema("jpaPU", puproperties);

    }
}

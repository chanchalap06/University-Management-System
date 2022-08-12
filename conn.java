/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author ilaan
 */
 class conn{
    Connection c;
    Statement s,p,q,r,t;
    public conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///project","root","Iap192002*");    
            s =c.createStatement();  
            p =c.createStatement();  
           q =c.createStatement();  
           r =c.createStatement();  
           t =c.createStatement();  
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  

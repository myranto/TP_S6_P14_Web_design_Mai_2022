package com.spring.springmvc_v_finale.utils.Connex;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public static Connection getConnection() throws Exception {
        Connection con=null;
        try{
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://localhost:5432/seo1";
	   		String user="postgres";
	   		String password="myranto";
	   		con=(Connection) DriverManager.getConnection(url, user, password);
            return con;
        }
        catch(Exception e){
            throw e;
        }
    }
    public static void main(String[] args) throws Exception {
        System.out.println(Connexion.getConnection());

    }
}

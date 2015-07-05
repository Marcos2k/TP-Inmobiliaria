
package paquete;

import java.sql.*;


public class MySql {
    private Connection conector;
    private Statement comando;
    
    public MySql() throws Exception {
       conectar();
    }
    
    private void conectar() throws Exception {
           Class.forName("com.mysql.jdbc.Driver");
           this.conector = DriverManager.getConnection("jdbc:mysql://localhost/inmobiliaria", "root", "");
            
          
           this.comando = (Statement) conector.createStatement();                                             
    }
    
    public void desconectar() throws Exception{
           this.comando.close();
           this.conector.close();
    }
    
    public ResultSet cargarResulset(String SQL) throws Exception{  
        return this.comando.executeQuery(SQL);        
    }
    

}

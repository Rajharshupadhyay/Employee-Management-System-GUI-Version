/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp_management_system_gui;

/**
 *
 * @author Rajharsh
 */
public class Crud {
    //field
    //Employee result;
    String id;
    Db db = new Db();
    
    //method
    Employee register(Employee e)
    {
        Employee result = db.register(e);
        //System.out.println("crud");
        return result;
    }//register
    
    Employee list(int db1)
    {
          return(db.list(db1));       
    }//list 
    
    int count()
    {
        return(db.count());
    }//count
    
    Employee search(String id)
    {
        return(db.search(id));
    }//constructor
}//crud

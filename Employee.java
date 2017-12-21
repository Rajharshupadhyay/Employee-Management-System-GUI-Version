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
public class Employee {
    //field
    private String name;
    private String id;
    private String dob;
    
    //method
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public String getDob(){
        return dob;
    }
    
    //constructor
    Employee(String name,String id,String dob){
        this.name = name;
        this.id = id;
        this.dob=dob;
    }//constructor
}//employee

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
public class Db {
    //field
    Employee DB[] = new Employee[100];
    Employee result;
    int db1=0;
    //method
    Employee register(Employee e){
        DB[db1] = e;
        Employee result=DB[db1];
        db1++;
        return result;      
    }//register
    
    Employee list(int d){            
        if(DB[d]!= null){
            Employee result;
            result=DB[d];
            return result;
        }//fi
        return result;
    }//list
    
    int count(){
       int count=0;
        //System.out.println("\nTotal Number of EMPLOYEE:\n");
        for(db1=0;db1<10;db1++)
        {
            if(DB[db1]!=null)
            {
                count++;
            }//fi
        }//for loop
        return(count);
    }//count
  
    Employee search(String id){
       //String s1=id;
        for(db1=0;db1<100;db1++){  
            if(DB[db1]!= null){
                if(DB[db1].getId().equals(id)){
                         //System.out.println("inner loop entered "+id);
                         Employee result;
                         result = DB[db1];
                         return result;
                }//fi nested     
            }//fi 
        }//fr         
        return result;
    }//search
}//DB

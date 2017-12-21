/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emp_management_system_gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
/**
 *
 * @author Rajharsh
 */
public class Menu extends JFrame implements ItemListener, ActionListener{
    //field
    String str;
    int db1=0;
    private ImageIcon image1;
    private JLabel label1;
    Crud cr = new Crud();
    
    JFrame f = new JFrame();
    GridLayout gl = new GridLayout(4,1);
    Label l1 = new Label("Employee Management System - Menu");
    
    Font f24 = new Font("Times New Romans",Font.BOLD,24);
    Font f12 = new Font("Times New Romans",Font.BOLD,12);
    
    Checkbox cb21 = new Checkbox("Register");
    Checkbox cb22 = new Checkbox("Search");
    Checkbox cb23 = new Checkbox("Count");
    Checkbox cb24 = new Checkbox("List");
    Checkbox cb25 = new Checkbox("Exit");
    
    Label l31 = new Label("Name: ");
    TextField tf31 = new TextField(9);
    
    Label l32 = new Label("Id: ");
    TextField tf32 = new TextField(9);
    
    Label l33 = new Label("Dob: ");
    TextField tf33 = new TextField(9);
    
    Button b34 = new Button("Continue");
    
    
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    Panel p3 = new Panel();
    Panel p4 = new Panel();
    
    TextArea ta =  new TextArea(2,60);
    
    //method
    public void itemStateChanged(ItemEvent ie){
        str = (String)ie.getItem();           ///since incomaptible types ie
        if(str.equals("Register")){
            p3.setVisible(true);
            l31.setVisible(true);
            l33.setVisible(true);
            tf31.setVisible(true);
            tf33.setVisible(true);
            tf32.setText("");
            p4.setVisible(false);
            cb22.setState(false);
            cb23.setState(false);
            cb24.setState(false);
        }//register
        
        else if(str.equals("Search")){
              //new Search();
            cb21.setState(false);
            cb23.setState(false);
            cb24.setState(false);
            p3.setVisible(true);
            l31.setVisible(false);
            tf31.setVisible(false);
            l33.setVisible(false);
            tf33.setVisible(false);
            ta.setVisible(false);
            tf32.setText("");                  
        }//search
        
        else if(str.equals("Count")){
            cb21.setState(false);
            cb22.setState(false);
            cb24.setState(false);
            p3.setVisible(false);
            ta.setVisible(true);
            ta.setText(" ");
            int total = cr.count();
            String strcount = total + "";
            //System.out.println(total);
            ta.append("Total Number of Employees:"+strcount);
            ta.setForeground(Color.BLACK);
            ta.setFont(f12);
            p4.setVisible(true);
            //cb23.setState(false);
        }//count
        
        else if(str.equals("List")){
            cb23.setState(false);
            cb21.setState(false);
            cb22.setState(false);
            p3.setVisible(false);
            ta.setText("Employee List is \n ");
            
            try{                 
                for(db1 = 0; db1 < 100; db1++){          
                    Employee result = cr.list(db1);
                    ta.append("  "+result.getName()+"  "+result.getId()+"  "+result.getDob()+"\n");
                    ta.setForeground(Color.BLACK);
                    ta.setFont(f12);
                    p4.setVisible(true);                    
                }
            }
            catch(NullPointerException e){   
            }
        }//list
    
        else if(str.equals("Exit")){
            //cb23.setState(false);
            System.exit(0);
        }
    }//itemStateChanged method
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Continue")){
            if(str.equals("Register")){
                //new Register();
                Employee emp = new Employee(tf31.getText(),tf32.getText(),tf33.getText());
                Employee result = cr.register(emp);
                //System.out.println(result.getName()+" "+result.getId()+" "+result.getDob());
                ta.setText(" ");
                ta.append(result.getName()+" "+result.getId()+" "+result.getDob()+"  Successfully Registered !!!");
                ta.setForeground(Color.BLACK);
                ta.setFont(f12);
                p4.setVisible(true);

                tf31.setText("");
                tf32.setText("");
                tf33.setText("");

                p3.setVisible(false);
                cb21.setState(false); 
            }
            try{
                if(str.equals("Search")){
                    //new Search();
                    ta.setText("");
                    String id;
                    id = tf32.getText();
                    Employee result;
                    result = cr.search(id);
                    ta.setText(" ");
                    ta.append("Employee details are:\n "+result.getName()+" "+result.getId()+" "+result.getDob());
                    ta.setForeground(Color.BLACK);
                    ta.setFont(f12);
                    ta.setVisible(true);
                    p4.setVisible(true);

                    p3.setVisible(false);
                    cb22.setState(false);
                }
            }
            catch(Exception e){
                System.out.println("");
            }
        }//fi
    }//actionPerformed
    
    //constructor
    Menu(){
        f.setTitle("menu");
        f.setBounds(100, 100, 800, 1000);
        f.setLayout(gl);
       
        cb21.addItemListener(this);
        cb22.addItemListener(this);
        cb23.addItemListener(this);
        cb24.addItemListener(this);
        cb25.addItemListener(this);
        b34.addActionListener(this);
        
        l1.setFont(f24);
        
        image1 = new ImageIcon(getClass().getResource("/images/star.png"));
        label1 = new JLabel(image1);
        p1.add(label1);
        add(p1);
        p1.setVisible(true);
             
        l31.setFont(f12);
        l32.setFont(f12);
        l33.setFont(f12);
        b34.setFont(f12);
        
        cb21.setFont(f12);
        cb22.setFont(f12);
        cb23.setFont(f12);
        cb24.setFont(f12);
        cb25.setFont(f12);
        
        b34.setFont(f12);
        
        p1.add(l1);
        p2.add(cb21);p2.add(cb22);p2.add(cb23);p2.add(cb24);p2.add(cb25);
        p3.add(l31);p3.add(tf31);p3.add(l32);p3.add(tf32);p3.add(l33);p3.add(tf33);p3.add(b34);
        p3.setVisible(false);
        p4.add(ta);//ta.setText(" ");
        p4.setVisible(false);
        
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        
        f.setVisible(true);
    }//constructor
}//menu

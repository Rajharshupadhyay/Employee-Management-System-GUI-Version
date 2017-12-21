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
public class Main extends JFrame implements ActionListener{
    //field
    JFrame f = new JFrame();
    GridLayout gl = new GridLayout(4,1);
    private ImageIcon image1;
    private JLabel label1;
        
    Font f24 = new Font("Times New Romans",Font.BOLD,24);
    Font f12 = new Font("Times New Romans",Font.BOLD,12);
    
    Panel p1  = new Panel();
    Panel p2  = new Panel();
    Panel p3  = new Panel();
    Panel p4 = new Panel();
    
    Label l1 = new Label("Employee Management System");
    Label l21 = new Label("User Name: ");
    TextField tf21 = new TextField(10);
    Label l22 = new Label("PASSWORD: ");
    TextField tf22 = new TextField(10);
    Button b2 = new Button("Enter");
    Button b3 = new Button("EXIT");
            
    Label l3 = new Label("OOP.com");
    Label l4 = new Label("Invalid User id or Password");
    
    //method
    public void actionPerformed(ActionEvent e){
        String str = e.getActionCommand();

        if(str.equals("Enter")){
            //System.out.println("button clicked");
            String str1 = tf21.getText();
            String str2 = tf22.getText();
            if(str1.equals("admin") && str2.equals("gui") ){
               new Menu();
            }//fi login`
            else{
                p4.setVisible(true);  
            }
            
        }//nested fi

        if(str.equals("EXIT")){
            System.exit(0);
        }
    }//actionPerformed

    //constructor
    Main(){       
       f.setTitle("Employee System");
       f.setBounds(100, 100, 800, 1000);
       f.setLayout(gl);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
       l1.setFont(f24);
       l1.setForeground(Color.red);   //top frame
       
       image1 = new ImageIcon(getClass().getResource("/images/Msblogo3.jpg"));
       label1 = new JLabel(image1);
       p1.add(label1);
       add(p1);
       p1.setVisible(true);
       
       l21.setFont(f12);
       l22.setFont(f12);
       tf22.setEchoChar('*');          //to hide password
       b2.setFont(f12);
       b3.setFont(f12);
       b3.setLabel("EXIT");
       b2.addActionListener(this);
       b3.addActionListener(this);
       
       l3.setFont(f12);
       l3.setForeground(Color.red);
       l4.setFont(f12);
       l4.setForeground(Color.blue);//bottom frame
       
       p1.add(l1);//topblock  frame
       p2.add(l21);p2.add(tf21);p2.add(l22);p2.add(tf22);p2.add(b2);//middle frame
       p3.add(l3);
       p3.add(b3);
       p4.add(l4); 
       p4.setVisible(false);//bottom frame
       
       f.add(p1);//top
       f.add(p2);//middle
       f.add(p3);//bottom
       f.add(p4);
        
       f.setVisible(true);
    }//constructor  
}//main

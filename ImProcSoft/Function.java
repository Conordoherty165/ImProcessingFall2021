import java.awt.*;
import java.awt.event.*;
import java.awt.TextComponent;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.util.*;
import java.lang.Object.*;

import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class FileChoice extends Frame implements ActionListener
{ 
   private Button btnClick1;
   private Button btnClick2;
   private Button btnClick3;
   private Button btnClick4;
   private Button btnClick5;
   private Button btnClick6;
   private Button btnClick7;
   private Button btnClick8;
   private Button btnClick9;
   private Button btnClick10;




  //private GainSlider gS;  
  
   static TextField entry1;
   static TextField entry2;
   private  Label prompt1;
   private Label prompt2;
   static String temp1;
   static String temp2;
   private FlowLayout layout;
   int number;
   private StringBuffer s1 = new StringBuffer("");
   private StringBuffer s2 = new StringBuffer("");
   private String str1= "";
   private String str2= "";
   public OurFilter oF;



   public FileChoice()
   {super ("File and Filter Choice");
      setBackground(Color.pink);
      layout = new FlowLayout(FlowLayout.CENTER,90,30);
      setLayout(layout);
      setSize(500,600); 
   
      entry1=new TextField(30);
      add(entry1);
      prompt1 = new Label("  Enter location of GIF/JPG File  ");
      add(prompt1);
   
      entry2= new TextField(30);
      add(entry2);
      prompt2=new Label("   Enter the filter type you want or select from buttons below   ");
      add(prompt2);
   
   
   
      btnClick1 = new Button("     Display Image and Filtered Image    ");
      add(btnClick1);
      btnClick1.addActionListener(this);
      show(); 
   
      btnClick2 = new Button("AV_2x2");
      add(btnClick2);
      btnClick2.addActionListener(this);
      show();
   
      btnClick3 = new Button("V_EDGE_2x2");
      add(btnClick3);
      btnClick3.addActionListener(this);
      show();
   
      btnClick4 = new Button("LR_DIAG_2x2");
      add(btnClick4);
      btnClick4.addActionListener(this);
      show();
   
      btnClick5 = new Button("toBW");
      add(btnClick5);
      btnClick5.addActionListener(this);
      show();
   
      btnClick6 = new Button("Random");
      add(btnClick6);
      btnClick6.addActionListener(this);
      show();
   
      btnClick7 = new Button("Sharp");
      add(btnClick7);
      btnClick7.addActionListener(this);
      show();
   
      btnClick8 = new Button("Add 50");
      add(btnClick8);
      btnClick8.addActionListener(this);
      show();
      
      btnClick9 = new Button("Poster");
      add(btnClick9);
      btnClick9.addActionListener(this);
      show();
      
      btnClick10 = new Button("SquareRoot");
      add(btnClick10);
      btnClick10.addActionListener(this);
   
   
   }
 

 
   public static void main(String[] args)
   {FileChoice fc = new FileChoice();
   
      fc.addWindowListener( 
         new WindowAdapter()
         {
            public void windowClosing(WindowEvent e)
            {System.exit(0);
            //fc.dispose();
            }
         });
   
   } //end main




   public void actionPerformed(ActionEvent e)
   {
      if (e.getActionCommand().equals("     Display Image and Filtered Image    "))
      {
      
         temp1=entry1.getText();//temp1=entry1.getText();
         temp2=entry2.getText();
         System.out.println(temp1);
         s1.append(temp1);
         s2.append(temp2);
         System.out.println(s1);
         str1=s1.toString();
         str2=s2.toString();
         str1.trim();
         str2.trim();
         System.out.println("The filtertype is ...."+str2);
      //bP=new ButtonPanel(str1);
      //DisplayFilterOutput dFO = new DisplayFilterOutput(str1,str2);
         s1.delete(0,60);
         s2.delete(0,60);
      }
      
      
      else if (e.getActionCommand().equals("AV_2x2"))
      {
         temp1=entry1.getText();
         temp2=entry2.getText();
      
         s1.append(temp1);
         s2.append(temp2);
      
         str1=s1.toString();
         str2="AV_2x2";
      
         System.out.println("The filtertype is ...."+str2);
         DisplayFilterOutput dFO = new DisplayFilterOutput(str1,str2);
      
      
         s1.delete(0,60);
         s2.delete(0,60);
      
      }
      
      else if (e.getActionCommand().equals("Sharp"))
      {
         temp1=entry1.getText();
         temp2=entry2.getText();
      
         s1.append(temp1);
         s2.append(temp2);
      
         str1=s1.toString();
         str2="Sharp";
      
         System.out.println("The filtertype is ...."+str2);
         DisplayFilterOutput dFO = new DisplayFilterOutput(str1,str2);
      
      
         s1.delete(0,60);
         s2.delete(0,60);
      
      }
      
      
      else if (e.getActionCommand().equals("toBW"))
      {
         temp1=entry1.getText();
         temp2=entry2.getText();
      
         s1.append(temp1);
         s2.append(temp2);
      
         str1=s1.toString();
         str2="toBW";
      
         System.out.println("The filtertype is ...."+str2);
         DisplayFilterOutput dFO = new DisplayFilterOutput(str1,str2);
      
      
         s1.delete(0,60);
         s2.delete(0,60);
      
      }
      
      
      else if (e.getActionCommand().equals("V_EDGE_2x2"))
      {temp1=entry1.getText();temp1=entry1.getText();
      //temp2=entry2.getText();
      
         s1.append(temp1);
         s2.append(temp2);
      
      
      
         str1=s1.toString();
         str2="V_EDGE_2x2";
      
         System.out.println("The filtertype is ...."+str2);
         DisplayFilterOutput dFO = new DisplayFilterOutput(str1,str2);
         s1.delete(0,60);
         s2.delete(0,60);
      }
      
      else if (e.getActionCommand().equals("Random"))
      {temp1=entry1.getText();temp1=entry1.getText();
      //temp2=entry2.getText();
      
         s1.append(temp1);
         s2.append(temp2);
      
         str1=s1.toString();
         str2="Random";
      
         System.out.println("The filtertype is ...."+str2);
         DisplayFilterOutput dFO = new DisplayFilterOutput(str1,str2);
         s1.delete(0,60);
         s2.delete(0,60);
      }
      
      else if (e.getActionCommand().equals("GainSlider"))
      {temp1=entry1.getText();temp1=entry1.getText();
      //temp2=entry2.getText();
      
         s1.append(temp1);
         s2.append(temp2);
      
         str1=s1.toString();
         str2="GainSlider";
      
         System.out.println("The filtertype is ...."+str2);
      //DisplayFilterOutput dFO = new DisplayFilterOutput(str1,str2);
      // gS=new GainSlider(str1);
         s1.delete(0,60);
         s2.delete(0,60);
      }
      
      else if (e.getActionCommand().equals("Add 50")){
       temp1=entry1.getText();
         temp2=entry2.getText();
      
         s1.append(temp1);
         s2.append(temp2);
      
         str1=s1.toString();
         str2="Add 50";
      
         System.out.println("The filtertype is ...."+str2);
         DisplayFilterOutput dFO = new DisplayFilterOutput(str1,str2);
      
      
         s1.delete(0,60);
         s2.delete(0,60);

      
      }
      
      else if (e.getActionCommand().equals("Poster")){
       temp1=entry1.getText();
         temp2=entry2.getText();
      
         s1.append(temp1);
         s2.append(temp2);
      
         str1=s1.toString();
         str2="Poster";
      
         System.out.println("The filtertype is ...."+str2);
         DisplayFilterOutput dFO = new DisplayFilterOutput(str1,str2);
      
      
         s1.delete(0,60);
         s2.delete(0,60);
      }
      
      else if (e.getActionCommand().equals("SquareRoot")){
          temp1=entry1.getText();
            temp2=entry2.getText();
         
            s1.append(temp1);
            s2.append(temp2);
         
            str1=s1.toString();
            str2="Poster";
         
            System.out.println("The filtertype is ...."+str2);
            DisplayFilterOutput dFO = new DisplayFilterOutput(str1,str2);
         
         
            s1.delete(0,60);
            s2.delete(0,60);
         }
   
   }
}

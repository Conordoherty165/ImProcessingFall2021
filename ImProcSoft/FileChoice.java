import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
   private Button btnClick11;
   private Button btnClick12;
   private Button btnClick13;



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
      entry1.setText("C:\\Users\\jedib\\Desktop\\brink.PNG");
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
      

      btnClick2 = new Button("AV_2x2");
      add(btnClick2);
      btnClick2.addActionListener(this);
      

      btnClick3 = new Button("V_EDGE_2x2");
      add(btnClick3);
      btnClick3.addActionListener(this);
      

      btnClick4 = new Button("LR_DIAG_2x2");
      add(btnClick4);
      btnClick4.addActionListener(this);
      

      btnClick5 = new Button("toBW");
      add(btnClick5);
      btnClick5.addActionListener(this);
      

      btnClick6 = new Button("Random");
      add(btnClick6);
      btnClick6.addActionListener(this);
      

      btnClick7 = new Button("Sharp");
      add(btnClick7);
      btnClick7.addActionListener(this);
      

      btnClick8 = new Button("Add 50");
      add(btnClick8);
      btnClick8.addActionListener(this);
      

      btnClick9 = new Button("Poster");
      add(btnClick9);
      btnClick9.addActionListener(this);
      

      btnClick10 = new Button("SquareRoot");
      add(btnClick10);
      btnClick10.addActionListener(this);
      
      
      btnClick11 = new Button("Blend");
      add(btnClick11);
      btnClick11.addActionListener(this);
      
      btnClick12 = new Button("Sepia");
      add(btnClick12);
      btnClick12.addActionListener(this);
      
      
      btnClick13 = new Button("Median Filtering");
      add(btnClick13);
      btnClick13.addActionListener(this);
      show();



   }



   public static void main(String[] args)
   {FileChoice fc = new FileChoice();

      fc.addWindowListener(
         new WindowAdapter()
         {
            @Override
			public void windowClosing(WindowEvent e)
            {System.exit(0);
            //fc.dispose();
            }
         });

   } //end main




   @Override
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

      else if (e.getActionCommand().equals("Blend")){
          temp1=entry1.getText();
            temp2=entry2.getText();

            s1.append(temp1);
            s2.append(temp2);

            str1=s1.toString();
            str2="Blend";

            System.out.println("The filtertype is ...."+str2);
            DisplayFilterOutput dFO = new DisplayFilterOutput(str1,str2);


            s1.delete(0,60);
            s2.delete(0,60);


         }
      else if (e.getActionCommand().equals("Sepia")){
          temp1=entry1.getText();
            temp2=entry2.getText();

            s1.append(temp1);
            s2.append(temp2);

            str1=s1.toString();
            str2="Sepia";

            System.out.println("The filtertype is ...."+str2);
            DisplayFilterOutput dFO = new DisplayFilterOutput(str1,str2);


            s1.delete(0,60);
            s2.delete(0,60);


         }
      
      
      else if (e.getActionCommand().equals("Median Filtering")){
          temp1=entry1.getText();
            temp2=entry2.getText();

            s1.append(temp1);
            s2.append(temp2);

            str1=s1.toString();
            str2="Median Filtering";

            System.out.println("The filtertype is ...."+str2);
            DisplayFilterOutput dFO = new DisplayFilterOutput(str1,str2);


            s1.delete(0,60);
            s2.delete(0,60);


         }


   }
}

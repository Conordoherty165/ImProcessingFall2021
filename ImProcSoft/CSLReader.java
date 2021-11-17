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
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CSLReader extends Frame implements ActionListener
{
  private Button btnClick1;
  private Button btnClick2;
  private Button btnClick3;
  private Button btnClick4;
  //private BufferedReader br= new BufferedReader();



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



  public CSLReader()
 {super ("File and Filter Choice");
  setBackground(Color.pink);
  layout = new FlowLayout(FlowLayout.CENTER,90,30);
  setLayout(layout);
  setSize(500,600);

  entry1=new TextField(20);
  add(entry1);
  prompt1 = new Label("Read CSL File Into Array");
  add(prompt1);

  entry2= new TextField(5);
  add(entry2);
  prompt2=new Label("Number of Fields in CSL");
  add(prompt2);



  btnClick1 = new Button("Read CSL File Into Array");
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

 }



 public static void main(String[] args)
 {CSLReader  cslread = new  CSLReader();

  cslread.addWindowListener( new WindowAdapter()
  	{@Override
	public void windowClosing(WindowEvent e)
  		{System.exit(0);
  		//fc.dispose();
		}
  	});

 } //end main




 @Override
public void actionPerformed(ActionEvent e)
 {
 if (e.getActionCommand().equals("Read CSL File Into Array"))
 { temp1=entry1.getText();temp1=entry1.getText();
 //temp2=entry2.getText();
 System.out.println(temp1);
 s1.append(temp1);
 s2.append(temp2);
 System.out.println(s1);
 str1=s1.toString();
 str2=s2.toString();
 str1.trim();
 str2.trim();
 System.out.println("The filtertype is ...."+str2);
 //DisplayFilterOutput dFO = new DisplayFilterOutput(str1,str2);
 try{
 int charcount=0;
 FileInputStream fis = new FileInputStream(str1) ;
  BufferedInputStream bis=new BufferedInputStream(fis);
    InputStreamReader isr = new InputStreamReader(bis);
	 //InputStreamReader isr1 = new InputStreamReader(bis);
	 FileReader fR= new FileReader(str1);
	int k =0;
	while(isr.read()!=-1)
	{isr.read();k++;System.out.println("The number of characters is " + k );}
	charcount =2*k-1;
	//isr.reset();
	char[] cbuff = new char[charcount];
	fR.read(cbuff,0,charcount);
	String textoffile = new String(cbuff);
	System.out.println("The text of the file is:     " + textoffile);

	int firstcomma = textoffile.indexOf(",");System.out.println("The first comma occurs as the "+firstcomma+ "th character");
	//We now parse the file into subarrays




		}// end try
 catch(IOException ioe){}
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

 else if (e.getActionCommand().equals("LR_DIAG_2x2"))
 {temp1=entry1.getText();temp1=entry1.getText();
 //temp2=entry2.getText();

 s1.append(temp1);
 s2.append(temp2);

 str1=s1.toString();
 str2="LR_DIAG_2x2";

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


 }

}
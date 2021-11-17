
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class DisplayFilterOutput extends JFrame
{JLabel jL;
 //OurFilter oF;

 DisplayFilterOutput(String file,String filtertype)
 {
 super("The output of the " + filtertype + " filter");
 OurFilter oF = new OurFilter();
 String s=file;
  File f = null;

 ImageDecomp iD = new ImageDecomp();
 SplitImage sIm =  ImageDecomp.prism(s);
 SplitImage ssIm ;//= new SplitImage(sIm.height,sIm.width);
 SplitImage sssIm;
 filtertype.trim();

 System.out.println("In display f out we have filtertype = "+filtertype);


 if (filtertype.compareTo("AV_2x2")==0)
 { ssIm = oF.passover(sIm,OurFilter.AV_2x2);
   //System.out.println("**** in AV_2x2 - ssIm is set as oFpassover");
 }


 //else if (filtertype.compareTo("Sharp")==0)
 //{ ssIm = oF.passover(sIm,oF.SHARP);
   //System.out.println("**** in AV_2x2 - ssIm is set as oFpassover");
 //}

  else if (filtertype.compareTo("toBW")==0)
 {
  ssIm = oF.toBW(sIm);
  System.out.println("Just called toBW");
 }


else if (filtertype.compareTo("Random")==0)
 { ssIm = oF.random(sIm);
   //System.out.println("**** in AV_2x2 - ssIm is set as oFpassover");
 }

 else if (filtertype.compareTo("V_EDGE_2x2")==0)
 {sssIm = oF.passover(sIm,OurFilter.V_EDGE_2x2);
  ssIm=new SplitImage(sssIm.height,sssIm.width);// this is a blank image that will be "drawn onto"

  for(int i=0;i<ssIm.width*ssIm.height;i++)
  {		if((sssIm.red[i]+sssIm.green[i] + sssIm.blue[i])< 20  && (sssIm.red[i]+sssIm.green[i] + sssIm.blue[i])>-20)
  			{ssIm.red[i]=0;ssIm.green[i]=0;ssIm.blue[i]=0;}

			else {ssIm.red[i]=255;ssIm.green[i]=255;ssIm.blue[i]=255;}  		}
 }



 else if (filtertype.compareTo("Sharp")==0)
 {sssIm = oF.sharp(sIm);
  ssIm=new SplitImage(sssIm.height,sssIm.width);// this is a blank image that will be "drawn onto"

ssIm=sssIm;



 }//end Sharp (our filter method "sharp")



 else if (filtertype.compareTo("LR_DIAG_2x2")==0)
 { //ssIm = oF.passover(sIm,oF.LR_DIAG_2x2);
 	//	ssIm = new SplitImage(2*sIm.height,2*sIm.width);
 		/*	for(int i=0;i<ssIm.width*ssIm.height;i++)
 			{//ssIm.red[i]=sIm.red[i];
 			//ssIm.red[i]=0;
			ssIm =oF.magnify(sIm);
 			}
 */
 //
 ssIm =oF.reduce(sIm);

 }

 else if (filtertype.compareTo("Poster")==0)
 {
  ssIm = oF.toBW(sIm);
  System.out.println("Just called Poster");
 }

 else if (filtertype.compareTo("SquareRoot")==0)
 {
  ssIm = oF.SquareRoot(sIm);
  System.out.println("Just called SquareRoot");
 }

 else if (filtertype.compareTo("Blend")==0)
 {
  ssIm = oF.Blend(sIm);
  System.out.println("Just called Blend");
 }

 /*
 else if (filtertype.compareTo("MAGNIFY50")==0)
 { ssIm = oF.magnify(sIm,50);

 }
 else if (filtertype.compareTo("MAGNIFY200")==0)
 { ssIm = oF.magnify(sIm,200);
 }
else if (filtertype.compareTo("SqRootTransformation")==0)
 { ssIm = oF.sqroot(sIm);
 }

else if (filtertype.compareTo("Histogram")==0)
 { System.out.println("Have entered the filtertype compare to.....wobbler");
   ssIm = oF.histogram(sIm);
 }
else if (filtertype.compareTo("DCT")==0)
 {ssIm = oF.DCT(sIm);
 }

else if (filtertype.compareTo("HAAR1")==0)
 {ssIm = oF.HAAR1(sIm);
 }
else if (filtertype.compareTo("HAAR2")==0)
 {ssIm = oF.HAAR2(sIm);
 }
else if (filtertype.compareTo("HAAR4")==0)
 {ssIm = oF.HAAR4(sIm);
 }
else if (filtertype.compareTo("HAAR8")==0)
 {ssIm = oF.HAAR8(sIm);
 }
else if (filtertype.compareTo("QuantDCT")==0)
 {ssIm = oF.qDCT(sIm);
 }
*/


 else
 { ssIm=sIm;
 }
 //SplitImage sssIm = oF.passover(ssIm,oF.AV_2x2);
 //SplitImage ssIm = oF.magnify(sIm,150);

 //commented out four lines
 CombineImages cI=new CombineImages(sIm,ssIm);
 SplitImage combo = cI.getCombined();
 IntDisplayCanvas iDC = new IntDisplayCanvas(combo);
 BufferedImage bI = iDC.getData();
 /*
 try{ //
FileOutputStream foS = new FileOutputStream("C:\\Images\\"+file.concat(".png"));
//f = new File("C:\\altered"+s.concat(".jpg"));
 f = new File("C:\\Images\\altered.png");
//encode(bI);
RenderedImage rI = (RenderedImage)bI;
Image i = (Image)rI;
if(f.canWrite()){System.out.println("Can write to the file");}
System.out.println("Can write just before ImageIOwrite");

ImageIO.write(bI,"png",f);

System.out.println();
//System.out.println("Can write just before ImageIOwrite");

//createJPEGEncoder(foS);
//JPEGImageEncoder jpeg=JPEGCodec.createJPEGEncoder(foS);
}//end try
catch(NullPointerException fose){System.out.println("Problem with file");}
catch(IOException ioe){System.out.println("Problem with writing jpg to C:\\");}
//encode(bI);
*/

try{FileOutputStream foS = new FileOutputStream("C:\\Images\\"+file.concat(".png"));
//f = new File("C:\\altered"+s.concat(".jpg"));
 f = new File("C:\\Images\\altered.png");
//encode(bI);
//RenderedImage rI = (RenderedImage)bI;
//Image i = (Image)rI;
//if(f.canWrite()){System.out.println("Can write to the file");}
//System.out.println("Can write just before ImageIOwrite");

ImageIO.write(bI,"png",f);

System.out.println("Written png file to C:\\Images\\");
//System.out.println("Can write just before ImageIOwrite");

//createJPEGEncoder(foS);
//JPEGImageEncoder jpeg=JPEGCodec.createJPEGEncoder(foS);
}
catch(NullPointerException fose){System.out.println("Problem with file");}
catch(IOException ioe){System.out.println("Problem with writing jpg to C:\\");}

 jL = new JLabel(new ImageIcon(bI));
getContentPane().add(jL);
this.pack();
this.setVisible(true);
addWindowListener(new WindowAdapter(){@Override
public void windowClosing(WindowEvent e)
{

System.gc();
}});
 }

/*
public static void main(String[] args)
{DisplayFilterOutput dFO = new DisplayFilterOutput();
}
*/


}

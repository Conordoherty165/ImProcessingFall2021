import java.awt.*;
import java.awt.image.*;
import javax.swing.*;


// The main output of this class is the output of 
// prism(String filename) - namely an object of the class type
// SplitImage which will in due course be natural input to the 
// IntDisplayCanvas class which will wrap the red/green/blue
// components of the SplitImage into a form that will allow
// display of the various components in JPanels as JLabels using 
// the DisplayArray class  

public class ImageDecomp
{	ImageDecomp()
	{;
	}//Constructor for Image Decomp class
IObserver observer;
Image img;
int[] dims = new int[2];
int imagewidth;
int imageheight;
byte[] red;
//SplitImage sI;

public static int[] getPixels(String infile,int width,int height)
{Image img= Toolkit.getDefaultToolkit().getImage(infile);


int[] rawPixels;
 PixelGrabber pg;
 int area=width*height;
 rawPixels = new int[area]; 
 
 pg = new PixelGrabber(img,0,0,width,height,rawPixels,0,width);
 
 try
 {pg.grabPixels();
 }
 catch(InterruptedException e)
 {e.printStackTrace();
 }
 return rawPixels;
}//End of method definition getPixels


public static int[] loadImage(String filename)
{Image img;
int[] dims = new int[2];
int width;
int height;

 img = Toolkit.getDefaultToolkit().getImage(filename);
 PixelGrabber pg = new PixelGrabber(img,0,0,-1,-1,false);
 try
 {
 	if (pg.grabPixels())
 	{IObserver observer;
 	observer = new IObserver();
 	width = img.getWidth(observer);
 	height = img.getHeight(observer);
	width=pg.getWidth();
	height=pg.getHeight();
 	dims[0]=width;dims[1]=height;
	
	
 	return dims;
 	}
 	else 
 	{dims[0]=1;dims[1]=1;
 	return dims;
 	}
 } 
 catch(InterruptedException e)
 {dims[0]=1;dims[1]=1;
 	return dims;
 }
}// End method loadImage

public static SplitImage prism(String filename)
{int[] red;
 int[] green;
 int[] blue;
 String name;
 int width;
 int height;
 
 name = filename;
 
 SplitImage sI = new SplitImage();
 
 String s =  name;
 int[] dims = new int[2];
 int area ;
 dims = loadImage(s);
 area = dims[0]*dims[1];
 red= new int[area];
 green = new int[area];
 blue = new int[area];
 
  sI.red = red;
 sI.green = green;
 sI.blue =  blue;
 
 
 int [] data = new int[area];
 data  = getPixels(s,dims[0],dims[1]);
 
 for(int i = 0; i < area; i++)
 { sI.red[i] = ((data[i]>>>16 & 0xff));
   sI.green[i] =((data[i]>>>8 & 0x0000ff));
   sI.blue[i] =((data[i] & 0x000000ff));
 }

sI.width = dims[0];
sI.height=dims[1];
sI.filename=name;

return sI; 
}


}//End public class ImageDecomp



class IObserver implements ImageObserver
{public boolean imageUpdate(Image img,int infoflags,int x,int y, int width,int height )
{return true;
}
}//End of IObserver class - implementing ImageObserver
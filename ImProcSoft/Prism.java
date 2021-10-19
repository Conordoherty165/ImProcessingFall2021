import java.awt.*;
import java.awt.image.PixelGrabber;
import java.awt.image.*;
import java.io.FileOutputStream.*;
import java.io.*;
public class Prism
{	
	Prism()
	{
	}

	 public static SplitImage applyPrism(String infile,String outfile) 
	{
	 Image image = Toolkit.getDefaultToolkit().getImage(infile);
	 SplitImage si = new SplitImage();
	 try
	 {//SplitImage si = new SplitImage();
	 PixelGrabber pg = new PixelGrabber(image,0,0,-1,-1,false);
	 int w = pg.getWidth();
	 int h = pg.getHeight();
	 int dimension = w*h;
	 si.filename=infile;
	 si.width = w;
	 si.height=h;
	 PixelGrabber grabber = new PixelGrabber(image,0,0,-1,-1,false);
	 System.out.println(si.filename  +   si.width   + si.height);
	 
	 grabber.startGrabbing();
	 if (grabber.grabPixels())
	 {int width = grabber.getWidth();
	  int height = grabber.getHeight();
	  si.width = width;
	 si.height=height;
	 dimension=width*height;
si.red = new int[dimension];
si.green = new int[dimension];
si.blue = new int[dimension];


	 //int dimension = height*width;
	 //byte  data[dimension];
	 System.out.println(si.filename  +   si.width   + si.height);  
	if (bytesAvailable(grabber))
	{
	
	byte[] data = (byte[])grabber.getPixels();
	 
	 
	int i = data.length;
	System.out.println("The number of available pixel values is" + i);
	System.out.println("The last pixel has byte value " + ((int)data[i-1]+128));
	IndexColorModel cMod = (IndexColorModel)grabber.getColorModel();
	
	//try
	{
	int size = cMod.getPixelSize();
	System.out.println("No. of bits per pixel is " + size);
	
	for(int p=0;p<5;p++)
	{System.out.println("p = " + p);
	int r=(int)cMod.getRed(data[p]+128);
	int g=(int)cMod.getGreen(data[p]+128);
	int b=(int)cMod.getBlue(data[p]+128);
/*
	si.red[p]=(int)cMod.getRed(data[p]);
	si.green[p]=(int)cMod.getGreen(data[p]);
	si.blue[p]=(int)cMod.getBlue(data[p]);
	System.out.println("data value is = "+ (data[p]));
*/
System.out.println("Paletet index = = " + (data[p]+128));
	
System.out.println("Red component = "+ (r+128));
	System.out.println("Green component = "+ (g+128));
	System.out.println("Blue component = "+ (b+128));
	
	
	}


}


/*	
	try
	{FileOutputStream fos = new FileOutputStream("C:\\yazoo.dat");
		try
		{
		fos.write(data);
		}
		catch(IOException q)
		{;
		}
	
	
		 System.out.println("Byte data is GO");
		 System.out.println("Width is"+width);
		 System.out.println("Height is"+height);
		 System.out.println(+data[0] +"-" +data[1]+"-"+data[2]);
		 System.out.println(+data[3]+ "-" +data[4]+"-"+data[5]);
	
		}//end try file outputstream
	catch (FileNotFoundException f)
	{;
	}
*/	  
		// do something to the pixel data 	
		} //End if  
	else
	{int[] data = (int[])grabber.getPixels();
	System.out.println("Integer colour data is GO");
	si.width=grabber.getWidth();
	si.height=grabber.getHeight();
	si.filename=infile;
	System.out.println("Width is"+si.width);
	System.out.println("Height is"+si.height);
		 System.out.println(+data[0] +"-" +data[1]+"-"+data[2]);
		 System.out.println(+data[3]+ "-" +data[4]+"-"+data[5]);	
	for (int s=0;s<5;s++)
	{si.red[s]= ((data[s]>>>16)&0x00ff) ;
	 si.green[s]= ((data[s]>>>8)&0x0000ff) ;
	 si.blue[s]= ((data[s])&0x000000ff) ; 
	/*
	System.out.println(  "Red = " + (int)((data[s]>>>16)&0x00ff)  );
	System.out.println(  "Green = " + (int)((data[s]>>>8)&0x0000ff)  );
	System.out.println(  "Blue = " + (int)((data[s])&0x000000ff)  );
	*/
	}
	
	//process colour image 
	}//End else
	 	}//end if
	 

	 		}//End first PixelGrabbing try
	
	
catch(InterruptedException e)
{e.printStackTrace();
}//End catch

System.out.println("si.red[0] = "+ si.red[0]);


return si;	  	
	}//End applyPrism method

public static final boolean bytesAvailable(PixelGrabber pg)
{return pg.getPixels() instanceof byte[];
}//End bytesAvailable

public static void main(String[] argv)
{	//if(argv.length>1)
	{//Prism pr = new Prism();
	SplitImage spl;
spl=applyPrism("C:\\LogPolar.gif","C:\\yazoo.dat");	
	//SplitImage si = pr.applyPrism("C:\\LogPolar.gif","C:\\yazoo.dat");
     System.exit(0);	
	}//End if 
}

}//End class Prism
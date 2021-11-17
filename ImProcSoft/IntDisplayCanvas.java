import java.awt.Point;
import java.awt.image.BufferedImage;

public class IntDisplayCanvas //implements ActionListener
{
public BufferedImage image;
public BufferedImage redimage;
public BufferedImage greenimage;
public BufferedImage blueimage;

public IntDisplayCanvas()
{

Point p = new Point(0,0);
int i;
int j;
int width =256;
int height = 256 ;
int[] data = new int[width*height];

image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
for(int s=0;s<width;s++)
	{	for(int t=0;t<height;t++)
		{//image.setRGB(s,t,((t<<16)|(t<<8)|t|0xff000000));
	       image.setRGB(s,t,t<<16|0xff000000);
		}
	}

//System.out.println("Just filled image with data");
//System.out.println("The value of the first = " + (image.getRGB(0,0)));

}

public IntDisplayCanvas(SplitImage sI)
{

Point p = new Point(0,0);
int i;
int j;
int[] data = new int[sI.width*sI.height];
int[] red;
int[] green;
int[] blue;
int wi = sI.width;
int he = sI.height;

image =  new BufferedImage(wi,he,BufferedImage.TYPE_INT_ARGB);
redimage = new BufferedImage(wi,he,BufferedImage.TYPE_INT_ARGB);
greenimage = new BufferedImage(wi,he,BufferedImage.TYPE_INT_ARGB);
blueimage = new BufferedImage(wi,he,BufferedImage.TYPE_INT_ARGB);


for(int s=0;s<he;s++)
	{	for(int t=0;t<wi;t++)
		{image.setRGB(t,s,(sI.red[s*wi+t]<<16)|(sI.green[s*wi+t]<<8)|(sI.blue[s*wi+t])|0xff000000);
		 redimage.setRGB(t,s,((sI.red[s*wi+t]<<16)|0xff000000));
		 greenimage.setRGB(t,s,((sI.green[s*wi+t]<<8)|0xff000000));
		 blueimage.setRGB(t,s,((sI.blue[s*wi+t])|0xff000000));
	    }
	}

//System.out.println("Just filled image with data");
//System.out.println("The blueimage's last entry is "+ blueimage.getRGB(wi-1,he-1));

} //End of constructor of IntDisplayCanvas with parameter int imdata[]


public BufferedImage getData()
{return image;}

public BufferedImage getredData()
{return redimage;}

public BufferedImage getgreenData()
{return greenimage;}

public BufferedImage getblueData()
{return blueimage;}


}//End class IntDisplayCanvas - with alternative constructors
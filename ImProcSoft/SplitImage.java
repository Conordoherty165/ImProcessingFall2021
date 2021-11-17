public class SplitImage
{

int[] red;
int[] green;
int[] blue;
String filename;
int width;
int height;


SplitImage(){}//End default constructor

SplitImage(int h,int w)
{int i;
 int[] redd = new int[h*w];
 int[] greenn = new int[h*w];
 int[] bluee = new int[h*w];

	for(i=0;i<h*w;i++)
	{redd[i]=255;greenn[i]=255;bluee[i]=255;
	}// end for loop on i

	 width=w;
	 height=h;
	 red=redd;green=greenn;blue=bluee;

}// end constructor with h and w as inputs ensuring initialisation


TwoDSplitImage from1To2D()
{int w =this.width;
int h=this.height;
String filename= new String(this.filename);
TwoDSplitImage ddsIm = new TwoDSplitImage(this.height,this.width);

int i =0;int j=0;


for(i=0;i<h;i++)
{		for(j=0;j<w;j++)
		{ddsIm.red[i][j]=this.red[i*w+j]; ddsIm.green[i][j]=this.green[i*w+j];ddsIm.blue[i][j]=this.blue[i*w+j];
		}// end for j
}//end for i
return ddsIm;
}// end method from1To2D

}//end class definition
public class TwoDSplitImage
{

int[][] red;
int[][] green;
int[][] blue;
String filename;
int width;
int height;


TwoDSplitImage()
{}//End default constructor

TwoDSplitImage(int h,int w)
{int i;
 int j;
 int[][] redd = new int[h][w];
 int[][] greenn = new int[h][w];
 int[][] bluee = new int[h][w];

			for(i=0;i<h;i++)
			{		for(j=0;j<w;j++)
					{redd[i][j]=255;greenn[i][j]=255;bluee[i][j]=255;}
			}// end for loop on i

	 width=w;
	 height=h;
	 red=redd;green=greenn;blue=bluee;

}// end constructor with h and w as inputs ensuring initialisation

//}

// methods below for converting from 1 to 2 D and back again if required

TwoDSplitImage from1To2D(SplitImage sIm)
{int i;int j;
 int width=sIm.width;
 int height =sIm.height;

 TwoDSplitImage out = new TwoDSplitImage(height,width);
 out.filename=sIm.filename;

  	for(i=0;i<height;i++)
	{	for(j=0;j<width;j++)
		{out.red[i][j]=sIm.red[i*width+j];
		 out.green[i][j]=sIm.green[i*width+j];
		 out.blue[i][j]=sIm.blue[i*width+j];
		}

	}

return out;
}// end method from1To2D


SplitImage from2To1D(TwoDSplitImage DDsIm)
{int i;int j;
 int width=DDsIm.width;
 int height =DDsIm.height;

 SplitImage out = new SplitImage(height,width);
 out.filename=DDsIm.filename;

  	for(i=0;i<height;i++)
	{	for(j=0;j<width;j++)
		{out.red[i*width+j]=DDsIm.red[i][j];
		out.green[i*width+j]=DDsIm.green[i][j];
		out.blue[i*width+j]=DDsIm.blue[i][j];
		}

	}

return out;
}// end method from2To1D


TwoDSplitImage markAllFlipsOnScanLines(TwoDSplitImage DDsIm)
{
int ww=DDsIm.width;
int hh=DDsIm.height;

TwoDSplitImage dd = new TwoDSplitImage(hh,ww);


for(int t=0;t<hh;t++){

int [] marked = new int[ww];
int[]  scanline = new int[ww];
int q ;
for(q=0;q<ww;q++)
{scanline[q]=DDsIm.red[t][q];marked[q]=255;}

for(q=0;q<ww-1;q++)
{		if(scanline[q]<scanline[q+1])
		{marked[q]=0;}
		else if(scanline[q]>scanline[q+1])
		{marked[q+1]=0;}
}
for(q=0;q<ww;q++){dd.red[t][q]=marked[q];
						dd.green[t][q]=marked[q];
						dd.blue[t][q]=marked[q];}

}//end for t


return dd;
}// end of markAllFlipsOnScanLine method

























}//end class definition
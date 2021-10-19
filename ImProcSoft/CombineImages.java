public class CombineImages
{int i;
 int j; 
 int k;
 int l;
 
 int wmax;
 int hmax;
 String names;
 
 int[] combred;
 int[] combgreen;
 int[] combblue;
 
 SplitImage sIcombined = new SplitImage();
 
 int fill =10;
 
 
 CombineImages(SplitImage sI1,SplitImage sI2)
 {int w1=sI1.width;
  int w2=sI2.width;
  wmax=w1; if(wmax<w2){wmax=w2; } else{;}
  int wtot = 2*wmax+fill;
  //This gives a space of "fill" pixels between the two images
  
  
  int h1=sI1.height;
  int h2= sI2.height;
  hmax=h1; if(hmax<h2){hmax=h2; } else{;}
  int htot = hmax;
  
  
  if (wtot<=1400 && htot<= 780)
  {
  String combined = "BEFORE AND AFTER - " + sI1.filename; 
  
  int areatot = wtot*htot; 
  combred = new int[areatot];
  combgreen = new int[areatot];
  combblue = new int[areatot];
  
  for(i=0;i<areatot;i++)
  {combred[i]=0xff;
   combgreen[i]=0xff;
   combblue[i]=0xff;
  } // Initialising the arrays to zero in the colour components
    // which will give the filler between the images a white colour

 for(i=0;i<h1;i++)
 {	k=i*wtot;
 	l=i*w1;
 	for(j=0;j<w1;j++)
 	{ combred[k+j]=sI1.red[l+j];
	  combgreen[k+j]=sI1.green[l+j];
	  combblue[k+j]=sI1.blue[l+j];	
 	}
 } // This fills out the first image into the left-hand-side of
   // of the combined image
 
 
 for(i=0;i<h2;i++)
 {	k=i*(wtot)+wmax+fill;
	l=i*w2; 
 	for(j=0;j<w2;j++)
 	{ 
	  combred[k+j]=sI2.red[l+j];
	  combgreen[k+j]=sI2.green[l+j];
	  combblue[k+j]=sI2.blue[l+j];	
 	}
 } // This fills out the second image into the right-hand-side of
   // of the combined image
 System.out.println("The combined variable has value = "+combined);
 sIcombined.filename= combined;
 sIcombined.width=wtot;
 sIcombined.height=htot;
 
 sIcombined.red=combred;
 sIcombined.green=combgreen;
 sIcombined.blue=combblue;
  } // this is the case if the combined sizes fit into 800x600 
    // pixel resolution
  
  else
  {sIcombined.filename= sI2.filename;
   sIcombined.width=sI2.width;
   sIcombined.height=sI2.height;
 
   sIcombined.red=sI2.red;
   sIcombined.green=sI2.green;
   sIcombined.blue=sI2.blue;
  }
 } //End of class constructor
 
public SplitImage getCombined()
{return sIcombined;
}

} //End class definition
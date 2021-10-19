import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.lang.Math;



public class OurFilter 
{ static final int[] AV_2x2 = {1,1,1,1,4};
   static final int[] V_EDGE_2x2={1,-1,1,-1,1}; 
   static final int[][] SHARP ={{0,-1,0},{-1,5,-1},{0,-1,0}};  
  
   public String s;
 // We will add some other filter masks as we proceed
 
   public SplitImage spIm = new SplitImage();
   public int[] rmanip;
   public int[] gmanip;
   public int[] bmanip;
   public SplitImage sssIm;
 
   OurFilter()
   {;
   }


   public SplitImage passover(SplitImage input, int[] mask)
   {int i;
      int j;
      int k;
      int w;
      int h;
      int p; 
      int q; 
      int area;
      int length = mask.length;
      String name;
   
      name =  input.filename;
      w=input.width;
   
      System.out.println("The value of width in SplitImage is " + input.width);
      h=input.height;
      area = w*h;
      spIm.width = w;
      spIm.height=h;
      spIm.filename = "Filtered"+ name;
      rmanip = new int[area];
      gmanip = new int[area];
      bmanip = new int[area];
      if ((length!=5)&&(length!=10)&&(length!=17)&&(length!=26))
      {System.out.println("Mask size is appropriate");System.exit(0);}
   
   
   
      if (length==5)
      { 	
         for(i=0;i<area;i++){rmanip[i]=0;}
         for(i=0;i<h-1;i++)
         {	
            for(j=0;j<w-1;j++)
            {k=i*w+j;
               rmanip[k]=(input.red[k]*mask[0] + input.red[k+1]*mask[1] + input.red[k+w]*mask[2] +input.red[k+w+1]*mask[3])/mask[4];
               if (rmanip[k]<0)
               {rmanip[k]=-rmanip[k];}
            }
         } //End of the main loop for filling in pass of mask over data
      
      
         for(i=0;i<h-1;i++)
         {k=i*w+w-1;
            rmanip[k] = rmanip[k-1];
         }//fills the right hand column with copies of penultimate column 
       // up to but excluding the last row
       
         for(j=0;j<w;j++)
         {p=(h-1)*w; q = (h-2)*w;
            rmanip[p+j]=rmanip[q+j];	
         }
      
         spIm.red=rmanip;
      
         for(i=0;i<area;i++){gmanip[i]=0;}
         for(i=0;i<h-1;i++)
         {	
            for(j=0;j<w-1;j++)
            {k=i*w+j;
               gmanip[k]=(input.green[k]*mask[0] + input.green[k+1]*mask[1] + input.green[k+w]*mask[2] +input.green[k+w+1]*mask[3])/mask[4];
               if (gmanip[k]<0)
               {gmanip[k]=-gmanip[k];}
            
            }
         } //End of the main loop for filling in pass of mask over data
      
      
         for(i=0;i<h-1;i++)
         {k=i*w+w-1;
            gmanip[k] = gmanip[k-1];
         }//fills the right hand column with copies of penultimate column 
       // up to but excluding the last row
       
         for(j=0;j<w;j++)
         {p=(h-1)*w; q = (h-2)*w;
            gmanip[p+j]=gmanip[q+j];	
         }
      
         spIm.green=gmanip;
      
         for(i=0;i<area;i++){bmanip[i]=0;} //reset the manip array
         for(i=0;i<h-1;i++)
         {	
            for(j=0;j<w-1;j++)
            {k=i*w+j;
               bmanip[k]=(input.blue[k]*mask[0] + input.blue[k+1]*mask[1] + input.blue[k+w]*mask[2] +input.blue[k+w+1]*mask[3])/mask[4];
               if (bmanip[k]<0)
               {bmanip[k]=-bmanip[k];}
            
            }
         } //End of the main loop for filling in pass of mask over data
      
      
         for(i=0;i<h-1;i++)
         {k=i*w+w-1;
            bmanip[k] = bmanip[k-1];
         }//fills the right hand column with copies of penultimate column 
       // up to but excluding the last row
       
         for(j=0;j<w;j++)
         {p=(h-1)*w; q = (h-2)*w;
            bmanip[p+j]=bmanip[q+j];	
         }
      
         spIm.blue=bmanip;
      
      } //End if(length==5) check on mask size
      for( q=0;q<area;q++)
      {
         if(spIm.red[q]>255){spIm.red[q]=255;}
         if(spIm.green[q]>255){spIm.green[q]=255;}
         if(spIm.blue[q]>255){spIm.blue[q]=255;}
      }
      return spIm;
   } // end of the passover method for 2x2 masks 


   SplitImage toBW(SplitImage sIm)
   {
      int height,width;
      height=sIm.height;
      width=sIm.width;
      int j=0;
      int size;//overall size in pixels of image
      size=height*width;
   
      SplitImage ssIm = new SplitImage(height,width); // blank canvas
      System.out.println("We are in the toBW method just written");
      for(j=0;j<size;j++)
      {
         ssIm.red[j]=(sIm.red[j]+sIm.green[j]+sIm.blue[j]) / 3;
         ssIm.green[j]=(sIm.red[j]+sIm.green[j]+sIm.blue[j]) / 3;
      
         ssIm.blue[j]=(sIm.red[j]+sIm.green[j]+sIm.blue[j]) / 3;
      
      //**************
      //median3x3array();
      //***************
      
      
      }// end for j
   
      return ssIm;
   }// end toBW method



   SplitImage random(SplitImage sIm)
   {int w = sIm.width;int h=sIm.height;
      SplitImage ssIm = new SplitImage(h,w);
      int numberofpoints =2020;
      int seedvalue1 = 40;//row
      int seedvalue2=2;//column
      int min=w;
      int place = (w-1)*seedvalue2+seedvalue1;
      int row;int col;
      int[] z = {seedvalue1,seedvalue2};
      int[] za ={seedvalue1,seedvalue2};
      int[] c = {2,51};
      int[] perturbx= new int[numberofpoints];
      int[] perturby=new int[numberofpoints];
   
      if(h<=w){min=h;}
      else if(h>w){min=w;}
   
   
      for(int q =1;q<numberofpoints;q++)
      {
         place = za[1]*(w) + za[0];
      
      
         ssIm.red[place]=0;
         ssIm.green[place]=0;
         ssIm.blue[place]=0;
      
         z[0]=(z[0]*z[0]-z[1]*z[1]+ c[0])%min;
         z[1]= (2*z[0]*z[1]+c[1])%min;
      
         za[0]=z[0];za[1]=z[1];
         if(z[0]<0){za[0]=min+z[0];}
         if(z[1]<0){za[1]=min+z[1];}
      
      
         perturbx[q]=za[0];
         perturby[q]=za[1];
      
      
         for(int ww=0;ww<q;ww++)
         {
            if(perturbx[ww]==za[0] && perturby[ww]==za[1])
            {c[0]=c[0]+1;c[1]=c[1]+1;}
         }// end for ww
      
      }/// / end for q
   
      return ssIm;
   }

   SplitImage magnify(SplitImage sIm)
   {int width= sIm.width;int height=sIm.height;
      sssIm = new SplitImage(2*height,2*width);
      int size = width*height; // size of original image
      int w=width;
      int h = height;
      System.out.println("The width of the image is "+w );
   
   
   
   
      System.out.println("Just finished with the magnify method and about to return the magnified image");
      return sssIm;
   }



//add 50
   SplitImage Add50(SplitImage sIm)
   {
      int height,width;
      height=sIm.height;
      width=sIm.width;
      int j=0;
      int size;//overall size in pixels of image
      size=height*width;
   
      SplitImage ssIm = new SplitImage(height,width); // blank canvas
      System.out.println("We are in the Add50 method just written");
      for(j=0;j<size;j++)
      {
         ssIm.red[j]=(sIm.red[j]+sIm.green[j]+sIm.blue[j]) + 50;
         ssIm.green[j]=(sIm.red[j]+sIm.green[j]+sIm.blue[j]) + 50;
      
         ssIm.blue[j]=(sIm.red[j]+sIm.green[j]+sIm.blue[j]) + 50;
      
      //**************
      //median3x3array();
      //***************
      
      
      }// end for j
   
      return ssIm;
   }// end Add50 method

   SplitImage Poster(SplitImage sIm){
    int height,width;
      height=sIm.height;
      width=sIm.width;
      int j=0;
      int size;//overall size in pixels of image
      size=height*width;
   
      SplitImage ssIm = new SplitImage(height,width); // blank canvas
      System.out.println("We are in the toBW method just written");
      for(j=0;j<size;j++)
      {
         ssIm.red[j]=(sIm.red[j]+sIm.green[j]+sIm.blue[j]) / 3;
         ssIm.green[j]=(sIm.red[j]+sIm.green[j]+sIm.blue[j]) / 3;
      
         ssIm.blue[j]=(sIm.red[j]+sIm.green[j]+sIm.blue[j]) / 3;
      
      //**************
      //median3x3array();
      //***************
      

      }// end for j
            return sssIm;

   }







   SplitImage reduce(SplitImage input)
   {int oldwidth=input.width;
      int oldheight=input.height;
      int newwidth=oldwidth/2;
      int newheight=oldheight/2;
      int w=oldwidth;
   
      SplitImage sssIm = new SplitImage(newheight, newwidth);
      int oldsize=oldwidth*oldheight;
      int newsize=newwidth*newheight;
   //SplitImage sim = new SplitImage(10,10);
   //TwoDSplitImage dsim = sim.from1To2D();
   
      if(oldwidth%2==1 || oldheight%2==1)
      {System.out.println("Odd dimensions");
         for(int i=0;i<newsize;i++)
         {sssIm.red[i]=128;	
            sssIm.green[i]=128;
            sssIm.blue[i]=128;
         }
      }
      return sssIm;
   }// end method reduce

   SplitImage sharp(SplitImage input)
   {int w=input.width;
      int h=input.height;
      int size = h*w;
      int i=0;
      int j=0; 
      SplitImage sssIm = new SplitImage(h, w);
      SplitImage ssIm = new SplitImage(h,w);
      Function f = new Function ();
      double mu=1.0;
   
      TwoDSplitImage ddinput = new TwoDSplitImage(h,w);
      TwoDSplitImage dsIm = new TwoDSplitImage(h,w);
      TwoDSplitImage dssIm = new TwoDSplitImage(h,w);
      TwoDSplitImage dsssIm = new TwoDSplitImage(h,w);
      TwoDSplitImage deltaIm = new TwoDSplitImage(h,w);
   //SplitImage sim = new SplitImage(10,10);
   //TwoDSplitImage dsim = sim.from1To2D();
   
      dsIm = input.from1To2D();
   
   //for(i=0;i<size;i++)
   //{sssIm.red[i]=128;sssIm.green[i]=42;sssIm.blue[i]=39;
   //}
      for(i=1;i<h-1;i++)
      {
         for(j=1;j<w-1;j++)
         {dssIm.red[i][j]= SHARP[0][0]*dsIm.red[i-1][j-1]+SHARP[0][1]*dsIm.red[i-1][j]+SHARP[0][2]*dsIm.red[i-1][j+1]
               +SHARP[1][0]*dsIm.red[i][j-1]+SHARP[1][1]*dsIm.red[i][j]+SHARP[1][2]*dsIm.red[i][j+1]
               +SHARP[2][0]*dsIm.red[i+1][j+1]+SHARP[2][1]*dsIm.red[i+1][j]+SHARP[2][2]*dsIm.red[i+1][j+1];
            
            dssIm.green[i][j]= SHARP[0][0]*dsIm.green[i-1][j-1]+SHARP[0][1]*dsIm.green[i-1][j]+SHARP[0][2]*dsIm.green[i-1][j+1]
               +SHARP[1][0]*dsIm.green[i][j-1]+SHARP[1][1]*dsIm.green[i][j]+SHARP[1][2]*dsIm.green[i][j+1]
               +SHARP[2][0]*dsIm.green[i+1][j+1]+SHARP[2][1]*dsIm.green[i+1][j]+SHARP[2][2]*dsIm.green[i+1][j+1];
         
         
            dssIm.blue[i][j]= SHARP[0][0]*dsIm.blue[i-1][j-1]+SHARP[0][1]*dsIm.blue[i-1][j]+SHARP[0][2]*dsIm.blue[i-1][j+1]
               +SHARP[1][0]*dsIm.blue[i][j-1]+SHARP[1][1]*dsIm.blue[i][j]+SHARP[1][2]*dsIm.blue[i][j+1]
               +SHARP[2][0]*dsIm.blue[i+1][j+1]+SHARP[2][1]*dsIm.blue[i+1][j]+SHARP[2][2]*dsIm.blue[i+1][j+1];
         
         }
      }
   
      for(i=1;i<h-1;i++)
      {     
         for(j=1;j<w-1;j++)
         {dsssIm.red[i][j]= (5*dssIm.red[i][j]+dssIm.red[i][j+1] + dssIm.red[i+1][j] + dssIm.red[i+1][j+1])/8;
            dsssIm.green[i][j]= (5*dssIm.green[i][j]+dssIm.green[i][j+1] + dssIm.green[i+1][j] + dssIm.green[i+1][j+1])/8;
            dsssIm.blue[i][j]= (5*dssIm.blue[i][j]+dssIm.blue[i][j+1] + dssIm.blue[i+1][j] + dssIm.blue[i+1][j+1])/8;      }
      }
   
   /*
   
   
   //
   
   // The average comes next
   for(i=0;i<h-1;i++)
   {     for(j=0;j<w-1;j++)
      {dssIm.red[i][j]= (int) f.Floor( (dsIm.red[i][j]+dsIm.red[i][j+1]+dsIm.red[i+1][j]+dsIm.red[i+1][j+1])/4) ; 
      dssIm.green[i][j]= (int)f.Floor( (dsIm.green[i][j]+dsIm.green[i][j+1]+dsIm.green[i+1][j]+dsIm.green[i+1][j+1])/4);
      dssIm.blue[i][j]= (int )f.Floor( (dsIm.blue[i][j]+dsIm.blue[i][j+1]+dsIm.blue[i+1][j]+dsIm.blue[i+1][j+1])/4);}
   }
   
   for(i=0;i<h-1;i++)
   {        for(j=0;j<w-1;j++)
         {deltaIm.red[i][j] = dsIm.red[i][j] - dssIm.red[i][j];}
         
   }
   
   // Next: Sharp = Original + mu*(Difference between original and average)
   for(i=0;i<h-1;i++)
   {     for(j=0;j<w-1;j++)
      {     if(deltaIm.red[i][j] > 4 || deltaIm.red[i][j] < -4)  {;}
            else dsssIm.red[i][j]= (int) f.Floor( dsIm.red[i][j] + mu*(dsIm.red[i][j]- dssIm.red[i][j]) );
             
            if(deltaIm.green[i][j] > 4 || deltaIm.green[i][j] < -4)  {;}
            else dsssIm.green[i][j]=(int) f.Floor( dsIm.green[i][j] + mu*(dsIm.green[i][j]- dssIm.green[i][j]));
            
            if(deltaIm.blue[i][j] > 4 || deltaIm.blue[i][j] < -4)  {;}
            else dsssIm.blue[i][j]= (int) f.Floor( dsIm.blue[i][j] + mu*(dsIm.blue[i][j]- dssIm.blue[i][j])) ;
      }
   }
   
   
   sssIm = dsssIm.from2To1D(dsssIm);*/
   //for(i=0;i<size;i++)
   //{sssIm.red[i]=255;sssIm.green[i]=0;sssIm.blue[i]=0;
   //}
      return dsssIm.from2To1D(dsssIm);
   //return sssIm;
   }// end method sharp



//++++++++++++++++++++++++++++++++++++

   int median3x3array(int[][] array)
   {
      int[] val= new int[9];
      int[] ordered =new int[9];
   
      int index=-1;
      int max=0;
      int min = 255;
      int ret=0;
   
      val[0]=array[0][0];val[1]=array[0][1];val[2]=array[0][2];
      val[3]=array[1][0];val[4]=array[1][1];val[5]=array[1][2];
      val[6]=array[2][0];val[7]=array[2][1];val[8]=array[2][2];
   
      for(int j=8;j>=0;j--){
         max=0;
         for(int k=0;k<9;k++)
         {  
            if(val[k]>=max){max=val[k];index=k;}
         }
         val[index]= -1;
      
         ordered[j]=max;
      }// end for j
   
      ret=ordered[4];
      return ret;
   }// end median3x3


//++++++++++++++++++++++++++++++++++++

//****************************************************************************************************
//****************************************************************************************************
//****************************************************************************************************
 



}//End definition of class OurFilter
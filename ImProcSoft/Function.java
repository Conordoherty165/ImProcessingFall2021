import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Function
{double input;
 double output;
 int output1;
 double[] vect1;
 double[] vect2;
 double[][] matrix;

  static final double pi = java.lang.Math.PI;
  static final double e = java.lang.Math.E;

  //pi = java.lang.MAth.PI;
  //e  = java.lang.Math.E;

Function(){}


public double[][] MatMult256(double[][] mat1,double[][] mat2)
{double[][] matrix=new double[256][256];


for(int i =0;i<256;i++)
{
	for(int j=0;j<256;j++)
	{	double sum=0;
		for(int k=0;k<256;k++){
		sum+=mat1[i][k]*mat2[k][j];
		}
	matrix[i][j]=sum;
	}

}
return matrix;
}

public double[][] MatMult16(double[][] mat1,double[][] mat2)
{double[][] matrix=new double[16][16];


for(int i =0;i<16;i++)
{
	for(int j=0;j<16;j++)
	{	double sum=0;
		for(int k=0;k<16;k++){
		sum=sum + mat1[i][k]*mat2[k][j];
		}
	matrix[i][j]=sum;
	}

}
return matrix;
}

public double[][] MatMult8(double[][] mat1,double[][] mat2)
{double[][] matrix=new double[8][8];


for(int i =0;i<8;i++)
{
	for(int j=0;j<8;j++)
	{	double sum=0;
		for(int k=0;k<8;k++){
		sum=sum + mat1[i][k]*mat2[k][j];
		}
	matrix[i][j]=sum;
	}

}
return matrix;
}




public double[][] TileMatMult16(double[][] mat1,double[][] mat2)
{double[][] matrix=new double[16][16];


for(int i =0;i<16;i++)
{
	for(int j=0;j<16;j++)
	{	int sum=0;
		for(int k=0;k<16;k++){
		sum+=mat1[i][k]*mat2[k][j];
		}
	matrix[i][j]=sum;
	}

}
return matrix;
}


public double Dot(double[] vect1, double[] vect2)
{output= vect1[0]*vect2[0]+vect1[1]*vect2[1]+vect1[2]*vect2[2];
return output;
}



public double Cos(double input)
{output = java.lang.Math.cos(input);
 return output;
}

public double Sin(double input)
{output = java.lang.Math.sin(input);
 return output;
}

public double Tan(double input)
{output = java.lang.Math.tan(input);
 return output;
}

public double Rec(double input)
{if(input!=0){output = 1/input;}
 else {System.out.println("Divide by zero problem with Reciprocal");
  output= input; }
return output;
}

public double Exp(double input)
{output = java.lang.Math.exp(input);
 return output;
}

public double ISin(double input)
{output = java.lang.Math.asin(input);
 return output;
}

public double ICos(double input)
{output = java.lang.Math.acos(input);
 return output;
}

public double ITan(double input)
{output = java.lang.Math.atan(input);
 return output;
}

public double Sqrt(double input)
{output = java.lang.Math.sqrt(input);
 return output;
}

public double Floor(double input)
{output = java.lang.Math.floor(input);
 return output;
}

public double Abs(double input)
{if(input<0){output=-input;}
 else{output=input;}
return output;
}

public int Round(double input)
{output1=(int)java.lang.Math.round(input);
return output1;
}

public static void main(String [] args) throws java.io.IOException
{Function f = new Function();
 //double input = .7854;
InputStreamReader isr = new InputStreamReader(System.in) ;
BufferedReader br = new BufferedReader(isr) ;
System.out.println("Please enter the angle theta in radians") ;
double inp = Double.parseDouble(br.readLine()) ;
System.out.println( "The Cos of " + inp + " rads is " + f.Cos(inp)  );
System.out.println( "The Sin of " +inp  + " rads is "  + f.Sin(inp) );
System.out.println( "The Tan of " +inp   +" rads is" + f.Tan(inp) );
System.out.println( "The Reciprocal of " +inp   +"is" + f.Rec(inp) );
System.out.println( "The Exponential of " +inp   +"is" + f.Exp(inp) );
System.out.println( "The ArcSin of " +inp  + "is "  + f.ISin(inp) );
System.out.println( "The ArcCos of " +inp  + "is "  + f.ICos(inp) );
System.out.println( "The ArcTan of " +inp  + "is "  + f.ITan(inp) );
System.out.println( "The value of pi is  " + Function.pi  );
System.out.println( "The value of e is " +Function.e );
System.out.println( "The Sqrt of " +inp  + "is "  + f.Sqrt(inp) );
System.out.println( "The Floor of " +inp  + "is "  + f.Floor(inp) );
}

} //end Class F (for function) definition

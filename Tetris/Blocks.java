
public class Blocks {

	public int BlockPosition[][]= new int[4][4];
	
	
	public static int offsetX = 0;
	public static int offsetY = 0;	
	
	
	 public static int[][] LShape = {
		        {1,0,0,0},
		        {1,0,0,0},
		        {1,1,0,0},
		        {0,0,0,0}
		    };

	 public static int[][]  L2Shape = {
		        {0,2,0,0},
		        {0,2,0,0},
		        {2,2,0,0},
		        {0,0,0,0}
		    };

	 public static int[][]  SShape = {
		        {3,0,0,0},
		        {3,3,0,0},
		        {0,3,0,0},
		        {0,0,0,0}
		    };

	 public static int[][]  ZShape = {
		        {0,4,0,0},
		        {4,4,0,0},
		        {4,0,0,0},
		        {0,0,0,0}
		    };

	 public static int[][]  IShape = {
		        {0,5,0,0},
		        {0,5,0,0},
		        {0,5,0,0},
		        {0,5,0,0}
		    };

	 public static int[][] SquShape = {
		        {6,6,0,0},
		        {6,6,0,0},
		        {0,0,0,0},
		        {0,0,0,0}
		    };

	 public static int[][]  TShape = {
		        {7,0,0,0},
		        {7,7,0,0},
		        {7,0,0,0},
		        {0,0,0,0}
		    };
	
	 public static int CurrentShape = 0;
	 
	 public static int[][] SpriteShape= new int[4][4];	
	 
	 public static int CurrentSymbol = 0;
	 
	 
	 public static int[][] GetCurrent() {	 
	 
		 	if(CurrentShape == 0) {

		        return LShape;
		    } else if(CurrentShape == 1) {

		        return L2Shape;
		    } else if(CurrentShape == 2) {

		        return SShape;
		    } else if(CurrentShape == 3) {

		        return ZShape;
		    } else if(CurrentShape == 4) {

		        return IShape;
		    } else if(CurrentShape == 5) {

		        return SquShape;
		    } else if(CurrentShape == 6) {

		        return TShape;
		    }
		 
		 return LShape;
	 }
	 
	 
	 public static void BlockHandler(String rotation) {
		 
		    int placeTemp = 0;
		    int temp = 0;
		    int temp2 = 0;

		   int[][] CurrentShapeTemp = new int[4][4];
		   
		   
		   	CurrentShapeTemp = GetCurrent();
		    
		   	SpriteShape = new int[4][4];
		   
			  for(int i = 0; i <4;i++) {
				  for(int j = 0; j <4; j++) {

						
				//	  System.out.print(CurrentShapeTemp[i][j]);

			 
				  }
				//System.out.println();  
			  }
		   
		    
		//rotation = "U";
		//rotation = "D";
		//rotation = "L";
		//rotation = "R";
		//[up][right]

		    if(rotation == "U") {
//works
		  	  for(int i = 0; i <4;i++) {
				  for(int j = 0; j <4; j++) {
		                if(CurrentShapeTemp[i][j] != 0) {

		                    if(j == 1)
		                        temp = 0;

		                    if(j == 0)
		                        temp = 1;

		                    SpriteShape[temp][i]=CurrentSymbol;
		                   
		                }
		            }
		        }

		    } else if(rotation == "D") {

		    	//works
	            for(int i = 0; i < 4; i++) {
		        for(int j = 0; j<4; j++) {

		                if(CurrentShapeTemp[i][j] != 0) {

		                    if(i == 0) {
		                        temp = 3;
		                    }
		                    if(i == 1) {
		                        temp = 2;
		                    }
		                    if(i == 2) {
		                        temp = 1;
		                    }
		                    if(i == 3) {
		                        temp = 0;
		                    }

		                    SpriteShape[j][temp]=CurrentSymbol;
		                    
		                } 
		            }
		        }
		    }  else if(rotation == "L") {

		
		    	SpriteShape = GetCurrent();
		        
		    } else if(rotation == "R") {
				//Works
		        for(int i = 0; i < 4; i++) {

		            for(int j = 0; j<2; j++) {

		                if(CurrentShapeTemp[i][j] != 0) {


		                    if(j == 0) {
		                        temp2 = 1;
		                    }
		                    if(j == 1) {
		                        temp2 = 0;
		                    }

		                    if(i == 0) {
		                        temp = 3;
		                    }
		                    if(i == 1) {
		                        temp = 2;
		                    }
		                    if(i == 2) {
		                        temp = 1;
		                    }
		                    if(i == 3) {
		                        temp = 0;
		                    }

		                    SpriteShape[temp][temp2]=CurrentSymbol;
		                    
		                } 

		            }
		        }
		 
		    }  
		    
	 }
	 
	 
	public static Boolean WhereFloor() {
		
		
		
		
		return false;
	}
	 
	 
	 
	
	
}

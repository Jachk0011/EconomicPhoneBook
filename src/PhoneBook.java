import java.io.*;
import java.util.StringTokenizer;

public class PhoneBook {

	public void readFile()
	{
		File file = null;
	      FileReader fr = null;
	      BufferedReader br = null;

	      try 
	      {
			 file = new File ("test1.txt");
			 fr = new FileReader (file);
			 br = new BufferedReader(fr);
			
			
			 
			 int rows = Integer.parseInt(br.readLine()), // for build first matrix row 
				 col = Integer.MIN_VALUE, 
				 counter = 0, result = 0;
			 int[][] book;
			 
			 String line = br.readLine(); //get the array of numbers for first matrix;
			 
			 
			 while(line != null)
			 {
				 
				 if(line.length() == 1) // when the line of file has only one number who says length of rows
				 {
					 int tmp = Integer.parseInt(line); // get the sentinel "zero" for stop the program
					 									// if we use this sentence and analyze since while sentence, exist error
					 if(tmp == 0)
						 break; // finish the program
					 else
					 {
						 rows = Integer.parseInt(line);
						 line = br.readLine();
						 counter = 0; // for not have problem after 
						 result = 0; // for not have problem after 
					 }					 
				 }				 
				 
				 col = (line.length()+1)/2; //equal to the length, we supposed that all numbers has the same length as first line
				 book = new int[rows][col]; // building the matrix
				 
				 while(line != null)
				 {					 
					 StringTokenizer st = new StringTokenizer(line); //for split each  phone number
					 for(int j=0; j < col; j++)
					 	 book[counter][j] = Integer.parseInt(st.nextToken()); 
					 line = br.readLine(); //get second line of each test case
					 if(line.length() == 1) // sentinel which say if a new test case is present 
						 break;
					 else
						 counter++;	//change the next row to fill again with the tokenizer
				 }
				 
				 
				 for(int i=0; i < rows-1; i++) // need rows-1 because if we include last row we have a problem with index found row
					 for(int j=0; j < col; j++)
					 {
						if(book[i][j] == book[i+1][j]) // comparing two rows at time
							result++;
						else
							j = col-1; // here we jump last j index when a data comparing is different, we have in mind that j should increase
					 }
				 
				 System.out.println(result); // printing the result of i case
				 
			 }
	      }
	      catch(Exception e)
	      {
	    	  e.printStackTrace();
	      }
	      finally
	      {	         
			 try{                    
			    if( fr != null ){   
			       fr.close();     
			    }                  
			 }catch (Exception e2){ 
			    e2.printStackTrace();
			 }
	      }
	}
	
	public static void main(String[] args) {
		/*
		int r = 4, c = 7, r_ = 0;
		
		int[][] b = {{1,2,3,4,5,6,7},{1,2,3,5,4,6,7},{1,2,3,5,6,4,7},{1,2,3,5,6,7,4}};
		for(int i=0; i < r-1; i++)
			 for(int j=0; j < c; j++)
			 {
				if(b[i][j] == b[i+1][j])
					r_++;
				else
					j = c-1;
			 }
		
		System.out.println(r_);*/
		
		PhoneBook pb = new PhoneBook();
		pb.readFile();

	}

}

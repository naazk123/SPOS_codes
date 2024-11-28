import java.util.*;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;
public class sposass2{
public static void main(String arg[]){
	String[] MDT=new String[40];
	int MDT_index=0;
	try
   {File myFile = new File("Input.txt");
	Scanner myReader = new Scanner(myFile);
	FileWriter ir= new FileWriter("Output.txt");
	String str = "";
	
 	int flag=0;
	while(myReader.hasNextLine()){
				String data = myReader.nextLine();
				//String[] result = data.split(" ");

				if(data.equals("MACRO"))
					{
					data = myReader.nextLine();
					while(!data.equals("MEND"))
						{
						
						MDT[MDT_index]=data;
						System.out.println(MDT[MDT_index]);


						MDT_index++;
						data = myReader.nextLine();
						}
						MDT[MDT_index]=data;
						System.out.println(MDT[MDT_index]);


						MDT_index++;
					flag=1;
					}

				if(flag==0)
					ir.write(data+"\n");
				
				if(data.equals("MEND"))
					flag=0;

				
	}
	//for(int i=0;i<20;i++)
		//System.out.println(MDT[0]);
	
	ir.close();
}
	catch(FileNotFoundException e){
			System.out.println("An error occured with the file!");
			e.printStackTrace();
		}
	catch(IOException e){
			System.out.println("An error occured with the file!");
			e.printStackTrace();
		}
		//input.close();
		//myFile.close();
		//fw.close();
}
}




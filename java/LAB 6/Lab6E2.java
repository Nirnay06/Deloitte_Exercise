package lab6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RNDFile {

	public static void main(String[] args) {

		File file = new File("C:\\Users\\ADMIN\\workspace\\Pratik\\src\\lab6\\rndfile.txt"); 
		  
		  BufferedReader br = null;
		  int i=0;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		  
		  String st; 
		  try {
			while ((st = br.readLine()) != null) 
			    System.out.println(++i+". "+st);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		  
	}

}

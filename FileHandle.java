package com.file.handling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileHandle {
	static void createFile() throws IOException{                 //Method to create file
		File file = new File("E:\\SD\\filedemo\\testfile.txt");

		if(file.createNewFile())
			System.out.println("File is created "+file.getName());
		else 
			System.out.println("File already exist ");
	}
	static void writeFile() throws IOException {                //Method to writeFile
	File file = new File("E:\\SD\\filedemo\\testfile.txt");
	FileWriter writer= new FileWriter(file);
	writer.write("welcom user to file ");
	writer.close();
	}	
	
	static void appendFile(String s) throws IOException{        //Append file
		File file = new File("E:\\SD\\filedemo\\testfile.txt");
		FileWriter wr=new FileWriter(file,true);
		wr.write(s);
		wr.close();
	}
	static List<String> readFile(String file) throws IOException{    // Read File  
		List<String> list= Collections.emptyList();
		try {
			list=Files.readAllLines(Paths.get(file),StandardCharsets.UTF_8);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
		public static void main(String[] args) {              // Main Method
		Scanner sc = new Scanner(System.in);
		int a = 0;
		System.out.println("Enter 1 to create file ");
		System.out.println("Enter 2 to write file ");
		System.out.println("Enter 3 to Append file ");
		System.out.println("Enter 4 to Read file ");
		a=sc.nextInt();
		
		if(a==1){
		try {
		createFile();
		}
		catch(IOException e) {
			System.out.println(e);
		} }
		else if(a==2) {
			try {
				writeFile();
				System.out.println("write complete!!");
			}
			catch(IOException e) {
				System.out.println(e);
			} }
			else if(a==3) {
				Scanner s1 = new Scanner(System.in);
				String s ;
				System.out.println("Type your Message ");
				s=s1.nextLine();
				try {
					
				appendFile("\n"+s);
				System.out.println("Message added Sucessfully!!");
			}
				catch(Exception e) {
					System.out.println(e);
				} }
			else if(a==4){
				try {
					List<String> result =readFile("E:\\SD\\filedemo\\testfile.txt");
					Iterator<String> it =result.iterator();
					while(it.hasNext()) {
						System.out.println(it.next());
					}
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
}
				

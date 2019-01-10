package com.hs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fileprogram {
	
	public void writeToFile(){
		FileWriter fw=null;
		BufferedWriter bf=null;
		try {
			fw=new FileWriter(new File("abc.ser"));
			bf=new BufferedWriter(fw);
			String str="my name is khan and i am not a terrorist";
			bf.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bf.flush();
				bf.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String readFromFile(){
		FileReader fr=null;
		BufferedReader br=null;
		String str=null;
		try {
			fr = new FileReader(new File("abc.ser"));
			br=new BufferedReader(fr);
			str=br.readLine();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		 return str;
	}
	public static void main(String[] args) {
		Fileprogram pf=new Fileprogram();
		pf.writeToFile();
		String str=pf.readFromFile();
		String[] arr=str.split(" ");
		int max=0;
		int maxIndex=0;
		for(int i=0;i<arr.length;i++){
			int length=arr[i].length();
			if(length>max){
				max=length;
				maxIndex=i;
			}
		}	
		System.out.println("word of maximum length is "+arr[maxIndex]);
	}
}
package LineOfCodeCounter;

import java.util.Hashtable;
import java.util.LinkedList;

public class ClassCounter {

	public static String ClassCounter(LinkedList<String> linesOfCode){
		String className ="No Class Name Detected";
		
		for (String lineOfCode : linesOfCode){
			if(lineOfCode.contains("class")){
				return lineOfCode.replaceAll("(public|class|private|\\{|\\})","").replaceAll("\\s", "");				
			}
		}		
		return className;		
	}
	
	public static int LineCounter(LinkedList<String> linesOfCode){
		int countLines=0;
		
		for (String lineOfCode : linesOfCode){
			lineOfCode = lineOfCode.replaceAll("\\t+", "");
			if(!lineOfCode.contains("//") && !lineOfCode.isEmpty()){
				countLines++;
			}
		}		
		return countLines;
	}
	
	public static Hashtable<String, Integer> MethodName(LinkedList<String> linesOfCode){
		String methodName ="";
		int countLines=0;
		Hashtable<String, Integer> hashTable =  new Hashtable<String, Integer>();
		boolean isMethod = false;
		for (String lineOfCode : linesOfCode){
			if((lineOfCode.contains("public") || lineOfCode.contains("private") || lineOfCode.contains("static")) && lineOfCode.contains("(") && lineOfCode.contains(")")){
				
				if(countLines>0){
					hashTable.put(methodName, countLines);
				}
				
				methodName = lineOfCode.replaceAll("(public|static|class|private|int|String|double|void|\\{|\\})","");				
				methodName = methodName.substring(0,methodName.indexOf("("));				
				String [] arrayName = methodName.split(" ");				
				methodName = arrayName[arrayName.length - 1].replaceAll("\\s", "");
								
				countLines =0;
				isMethod =true;
			}
			if(isMethod){
				lineOfCode = lineOfCode.replaceAll("\\t+", "");
				if(!lineOfCode.contains("//") && !lineOfCode.isEmpty()){
					countLines++;
				}
			}
		}
		
		if(countLines >0){
			hashTable.put(methodName, countLines);
		}
		
		return hashTable;
	}	
}

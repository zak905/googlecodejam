if(this.args.size() <= 0){
	println "test"
	System.exit 1
}




if(this.args[0] == null || this.args[0].equals("")){
   println "Incorrect number of arguments"
  System.exit 1
}

processInput(args[0]);

public static def processInput(String fileName){
 def filePath = "src/" + fileName
 def file = new File(filePath)
 def lines = file.readLines()
  // println lines
  
   def problemSize = Integer.valueOf(lines[0])
   
   
   for(int i = 1 ; i < lines.size(); i++){
	   solveProblemInstance(lines[i], i);
  }
   
 
}

public static def solveProblemInstance(String number, int caseNumber){
	
	Set<Character> digits = new HashSet<Character>()
	
	int numberAsInteger = Integer.valueOf(number)
	
	int i = 1;
	int result = 0;
	while (digits.size() < 10){
		
		if (i == 100)
		  break;
		  
		result = i * numberAsInteger;
		char[] numberChars = String.valueOf(result).toCharArray();
		
		  for(int j = 0; j < numberChars.length; j++){
			  digits.add(numberChars[j])
		  }

       i++;
	}
	
	

	if(digits.size() < 10)
	   println "Case #"+caseNumber+": INSOMNIA" 
	else
	   println "Case #"+caseNumber+": " + result 
	
	
}

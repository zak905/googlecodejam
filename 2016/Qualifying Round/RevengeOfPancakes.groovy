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

public static def solveProblemInstance(String pancakes, int caseNumber){
	
	Stack<Character> pancakesStack = new Stack<Character>()
	
	char[] pancakesAsChars = pancakes.toCharArray()
	
	for(int i = pancakesAsChars.length - 1 ; i >= 0; i--){
		pancakesStack.push(pancakesAsChars[i])
	}
	
//	println pancakesStack.peek()
	//println "Initial " + pancakesStack
	
	Stack<Character> subStack = new Stack<Character>()
	
	int numberOfFlips = 0;
	

if(checkIfAllElementsAreUnhappy(pancakesStack)){
	
	numberOfFlips++;
	}
else{
	
	while(!checkIfAllElementsAreHappy(pancakesStack)){

		
	 for(int i = pancakesStack.size() - 1; i >= 0 ; i--){
	
		char currentElement = pancakesStack.get(i);
		char nextElement = 0;
		
		 if(i - 1 >=  0)
		    nextElement = pancakesStack.get(i - 1);
			
			if(currentElement == "+"){
				
				if(nextElement == "-" && i == 1){
					
					for(int j = pancakesStack.size() - 1; j >= i ; j--){
						subStack.push(reverseElement(pancakesStack.pop()))
					}
					while(!subStack.empty()){
						pancakesStack.push(subStack.pop());
					}
					//println "case1 - 1: " + pancakesStack
					subStack.clear()
					numberOfFlips++
					
					if(checkIfAllElementsAreUnhappy(pancakesStack)){
						break
					}
					
				}
				
				
			}else {
				if(nextElement == 0 ){
					
					for(int j = pancakesStack.size() - 1; j >= 0  ; j--){
						subStack.push(reverseElement(pancakesStack.pop()))
					}
					while(!subStack.empty()){
						pancakesStack.push(subStack.pop());
					}
					//println "case2 - 1: " + pancakesStack
					subStack.clear()
					numberOfFlips++
					
					if(checkIfAllElementsAreUnhappy(pancakesStack)){
						break
					}
					
				}else if(nextElement == "+" ){
				
				
				for(int j = pancakesStack.size() - 1; j >= i   ; j--){
					
					subStack.push(reverseElement(pancakesStack.pop()))
					//println "loop: " + pancakesStack
					//println "substack: " + subStack
				}
				//println "after loop 1" + pancakesStack
				while(!subStack.empty()){
					pancakesStack.push(subStack.pop());
//					println "*: " + pancakesStack
//					println "**: " + subStack
				}
				//println "case2 - 2: " + pancakesStack 
				subStack.clear()
				numberOfFlips++
				
				if(checkIfAllElementsAreUnhappy(pancakesStack)){
					break
				}
				
				}
				
			}
		
		
	  
		
	      }	
	 
	 if(checkIfAllElementsAreUnhappy(pancakesStack)){
		// println "all happy case: " + pancakesStack
		 numberOfFlips++
		 break
	 }
				
	}
	
}
	
	 

	 
	 

		


println "Case #"+caseNumber+": "+ numberOfFlips
}	



	



public static def reverseElement(def element){
	
	if(element == "-")
	  return "+"
	 else
	   return "-"
}

public static def checkIfAllElementsAreHappy(Stack<Character> stack){
	
for(int i = 0; i < stack.size(); i++){
	if(stack.get(i) == "-")
	   return false
	}
	
return true;
	
}

public static def checkIfAllElementsAreUnhappy(Stack<Character> stack){
	
for(int i = 0; i < stack.size(); i++){
	if(stack.get(i) == "+")
	   return false
	}
	
return true;
	
}
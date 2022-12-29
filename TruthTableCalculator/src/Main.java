import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expres = "(bv(!c))^(avcvd)";
		System.out.println(expres);
		
		String postfix = infixtoPostfix(expres);
		System.out.println(postfix);
		
		makeTruthTable(postfix);
	}

	public static String infixtoPostfix(String exp) {
		Stack ops = new Stack();

		String dataString = "";
		for(int i = 0; i < exp.length(); ++i) {

			if(!isop(exp.charAt(i))) {
				dataString = dataString + exp.charAt(i);
			}
			else if(exp.charAt(i) == '(') { ops.push(exp.charAt(i)); }
			
			else if(exp.charAt(i) == ')') {
				while(!ops.isEmpty() && ops.peekc() != '(') {
					dataString += ops.popc();
				}
				ops.pop();
			}

			else {
				while(!ops.isEmpty() && prec(exp.charAt(i)) <= prec(ops.peekc())) {
					dataString += ops.popc();
				}
				ops.push(exp.charAt(i));
			}

		}

		while(!ops.isEmpty()) {
			if(ops.peekc() == '(')
				return "INVALID EXPRESSION";
			dataString += ops.popc();
		}
		return dataString;
		
	}
	
	
	public static char evaluate(String s) {
		Stack elems = new Stack();
		for(int i = 0; i < s.length(); ++i) {
			if(!isop(s.charAt(i))) {
				elems.push(s.charAt(i));
			}
			else if(s.charAt(i) == '!') {
				char a = elems.popc();
				if(a == 'T') { elems.push('F'); }
				else { elems.push('T'); }
			}
			else {
				char a = elems.popc();
				char b = elems.popc();
				boolean ab = false;
				boolean bb = false;
				if(a == 'T') { ab = true; }
				if(b == 'T') { bb = true; }
				char result = operation(ab,bb,s.charAt(i));
				elems.push(result);
				
			}
		}
		return elems.popc();
	}
	
	public static boolean isop(char c) {
		if(c == '!' || c == '^' || c == 'v' || c =='>' || c == 'z' || c == '(' || c == ')')
			return true;
		return false;
	}
	
	public static int prec(char ch) {
		switch(ch)
		{
			case '!':
				return 5;
			case '^':
				return 4;
			case 'v':
				return 3;
			case '>':
				return 2;
			case 'z':
				return 1;
		}
		return -1;
	}
	
	public static char operation(boolean a, boolean b, char op) {
		boolean returnBool = false;
		if(op == '^') { returnBool = b & a; }
		if(op == 'v') { returnBool = b | a; }
		if(op == '>') { returnBool = !b | a; }
		if(op == 'z') { returnBool = (b & a) | (!b & !a); }
		if(returnBool) { return 'T'; }
		return 'F';
		
	}
	
	public static void makeTruthTable(String s) {
		//First find the total number of variables
		ArrayList<Character> vars = new ArrayList<Character>();
		char[] values = new char[]{'T', 'F'};
		
		for(int i = 0; i < s.length(); i++) {
			if(!isop(s.charAt(i)) && !vars.contains(s.charAt(i))) { vars.add(s.charAt(i)); }
		}
		//Put in alphabetical order here
		Collections.sort(vars);
		
		
		for(int i = 0; i < vars.size(); i++) {
			System.out.print(vars.get(i) + " ");
		}
		System.out.print("O \n");
		
		String[] prevs = new String[vars.size()];
		System.out.println();
		subLetters(s, vars, 0, prevs);
		
	}
	public static void subLetters(String eqn, ArrayList<Character> vals, int index, String[] prevs) {
		if(vals.size() == index) { 
			for(int i = 0; i < index; i++) {
				System.out.print(prevs[i] + " ");
			}
			System.out.print(evaluate(eqn) + "\n");
			return;
		}
		//T first
		String tempeqn = eqn.replaceAll(vals.get(index).toString(), "F");
		prevs[index] = "F";
		
		subLetters(tempeqn, vals, index + 1, prevs);
		
		//F second
		tempeqn = eqn.replaceAll(vals.get(index).toString(), "T");
		prevs[index] = "T";
		subLetters(tempeqn, vals, index + 1, prevs);
		
	}
	
}	


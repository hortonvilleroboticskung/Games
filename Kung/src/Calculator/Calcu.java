package Calculator;

import java.util.*;

public class Calcu {
	
	static ArrayList<String> oper = new ArrayList<String>();
	static ArrayList<Double> ints = new ArrayList<Double>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		String[] arr = s.split(" ");
		for (int i = 0; i < arr.length; i++)
			if (i % 2 == 0)
				ints.add(Double.parseDouble(arr[i]));
			else
				oper.add(arr[i]);

		while (ints.size() != 1)
			ints.add(0,gather());

		System.out.println(ints.get(0));
	}

	public static Double gather() {
		int index = 0;
		int si = 0;
		String[] signs = new String[] {"*","/","+","-"};
		double fnum = 0;
			if(!oper.contains(signs[si]) && !oper.contains(signs[si+1])) {
				si = si+2;
			}
			while (!oper.get(index).equals(signs[si]) && !oper.get(index).equals(signs[si+1]))
				index++;

			if (oper.get(index).equals("*"))
				fnum = ints.get(index) * ints.get(index + 1);
			
			if (oper.get(index).equals("/"))
				fnum = ints.get(index) / ints.get(index + 1);
			
			if(oper.get(index).equals("+"))
				fnum = ints.get(index) + ints.get(index + 1);
			
			if(oper.get(index).equals("-"))
				fnum = ints.get(index) - ints.get(index + 1);
			
			ints.remove(index);
			ints.remove(index);
			oper.remove(index);
			
			return fnum;
	}
}
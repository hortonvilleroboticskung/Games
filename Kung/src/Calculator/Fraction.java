package Calculator;

import java.util.*;

public class Fraction {

	int num;
	int den;

	public Fraction(int num, int den) {
		this.num = num;
		this.den = den;
	}

	public static void main(String[] args) {
		ArrayList<Fraction> frac = new ArrayList<>();
		ArrayList<String> oper = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		String[] arr = scan.nextLine().split(" ");
		scan.close();
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 1)oper.add(arr[i]);
			else frac.add(improp(arr[i]));
		}
		while (frac.size() != 1) frac.add(eval(frac, oper));

		System.out.println(simplify(frac.get(0)));
		
	}
	
	static Fraction improp(String fraction) {
		int den = Integer.parseInt(fraction.split("/")[1]);
		
		if (fraction.split("/").length==1)  throw new IllegalArgumentException("Not a Fraction");
		if (fraction.split("/")[1].equals("0")) throw new IllegalArgumentException("Divide by 0 Error");
		
		if (fraction.split("_").length == 2) {
			int whole = Integer.parseInt(fraction.split("_")[0]);
			return new Fraction(whole * den + Integer.parseInt(fraction.split("_")[1].split("/")[0]), den);
		}
		return new Fraction(Integer.parseInt(fraction.split("/")[0]), den);
	}

	static Fraction eval(ArrayList<Fraction> f, ArrayList<String> oper) {
		int index = 0;
		int si = 0;
		String[] signs = new String[] { "*", "/", "+", "-" };
		Fraction fr = null;
		if (!oper.contains(signs[si]) && !oper.contains(signs[si + 1])) {
			si = 2;
		}

		while (!oper.get(index).equals(signs[si]) && !oper.get(index).equals(signs[si + 1]))
			index++;

		if (oper.get(index).equals("*")) {
			fr = new Fraction(f.get(index).num * f.get(index + 1).num, f.get(index).den * f.get(index + 1).den);
		}

		if (oper.get(index).equals("/")) {
			fr = new Fraction(f.get(index).num * f.get(index + 1).den, f.get(index).den * f.get(index + 1).num);
		}

		if (oper.get(index).equals("+")) {
			int fnum = f.get(index).num * f.get(index + 1).den;
			int bothden = f.get(index).den * f.get(index + 1).den;
			int snum = f.get(index + 1).num * f.get(index).den;
			fr = new Fraction(fnum + snum, bothden);
		}

		if (oper.get(index).equals("-")) {
			int fnum = f.get(index).num * f.get(index + 1).den;
			int bothden = f.get(index).den * f.get(index + 1).den;
			int snum = f.get(index + 1).num * f.get(index).den;
			fr = new Fraction(fnum - snum, bothden);
		}
		
		f.remove(index);
		f.remove(index);
		oper.remove(index);

		return fr;
	}

	static String simplify(Fraction f) {
		int whole = 0;
		int n = f.num;
		int d = f.den;

		if (n / d == 1)
			return "1";
		while (n>d) {
			whole++;
			n = n - d;
		}
		for (int i = 2; i < 9; i++) {
			while (n % i == 0 && d % i == 0) {
				n = n / i;
				d = d / i;
			}
		}
		if(whole == 0) return n+"/"+d;
		return whole + "_" + n + "/" + d;
	}

}

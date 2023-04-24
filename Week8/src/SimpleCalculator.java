import java.util.Scanner;
import java.io.*;
class OutOfRangeException extends RuntimeException{

}
class AddZeroException extends RuntimeException{
	
}
class SubtractZeroException extends RuntimeException{
	
}

public class SimpleCalculator {
	
	public static void main(String[] args) {
		SimpleCalculator calc = new SimpleCalculator();
		Scanner scn = new Scanner(System.in);
		
		int a = scn.nextInt();
		char qual = scn.next().charAt(0);
		int b = scn.nextInt();
			
		try {
			if (qual == '+') calc.add(a, b);
			if (qual == '-') calc.subtract(a, b);
			calc.print();
		} catch(OutOfRangeException e) {
			e.printStackTrace();
		} catch(AddZeroException e) {
			e.printStackTrace();
		} catch(SubtractZeroException e) {
			e.printStackTrace();
		}
	}


	
	
	private int result  = 0;

	public void add(int a, int b) throws OutOfRangeException, AddZeroException {
		result = a+b;
		if (result < 0 || 1000 < result) {
			throw new OutOfRangeException();
		}
		else if (a == 0 || b == 0) {
			throw new AddZeroException();
		}
	}

	public void subtract(int a, int b) throws OutOfRangeException, SubtractZeroException {
		result = a-b;
		if (result < 0 || 1000 < result) {
			throw new OutOfRangeException();
		}
		else if (a == 0 || b == 0) {
			throw new SubtractZeroException();
		}
	}

	public void print() {
		System.out.println(result);
	}

	public void reset() {
		setResult(0);
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}

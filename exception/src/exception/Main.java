package exception;

public class Main {

	public static void main(String[] args) {
		int j=20, i=0;
		try{
				System.out.println(j/i);
			} 
		catch (ArithmeticException e) {
			//e.printStackTrace();
			System.out.println(e.toString());
			e.printStackTrace();
		}

	}

}

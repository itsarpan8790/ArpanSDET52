package LearnJava;

public class C1P1_CheckScope   {

	public void method1() {
		System.out.println("child");
	
	}
	public static void main(String[] args) {
		StringBuilder sb1=new StringBuilder("BTM");
		StringBuilder sb2=new StringBuilder("bTM");
		
		int op1 = sb1.compareTo(sb2);
		System.out.println("Compare output------>"+op1);
		boolean op2 = sb1.equals(sb2);
		System.out.println("equals output----->"+ op2);
		
	}
	
}

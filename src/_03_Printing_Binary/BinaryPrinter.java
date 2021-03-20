package _03_Printing_Binary;

public class BinaryPrinter {
	 /*
	 * Complete the methods below so they print the passed in parameter in binary.
	 * Do not use the Integer.toBinaryString method!
	 * Use the main method to test your methods.
	 */

	
	public void printByteBinary(byte b) {
		// We first want to print the bit in the one's place
		System.out.print((b & 0b10000000) >> 7);
		System.out.print((b & 0b01000000) >> 6);
		System.out.print((b & 0b00100000) >> 5);
		System.out.print((b & 0b00010000) >> 4);
		System.out.print((b & 0b00001000) >> 3);
		System.out.print((b & 0b00000100) >> 2);
		System.out.print((b & 0b00000010) >> 1);
		System.out.print(((b & 0b00000001) >> 0) + " ");
	
		// Shift b seven bits to the right
		//int shifted = b >> 7;
		// Use the & operator to "mask" the bit in the one's place
		// This can be done by "anding" (&) it with the value of 1
		//int result = shifted & 0b00000001;
		// Print the result using System.out.print (NOT System.out.println)
		//System.out.print(result);
		//Use this method to print the remaining 7 bits of b
		//System.out.print(b & 0b00000001);
	}
	public static BinaryPrinter byn = new BinaryPrinter();
	public void printShortBinary(short s) {
		// Create 2 byte variables
		byte by1 = (byte) ((s >> 8) & 0b11111111);
		byte by2 = (byte) (s & 0b11111111);
		// Use bit shifting and masking (&) to save the first
		// 8 bits of s in one byte, and the second 8 bits of
		// s in the other byte
		
		// Call printByteBinary twice using the two bytes
		// Make sure they are in the correct order
		byn.printByteBinary(by1);
		byn.printByteBinary(by2);
	
	}
	
	public void printIntBinary(int i) {
		// Create 2 short variables
		short s1 = (short) ((i >> 16) & 0b1111111111111111);
		short s2 = (short) (i & 0b1111111111111111);
		// Use bit shifting and masking (&) to save the first
		// 16 bits of i in one short, and the second 16 bits of
		// i in the other short
		
		// Call printShortBinary twice using the two short variables
		// Make sure they are in the correct order
		byn.printShortBinary(s1);
		byn.printShortBinary(s2);
		
	}

	public void printLongBinary(long l) {
		// Use the same method as before to complete this method
		int l1 = (int) ((l >> 32) & 0b11111111111111111111111111111111);
		int l2 = (int) (l & 0b11111111111111111111111111111111);
		
		byn.printIntBinary(l1);
		byn.printIntBinary(l2);
		
	}
	
	public static void main(String[] args) {
		// Test your methods here
		byn.printByteBinary((byte) 69);
		System.out.println();
		
		byn.printShortBinary((short) 42069);	
		System.out.println();
		
		byn.printIntBinary(69420666);
		System.out.println();
		
		byn.printLongBinary(1800266822899999999L);

	}
}

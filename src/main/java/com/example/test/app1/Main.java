package com.example.test.app1;

public class Main {
	
	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("please input some string");
			return;
		}
		
		StringBuilder ogStringBuilder = new StringBuilder();
		
		for (String arg : args)
			ogStringBuilder
				.append(" ")
				.append(arg);
				
		String ogString = ogStringBuilder.toString()
			.substring(1);
		
		System.out.println(""
			+ ogString + " "
			+ reverse(ogString) + " "
			+ measureTime(ogString, 1000) + " "
			+ measureTime(ogString, 10000) + " "
			+ measureTime(ogString, 100000)
		);
	}
	
	private static long measureTime(String in, int passes) {
		long now = System.nanoTime();
		multipleReverse(in, passes);
		return System.nanoTime() - now;
	}
	
	private static String multipleReverse(String in, int times) {
		String out = in;
		
		for (int pass = 0; pass < times; pass += 1)
			out = reverse(in);
		
		return out;
	}
	
	private static String reverse(String in) {
		char[] buf = in.toCharArray();
		char temp;
		int revNum;
		for (int letterNum = 0; letterNum < buf.length / 2; letterNum += 1) {
			temp = buf[letterNum];
			revNum = buf.length - letterNum - 1;
			buf[letterNum] = buf[revNum];
			buf[revNum] = temp;
		}
		
		return new String(buf);
	}
	
}
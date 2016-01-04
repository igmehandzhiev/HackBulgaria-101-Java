package p33_sms;

public class P33_sms {

	public static void main(String[] args) {

		int[] sequence = { 1, 4, 4, 4, 8, 8, 8, 6, 6, 6, 0, 3, 3, 0, 1, 7, 7, 7, 7, 7, 2, 6, 6, 3, 2};
		System.out.println(Sms.numbersToMessage(sequence));
		String str = "Ivo e panda";
/*		System.out.println(Sms.getKey(str));
		System.out.println(Sms.getKeystrokeAmount(str));*/
		System.out.println(Sms.messageToNumbers(str));
		System.out.println(Sms.messageToNumbers("aabbcc"));
	}
}

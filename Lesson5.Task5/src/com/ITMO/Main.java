package com.ITMO;

public class Main {

	static String Invert(String str){

		char[] charArray = str.toCharArray();
		char s;
		int i = 0;
		int j = charArray.length - 1;
		while (i < j) {
			s = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = s;
			i++;
			j--;
		}
		return new String(charArray);
	}

    public static void main(String[] args) {

		//String strMain = "This is a test string ";
		String strMain = "От топота копыт пыль по полю летит. ";
		String strFinish = "";
		String str = "";
		int start = 0;
		int finish = 0;

		for(int i = 0; i < strMain.length()-1; i++){
			if (strMain.charAt(i) == ' ')
				strFinish += strMain.charAt(i);

			else{
				start = i;
				while (strMain.charAt(i) != ' ' && i < strMain.length()-1){
					i++;
				}
				finish = i;
				i--;
				str = strMain.substring(start, finish);
				if (str.length() > 1) str = Invert(str);
				strFinish += str;
			}
		}
		System.out.println(strMain);
		System.out.println(strFinish);
    }
}

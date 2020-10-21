package com.ITMO;

import java.util.Comparator;

public class SortByNum implements Comparator<String> {
    public int NumberOfDigits(String str){
        int sum = 0;
        char[] ch = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
                if (ch[i] >= '0' && ch[i] <= '9'){
                    sum++;
                }
        }
        return sum;
    }

    @Override
    public int compare(String o1, String o2) {
        if(NumberOfDigits(o1) > NumberOfDigits(o2)){
            return 1;
        }else {
            if (NumberOfDigits(o1) < NumberOfDigits(o2)) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

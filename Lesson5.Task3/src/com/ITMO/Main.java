package com.ITMO;

public class Main {

    static String Replacement (String str){
        str = str.replace("бяка", "[вырезано цензурой]");
        return str;
    }

    public static void main(String[] args) {
        String str="Заварилась какая-то бяка на отдалённых рубежах о которой нет достоверной информации.";
        System.out.println(Replacement(str));
    }
}

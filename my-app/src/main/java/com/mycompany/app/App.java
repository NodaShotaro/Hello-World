package com.mycompany.app;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class App 
{
    // strをseparatorで分割してArrayList<Integer>へ変換
    public static ArrayList<Integer> splitToArrayList(String str, String separator){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        String[] separated_str = str.split(" ");
        for(int i = 0; i < separated_str.length; i++){
            ans.add(Integer.valueOf(separated_str[i]));
        }
        return ans;
    }

    public static void main( String[] args )
    {
        Scanner scan = new Scanner(System.in);
        String first_line = scan.nextLine();
        scan.close();

        // c, w, wがこの順で現れる正規表現
        Pattern p = Pattern.compile("(c.*?w.*?w)");
        Matcher m = p.matcher(first_line);

        // 文字列の最大値は100なので，デフォルト値は101
        int min_length = 101;
        int start = 0;
        while(m.find(start)){
            System.out.println(m.group());
            int matching_str_length = m.group().length();
            if(matching_str_length < min_length){
                min_length = matching_str_length;
            }
            start = m.start() + 1;
        }
        if(min_length == 101) System.out.println(-1);
        else System.out.println(min_length);
        return;

    }

}

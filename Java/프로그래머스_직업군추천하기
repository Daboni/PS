package D_0829.프로그래머스_위클리4주_직업군추천하기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 
 * 		https://programmers.co.kr/learn/courses/30/lessons/84325
 * 
 */
public class Db {

	static String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
	static String[] languages = {"JAVA", "JAVASCRIPT"};
	static int[] preference = {7, 5};
	public static void main(String[] args) {
		
		int len = languages.length;
		int[] score = new int[5];
		
		String[] lang = new String[5];
		
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(table[i]," ");
			String s = st.nextToken();
			lang[i] = s;
			for(int j=0;j<5;j++) {
				s=st.nextToken();
				for(int k=0;k<len;k++)
					if(s.equals(languages[k])) score[i]+=((5-j)*preference[k]);
			}
		}
		int max=0;
		for(int i=0;i<5;i++) {
			if(score[max]<score[i]) max = i;
            else if(score[max]==score[i]){
                if(lang[max].compareTo(lang[i])>0){
                    max=i;
                }
            }
		}
		String ans = lang[max];
		System.out.println(ans);
	}

}

package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class MainApp {
	

		    public static void main(String[] args) throws IOException {

		        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        int N = Integer.parseInt(br.readLine());

		        StringTokenizer st = new StringTokenizer(br.readLine());

		        List<Integer> list = new ArrayList<>();
		        for(int i = 0; i < N; i++) {
		            list.add(Integer.parseInt(st.nextToken()));
		        }
		        System.out.println("기존 list : " + Arrays.toString(list.toArray()));

		        for(int i = 0; i < list.size(); i++) {
		            for(int j = 0; j < list.size()-1; j++) {
		                if(list.get(j) > list.get(j+1)) {
		                    list.add(list.get(j));
		                    list.remove(j);
//		                    System.out.println("add+remove list : " + Arrays.toString(list.toArray()));
		                } else {
//		                    System.out.println("list : " + Arrays.toString(list.toArray()));
		                }
		            }
		        }
		        System.out.println(Arrays.toString(list.toArray()));

		        br.close();
		    }

}

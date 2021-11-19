package com.utils;

import java.util.Random;

public class CodeGenerator {
	
	static char al_u[]= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	static char al_l[]= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	static char digit[]={'0','1','2','3','4','5','6','7','8','9'};
	public static String generateCode(int noOfdigit){
		String ret="";
		Random r=new Random();
		for(int i=0;i<noOfdigit;i++){
			int l_u=r.nextInt(26);
			int l_l=r.nextInt(26);
			int d=r.nextInt(10);

			ret=ret+al_l[l_l];
			ret=ret+al_u[l_u];
			ret=ret+digit[d];
			
		}
		//System.out.println("vcode : Codegenerator : : : "+ret);
		return ret;
	}
	
}

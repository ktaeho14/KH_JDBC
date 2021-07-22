package com.product_01_view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.product.model.dto.Product;
import com.product_01_controller.Controller;
import com.product_01_dto.Product_01;
public class View {
 static Scanner sc = new Scanner(System.in);
	
	
	public static int getMenu() {
		System.out.println("선택할 메뉴의 번호를 입력하세요: ");
		int a = sc.nextInt();
		
		System.out.print("1.전체출력");
		System.out.print("2.선택출력");
		System.out.print("3.물품입력");
		System.out.print("4.물품수정");
		System.out.print("5.물품삭제");
		System.out.print("6.프로그램 종료");
		
		return a;
	}
	
	
	
	public static void main(String[] args) {
		int a = 0;
		
		Controller co = new Controller();
		while(a!=6) {
			View.getMenu();
			switch(a) {
			case 1:
				
				List<Product_01> res = co.selectAll();
				for(Product_01 p : res) {
					System.out.println(p);
				
			case 2:
				
			case 3:
				
			case 4:
				
			case 5:
				
			case 6:
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
			
			
		}
		

	}

}

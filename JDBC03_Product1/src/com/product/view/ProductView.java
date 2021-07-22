package com.product.view;

import java.util.List;
import java.util.Scanner;

import com.product.controller.ProductController;
import com.product.model.dto.Product;

public class ProductView {
	static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		
		System.out.println("*************");
		System.out.println("1.전체 출력");
		System.out.println("2.선택 출력");
		System.out.println("3.제품 추가");
		System.out.println("4.제품 수정");
		System.out.println("5.제품 삭제");
		System.out.println("6.종료");
		System.out.println("*************");
		System.out.print("메뉴선택: ");
		int select =sc.nextInt();
		
		return select;
	}
	
	
	
	
	public static void main(String[] args) {
		int select = 0;
		ProductController pc = new ProductController();
		
		while(select!=6) {
			select = getMenu();
			
			switch(select) {
			//전체출력
			case 1:
				List<Product> res = pc.selectAll();
				
				for(Product p : res) {
					System.out.println(p);
				}
				break;
			case 2:
				//선택출력
				System.out.println("조회 할 제풍ID: ");
				String pId = sc.next();
				
				Product res_one = pc.selectOne(pId);
				
				System.out.println(res_one);
				break;
			case 3:
				//제품추가
				System.out.println("추가할 제품의 정보를 입력해 주세요.");
				System.out.print("제품ID: ");
				String pIdIn = sc.next();
				System.out.print("제풍명: ");
				String pNameIn = sc.next();
				System.out.print("가격: ");
				int priceIn = sc.nextInt();
				System.out.print("설명: ");
				String descIn =sc.next();
				
				Product insert = new Product(pIdIn,pNameIn,priceIn,descIn);
				
				int resIns =pc.insert(insert);
				
				if(resIns>0) {
					System.out.println("[추가 성공]");
				}else {
					System.out.println("[추가 실패]");
				}
				break;
				
				
				
			case 4:
				//제품수정
				System.out.println("수정할 제품 ID 입력: ");
				String pIdUp = sc.next();
				System.out.print("수정할 가격: ");
				int priceUp =sc.nextInt();
				
				Product update = new Product(pIdUp,"",priceUp,"");
				int res_up = pc.update(update);
				
				if(res_up>0) {
					System.out.println("[수정 성공!!]");
				}else {
					System.out.println("[수정 실패!!]");
				}
				break;
				
				
				
			case 5:
				//삭제
				System.out.println("삭제할 ID 입력: ");
				String pIdDel = sc.next();
				int res_del = pc.delete(pIdDel);
				
				if(res_del>0) {
					System.out.println("[삭제 성공!!]");
				}else {
					System.out.println("[삭제 실패!!]");
				}
				
				break;
				
			case 6:
				System.out.println("[[프로그램이 종료되었습니다]]");
				break;
			
			}
			
			
			
			
			
			
			
			
		}
	
		
		

	}

}

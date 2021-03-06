package com.view;

import java.util.List;
import java.util.Scanner;

import com.biz.MemberBizImpl;
import com.dto.Member;

public class MemberView {
	static Scanner sc = new Scanner(System.in);
	
	
	public static int getMenu() {
		int select = 0;
		System.out.println("***********");
		System.out.println("1.전체출력");
		System.out.println("2.선택출력");
		System.out.println("3.추가");
		System.out.println("4.수정");
		System.out.println("5.삭제");
		System.out.println("6.종료");
		
		System.out.println("메뉴 선택: ");
		select = sc.nextInt();
		return select;
	}
	
	
	public static void main(String[] args) {
		int select=0;
		MemberBizImpl memberbiz = new MemberBizImpl(); 
		
		
		while(select != 6) {
		select = getMenu();
			switch(select) {
			case 1:
				//전체 출력
				List<Member> res = memberbiz.getAll();
				
				for(Member m : res) {
					System.out.println(m);
				}
				break;
			case 2:
				//선택 출력
				System.out.println("번호를 선택해주세요: ");
				int n = sc.nextInt();
				
				Member resOne = memberbiz.getOne(n);
				
				System.out.println(resOne);
				
				break;
				
				
			case 3:
				//추가
				//여기서 키보드로 입력할 것을 받고
				System.out.println("==추가할 데이터입력 ==");
				System.out.print("이름: ");
				String name = sc.next();
				System.out.print("나이: ");
				int age = sc.nextInt();
				System.out.print("성별[M/F]: ");
				String gender = sc.next();
				System.out.print("지역: ");
				String location = sc.next();
				System.out.print("직업: ");
				String job = sc.next();
				System.out.print("전화번호: ");
				String tel = sc.next();
				System.out.print("이메일: ");
				String email = sc.next();
				
				//여기서 매개변수생성자를 통해 키보드로 입력받겠다
				Member insert = new Member(0,name,age,gender,location,job,tel,email);
				
				int res_in = memberbiz.insert(insert);
				
				if(res_in>0) {
					System.out.println("[insert] 성공");
				}else {
					System.out.println("[insert] 실패");
				}
				
				break;
			case 4:
				//수정
				System.out.print("수정할 번호: ");
				int up_no = sc.nextInt();
				
				System.out.print("수정할 나이: ");
				int up_age = sc.nextInt();
				
				System.out.print("수정할 지역: ");
				String up_loc = sc.next();
				
				System.out.print("수정할 직업: ");
				String up_job = sc.next();
				
				System.out.print("수정할 전화번호: ");
				String up_tel =sc.next();
				
				Member update = new Member();
				update.setM_no(up_no);
				update.setM_age(up_age);
				update.setM_location(up_loc);
				update.setM_job(up_job);
				update.setM_tel(up_tel);
				
				int res_up = memberbiz.update(update);
				
				if(res_up>0) {
					System.out.println("update 성공!!");
				}else {
					System.out.println("update 실패!!");
				}
				
				break;
				
				
			case 5:
				//삭제
				System.out.println("삭제할 번호: ");
				int del_no = sc.nextInt();
				
				int del_res = memberbiz.delete(del_no);
				
				if(del_res>0) {
					System.out.println("삭제 성공!!");
				}else {
					System.out.println("삭제 실패!!");
				}
				
				break;
				
				
				
				
				
				
				
			case 6:
				System.out.println("종료되었습니다.");
				break;
			}
			
			
			
			
			
			
		}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

package com.test02.view;

import static common.JDBCTemplate.close;
import static common.JDBCTemplate.commit;
import static common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.Scanner;

import com.test02.dao.MyTestDao;
import com.test02.dto.MyTestDto;
public class MyTestView {
	static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		String str = null;
		int select = 0;
		
		str = "1.전체출력\n";
		str += "2.추가\n";
		str += "3.수정\n";
		str += "4.삭제\n";
		str += "5.종료\n";
		
		System.out.println(str);
		System.out.println("메뉴 선택");
		select = sc.nextInt();
		
		return select;
	}
	
	
	
	
	public static void main(String[] args) {
		int no =0;
		
		int mno=0;
		String name = null;
		String nickName = null;
		
		MyTestDao dao = new MyTestDao();
		
		do {
			
			no=getMenu();
			
			switch(no) {
			//전체 출력(selectAll)
			case 1:
				System.out.println("****전체출력****");
				Connection con = getConnection();
				
				System.out.println(dao.getAll(con));
				
				close(con);
				break;
			//추가(insert)
			case 2:
				System.out.println("추가할 번호:");
				mno = sc.nextInt();
				System.out.println("추가할 이름: ");
				name = sc.next();
				System.out.println("추가할 별명: ");
				nickName = sc.next();
				
				MyTestDto dto = new MyTestDto(mno, name, nickName);
				Connection con2 = getConnection();
				
				int res = dao.getInsert(con2,dto);
						
				if(res>0) {
					commit(con2);
					System.out.println("입력 성공!");
				}else {
					System.out.println("입력 실패!!");
				}
				break;
				
				
			//수정(update)
			case 3:
				System.out.print("수정할 번호: ");
				mno = sc.nextInt();
				System.out.print("수정할 이름: ");
				name = sc.next();
				System.out.println("수정할 별명: ");
				nickName = sc.next();
				
				MyTestDto update = new MyTestDto(mno,name,nickName);
				Connection con3 = getConnection();
				
				int res_update = dao.getUpdate(con3, update);
				
				if(res_update>0) {
					commit(con3); //저장을 꼭해주어야한다. 아니라면 update가되지않는다.
					System.out.println("Update 성공!!");
				}else {
					System.out.println("Update 실패!!");
				}
				close(con3);
				break;
				
			//삭제(delete)
			case 4:
				
				System.out.println("삭제할 번호: ");
				int del = sc.nextInt();
				
				Connection con4 = getConnection();
				
				
				
				int res_del = dao.getDelete(con4, del);
				
				if(res_del>0) {
					commit(con4);
					System.out.println("삭제성공!!");
				}else {
					System.out.println("삭제실패!!");
				}
				
				close(con4);
				break;
				
				
				
				
				
				
				
				
			//종료
			case 5:
				System.out.println("종료");
			break;
			}
			
		}while(no != 5);
		
		
		
		
		
		
		
		
		
		
		
	}
}

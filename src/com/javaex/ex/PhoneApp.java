package com.javaex.ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		
		System.out.println("*************************************************");
		System.out.println("*             전화번호 관리 프로그램            *");
		System.out.println("*************************************************");

		
		List<Phone> pArr = new ArrayList<Phone>();
		
		Scanner sc = new Scanner(System.in);

	
		FileReader fr = new FileReader("C:\\javaStudy\\PhoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		
		while (true) {
			String str = br.readLine();
			if (str == null) { 
				break;
			}
			String[] info = str.split(","); 
			String name = info[0];
			String hp = info[1];
			String cp = info[2];

			Phone p = new Phone(name, hp, cp); 
			pArr.add(p); 
		}
		br.close();

		while (true) {
			
			System.out.println("");
			System.out.println("1. 리스트 | 2. 등록 |  3. 삭제 | 4. 검색 |  5. 종료");
			System.out.println("-------------------------------------------------");
			System.out.print("메뉴번호: ");
			int num = sc.nextInt(); // 메뉴번호 입력

			if (num == 5) {
				System.out.println("*************************************************");
				System.out.println("*                   감사합니다                  *");
				System.out.println("*************************************************");
				break;
			}

			switch (num) {
			case 1:
				System.out.println("<1. 리스트>");
				for (int i = 0; i < pArr.size(); i++) {
					System.out.print((i + 1) + ". ");
					pArr.get(i).showInfo();
				}
				break;

			case 2:
				System.out.println("<2. 등록>");
				sc.nextLine();
				System.out.print("이름: ");
				String name = sc.nextLine();
				System.out.print("휴대전화: ");
				String hp = sc.nextLine();
				System.out.print("회사전화: ");
				String cp = sc.nextLine();

				Phone p = new Phone(name, hp, cp);
				pArr.add(p);

				
				FileWriter fw = new FileWriter("C:\\javaStudy\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(fw);

				for (Phone Phone : pArr) {
					bw.write(Phone.getName() + "," + Phone.getHp() + "," + Phone.getCp());
					bw.newLine();
				}
				System.out.println("[등록되었습니다.]");
				bw.close();
				break;

			case 3:
				System.out.println("<3. 삭제>");
				sc.nextLine();
				System.out.print("번호: ");
				int delete = sc.nextInt();
				pArr.remove(delete - 1);

				
				try (BufferedWriter bwr = new BufferedWriter(new FileWriter("C:\\javaStudy\\PhoneDB.txt"))) {
				    for (Phone phone : pArr) {
				        bwr.write(phone.getName() + "," + phone.getHp() + "," + phone.getCp());
				        bwr.newLine();
				    }
				}
				System.out.println("[삭제되었습니다.]");
				
				

			case 4:
				System.out.println("<4. 검색>");
				sc.nextLine();
				System.out.print("이름: ");
				String sName = sc.nextLine();

				for (int i = 0; i < pArr.size(); i++) {
					Phone pName = pArr.get(i);
					if (pName.getName().contains(sName)) {
						System.out.print((i + 1) + ". ");
						pName.showInfo();
					}
				}
				break;

			default:
				System.out.println("[다시 입력해 주세요.]");
			}

		}

		sc.close();
	}

}
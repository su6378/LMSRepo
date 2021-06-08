package LMS;

import java.util.ArrayList;
import java.util.Scanner;

class C01Student
{
	String stdId;
	String stdName;
	String stdAddr;
	String stdPhone;
	ArrayList Subject = new ArrayList();	//수강신청과목 저장 
}

public class C01StudentMenu {
	
	ArrayList<C01Student> Stdlist = new ArrayList();
	int Curidx = 9999;	// 현재 로그인한 학생 idx 저장  
	
	Scanner sc = new Scanner(System.in);
	int no=0;
	void run() {
		while(true)
		{
		System.out.println("------------ 학생메뉴 -------------");
		System.out.println("1.계정 등록");
		System.out.println("2.로그  인");
		System.out.println("3.로그 아웃");
		System.out.println("4.내 강의실");
		System.out.println("5.수강 신청");
		System.out.println("6.신청 취소");
		System.out.println("7.정보 수정");
		System.out.println("8.계정 삭제");
		System.out.println("9.종료");
		System.out.println("------------ 학생메뉴 -------------");
		System.out.print("입력 : ");
		no = sc.nextInt();
		switch(no)
		{
		case 1:
			//C01StudentMenu객체를 만들고 
			//각정보 입력한 후
			//ArrayList에 추가합니다
			C01Student C = new C01Student(); 
			sc.nextLine();
			System.out.print("ID : ");
			C.stdId = sc.nextLine();
			
			System.out.print("이름 : ");
			C.stdName = sc.nextLine();
			
			System.out.print("주소 : ");
			C.stdAddr = sc.nextLine();
			
			System.out.print("연락처 : ");
			C.stdPhone = sc.nextLine();
			
			Stdlist.add(C);
			break;
		case 2:
			//로그인
			//ArrayList에 해당 stdId가 있는 idx를 CurIdx에 저장
			if (Curidx != 9999) {System.out.println("이미 로그인 되어있습니다."); break;}
			sc.nextLine();
			String id = sc.nextLine();
			for (int i = 0 ; i < Stdlist.size() ; i++) {
				if(Stdlist.get(i).stdId.equals(id)) {
					Curidx = i;
					System.out.println(Stdlist.get(i).stdName + "님 환영합니다.");
					break;
				}
			}
			if (Curidx == 9999) System.out.println("일치하는 ID가 없습니다.");
			break;
		case 3:
			//로그아웃
			//CurIdx 에 9999값 넣음
			if (Curidx == 9999) {
				System.out.println("로그인 되어있지 않습니다.");
				break;
			}
			Curidx = 9999;
			System.out.println("로그아웃 되었습니다.");
			break;
		case 4:
			//내가 신청한 과목 정보 출력(여러 과목일수 있음)
			if (Curidx == 9999) {
				System.out.println("로그인 후 이용해주세요");
				break;
			}
			System.out.println(Stdlist.get(Curidx).Subject);
			break;
		case 5:
			if (Curidx == 9999) {
				System.out.println("로그인 후 이용해주세요");
				break;
			}
			//CurIdx에 있는 학생 정보객체에 과목을 입력받아 저장 
			sc.nextLine();
			System.out.print("신청할 과목을 입력하세요 : ");
			String sub = sc.nextLine();
			Stdlist.get(Curidx).Subject.add(sub);
			break;
		case 6:
			if (Curidx == 9999) {
				System.out.println("로그인 후 이용해주세요");
				break;
			}
			//신청 취소할 과목을 입력받아
			//동일한 과목이 있다면 삭제(NULL값 입력)
			System.out.println("현재 수강중인 과목은 " + Stdlist.get(Curidx).Subject + "입니다.");
			System.out.print("몇 번째 과목을 취소하시겠습니까? (뒤로가기 : 9999) : ");
			sc.nextLine();
			int remove = sc.nextInt();
			Stdlist.get(Curidx).Subject.remove(remove+1);
			break;
		case 7:
			if (Curidx == 9999) {
				System.out.println("로그인 후 이용해주세요");
				break;
			}
			//학생정보를 수정
			sc.nextLine();
			System.out.print("ID : ");
			Stdlist.get(Curidx).stdId = sc.nextLine();
			
			System.out.print("이름 : ");
			Stdlist.get(Curidx).stdName = sc.nextLine();
			
			System.out.print("주소 : ");
			Stdlist.get(Curidx).stdAddr = sc.nextLine();
			
			System.out.print("연락처 : ");
			Stdlist.get(Curidx).stdPhone = sc.nextLine();
			System.out.println("정보 수정이 완료되었습니다.");
			break;
		case 8:
			if (Curidx == 9999) {
				System.out.println("로그인 후 이용해주세요");
				break;
			}
			//계정삭제
			//현재 CurIdx 를 리스트에서 제거 
			Stdlist.remove(Curidx);
			System.out.println("계정 삭제가 완료되었습니다.");
			break;
		case 9:
			//종료
			return ;
		default :
			//잘못입력 다시
		}
		
		
		
		}	
		
	}
}

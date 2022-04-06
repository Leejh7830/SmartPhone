package com.kk.smartPhoneApp.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ModifyMemberMenu {
	// Static Final ModifyMember Menu Values
	public static final int MEMBER_MODIFY_ALL_INFO = 1;
	public static final int MEMBER_MODIFY_PASSWORD = 2;
	public static final int MEMBER_MODIFY_EMAIL = 3;
	public static final int MEMBER_MODIFY_PHONE = 4;
	public static final int MEMBER_MODIFY_NAME = 5;
	public static final int MEMBER_MODIFY_ADDRESS = 6;
	public static final int MEMBER_PREV = 0;
	Scanner sc = new Scanner(System.in);

	public int modifyMember() {
		System.out.println("---------------------");
		System.out.println("    ȸ�� ���� ����");
		System.out.println("---------------------");
		System.out.println(" 1. ��ü ����");
		System.out.println(" 2. ��й�ȣ ����");
		System.out.println(" 3. �̸��� ����");
		System.out.println(" 4. ��ȭ��ȣ ����");
		System.out.println(" 5. �̸� ����");
		System.out.println(" 6. �ּ� ����");
		System.out.println(" 0. ��������");
		System.out.println("---------------------");
		System.out.print("�޴��� �����ϼ��� : ");
		int menu = -1;
		while (true) {
			try {
				menu = sc.nextInt();
				if (menu >= ModifyMemberMenu.MEMBER_PREV && menu <= ModifyMemberMenu.MEMBER_MODIFY_ADDRESS)
					break;
				else
					System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			} catch (InputMismatchException e) {
				sc = new Scanner(System.in);
				System.out.println("�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���.");
			}
		}
		return menu;

	}
}
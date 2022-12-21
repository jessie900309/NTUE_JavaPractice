package java_programming_parctice;
import java.util.Scanner;
public class H4_someone {

	public static void main(String[] args) {
		/*
		�ŦX�������з�: 1.�{�����N�q�B�i���� 2.���������\��3.�s�W�d�ߤ���O�_���Ī��\��
		�۵����� : 100 */
		int num; String input,date=null;
		Scanner scan = new Scanner(System.in);
		System.out.print("�п�J�~,��,��(�����H�ťն��j):");
		input = scan.nextLine(); //���N�r��Ū�iinput�ܼƤ�
		scan.close();
		String[] data = input.split("\\s+"); //�N���r��ھڪťնi�����
		int size = data.length;
	    int [] arr = new int [size]; //�z�L�}�C�����׳]�w�x�s��ư}�C���j�p
		for(int i=0;i<arr.length;i++) {
				arr[i] = Integer.parseInt(data[i]); //�N�r�ꪺ��ƫ��A�ഫ����ƪ���ƫ��A
		}
		num = getDay(arr[0],arr[1],arr[2]);
		switch(num) { //�ھڤ����p�⪺���G�A�^�ǹ����O�P���X
		case 0:
			date = "�@";
			break;
		case 1:
			date = "�G";
			break;
		case 2:
			date = "�T";
			break;
		case 3:
			date = "�|";
			break;
		case 4:
			date = "��";
			break;
		case 5:
			date = "��";
			break;
		case 6:
			date = "��";
			break;
		}
		System.out.printf("%d�~%d��%d�����P��%s\n", arr[0],arr[1],arr[2],date); //��X��Ѭ��P���X
		printMonth(arr[0],arr[1]);
	}
	public static int LeapYear(int year) { //�P�_�Ӧ~�O�_���|�~
		if(year % 4 == 0 && year % 100 != 0)
			return 1; //�p�G���|�~�A�h�Ѽƥ[1
		else if (year % 400 == 0)
			return 1; //�p�G���|�~�A�h�Ѽƥ[1
		else
			return 0; //�p�G�����~�A�h�ѼƤ���
	}
	public static int getDay(int year, int month, int day) {
		int num;
		int days[] = {31,28,31,30,31,30,31,31,30,31,30,31}; //����J�U������Ѽ�
		days[1]+=LeapYear(year); //�d�߸Ӧ~�O�_���|�~
		if(month > 12 || day > days[month-1]) { //�T�{�ϥΪ̿�J������O�_����
			System.out.println("�d�L����A�п�J���Ĥ��");
			System.exit(0);
		}
		if (month == 1 || month == 2) { //�p�G�O1,2��A�h�ݥH�e�@�~��13,14��p��
			month += 12;
			year--;}
		num = (day + 2*month + 3*(month+1)/5 + year + (year/4) - (year/100) + year/400) % 7; //�z�L�����p���Ѭ��P���X
		return num;
	}
	public static void printMonth(int year, int month) {
		int times = 0;
		int day[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		day[1]+=LeapYear(year);
		System.out.println("��\t�@\t�G\t�T\t�|\t��\t��"); //����X�P���X
		for(int i =1;i<day[month-1]+1;i++) {
			if(i==1) { //�p�G�O1���A�h�ݥ���X�ť�
				times = getDay(year,month,1)+1; //�z�L�p����1�����P���X�A�M�w�ݥ��L�h�֭Ӫť�
				if(times != 7) {
					for(int j=0;j<times;j++) {
						System.out.print(" \t");}}
				else{
					times = 0;}
				}
			if(7-times > 0) {
				System.out.printf("%d\t",i); //�p�G�@�P������٨S�L���A�h�~��L�P�@��
				times++;
			}
			else if(7-times == 0) {
				System.out.println(); //�p�G�w�g�L���F�A�h�����~��L
				System.out.printf("%d\t", i);
				times = 1;
			}
		}
	}
}

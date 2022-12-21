package java_programming_parctice;
import java.util.Scanner;
public class H4_someone {

	public static void main(String[] args) {
		/*
		符合的評分標準: 1.程式有意義且可執行 2.完成全部功能3.新增查詢日期是否有效的功能
		自評分數 : 100 */
		int num; String input,date=null;
		Scanner scan = new Scanner(System.in);
		System.out.print("請輸入年,月,日(中間以空白間隔):");
		input = scan.nextLine(); //先將字串讀進input變數中
		scan.close();
		String[] data = input.split("\\s+"); //將長字串根據空白進行切割
		int size = data.length;
	    int [] arr = new int [size]; //透過陣列的長度設定儲存整數陣列的大小
		for(int i=0;i<arr.length;i++) {
				arr[i] = Integer.parseInt(data[i]); //將字串的資料型態轉換成整數的資料型態
		}
		num = getDay(arr[0],arr[1],arr[2]);
		switch(num) { //根據公式計算的結果，回傳對應是星期幾
		case 0:
			date = "一";
			break;
		case 1:
			date = "二";
			break;
		case 2:
			date = "三";
			break;
		case 3:
			date = "四";
			break;
		case 4:
			date = "五";
			break;
		case 5:
			date = "六";
			break;
		case 6:
			date = "日";
			break;
		}
		System.out.printf("%d年%d月%d號為星期%s\n", arr[0],arr[1],arr[2],date); //輸出當天為星期幾
		printMonth(arr[0],arr[1]);
	}
	public static int LeapYear(int year) { //判斷該年是否為閏年
		if(year % 4 == 0 && year % 100 != 0)
			return 1; //如果為閏年，則天數加1
		else if (year % 400 == 0)
			return 1; //如果為閏年，則天數加1
		else
			return 0; //如果為平年，則天數不變
	}
	public static int getDay(int year, int month, int day) {
		int num;
		int days[] = {31,28,31,30,31,30,31,31,30,31,30,31}; //先輸入各月份的天數
		days[1]+=LeapYear(year); //查詢該年是否為閏年
		if(month > 12 || day > days[month-1]) { //確認使用者輸入的日期是否有效
			System.out.println("查無此日，請輸入有效日期");
			System.exit(0);
		}
		if (month == 1 || month == 2) { //如果是1,2月，則需以前一年的13,14月計算
			month += 12;
			year--;}
		num = (day + 2*month + 3*(month+1)/5 + year + (year/4) - (year/100) + year/400) % 7; //透過公式計算當天為星期幾
		return num;
	}
	public static void printMonth(int year, int month) {
		int times = 0;
		int day[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		day[1]+=LeapYear(year);
		System.out.println("日\t一\t二\t三\t四\t五\t六"); //先輸出星期幾
		for(int i =1;i<day[month-1]+1;i++) {
			if(i==1) { //如果是1號，則需先輸出空白
				times = getDay(year,month,1)+1; //透過計算當月1號為星期幾，決定需先印多少個空白
				if(times != 7) {
					for(int j=0;j<times;j++) {
						System.out.print(" \t");}}
				else{
					times = 0;}
				}
			if(7-times > 0) {
				System.out.printf("%d\t",i); //如果一周的日期還沒印完，則繼續印同一排
				times++;
			}
			else if(7-times == 0) {
				System.out.println(); //如果已經印完了，則換行繼續印
				System.out.printf("%d\t", i);
				times = 1;
			}
		}
	}
}

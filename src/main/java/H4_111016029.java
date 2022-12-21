/*
H3_111016029.java
(1) 作者姓名及學號. 若參考他人程式改寫, 請加註原創者姓名及學號
    作者姓名：許晉綸
    作者學號：111016029
    是否原創：是

(2) 程式執行時的操作說明
    ※注意 -- 編譯時請使用UTF-8否則將無法編譯※
    輸入年、月、日
    年分範圍從公元1年起，月、日則參照常理
    輸出當天為星期幾以及當月之月曆
    Ex.
    YEAR:2050
    MONTH:10
    DATE:10
    2050/10/10 is Monday
    2050/10
     Sun. Mon. Tue. Wed. Thu. Fri. Sat
    ===================================
      25   26   27   28   29   30    1
       2    3    4    5    6    7    8
       9   10   11   12   13   14   15
      16   17   18   19   20   21   22
      23   24   25   26   27   28   29
      30   31    1    2    3    4    5

(3) 符合的評分標準及自評應得的分數, 注意: 評分時會參考此資訊, 請仔細正確填寫
    1. 程式有意義且可以執行 --- 20%
    2. 完成全部功能 --- 80%
    3. 程式檔案遵照規定命名
    4. 主程式開始包含作者、操作說明及符合的評分標準等資訊
    5. 程式包含適當註解
    應拿100%

(4) 若參考他人程式, 請說明不同的地方或增加的功能
    無

(5) 其他有利於評分的說明, 例如獨特的功能等
    無
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class H4_111016029 {
    public static void main(String[] args) throws IOException{
        new DateApp();
    }
}
class DateApp {
    //初始化
    private Calendar target = Calendar.getInstance();
    private int CommonEra = 0;
    private int Month = -1;
    private int Date = 0;

    public DateApp() throws IOException{    //建構
        InputCalender();    //輸入目標時間
        System.out.print(CommonEra+"/"+Month+"/"+Date+" is ");
        this.setCalender(); //設定目標時間
        this.getCalender(); //獲取目標時間
    }

    private void setCalender() throws IOException{  //將時間設為使用者輸入時間
        try {
            target.set(Calendar.YEAR,CommonEra);
        } catch (Exception e) {
            System.out.println("Error -- "+e.getMessage());
            this.InputYear();
        }
        try {
            target.set(Calendar.MONTH,Month-1);
        } catch (Exception e) {
            System.out.println("Error -- "+e.getMessage());
            this.InputMonth();
        }
        try {
            target.set(Calendar.DAY_OF_MONTH,Date);
        } catch (Exception e) {
            System.out.println("Error -- " + e.getMessage());
            this.InputDate();
        }
    }

    private void getCalender() {    //輸出星期幾及月曆
        switch (target.get(Calendar.DAY_OF_WEEK)) { //星期幾
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");
                break;
            case 3:
                System.out.println("Tuesday");
                break;
            case 4:
                System.out.println("Wednesday");
                break;
            case 5:
                System.out.println("Thursday");
                break;
            case 6:
                System.out.println("Friday");
                break;
            case 7:
                System.out.println("Saturday");
                break;
        }
        //月曆
        int maxWeek = target.getActualMaximum(Calendar.WEEK_OF_MONTH);
        target.set(Calendar.DAY_OF_MONTH, 1);
        target.add(Calendar.DATE,-(target.get(Calendar.DAY_OF_WEEK))+1);

        System.out.println(CommonEra + "/" +Month);
        System.out.println(" Sun. Mon. Tue. Wed. Thu. Fri. Sat ");
        System.out.println("===================================");


        for (int i = 0; i < maxWeek; i++) { //月曆日期部分
            System.out.print("  ");
            for (int j = 0; j < 7; j++) {
                System.out.printf("%2d",target.get(Calendar.DAY_OF_MONTH));
                System.out.print("   ");
                target.add(Calendar.DATE,1);
            }
            System.out.println();
        }



    }
    private void InputCalender() throws IOException{    //使用者輸入
        System.out.println("Please Enter The Date.");
        this.InputYear();
        this.InputMonth();
        this.InputDate();
    }
    private void InputYear() throws IOException {   //輸入年分
        String ctmp;
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));   //輸入數字 透過字串形式讀取
        boolean check;
        while (true) {  //輸入型態判定 輸入正常即跳出
            check = true;
            System.out.print("YEAR:");
            ctmp = sc.readLine();
            for (int i = 0, m = ctmp.length(); i < m; i++) {     //判斷是否輸入異常
                if (ctmp.charAt(i) <= 57 && ctmp.charAt(i) >= 48 || ctmp.charAt(i) == '+'|| ctmp.charAt(i) == '-') {

                } else {
                    check = false;
                }
            }
            CommonEra = Integer.parseInt(ctmp);

            if (CommonEra < 1) {
                check = false;
            }
            if (check) {
                break;
            }
            System.out.println("ERROR -- ");
        }
    }
    private void InputMonth() throws IOException {  //輸入月份
        String ctmp;
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));   //輸入數字 透過字串形式讀取
        boolean check;
        while (true) {  //輸入型態判定 輸入正常即跳出
            check = true;
            System.out.print("MONTH:");
            ctmp = sc.readLine();
            for (int i = 0, m = ctmp.length(); i < m; i++) {     //判斷是否輸入異常
                if (ctmp.charAt(i) <= 57 && ctmp.charAt(i) >= 48) {

                } else {
                    check = false;
                }
            }
            Month = Integer.parseInt(ctmp);

            if (Month < 1 || Month > 12) {
                check = false;
            }
            if (check) {
                break;
            }
            System.out.println("ERROR -- ");
        }
    }
    private void InputDate() throws IOException {   //輸入日期
        String ctmp;
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));   //輸入數字 透過字串形式讀取
        boolean check;

        while (true) {   //輸入型態判定 輸入正常即跳出
            check = true;
            System.out.print("DATE:");
            ctmp = sc.readLine();
            for (int i = 0, m = ctmp.length(); i < m; i++) {     //判斷是否輸入異常
                if (ctmp.charAt(i) <= 57 && ctmp.charAt(i) >= 48) {

                } else {
                    check = false;
                }
            }
            Date = Integer.parseInt(ctmp);

            if (Date < 1 || Date > target.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                check = false;
            }
            if (check) {
                break;
            }
            System.out.println("ERROR -- ");
        }
    }
}
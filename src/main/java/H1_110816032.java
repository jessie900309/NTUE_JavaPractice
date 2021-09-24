import java.util.Scanner;
//由鍵盤輸入資料
public class H1_110816032 {
    //姓名:謝妤婕
    //學號:110816032
    /*操作說明:
        1. 依輸出說明輸入>1之正整數
        2. 顯示結果後可選擇是否繼續執行程式
        3. 感謝您的使用
    */
    /*自評分數:
        按評分標準為100，但無法避免使用者輸入非整數型態時程式會爆掉。
        基本上都是先用Python做出來以後再改成Java的語法，
        某方面算是參考自己的程式，但Java的例外處理還沒學會，
        所以無法避免使用者輸入非整數型態時程式會爆掉。
     */
    public static void main(String arg[]){ //主程式開始

        /* 宣告 */
        Scanner user_input = new Scanner(System.in);
        //宣告Scanner類別物件，命名為user_input
        int number = 0, result = 0, check = 1;
        //宣告使用者將輸入的數字為number，且初始值設0
        //宣告number是否為質數的判斷結果為result，且初始值設0
        //控制使用者是否重複使用之變數為check，且初始值設1

        /* 與使用者互動功能開始 */
        System.out.println("Homework 1 檢查一個數字是否為質數");
        while (check == 1){

            /* 每次功能開始前將數字歸零 */
            number = 0; result = 0;

            /* 確保輸入之整數>1 */
            while (number <= 1){
                System.out.print("請輸入一個大於1的正整數:");
                number  = user_input.nextInt();
                if (number == 1){
                    System.out.println("1不是質數啦 ┴─┴︵╰（‵□′╰ 冰豆喔!\n");
                }
                else if (number < 1){
                    System.out.println(number + "不是正整數喔\n");
                }
            }

            /* 計算是否為質數 */
            for (int Count=2;number != 2 && Count<number;Count++){
                //若條件成立表示有>=2的整數可整除number 即number不是質數
                //其實只要計算到根號number，但java次方好像還要呼叫函式所以算了嘿嘿
                //紀錄計算結果至result
                if (number%Count == 0){
                    result = 0;
                    break;
                }
                else {
                    result = 1;
                }
            }

            /* 若result為0，即number是質數 */
            if (result == 1 || number == 2) {
                /*輸出結果*/
                System.out.println(number + "是質數\n");
            }

            /* 若result為0，即number不是質數，宣告新變數Number_與count進行因式分解(Number保留字) */
            if (result == 0 && number != 2){
                int Number_ = number;
                int count = 2;
                /* 不換行印出結果 */
                System.out.print(number + " = ");
                /* 控制條件同檢查質數時 */
                for (int Count=2;Count<Number_;Count++){
                    /* 整除則印出count並以商做為新的被除數 */
                    if (Number_%count == 0){
                        System.out.print(count + "*");
                        Number_ = Number_/count;
                    }
                    /* 有餘數則以count+1做為新的除數 */
                    else {
                        count+=1;
                    }
                }
                /* 商為1輸出最後一個因數(被除數) */
                System.out.print(Number_);
                /*輸出結果*/
                System.out.println("\n" + number + "不是質數\n");
            }

            /* 主迴圈控制:check是否重複使用並確保check為1或0 */
            System.out.print("是否再次使用(1是/0否):");
            check  = user_input.nextInt();
            while (check != 1 && check != 0){
                System.out.print("( ･ิ,_ゝ･ิ)...(1是/0否) 再輸入一次吧:");
                check  = user_input.nextInt();
            }
            if (check==1){
                System.out.println("謝謝支持!\n");
            }
            else if (check==0){
                System.out.println("\nヽ(○´∀`)ﾉ♪感謝您的使用!");
                break;
            }

        }
    }
}

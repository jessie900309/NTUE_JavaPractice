import java.util.Scanner;
//由鍵盤輸入資料
import java.lang.*;
//等等要宣告 可以把字串咻咻咻變成數字的謎之物件 的 套件
public class H6_110816032 {
    //姓名:謝妤婕
    //學號:110816032
    /*操作說明:
        1. 依輸出說明輸入五個數字
        2. 顯示五數字之和以後，可繼續輸入數字計算
        3. 若要結束程式請輸入q
        4. 感謝您的使用
    */
    /*自評分數:
        按照配分標準是100啦100啦
        輸入q輸入q快搞死我了啊啊啊啊啊啊啊
        嗚嗚嗚拜託加分｡ﾟヽ(ﾟ´Д`)ﾉﾟ｡。
     */
    public static void main(String arg[]){

        /* 宣告 */
        Scanner user_input = new Scanner(System.in);
        //宣告Scanner類別物件，命名為user_input
        Float float_change = new Float("20.14f");
        //宣告可以把字串咻咻咻變成數字的謎之物件
        //教學來源:http://tw.gitbook.net/java/lang/float_parsefloat.html
        float Num_array[];
        Num_array = new float[5];
        //宣告陣列Num_array存取將作總和的五個數字
        float user_num = 0, Answer = 0;
        String user_end = "";
        //宣告使用者輸入(數字為user_num，其他為user_end)與最後總合為Answer並令初始值為0
        int END = 0, check = 1;
        //以END紀錄使用者輸入狀態(0正常數字 1結束指令q 2輸入異常)
        //控制使用者是否重複使用之變數為check，且初始值設1

        /* 主迴圈:與使用者互動功能開始 */
        System.out.println("Homework 6  數字連加總和 ");
        while (check == 1) {

            /* 狀態初始化 */
            END = 0;
            Answer = 0;
            for (int i = 0; i < 5; i++) { Num_array[i] = 0; }

            /* 功能開始，五個合法輸入後將進行計算 */
            for (int i = 0; i < 5; i++) {
                System.out.print("請輸入第" + (i + 1) + "個數字 : ");

                /* 檢查迴圈:輸入是否合法 */
                while (true) {
                    try {
                        //先檢查是否為q
                        user_end = user_input.next();
                        if (user_end.equals("q")) {
                            END = 1;//結束指令
                        }
                        //不為q則確認是否可轉為數字
                        else {
                            user_num = float_change.parseFloat(user_end);
                            //System.out.println("正常轉換成數字了!!OuO");
                        }
                        break;
                        //正常輸入，結束檢查迴圈
                    }
                    catch (Exception e) {
                        //輸入異常
                        System.out.println("就說數字啦 ┴─┴︵╰（‵□′╰ 冰豆喔!");
                        System.out.print("請輸入第" + (i + 1) + "個數字 : ");
                        //user_input.next();
                    }
                }

                /* 使用者輸入q，強制結束迴圈 */
                if (END == 1) {
                    break;
                }

                /* 不為q且輸入合法(END == 0)，將數字存入陣列 */
                else {
                    Num_array[i] = user_num;
                    //System.out.println("數字放進陣列了!!OuO");
                }
            }//五個數字輸入完畢，迴圈結束
            //System.out.println("五個數字都正常!!OuO");

            /* 陣列已滿，確認狀態正常後，計算總和並輸出結果 */
            for (int i = 0; i < 5 && END == 0; i++) {
                Answer = Answer + Num_array[i];
                if (i == 4){
                    System.out.println("數字總合為 : " + Answer);
                }
            }

            /* 主迴圈控制:check是否重複使用並確保check為1或0 */
            System.out.print("\n\n確定要退出嗎｡ﾟヽ(ﾟ´Д`)ﾉﾟ｡。再來一次嘛(0是/1否):");
            while(true) {
                try { check = user_input.nextInt(); }
                catch (Exception e){
                    System.out.println("...連整數都不是你故意的吧");
                    user_input.next(); }
                if (check == 1){
                    System.out.println("謝謝支持!\n");
                    break; }
                else if (check == 0){
                    System.out.println("\n好啦掰掰ヽ(○´∀`)ﾉ♪\n感謝您的使用!");
                    break; }
                else if (check != 1 && check != 0){
                    System.out.print("( ･ิ,_ゝ･ิ)...(0是/1否) 再輸入一次吧:"); }
            }//主迴圈控制
        }//主迴圈
    }//程式結束
}

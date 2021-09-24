import java.util.Scanner;
//由鍵盤輸入資料
public class H3_110816032 {
    //姓名:謝妤婕
    //學號:110816032
    /*操作說明:
        1. 依輸出說明輸入四個整數
        2. 判別輸入格式是否合理，若為四個不重複整數則輸出結果
        3. 遊戲將進行直到猜中答案
        4. 顯示猜中以後可選擇是否繼續再來一局
        5. 感謝您的使用
        6. 若要方便檢測可執行註解掉的第64行，將會在遊戲開始時顯示解答
    */
    /*自評分數:
        按評分標準應該可以100...吧
        也是先用Python做出來以後再改成Java的語法，某方面算是參考自己的程式，
        但Java的例外處理還學得2266，程式基本上經不起整數以外的考驗嗚嗚嗚｡ﾟヽ(ﾟ´Д`)ﾉﾟ｡。
        有新增確認輸入數字有沒有重複、數字是否為四位數、重複遊戲等功能
        拜託加分｡ﾟヽ(ﾟ´Д`)ﾉﾟ｡。
     */
    public static void main(String arg[]){

        /* 宣告 */
        Scanner user_input = new Scanner(System.in);
        //宣告Scanner類別物件，命名為user_input
        int Answer = 1234, user_num = 0, check = 1;
        int Ran_01 = 0, Ran_02 = 0, Ran_03 = 0, Ran_04 = 0;
        //宣告答案為Answer初始為1234、使用者輸入數字為user_num，初始值設為零
        //宣告答案由Ran_01、Ran_02、Ran_03、Ran_04組成
        //控制使用者是否重複使用之變數為check，且初始值設1
        int Check_A = 0, Check_B = 0;
        //檢查答案為幾A幾B的數目字，初始值設為零
        //遊戲將持續進行直到Check_A==4

        /* 與使用者互動功能開始 */
        System.out.println("Homework 3  1A2B小遊戲 ");
        /* 主迴圈 : 使用者可決定遊戲結束後是否再來一場 */
        while (check == 1){

            /* 隨機產生Answer值 */
            //使用(int)Math.round(Math.random()*9)取0~9以個別決定四位數
            //第一位數
            Ran_01 = (int)Math.round(Math.random()*9);
            //第二位數
            Ran_02 = (int)Math.round(Math.random()*9);
            //不可與第一位數重複
            for (int i=0;Ran_02==Ran_01;i++){
                Ran_02 = (int)Math.round(Math.random()*9);
            }
            //第三位數
            Ran_03 = (int)Math.round(Math.random()*9);
            //不可與第一位數、第二位數重複
            for (int i=0;Ran_03==Ran_01 || Ran_03==Ran_02;i++){
                Ran_03 = (int)Math.round(Math.random()*9);
            }
            //第四位數
            Ran_04 = (int)Math.round(Math.random()*9);
            //不可與第一位數、第二位數、第三位數重複
            for (int i=0;Ran_04==Ran_01 || Ran_04==Ran_02 || Ran_04==Ran_03;i++){
                Ran_04 = (int)Math.round(Math.random()*9);
            }
            //把四個數字組合再一起
            Answer = Ran_01*1000+Ran_02*100+Ran_03*10+Ran_04;
            //System.out.println("Answer = " + Answer);

            /* 遊戲正式開始 */
            while (Check_A<4){

                //清空上一輪的結果
                user_num = 0;
                Check_A = 0;
                Check_B = 0;

                /* 檢查輸入是否合法 */
                System.out.print("請猜一組四位數(須為整數且數字不可重複) : ");
                while(true) {
                    //先檢查是否為整數
                    try {
                        user_num = user_input.nextInt();
                    }
                    catch (Exception e){
                        System.out.println("就說整數啦 ┴─┴︵╰（‵□′╰ 冰豆喔!");
                        System.out.print("請猜一組四位數(須為整數且數字不可重複) : ");
                        user_input.next();
                        continue;
                    }
                    //再檢查數字是否為四位數
                    if (user_num > 9999 || user_num<0){
                        //四位整數範圍:0000~9999
                        System.out.println("四位數四位數四位數啦 看不懂喔 ┴─┴︵╰（‵□′╰ 冰豆喔!");
                        System.out.print("請猜一組四位數(須為整數且數字不可重複) : ");
                    }
                    //再檢查輸入的整數是否不重複
                    else {
                        //利用取餘數慢慢比......
                        //第四位數
                        if (user_num%10==(user_num/10)%10 || user_num%10==(user_num/100)%10 || user_num%10==(user_num/1000)%10){
                            System.out.println("就說整數不可以重複啦 ┴─┴︵╰（‵□′╰ 冰豆喔!");
                            System.out.print("請猜一組四位數(須為整數且數字不可重複) : ");
                        }
                        //第三位數
                        else if ((user_num/10)%10==(user_num/100)%10 || (user_num/10)%10==(user_num/1000)%10){
                            System.out.println("就說整數不可以重複啦 ┴─┴︵╰（‵□′╰ 冰豆喔!");
                            System.out.print("請猜一組四位數(須為整數且數字不可重複) : ");
                        }
                        //第二位數與第一位數
                        else if ((user_num/100)%10==(user_num/1000)%10){
                            System.out.println("就說整數不可以重複啦 ┴─┴︵╰（‵□′╰ 冰豆喔!");
                            System.out.print("請猜一組四位數(須為整數且數字不可重複) : ");
                        }
                        //通過上述考驗，結束檢查迴圈
                        else {
                            break;
                        }
                    }
                }

                /* 若輸入合法，則先判斷是否為4A */
                //因為我只能想到跳出迴圈這個辦法｡ﾟヽ(ﾟ´Д`)ﾉﾟ｡。
                if (Answer == user_num) {
                    break;
                }
                //非4A(正確)結果，利用取餘數把數字一個一個拉出來檢查，我想不到更快的辦法｡ﾟヽ(ﾟ´Д`)ﾉﾟ｡。
                else {
                    //開始魔鬼判斷式吧啊哈哈哈哈哈哈
                    //第四位數
                    if (Answer%10 == user_num%10){
                        Check_A += 1;//數字正確位置正確Check_A+1
                    }
                    if (Answer%10 == (user_num/10)%10) {
                        Check_B += 1;//數字正確位置不正確Check_B+1
                    }
                    if (Answer%10 == (user_num/100)%10){
                        Check_B += 1;//數字正確位置不正確Check_B+1
                    }
                    if (Answer%10 == (user_num/1000)%10){
                        Check_B += 1;//數字正確位置不正確Check_B+1
                    }
                    //第三位數
                    if ((Answer/10)%10 == user_num%10){
                        Check_B += 1;//數字正確位置不正確Check_B+1
                    }
                    if ((Answer/10)%10 == (user_num/10)%10){
                        Check_A += 1;//數字正確位置正確Check_A+1
                    }
                    if ((Answer/10)%10 == (user_num/100)%10){
                        Check_B += 1;//數字正確位置不正確Check_B+1
                    }
                    if ((Answer/10)%10 == (user_num/1000)%10){
                        Check_B += 1;//數字正確位置不正確Check_B+1
                    }
                    //第二位數
                    if ((Answer/100)%10 == user_num%10){
                        Check_B += 1;//數字正確位置不正確Check_B+1
                    }
                    if ((Answer/100)%10 == (user_num/10)%10){
                        Check_B += 1;//數字正確位置不正確Check_B+1
                    }
                    if ((Answer/100)%10 == (user_num/100)%10){
                        Check_A += 1;//數字正確位置正確Check_A+1
                    }
                    if ((Answer/100)%10 == (user_num/1000)%10){
                        Check_B += 1;//數字正確位置不正確Check_B+1
                    }
                    //第一位數
                    if ((Answer/1000)%10 == user_num%10){
                        Check_B += 1;//數字正確位置不正確Check_B+1
                    }
                    if ((Answer/1000)%10 == (user_num/10)%10){
                        Check_B += 1;//數字正確位置不正確Check_B+1
                    }
                    if ((Answer/1000)%10 == (user_num/100)%10){
                        Check_B += 1;//數字正確位置不正確Check_B+1
                    }
                    if ((Answer/1000)%10 == (user_num/1000)%10){
                        Check_A += 1;//數字正確位置正確Check_A+1
                    }
                    System.out.println(Check_A + "A" + Check_B + "B");
                }
            }
            /* 猜中數字，Check_A==4，遊戲結束，跳出迴圈 */
            System.out.println("恭喜答對!! 遊戲結束✧٩(ˊωˋ*)و✧");

            /* 主迴圈控制:check是否重複使用並確保check為1或0 */
            System.out.print("\n\n是否再次使用(1是/0否):");
            while(true) {
                try {
                    check = user_input.nextInt();
                }
                catch (Exception e){
                    System.out.println("...連整數都不是你故意的吧");
                    user_input.next();
                }
                if (check == 1){
                    System.out.println("謝謝支持!\n");
                    break;
                }
                else if (check == 0){
                    System.out.println("\nヽ(○´∀`)ﾉ♪感謝您的使用!");
                    break;
                }
                else if (check != 1 && check != 0){
                    System.out.print("( ･ิ,_ゝ･ิ)...(1是/0否) 再輸入一次吧:");
                }
            }
        }
    }
}

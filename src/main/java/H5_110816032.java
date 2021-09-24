import java.util.*;
//由鍵盤輸入資料
import java.lang.*;
//等等要宣告 可以把字串咻咻咻變成數字的謎之物件 的 套件
public class H5_110816032 {
    //姓名:謝妤婕
    //學號:110816032
    /*操作說明:
        1. 依輸出說明輸入一串合法的中序運算式
        2. 顯示結果後可決定是否繼續使用
        3. 感謝您的使用
    */
    /*自評分數:
        可以正常執行100吉霸昏啦
        嗚嗚嗚還有重複使用跟檢查括號的功能拜託加分｡ﾟヽ(ﾟ´Д`)ﾉﾟ｡。
     */

    /*定義運算子優先權*/
    public static int priority(char op){
        switch (op){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    public static void main(String arg[]){

        /* 宣告 */
        Scanner user_input = new Scanner(System.in);
        //宣告Scanner類別物件，命名為user_input
        int count_brackets = 0, check = 1;
        //宣告檢查括號是否合法的變數並令初始值為0，控制使用者是否重複使用之變數為check，且初始值設1
        String user_string = "", formula = "", num = "",Num = ""; char K;
        //宣告使用者輸入為字元字串user_str，而計算用的字串為formula，num/Num作為讀取二位數以上之整數用,K為當前讀取到的字元
        Stack<String> stack_num = new Stack();
        Stack<Character> stack_op = new Stack();
        //宣告儲存結果與運算元的Stack

        /* 主迴圈:與使用者互動功能開始 */
        System.out.println("Homework 5  運算式轉換(中序轉前序，支援四則運算及括號) ");
        while (check == 1) {

            /* 狀態初始化 */
            count_brackets = 0;
            user_string = ""; formula = ""; num = ""; Num = "";

            /* 使用者輸入運算式 */
            System.out.print("請輸入一組「合法的」中序運算式 : ");
            user_string = user_input.nextLine();

            /*清除所有空白*/
            user_string = user_string.replaceAll("\\s+", "");

            /* 檢查輸入括號是否合法 */
            for (int i = 0; i < user_string.length(); i++) {
                if (user_string.charAt(i) == '(') {
                    count_brackets += 1;
                }
                if (user_string.charAt(i) == ')') {
                    count_brackets -= 1;
                }
            }

            /* 括號合法，進行轉換 */
            if (count_brackets == 0) {

                //前後加上():後)
                user_string += ')';
                //反轉字串(由後而前讀取)
                for(int j = user_string.length()-1; j >= 0; j--){
                    formula += user_string.charAt(j);
                }
                //前後加上():前(
                formula += '(';
                //debug  System.out.println(formula);


                //開肝中序轉前序演算法
                for(int i = 0; i < formula.length(); i++){

                    //簡化程式碼，令K為當前讀取到的字元
                    K = formula.charAt(i);

                    //運算元處理:嗚嗚嗚我想不到其他做法了｡ﾟヽ(ﾟ´Д`)ﾉﾟ｡。
                    //如果是數字就直接檢查下一個字元，直到完整數值都被讀到以後反轉push進stack_num
                    if(K == '0' || K == '1' ||K == '2'||K == '3'||K == '4'||K == '5'||K == '6'||K == '7'||K == '8'||K == '9'){
                        num += K;
                    }
                    else {//讀取到非數字的字元

                        //反轉num值再push進stack_num
                        for(int j = num.length()-1; j >= 0; j--){
                            Num += num.charAt(j);
                        }
                        if(Num!=""){
                            stack_num.push(Num);
                            System.out.println("Push " + Num + " in Stack");
                            num = ""; Num = "";
                        }

                        switch (K){

                            //括號處理
                            case ')'://右括號直接push
                                stack_op.push(')');
                                //debug
                                System.out.println("//Push ) in op_S");
                                break;
                            case '('://遇到左括號pop進stack_num直到遇見右括號
                                while (!stack_op.empty()){
                                    Num = "";
                                    Num += stack_op.pop();
                                    stack_num.push(Num);
                                    System.out.println("Push " + Num + " in Stack");
                                    Num = "";
                                    if (stack_op.peek()==')'){
                                        stack_op.pop();//不輸出括號
                                        break;
                                    }
                                }
                                break;
                            //四則運算運算子處理
                            default:
                                if (priority(K) >= priority(stack_op.peek())) {//運算優先權>stack的top則push
                                    stack_op.push(K);
                                    System.out.println("//Push " + K + " in op_S");
                                } else {//小於就pop直到大於為止再push
                                    while (!stack_op.empty()){
                                        Num = "";
                                        Num += stack_op.pop();
                                        stack_num.push(Num);
                                        System.out.println("Push " + Num + " in Stack");
                                        Num = "";
                                        if (priority(K) >= priority(stack_op.peek())){
                                            stack_op.push(K);
                                            break;
                                        }
                                    }
                                }
                                break;

                        }//switch
                    }//if數字/else符號
                }//轉換結束，輸出stack_num的結果
                while (!stack_num.empty()){ System.out.print(stack_num.pop() + " "); }
            }//合法括號

            /* 括號不合法，重新輸入*/
            else {
                System.out.println("嗚嗚嗚不要搞我｡ﾟヽ(ﾟ´Д`)ﾉﾟ｡。你的括號不合法");
                continue;
            }

            /* 主迴圈控制:check是否重複使用並確保check為1或0 */
            System.out.print("\n\n是否再次使用(1是/0否):");
            while(true) {
                try { check = user_input.nextInt(); }
                catch (Exception e){
                    System.out.println("...連整數都不是你故意的吧");
                    user_input.next(); }
                if (check == 1){
                    System.out.println("謝謝支持!\n");
                    user_input.nextLine();
                    break; }
                else if (check == 0){
                    System.out.println("\n好啦掰掰ヽ(○´∀`)ﾉ♪\n感謝您的使用!");
                    break; }
                else if (check != 1 && check != 0){
                    System.out.print("( ･ิ,_ゝ･ิ)...(1是/0否) 再輸入一次吧:"); }
            }//主迴圈控制
        }//主迴圈
    }//程式結束
}

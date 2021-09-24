import java.util.Scanner;
//由鍵盤輸入資料
public class H2_110816032 {
    //姓名:謝妤婕
    //學號:110816032
    /*操作說明:
        1. 依輸出說明輸入多個整數, 整數間以空白相隔
        2. 顯示結果後可選擇是否繼續執行程式
        3. 感謝您的使用
    */
    /*自評分數:
        按評分標準應該可以100...吧
        排序方式採最小值輸出後，將原數改為最大值+1，並繼續找出新的最小值，直到最小值與原最大值相等
        先偷翻了一下課本的例外處理，終於搞定了...一點點
        可以偵測輸入是否不為整數，但偵測完就結束了，不能重新輸入
        但看在有偵測的份上拜託至少給我一半的分數嗚嗚嗚 90分也很好 ｡ﾟヽ(ﾟ´Д`)ﾉﾟ｡。
        而且有重複使用的功能拜託加個分行行好嗚嗚嗚 ｡ﾟヽ(ﾟ´Д`)ﾉﾟ｡。
     */
    public static void main(String arg[]){

        /* 宣告 */
        Scanner user_input = new Scanner(System.in);
        //宣告Scanner類別物件，命名為user_input
        int Num_array[];
        int Min_number = 0, Max_number = 0, index = 0, check = 1;
        //宣告最小值為Min_number、最大值Max_number、索引值index
        //控制使用者是否重複使用之變數為check，且初始值設1

        /* 與使用者互動功能開始 */
        System.out.println("Homework 2  輸入多個整數,排序後由小到大輸出");
        while (check == 1){

            /* 使用者決定要輸入多少數字並確保輸入是整數且>1 */
            int count = 0;
            System.out.print("請決定你要排序多少數字:");
            while(true) {
                //先檢查是否為整數
                try {
                    count = user_input.nextInt();
                }
                catch (Exception e){
                    System.out.println("就說輸入整數啦 ┴─┴︵╰（‵□′╰ 冰豆喔!");
                    System.out.print("請決定你要排序多少數字:");
                    user_input.next();
                    continue;
                }
                //再檢查輸入的整數是否>1
                if (count == 1){
                    System.out.println("一個數字要怎麼排序啦 ┴─┴︵╰（‵□′╰ 冰豆喔!");
                    System.out.print("請決定你要排序多少數字:");
                }
                else if (count < 1){
                    System.out.println("小於一個數字要怎麼排序啦 ┴─┴︵╰（‵□′╰ 冰豆喔!");
                    System.out.print("請決定你要排序多少數字:");
                }
                else if (count > 1){
                    break;
                }
            }

            /* 確認陣列長度 */
            Num_array = new int[count];

            /* 使用者輸入一串數字並確保皆為整數 */
            System.out.print("請輸入" + count + "個整數，並以空白區隔:");
            try{
                for (int i=0;i<Num_array.length;i++){
                    Num_array[i] = user_input.nextInt();
                }
            }
            catch (Exception e) {
                System.out.println("請勿輸入整數以外之資料!\n我才剛學會例外處理耶超難的說 ┴─┴︵╰（‵□′╰ 冰豆喔!\n");
                System.exit(0);
            }

            /* 印出合法陣列 */
            System.out.print("您輸入的數字 : ");
            for (int i=0;i<count;i++){
                System.out.print(Num_array[i] + " ");
            }

            /* 設最小值為Min_number、最大值Max_number初始值為第一個輸入 */
            Min_number  = Num_array[0];
            Max_number = Num_array[0];

            /* 開始排序 */
            //找出最大值
            for (int i=0;i<count;i++){
                if (Max_number<Num_array[i]){
                    Max_number = Num_array[i];
                }
            }
            //找出最小值並輸出，再改為原最大值+1，直到直到最小值與原最大值相等
            System.out.print("\n數字排序後為 : ");
            for (int j = 0;j<Num_array.length; j++) {
                //找出最小值
                for (int i = 0; i < Num_array.length; i++) {
                    if (Min_number > Num_array[i]) {
                        Min_number = Num_array[i];
                        index = i;
                    }
                }
                //輸出最小值
                System.out.print(Min_number + " ");
                //改為原最大值+1
                Num_array[index] = Max_number + 1;
                //重置最小值與索引值
                Min_number = Num_array[0];
                index = 0;

            }

            /* 主迴圈控制:check是否重複使用並確保check為1或0 */
            System.out.print("\n\n是否再次使用(1是/0否):");
            while(true) {
                try {
                    check = user_input.nextInt();
                }
                catch (Exception e){
                    System.out.println("...連整數都不是你故意的吧，我就當你要繼續用了喔嘿嘿");
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

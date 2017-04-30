package ladder;

import java.util.Arrays;
import java.util.Scanner;

public class LadderTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int row = 10;
        int players = checkNum(3, 9, "플레이어는 몇명인가요(3~9명 사이) : ", scanner);
        System.out.println();

        Ladder ladder = new Ladder(row, players);
        ladder.ladderMake();
        System.out.println("--------행운의 사다리--------");
        ladder.ladderDraw();

        String[] player = new String[players];
        String[] result = new String[players];

        System.out.println("----자리 정하기----");
        for (int i=0 ; i < players ; i++){
            System.out.print(i+1+"번 플레이어 : ");
            player[i] = scanner.nextLine();
        }
        System.out.println();

        System.out.println("----행운 정하기----");
        for (int i=0 ; i < players ; i++){
            System.out.print((char)('A'+i)+"번 결과 : ");
            result[i] = scanner.nextLine();
            result[i] = (result[i].equals(""))? "꽝~~" : result[i];
        }
        System.out.println();

        for (;true;){
            System.out.print("알고 싶은 플레이어 번호(\"나\":엔터, 중지:0) : ");
            String tmp = scanner.nextLine();
            int playNum;
            if (tmp.equals("0")){
                break;
            } else if (tmp.equals("")) {
                playNum = Arrays.asList(player).indexOf("나")+1;
            } else {
                playNum = Integer.parseInt(tmp);
            }
            System.out.println();

            System.out.println("-----행운의 사다리 결과-----");
            int resultNum =ladder.luck(playNum);
            ladder.ladderDraw();
            System.out.println(playNum+":"+player[playNum-1]+"의 행운은 >> "+(char)('A'+resultNum-1)+":"+result[resultNum-1]);
        }
        System.out.println("행운의 사다리를 종료합니다");
    }

    // 유효값 체크
    public static int checkNum(int min, int max, String str, Scanner scanner){
        for(;true;){
            System.out.print(str);
            int num = scanner.nextInt();
            scanner.nextLine();
            if (min <= num && num <= max){
                return num;
            } else {
                System.out.println(min+"~"+max+" 사이값이 아닙니다.\n다시 입력해 주세요");
            }
        }
    }
}

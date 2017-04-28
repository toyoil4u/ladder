package ladder;

import java.util.Scanner;

public class ladder {
    public static void main(String[] args) {
        int[][] ladder = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1}
        };

        ladderDraw(ladder); /* 사다리 그리기 */

        Scanner kb = new Scanner(System.in);
        String[] chair = chair(ladder[0].length, kb); /* 자리결정 */
        System.out.println();

        String[] result = result(ladder[0].length, kb); /* 행운결정 */
        System.out.println();

        System.out.println("------ 행운의 결과 ------");
        for (int i = 0 ; i < ladder[0].length+1 ; i++){
            int x = ladderLogic(i, ladder);             /* 사다리 로직 */
            System.out.println(chair[i] + " >> " + result[x]);
        }
    }

    public static void ladderDraw(int[][] array) {
        System.out.println("------행운의 사다리------");
        System.out.println("1     2     3     4     5");
        for (int i = 0; i < array.length ; i++){
            for (int j = 0; j < array[0].length ; j++){
                String bar;
                bar =  (array[i][j] == 1)? "-----" : "     ";
                System.out.print("|" + bar + ((j==3)? "|\n" : ""));
            }
        }
        System.out.println("A     B     C     D     E\n");
    }

    public static int ladderLogic(int x, int[][] array) { /* 사다리로직 */
        for (int y = 0; y < array.length ; y++){
            if (x > 0 && array[y][x-1] == 1) x--;                  /* left check */
            else if (x < array[0].length && array[y][x] == 1) x++; /* right check */
            System.out.println("("+y+", "+x+")");
        }
        return x;
    }

    public static String[] chair(int x, Scanner kb) {  /* 자리결정 */
        System.out.println("------ 자리 결정 ------");
        String[] chair = new String[x+1];
        for (int i = 0; i < x+1 ; i++){
            System.out.print(i+1+"번 자리 : ");
            chair[i] = kb.nextLine();
            if (chair[i].equals("")) chair[i] = i+1+"";
        }
        return chair;
    }

    public static String[] result(int x, Scanner kb) {  /* 행운결정 */
        System.out.println("------ 행운 결정 ------");
        String[] result = new String[x+1];
        for (int i = 0; i < x+1 ; i++){
            System.out.print((char)('A'+i)+"번 결과 : ");
            result[i] = kb.nextLine();
            if (result[i].equals("")) result[i] = "꽝~";
        }
        return result;
    }
}

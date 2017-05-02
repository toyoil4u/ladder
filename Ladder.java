package ladder;

public class Ladder {

    private int row;
    private int leg;
    private int[][] arr;

    public Ladder() {
    }

    public Ladder(int row, int leg) {
        this.row = row;
        this.leg = leg;
        this.arr = new int[row+2][leg+1];
    }

    public int getArr(int a, int b) {
        return arr[a][b];
    }

    public void setArr(int a, int b, int val) {
        this.arr[a][b] = val;
    }

    public int getrow() {
        return row;
    }

    public void setrow(int row) {
        this.row = row;
    }

    public int getLeg() {
        return leg;
    }

    public void setLeg(int leg) {
        this.leg = leg;
    }

    // 사다리 랜덤생성
    public void ladderMake(){
        for (int i=1 ; i<arr[0].length-1 ; i++){
            for (int j=0 ; j<3 ; j++){
                int bar = 3*j + (int)(Math.random()*3) + 1;
                if (arr[bar][i] > 0){
                    j--;
                    continue;
                } else {
                    arr[bar][i] = 1;
                    arr[bar][i+1] = 2 ;
                }
            }
        }
    }

    // 사다리 그리기
    public void ladderDraw(){
        String str = "";
        for (int k=1 ; k<arr[0].length ; k++){
            str = str + k + ((k<arr[0].length)? "     ":"");
        }
        System.out.println(str);
        for (int i=0 ; i<arr.length ; i++ ){
            for (int j=1 ; j<arr[0].length ; j++){
                if(arr[i][j] == 1) {
                    System.out.print("|-----");
                } else if(arr[i][j] == 10) {
                    System.out.print("║     ");
                    arr[i][j] = 0;
                } else if(arr[i][j] == 11) {
                    System.out.print("║═════");
                    arr[i][j] = 1;
                } else if(arr[i][j] == 12) {
                    System.out.print("║     ");
                    arr[i][j] = 2;
                } else {
                    System.out.print("|     ");
                }
            }
            System.out.println();
        }
        str = "";
        for (int k=0 ; k<arr[0].length-1 ; k++){
            str = str + (char)('A' + k ) + ((k<arr[0].length-1)? "     ":"");
        }
        System.out.println(str+"\n");
    }

    // 경로 계산
    public int luck(int index) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][index] == 0) arr[i][index] = 10;
            if (arr[i][index] == 1 || arr[i][index] == 2) {
                if (arr[i][index - 1] == 1 && arr[i][index] == 2) {
                    arr[i][index-1] = 11;
                    arr[i][index] = 12;
                    index--;
                } else {
                    arr[i][index] = 11;
                    arr[i][index+1] = 12;
                    index++;
                }
            }
        }
        return index;
    }
}

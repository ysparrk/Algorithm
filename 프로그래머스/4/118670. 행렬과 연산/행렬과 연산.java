import java.util.*;

class Solution {
    
    int R, C;
    ArrayDeque<Integer> leftCol, rightCol;
    ArrayDeque<ArrayDeque<Integer>> rows;  // 중간 row들
    
    /*
    1. 초기 설정
    - rc를 leftCol, rightCol, rows로 분리
    */
    private void init(int[][] rc) {
        R = rc.length;
        C = rc[0].length;
        
        leftCol = new ArrayDeque<>();
        rightCol = new ArrayDeque<>();
        rows = new ArrayDeque<>();
        
        //분리
        for (int i = 0; i < R; i++) {
            leftCol.add(rc[i][0]);
            rightCol.add(rc[i][C - 1]);
            
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            for (int j = 1; j < C - 1; j++) {
                tmp.add(rc[i][j]);
            }
            rows.add(tmp);
        }
        
    }
    
    //2. shiftRow
    private void shiftRow() {
        /*
        마지막 -> 맨 위로
        */
        leftCol.addFirst(leftCol.pollLast());
        rightCol.addFirst(rightCol.pollLast());
        rows.addFirst(rows.pollLast());
    }
    
    //3. rotate
    private void rotate() {
        /*
        1) rows[0][0] -> leftCol의 맨앞 데이터 넣기
        2) rightCol의 맨 앞에 -> rows[0][-1] 데이터 넣기
        3) rows[-1][-1] -> rightCol의 맨뒤 데이터 넣기
        4) leftCol의 맨 뒤에 -> rows[-1][0] 데이터 넣기
        */
        rows.peekFirst().addFirst(leftCol.pollFirst());
        rightCol.addFirst(rows.peekFirst().pollLast());
        rows.peekLast().addLast(rightCol.pollLast());
        leftCol.addLast(rows.peekLast().pollFirst());
    }
    
    //4. 합치기
    private int[][] getRlt() {
        int[][] rlt = new int[R][C];
        
        //1) col
        for (int i = 0; i < R; i++) {
            rlt[i][0] = leftCol.pollFirst();
            rlt[i][C - 1] = rightCol.pollFirst();
        }
        
        //2) rows
        int i = 0;
        for (ArrayDeque<Integer> row : rows) {
            for (int j = 1; j < C - 1; j++) {
                rlt[i][j] = row.pollFirst();
            }
            i++;
        }
        
        return rlt;
    }
    
    //5. result
    public int[][] solution(int[][] rc, String[] operations) {        
    
        //1) 초기설정
        init(rc);
        
        //2) 함수 시행
        for (String op : operations) {
            switch (op) {
                case "ShiftRow":
                    shiftRow();
                    break;
                case "Rotate":
                    rotate();
                    break;
            }
        }
        
        //3) 결과
        return getRlt();
            
    }

}
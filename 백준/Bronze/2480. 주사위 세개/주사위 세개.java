import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt = br.readLine().split(" ");
        int dice1 = Integer.parseInt(ipt[0]);
        int dice2 = Integer.parseInt(ipt[1]);
        int dice3 = Integer.parseInt(ipt[2]);
        boolean[] dice = {false, false, false, false, false, false};
        int seconddice = 0;

        if(!dice[dice1 - 1]) dice[dice1 - 1] = true;
        else seconddice = dice1;

        if(!dice[dice2 - 1]) dice[dice2 - 1] = true;
        else seconddice = dice2;

        if(!dice[dice3 - 1]) dice[dice3 - 1] = true;
        else seconddice = dice3;

        int distinct = 0;
        for(boolean d : dice) {
            if(d) distinct++;
        }
        if(distinct == 1) {
            bw.write(Integer.toString(10000+dice1 * 1000));
        } else if (distinct == 2) {
            bw.write(Integer.toString(1000 + seconddice * 100));
        } else {
            bw.write(Integer.toString(100 * Math.max(dice1, Math.max(dice2, dice3))));
        }


        bw.flush();
        bw.close();
    }
}
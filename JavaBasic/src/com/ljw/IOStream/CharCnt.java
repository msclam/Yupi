package com.ljw.IOStream;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lanjuwen
 * @create 2021-12-02  0:53
 */
public class CharCnt {
    @Test
    public void test() {
        FileReader fr = null;
        BufferedWriter bw = null;
        try {
            Map<Character, Integer> mp = new HashMap<>();
            fr = new FileReader("abc.txt");
            int c = 0;
            while ((c = fr.read()) != -1) {
                char ch = (char) c;
                if (mp.get(ch) == null) {
                    mp.put(ch, 1);
                } else {
                    mp.put(ch, mp.get(ch) + 1);
                }
            }

            bw = new BufferedWriter(new FileWriter("bca.txt"));

            Set<Map.Entry<Character, Integer>> entrySet = mp.entrySet();

            for (Map.Entry<Character, Integer> entry : entrySet) {
                switch (entry.getKey()) {
                    case ' ':
                        bw.write("空格=" + entry.getValue());
                        break;
                    default:
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

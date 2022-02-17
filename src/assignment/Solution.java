package assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

class Result {
    public static int uniqueWolfs(List<Integer> arr) {
     
        //array boyutu 5 ≤ n ≤ 2 x 105
        int arrCount = arr.size();
        if (arrCount < 5 || arrCount > 200000) {
            throw new RuntimeException("please enter a number between 5 and 200000");
        }

        Map<Integer, Integer> resMap = new HashMap<>();

        for (int i = 0; i < arrCount; i++) {
            int key = arr.get(i);

            //Her türün 1,2,3,4 veya 5 olduğu garanti edilir.
            if (key > 5 || key < 1) {
                throw new RuntimeException("please enter numbers between 1 and 5");
            }

            if (resMap.containsKey(key)) {
                int freq = resMap.get(key);
                freq++;
                resMap.put(key, freq);
            } else {
                resMap.put(key, 1);
            }
        }

        //en cok tekrarlanan en dusuk degeri bul
        int max_count = 0, res = -1;
        for (Map.Entry<Integer, Integer> val : resMap.entrySet()) {
            if (max_count < val.getValue()) {
                res = val.getKey();
                max_count = val.getValue();
            }
        }

        return res;
    }
}

public class Solution {
	static String OUTPUT_PATH = "./testOutput.txt";

	public static void main(String[] args) throws IOException {
		 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(OUTPUT_PATH));
		 int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
		 List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split("")).map(Integer::parseInt).collect(toList());
		 int result = Result.uniqueWolfs(arr);
		 bufferedWriter.write(String.valueOf(result));
		 bufferedWriter.newLine();
		 bufferedReader.close();
		 bufferedWriter.close();
		 
		
		
	}

}

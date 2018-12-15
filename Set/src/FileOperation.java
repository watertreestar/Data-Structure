import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * @ClassName FileOperation
 * @Author ranger
 * @Date 2018/12/14
 **/
public class FileOperation {

    /**
     * 读取文件，获取文件总词数
     * @param fileName
     * @param words
     */
    public static void readFile(String fileName, List words){
        if (fileName == null || fileName == "" || words == null) {
            throw new IllegalArgumentException("fileName is null or list is null");
        }
        // 读取文件
        Scanner scanner = null;
        try {
            fileName = FileOperation.class.getResource(fileName).getPath();
            File file = new File(fileName);
            if(file.exists()){
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis),"UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            }
        }catch (Exception e){
            System.out.printf("Failed to open file");
        }finally {

        }
        if(scanner.hasNext()){
            String contents  = scanner.useDelimiter("\\A").next();
            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); )
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else
                    i++;
        }

    }

    // 寻找字符串s中，从start的位置开始的第一个字母字符的位置
    private static int firstCharacterIndex(String s, int start){

        for( int i = start ; i < s.length() ; i ++ )
            if( Character.isLetter(s.charAt(i)) )
                return i;
        return s.length();
    }

}

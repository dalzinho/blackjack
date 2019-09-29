package cards.output;

import java.io.InputStream;
import java.util.Scanner;

public class SysInReader {

    private Scanner scanner;

    public SysInReader(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public char readCharFromCommandLine(){
        String data = scanner.nextLine();
        return data.charAt(0);
    }

}

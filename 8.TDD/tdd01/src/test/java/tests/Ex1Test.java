package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;

public class Ex1Test {

    @TempDir
    private File tmpFIle;

    @Test
    void test1(){
        System.out.println(tmpFIle.getAbsolutePath()); // 절대 경로
    }

    @Test
    @Timeout(3)
    void test2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
    }
}

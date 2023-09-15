package src.junit.SQLTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Auther: Green Park(pch))
 * @Date: 2023/9/12-09-12-14:49
 * @Description：src.junit
 */
public class AnnotateTest {

    @Before
    public void before() {
        System.out.println("before execute");
    }

    @Test
    public void test() {
        System.out.println("test execute");
    }

    @After
    public void after() {
        System.out.println("after execute");
    }
}

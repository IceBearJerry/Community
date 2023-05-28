package com.nowcoder.community;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class AlphaTests {
    @Test
    public void testLock(){
        new Thread(()->{
           for (int i = 0;  i< 30;i++){
               System.out.println(i);
            }
        }).start();
    }


}

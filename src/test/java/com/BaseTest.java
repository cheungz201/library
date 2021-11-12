package com;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Program: library
 * @Author: Zhang Zhe
 * @Create: 2021-11-12 17:34
 * @Version: 1.0.0
 * @Description:
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf/applicationContext.xml"})
public class BaseTest {

}

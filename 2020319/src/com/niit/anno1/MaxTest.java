package com.niit.anno1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ExtendWith(SpringExtension.class)//ָ����Ԫ���Ե����л���
@ContextConfiguration(locations= {"maxbeans.xml"})//ָ�������ļ�·��
class MaxTest {
    @Autowired//�Զ����������ļ��е�Max��ʵ��max
    private Max max;
	@Test
	void getMax() {
		int result=max.getMax();
		System.out.println(result);
		assertEquals(10, result);
	}

}

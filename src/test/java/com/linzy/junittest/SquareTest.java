package com.linzy.junittest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/*
 * 对于参数测试需要重新写一个类， 而不能与其他测试共用同一个类，此例中我们定义了一个SquareTest类。
 * 然后，你要为这个类指定一个 Runner，而不能使用默认的Runner了，因为特殊的功能要用特殊的Runner嘛。
 * @RunWith(Parameterized.class)
 *
 * */
@RunWith(Parameterized.class)
public class SquareTest {
	private static Calculator calculator = new Calculator();
	private int param;
	private int result;

	/*
     * 定义测试数据的集合，也就是上述的data()方法，
     * 该方法可以任意命名，但是必须使用@Parameters标注进行修饰。
     * 这个方法的框架就不予解释了，大家只需要注意其中的数据，是一个二维数组，
     * 数据两两一组，每组中的这两个数据，一个是参数，一个是你预期的结果
     * */
	@Parameters
	public static Collection date() {
		return Arrays.asList(new Object[][] { { 2, 4 }, { 0, 0 }, { -3, 9 }, });
	}

	// 构造函数，对变量进行初始化

	// 定义一个待测试的类，并且定义两个变量，一个用于存放参数，一个用于存放期待的结果。
	public SquareTest(int param, int result) {
		this.param = param;
		this.result = result;
	}

	@Test
	public void square() {
		calculator.square(param);
		assertEquals(result, calculator.getResult());
		System.out.println("param:" + this.param + "	result:" + this.result);
	}
}

/**
 * @author ChanceZhou
 * @code this file2022-01-25-17:51
 */
public class testPo {
    //考查多态的笔试题目：

    public static void main(String[] args) {
        Base base = new Sub();
        base.add(1, 2, 3);

		Sub s = (Sub)base;
		s.add(1,2,3);
    }
}

class Base {
    public void add(int a, int... arr) {
        System.out.println("base");
    }
}

class Sub extends Base {

    public void add(int a, int[] arr) {
        System.out.println("sub_1");
    }

	public void add(int a, int b, int c) {
		System.out.println("sub_2");
	}

}

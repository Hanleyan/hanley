package com.api.hanley.testClass;

/**
 * @author hanley
 * @date 2019/6/19 13:16
 * 风萧萧兮易水寒
 */
public class fanxing {

    /**
     * 泛型方法
     你可以写一个泛型方法，该方法在调用时可以接收不同类型的参数。根据传递给泛型方法的参数类型，编译器适当地处理每一个方法调用。

     下面是定义泛型方法的规则：
     所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前（在下面例子中的<E>）。
     每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
     类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。
     泛型方法方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像int,double,char的等）。
     * @param inputArray inputArray
     * @param <E> E
     */
    public static <E> void printArray(E[] inputArray){
        for (E element : inputArray) {
            System.out.print("\t"+element);
        }
        System.out.println();
    }

    /**
     * 有界的类型参数:

     可能有时候，你会想限制那些被允许传递到一个类型参数的类型种类范围。例如，一个操作数字的方法可能只希望接受Number或者Number子类的实例。这就是有界类型参数的目的。
     要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。

     实例
     下面的例子演示了"extends"如何使用在一般意义上的意思"extends"（类）或者"implements"（接口）。该例子中的泛型方法返回三个可比较对象的最大值。
     */
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        T max = x; // 假设x是初始最大值
        if ( y.compareTo( max ) > 0 ){
            max = y; //y 更大
        }
        if ( z.compareTo( max ) > 0 ){
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }

    public static void main(String[] args) {
        Integer[] num = {1,3,6,9,7,4,5};
        String[] str = {"你","好","啊"};
        Boolean[] bool = {false,false,true,true,false};
        printArray(num);
        printArray(str);
        printArray(bool);


        System.out.println("Interger 最大值："+maximum(1,4,6));
        System.out.println("String 最大值："+maximum("apple","pear","orange"));
        System.out.println("Double 最大值："+maximum(1.3,4.6,6.6));
    }
}

package com.songjn.stacktrace;

/**
 * Demo描述:
 * StackTrace简述以及StackTraceElement使用实例
 * <p>
 * <p>
 * StackTrace简述
 * 1 StackTrace用栈的形式保存了方法的调用信息.
 * 2 怎么获取这些调用信息呢?
 * 可用Thread.currentThread().getStackTrace()方法
 * 得到当前线程的StackTrace信息.
 * 该方法返回的是一个StackTraceElement数组.
 * 3 该StackTraceElement数组就是StackTrace中的内容.
 * 4 遍历该StackTraceElement数组.就可以看到方法间的调用流程.
 * 比如线程中methodA调用了methodB那么methodA先入栈methodB再入栈.
 * 5 在StackTraceElement数组下标为2的元素中保存了当前方法的所属文件名,当前方法所属
 * 的类名,以及该方法的名字.除此以外还可以获取方法调用的行数.
 * 6 在StackTraceElement数组下标为3的元素中保存了当前方法的调用者的信息和它调用
 * 时的代码行数.
 * <p>
 * <p>
 * 示例说明:
 * 1 methodA()调用methodB()
 * methodB()调用methodC()
 * 2 在methodC()中获取StackTrace中的内容并遍历StackTraceElement数组
 * 这样就能观察到从开始到现在的方法间调用流程.
 * 在该流程中可以观察到:
 * StackTraceElement数组下标为2的元素中保存了当前方法的所属文件名,
 * 当前方法所属的类名,以及该方法的名字.
 * 除此以外还可以利用stackTraceElement.getLineNumber()获取调用getStackTrace()方法的行数.
 * <p>
 * 在StackTraceElement数组下标为3的元素中保存了当前方法的调用者的信息.
 * 并且可以还可以利用stackTraceElement.getLineNumber()获取到调用时的代码行数.
 * 注意此时获取到的不再是调用getStackTrace()方法的行数.
 * 3 methodC()调用methodD()
 * 在methodD()中获取StackTraceElement数组下标为2和3的元素信息.
 * 这两个元素包含了对于代码调试的重要信息.所以在此单独获取查看.
 */
public class TestStackTrace {

    public static String showAllElementsInfo() {
        StringBuilder print = new StringBuilder();
        int count = 0;
        //从当前线程中获取所有的StackTraceElement
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            count++;
            print.append(String.format("ClassName:%s " +
                            "\nMethodName:%s " +
                            "\nMethodLine:%d " +
                            "\n当前是第%d个 " +
                            "\n---------------------------- " +
                            "\n",
                    stackTraceElement.getClassName(),
                    stackTraceElement.getMethodName(),
                    stackTraceElement.getLineNumber(),
                    count));
        }
        return print.toString();
    }

    public static void main(String[] args) {
        methodA();
    }
    private static void methodA() {
        System.out.println("------进入methodA----------");
        methodB();
    }

    private static void methodB() {
        System.out.println("------进入methodB----------");
        methodC();
    }

    /**
     * 遍历StackTrace中的内容并遍历StackTraceElement数组
     * 请注意观察此处的输出信息.
     */

    private static void methodC() {
        System.out.println("------进入methodC----------");
        System.out.println(showAllElementsInfo());
        StackTraceElement stackTraceElements[] = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElements.length; i++) {
            String threadName = Thread.currentThread().getName();
            long threadID = Thread.currentThread().getId();
            StackTraceElement stackTraceElement = stackTraceElements[i];
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            String fileName = stackTraceElement.getFileName();
            int lineNumber = stackTraceElement.getLineNumber();
            System.out.println("StackTraceElement数组下标 i=" + i + ",threadID=" + threadID + ",threadName=" + threadName + ",fileName="
                    + fileName + ",className=" + className + ",methodName=" + methodName + ",lineNumber=" + lineNumber);
            System.out.println("-------------");
        }
//		methodD();
    }

    /**
     * 在methodC中遍历StackTraceElement数组.
     * 但是发现下标为2和3的元素包含的信息是最有用的.
     * 于是在这里单独获取.
     */
    private void methodD() {
        System.out.println("------进入methodD----------");
        StackTraceElement stackTraceElement = null;
        String threadName = Thread.currentThread().getName();
        long threadID = Thread.currentThread().getId();
        stackTraceElement = Thread.currentThread().getStackTrace()[2];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        int lineNumber = stackTraceElement.getLineNumber();
        System.out.println("该方法的信息:threadID=" + threadID + ",threadName=" + threadName + ",fileName=" + fileName +
                ",className=" + className + ",methodName=" + methodName + ",lineNumber=" + lineNumber);
        stackTraceElement = Thread.currentThread().getStackTrace()[3];
        className = stackTraceElement.getClassName();
        methodName = stackTraceElement.getMethodName();
        fileName = stackTraceElement.getFileName();
        lineNumber = stackTraceElement.getLineNumber();
        System.out.println("该方法的调用者的信息:threadID=" + threadID + ",threadName=" + threadName + ",fileName=" + fileName +
                ",className=" + className + ",methodName=" + methodName + ",lineNumber=" + lineNumber);
    }

}


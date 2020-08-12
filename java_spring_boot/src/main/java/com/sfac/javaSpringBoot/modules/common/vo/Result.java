package com.sfac.javaSpringBoot.modules.common.vo;

/**
 * Created with IntelliJ IDEA.
 * User: CH
 * Date: 2020/8/12
 * Time: 13:45
 * Description: No Description
 */
public class Result<T> {

    //200成功
    private final static int SUCCESS_CODE = 200;
    //500失败
    private final static int FAILD_CODE =500;

    private int status;
    private String message;
    private T object;

    public Result() {
    }

    public Result(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Result(int status, String message, T object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    /**
     * ResultStatus
     */
    public enum ResultStatus{
        //代表了各个枚举值,可以理解成带属性的常量值
        SUCCESS(200),FAILD(500);
        public int status;

        ResultStatus(int status){
            this.status=status;
        }
    }

    private final static int BIG_IMAGE_WIDTH = 1000;
    private final static int BIG_IMAGE_HEIGHT = 1000;
    private final static int MIDDLE_IMAGE_WIDTH = 500;
    private final static int MIDDLE_IMAGE_HEIGHT = 500 ;
    private final static int SMALL_IMAGE_WIDTH = 100 ;
    private final static int SMALL_IMAGE_HEIGHT = 100 ;

    //相对于上面直接用常量，使用枚举类型更加方便
    public enum IMAGE{
        BIG_IMAGE(1000,1000,100),
        MIDDEL_IMAGE(500,500,50),
        SMALL_IMAGE(100,100,20),
        ;
        public int width;
        public int height;
        public int size;

        IMAGE(int width, int height, int size) {
            this.width = width;
            this.height = height;
            this.size = size;
        }
    }
}

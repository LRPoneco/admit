package com.example.admit.poneco.com.number;

public interface RandomNumbrerInterface {
    /**
     *
     * @param length 随机数的长度
     * @return 返回字符串行
     */
    public String getRandomNumber(int length);
    public String getRandomNumber();

    /**
     * 产生一个随机字母串
     * @param length 表示随机字符串的长度
     * @return
     */
    public String getRandomA(int length);
    public String getRandomA();


    /**
     * 产生一个随机混合字符串
     * @param length 表示字符串的长度
     * @return
     */
    public String getRandomNumberA(int length);
    public String getRandomNumberA();

}

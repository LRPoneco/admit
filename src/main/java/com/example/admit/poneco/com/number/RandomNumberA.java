package com.example.admit.poneco.com.number;

import java.util.Random;

public class RandomNumberA implements RandomNumbrerInterface {
    Random random = new Random();
    @Override
    public String getRandomNumber(int length) {
        String alex="";
        for(int i=0;i<length;i++){
            alex = alex + random.nextInt(10);
        }
        return alex;
    }

    @Override
    public String getRandomNumber(){
        String alex="";
        int j = random.nextInt(0+50);
        for(int i=0;i<j;i++){
            alex = alex + random.nextInt(10);
        }
        return alex;
    }

    @Override
    public String getRandomA(int length) {
        char[] a = {'a','b','c','d','e','f','g','h','i','j','k'
                ,'l','m','n','o','p','q','r','s','t','u','v'
                ,'w','x','y','z','A','B','C','D','E','F','G','H','I','J','K'
        ,'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

        String alex = new String();
        for(int i=0;i<length;i++){
            alex = alex + a[random.nextInt(0+52)];
        }
        return alex;
    }

    @Override
    public String getRandomA() {
        char[] a = {'a','b','c','d','e','f','g','h','i','j','k'
                ,'l','m','n','o','p','q','r','s','t','u','v'
                ,'w','x','y','z','A','B','C','D','E','F','G','H','I','J','K'
                ,'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String alex = new String();
        int j = random.nextInt(0+50);
        for(int i=0;i<j;i++){
            alex = alex + a[random.nextInt(0+52)];
        }
        return alex;
    }

    @Override
    public String getRandomNumberA(int length) {
        char[] a = {'a','b','c','d','e','f','g','h','i','j','k'
                ,'l','m','n','o','p','q','r','s','t','u','v'
                ,'w','x','y','z','A','B','C','D','E','F','G','H','I','J','K'
                ,'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
                ,'1','2','3','4','5','6','7','8','9','0'
        };
        String alex = new String();
        for(int i=0;i<length;i++){
            alex = alex + a[random.nextInt(0+62)];
        }
        return alex;
    }

    @Override
    public String getRandomNumberA() {
        char[] a = {'a','b','c','d','e','f','g','h','i','j','k'
                ,'l','m','n','o','p','q','r','s','t','u','v'
                ,'w','x','y','z','A','B','C','D','E','F','G','H','I','J','K'
                ,'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'
                ,'1','2','3','4','5','6','7','8','9','0'
        };
        String alex = new String();
        int j = random.nextInt(0+50);
        for(int i=0;i<j;i++){
            alex = alex + a[random.nextInt(0+62)];
        }
        return alex;
    }

}

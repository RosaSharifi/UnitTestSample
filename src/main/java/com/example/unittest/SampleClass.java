package com.example.unittest;

import java.util.List;

public class SampleClass {

    //Start 2
    public int add(int a, int b) {
        return a + b;
    }




    public Object checkNull(Object obj) {
        if (obj != null) {
            return obj;
        }
        return null;
    }





    private final String academy = "academy";
    private final String academy2 = academy;

    public String getAcademy() {
        return academy;
    }

    public String getAcademy2() {
        return academy2;
    }

    private final Person person = new Person("rosa", 28);
    private final Person person2 = person;

    public Person getPerson() {
        return person;
    }

    public Person getPerson2() {
        return person2;
    }




    public Boolean isBigger(int a, int b) {
        return a > b;
    }



    private final String[] alphabetArray = {"A", "B", "C"};

    public String[] getAlphabetArray() {
        return alphabetArray;
    }




    private final List<String> strings = List.of("str1,str2");

    public List<String> getStrings() {
        return strings;
    }




    public String throwException(int a) throws Exception{
        if (a < 0){
            throw new  Exception("Value must be greater that zero");
        }
        return "value is greater that zero.";
    }


    public void checkTimeOut()throws InterruptedException{
        System.out.println("Im going to sleep");
        Thread.sleep(2000);
        System.out.println("sleeping over");
    }
    //end 2
}
package com.example.mianshi01.base02;

/**
 * 醒脑小练习
 */
public class TestTransferValue {

    public void changeValue1(int age) {
        age = 30;
    }

    public void changeValue2(Person person) {
        person.setPersonName("xxx");
    }

    public void changeValue3(String str) {
        str = "xxx";
    }

    public static void main(String[] args) {
        TestTransferValue test = new TestTransferValue();

        int age = 20;
        test.changeValue1(age);
        System.out.println("age = " + age); // 结果：age = 20

        Person person = new Person("abc");
        test.changeValue2(person);
        System.out.println("personName = " + person.getPersonName());
        // 结果：personName = xxx

        String str = "abc";
        test.changeValue3(str);
        System.out.println("str = " + str); // 结果：str = abc
    }
}

class Person {
    private Integer id;
    private String personName;

    public Person(String personName) {
        this.personName = personName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

}

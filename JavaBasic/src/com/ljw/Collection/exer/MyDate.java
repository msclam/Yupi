package com.ljw.Collection.exer;

/**
 * @author lanjuwen
 * @create 2021-11-20  17:27
 */
public class MyDate implements Comparable {
    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof MyDate) {
            MyDate m = (MyDate) o;
            if (this.getYear() - m.getYear() != 0) {
                return this.getYear() - m.getYear();
            } else if (this.getMonth() - m.getMonth() != 0) {
                return this.getMonth() - m.getMonth();
            } else {
                return this.getDay() - m.getDay();
            }
        } else {
            throw new RuntimeException();
        }
    }

}

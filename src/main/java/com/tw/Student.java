package com.tw;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private String name;
    private String id;
    private Score score;

    public Student() {
    }

    public Student(String name, String id, Score score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void disPlay() {
        System.out.print(name + "|" + score.getMathScore() + "|" + score.getChineseScore()
                        + "|" + score.getEnglishScore() + "|" + score.getProgramScore()
                        + "|" + score.getAverageScore() + "|" + score.getTotalScore() + " \n");
    }

    boolean checkFormat(String str) {
        String pattern = "[\\u4e00-\\u9fa5]+, [0-9]([0-9]*), 数学: [1-9]([0-9]{0,1})(0{0,1}), 语文: [1-9]([0-9]{0,1})(0{0,1}), 英语: [1-9]([0-9]{0,1})(0{0,1}), 编程: [1-9]([0-9]{0,1})(0{0,1})";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        return m.matches();
    }
}

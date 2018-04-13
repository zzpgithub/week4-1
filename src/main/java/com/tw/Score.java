package com.tw;

public class Score {
    private int mathScore;
    private int chineseScore;
    private int englishScore;
    private int programScore;
    private double averageScore;
    private int totalScore;

    public Score(int mathScore, int chineseScore, int englishScore, int programScore) {
        this.mathScore = mathScore;
        this.chineseScore = chineseScore;
        this.englishScore = englishScore;
        this.programScore = programScore;
        this.totalScore = this.mathScore + this.chineseScore + this.englishScore + this.programScore;
        this.averageScore = (double)this.totalScore/4;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getChineseScore() {
        return chineseScore;
    }

    public void setChineseScore(int chineseScore) {
        this.chineseScore = chineseScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public int getProgramScore() {
        return programScore;
    }

    public void setProgramScore(int programScore) {
        this.programScore = programScore;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public int getTotalScore() {
        return totalScore;
    }
}

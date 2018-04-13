package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;

public class StudentTest {
    private Score score;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup(){
        score = new Score(75, 95, 80, 80);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_student_have_id_name_and_score() throws Exception{
        Student student = new Student("张三","00",score);
        assertThat(student.getName()).isEqualTo("张三");
        assertThat(student.getId()).isEqualTo("00");
        assertThat(student.getScore()).isEqualTo(score);
    }

    @Test
    public void should_student_display_message() throws Exception{
        Student student = new Student("张三","00",score);
        student.disPlay();
        assertThat(systemOut()).isEqualTo("张三|75|95|80|80|82.5|330 \n");
    }

    @Test
    //格式：   姓名, 学号, 学科: 成绩, ...
    public void testCheck() {
        Student student = new Student();
        String studentMessage1 = "张三, 01, 数学: 75, 语文: 95, 英语: 80, 编程: 80";
        assertThat(student.checkFormat(studentMessage1)).isEqualTo(true);

        String studentMessage2 = "张三, 01, 语文: 75, 数学: 95, 英语: 80, 编程: 80";
        assertThat(student.checkFormat(studentMessage2)).isEqualTo(false);

        String studentMessage3 = "张三, 01, 数学:, 语文: 95, 英语: 80, 编程:";
        assertThat(student.checkFormat(studentMessage3)).isEqualTo(false);
    }

    @Test
    public void testCheckIdFormat() {
        Student student = new Student();
        String studentId = "123, 344, id";
        assertThat(student.checkIdFormat(studentId)).isEqualTo(false);

        String studentId1 = "01, 02";
        assertThat(student.checkIdFormat(studentId1)).isEqualTo(true);
    }

    private String systemOut() {
        return outContent.toString();
    }
}

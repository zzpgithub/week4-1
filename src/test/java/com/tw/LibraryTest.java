package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LibraryTest {
    private Library library;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        library = new Library();
        library.setStudentMap(new Student("张三","01", new Score(75, 95, 80, 80)));
        library.setStudentMap(new Student("李四","02", new Score(85, 80, 70, 90)));
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testDisplayMenu() {
        library.displayMenu();
        assertEquals(systemOut(), "1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：\n");
    }

    @Test
    public void should_input_correct_format_of_student_message() {
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn("张三, 01, 数学: 75, 语文: 95, 英语: 80, 编程: 80");
//        System.out.println(mockedList.get(0).toString());
        library.functionOfMenuOne(mockedList.get(0).toString());
        assertEquals(systemOut(), "学生张三成绩被添加\n");
    }

    @Test
    public void should_input_incorrect_format_of_student_message() {
        LinkedList mockedList = mock(LinkedList.class);
        when(mockedList.get(0)).thenReturn("张三, 01,  75, 数学: 95, 英语: 80, 编程: 80");
        library.functionOfMenuOne(mockedList.get(0).toString());
        assertEquals(systemOut(), "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n");
    }

    @Test
    public void should_input_correct_student_id_and_output_score_list() {
        String checkStudentId = "01, 02, 03, 04";
        library.functionOfMenuTwo(checkStudentId);
        assertEquals(systemOut(), "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75|95|80|80|82.5|330 \n" +
                "李四|85|80|70|90|81.25|325 \n" +
                "========================\n"+
                "全班总分平均数：327.5\n" +
                "全班总分中位数：327.5\n");
    }

    @Test
    public void should_input_incorrect_student_id_and_output_warning() {
        String checkStudentId = "id, 02test";
        library.functionOfMenuTwo(checkStudentId);
        assertEquals(systemOut(),"请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
    }

    @Test
    public void should_get_average_score_of_all_students() {
        assertThat(library.calculateAverageScoreOfAllStudents()).isEqualTo(327.5);
    }

    @Test
    public void should_get_median_score_of_all_students() {
        assertThat(library.calculateMedianScoreOfAllStudents()).isEqualTo(327.5);
    }

    //    @Test
//    public void testSomeLibraryMethod() {
//        Library classUnderTest = new Library();
//        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
//    }
//
//    @Test
//    public void testMockClass() throws Exception {
//        // you can mock concrete classes, not only interfaces
//        LinkedList mockedList = mock(LinkedList.class);
//
//        // stubbing appears before the actual execution
//        String value = "first";
//        when(mockedList.get(0)).thenReturn(value);
//
//        assertEquals(mockedList.get(0), value);
//
//    }

    private String systemOut() {
        return outContent.toString();
    }

}

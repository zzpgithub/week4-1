package com.tw;

import java.util.*;

public class Library {

    private  Map<String, Student> studentMap = new HashMap<String, Student>();

    public static void main(String[] args) {
        Library library = new Library();
        library.libraryManagement();
    }

    public void setStudentMap(Student student) {
        this.studentMap.put(student.getId(), student);
    }

    public double calculateAverageScoreOfAllStudents() {
        int totalScore = 0;
        if (studentMap.size() == 0) {
            return 0;
        }
        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            totalScore += entry.getValue().getScore().getTotalScore();
        }
        return (double)totalScore/studentMap.size();
    }

    public double calculateMedianScoreOfAllStudents() {
        ArrayList<Student> studentList = new ArrayList<>();
        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            studentList.add(entry.getValue());
        }
        Collections.sort(studentList, (a,b)->(Integer.compare(a.getScore().getTotalScore(),b.getScore().getTotalScore())));
        int size = studentList.size();
        if (size == 0) {
            return 0;
        }
        else if(size % 2 == 0){
            return (double)(studentList.get(size/2 - 1).getScore().getTotalScore() + studentList.get(size/2).getScore().getTotalScore())/2;
        }else {
            return studentList.get(size/2).getScore().getTotalScore();
        }
    }
    public void libraryManagement() {
        while (true) {
            displayMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (choice == 3) {
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...）,按回车提交");
                    Scanner scannerMessage = new Scanner(System.in);
                    String studentMessage = scannerMessage.nextLine();
                    functionOfMenuOne(studentMessage);
                    break;
                case 2:
                    System.out.println("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：");
                    Scanner scannerId = new Scanner(System.in);
                    String studentId = scannerId.nextLine();
                    functionOfMenuTwo(studentId);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("您输入的数字有误，请重新输入：1~3");
                    break;
            }
        }

    }

//    public boolean someLibraryMethod() {
//        return true;
//    }

    public String displayMenu(){
        System.out.print("1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：\n");
        return "1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：\n";
    }

    public String functionOfMenuOne(String studentMessage) {
        Student student = new Student();
        if (student.checkFormat(studentMessage)) {
            String[] studentMessageArray = studentMessage.split(",\\s+|:\\s+");
            student.setName(studentMessageArray[0]);
            student.setId(studentMessageArray[1]);
            Score score = new Score(Integer.parseInt(studentMessageArray[3]), Integer.parseInt(studentMessageArray[5]),
                    Integer.parseInt(studentMessageArray[7]), Integer.parseInt(studentMessageArray[9]));
            student.setScore(score);

            studentMap.put(student.getId(), student);

            System.out.print("学生" + student.getName() + "成绩被添加\n");
            return "学生" + student.getName() + "成绩被添加\n";
        } else {
            System.out.print("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n");
            return "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n";
        }
    }
    public void functionOfMenuTwo(String studentId) {
        Student student = new Student();
        if (student.checkIdFormat(studentId)) {
            String[] studentIdArray = studentId.split(",\\s+");
            System.out.print("成绩单\n姓名|数学|语文|英语|编程|平均分|总分\n========================\n");

            for (String s : studentIdArray) {
                if (studentMap.containsKey(s)) {
                    studentMap.get(s).disPlay();
                } else {
                    continue;
                }
            }
            System.out.print("========================\n全班总分平均数：" + calculateAverageScoreOfAllStudents()
                    + "\n全班总分中位数：" + calculateMedianScoreOfAllStudents() + "\n");
        } else {
            System.out.print("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
        }
    }
}

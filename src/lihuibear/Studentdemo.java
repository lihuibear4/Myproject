package lihuibear;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Studentdemo {
    public static void main(String[] args) {
        ArrayList<Student> array = new ArrayList<>();//在 main 中创建ArrayList

        login();

        menu(array);
    }

    public static void login() {

        Scanner sc = new Scanner(System.in);
        String password = "admin";
        System.out.println("===================");
        System.out.println("请先登录密码");
        System.out.println("===================");
        String pw = sc.nextLine();

        while (!pw.equals(password)) {
            System.out.println("密码错误，请重试!");
            pw = sc.nextLine();
        }
    }

    public static void menu(ArrayList<Student> array) {


        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1.查看成绩");
            System.out.println("2.添加信息");
            System.out.println("3.删除信息");
            System.out.println("0.退出程序");
            System.out.println("===================");

            String num = sc.nextLine();

            switch (num) {
                case "1":
                    findscore(array);
                    break;
                case "2":
                    addinformation(array);
                    break;
                case "3":
                    deleteStudent(array);
                    break;
                case "0":
                    System.exit(0);
                default:
                    System.out.println("输入有误,重新输入");
                    menu(array);


            }
        }
    }

    public static void findscore(ArrayList<Student> array) {

        int j = array.size();
        System.out.println("共有" + j + "名同学");
        System.out.println("姓名\t\tjava\tpython\t总分");

        array.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int sum1 = s1.getScore_java() + s1.getScore_python();
                int sum2 = s2.getScore_java() + s2.getScore_python();
                return sum2 - sum1;

            }
        });


        for (Student s : array) {
            int sum = s.getScore_java() + s.getScore_python();

            System.out.println(s.getName() + "\t" + s.getScore_java() + "\t\t" + s.getScore_python() + "\t\t" + sum);
        }

        System.out.println("查询完成");
    }

    public static void addinformation(ArrayList<Student> array) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        System.out.println("输入学生姓名");
        String name = sc.nextLine();


        if (namesame(array, name)) {
            System.out.println("输入学生java成绩");


            try {
                int score_java = sc.nextInt();
                if (score_java < 0 || score_java > 100) {
                    System.out.println("分数错误");
                    menu(array);
                }
                s.setScore_java(score_java);
            } catch (NoSuchElementException e1) {
                System.out.println("输入错误");
                menu(array);
            }

            System.out.println("请输入python成绩：");
            try {
                int score_python = sc.nextInt();
                if (score_python < 0 || score_python > 100) {
                    System.out.println("分数错误");
                    menu(array);
                }
                s.setScore_python(score_python);
            } catch (NoSuchElementException e2) {
                System.out.println("输入错误");
                menu(array);
            }

            s.setName(name);
//            s.setScore_java(score_java);
//            s.setScore_python(s.getScore_python());
            array.add(s);

            System.out.println("添加成功！");

        } else {
            System.out.println("已经有该同学了");
        }
    }


    public static void deleteStudent(ArrayList<Student> array) {
        System.out.println("请输入要删除学生的姓名");

        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        boolean a = false;
        for (int i = 0; i < array.size(); i++) {
            Student s = array.get(i);
            if (s.getName().equals(name)) {
                array.remove(i);

                System.out.println("删除成功！");
                a = true;
                break;
            }
        }
        if (a == false) {
            System.out.println("未找到名为" + name + "的信息");
        }
    }

    public static boolean namesame(ArrayList<Student> array, String name) {

        for (Student s : array) {
            if (s.getName().equals(name)) {
                return false;
            }
        }

        return true;
    }

}


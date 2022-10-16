package com.hackerrank.Algorithm.Implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradingStudents {

    public static void main(String[] args) {
        List<Integer> grades = Arrays.asList(73, 67, 38, 33); // 75, 67, 40, 33
        gradingStudents(grades);
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> finalGrades = new ArrayList<>();
        grades.forEach(grade -> {
            int rounding = (grade / 5 + 1) * 5;
            if (grade >= 38 && rounding - grade < 3) finalGrades.add(rounding);
            else finalGrades.add(grade);
        });
        return finalGrades;
    }
}

package com.geely.design.principle.dependenceinversion;

/**
 * Created by geely
 */
public class Geely {

    private ICourse iCourse;

    public void setiCourse(ICourse iCourse) {
        this.iCourse = iCourse;
    }

    public void studyImoocCourse() {
        iCourse.studyCourse();
    }
}

package com.packt.scrum1.domene;

/**
 *
 * @author magnussj
 */

import com.packt.scrum1.domene.Student;

public class Poengsum {
    public Student student;
    public int poeng;

   

    public Poengsum(Student student, int poeng){
        this.student = student;
        this.poeng = poeng;
    }
    
    public Student getStudent() {
        return student;
    }

    public int getPoeng() {
        return poeng;
    }
     public void setStudent(Student student) {
        this.student = student;
    }

    public void setPoeng(int poeng) {
        this.poeng = poeng;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvien;

/**
 *
 * @author chien
 */
public class Student {
    public String name;
    public double mark;
    public String major;
    
    public String getGrade() {
        if(this.mark < 3)
            return "Kém";
        if(this.mark < 5)
            return "Yếu";
        if(this.mark < 6.5)
            return "Trung bình";
        if(this.mark < 7.5)
            return "Khá";
        if(this.mark < 9)
            return "Giỏi";
        return "Xuất sắc";
    }
    
    public boolean isBonus() {
        return this.mark >= 7.5;
    }
}

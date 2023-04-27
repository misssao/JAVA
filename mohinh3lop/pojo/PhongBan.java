/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

/**
 *
 * @author chien
 */
public class PhongBan {
    private int maPHG;
    private String tenPHG;

    public PhongBan() {
    }
    
    public PhongBan(int maPHG, String tenPHG) {
        this.maPHG = maPHG;
        this.tenPHG = tenPHG;
    }

    public int getMaPHG() {
        return maPHG;
    }

    public void setMaPHG(int maPHG) {
        this.maPHG = maPHG;
    }

    public String getTenPHG() {
        return tenPHG;
    }

    public void setTenPHG(String tenPHG) {
        this.tenPHG = tenPHG;
    }
}

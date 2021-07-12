/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author DELL
 */
public class item {

    public item(sanpham sp, int soluong) {
        this.sp = sp;
        this.soluong = soluong;
    }

    public sanpham getSp() {
        return sp;
    }

    public void setSp(sanpham sp) {
        this.sp = sp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    private sanpham sp;
    private int soluong;
}

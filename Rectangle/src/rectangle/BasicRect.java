/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rectangle;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

/**
 *
 * @author qxz14sru
 */
public class BasicRect implements ADT_BasicRect, Comparable<BasicRect>{
    int x;
    int y;
    int w;
    int h;

    public BasicRect(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }
    
    @Override
    public BasicRect horizontalCut(int c) {
        if(c<=this.h&&c>=0){
            BasicRect newRect = new BasicRect(x, y+c, w, h-c);
            this.setH(c);
            return newRect;
        }else{
            throw new IllegalArgumentException("cut-value must be between 0 and the height of this BasicRect");
        }
    }
    
    @Override
    public BasicRect verticalCut(int c) {
        if(c<=this.w&&c>=0){
            BasicRect newRect = new BasicRect(x+c, y, w-c, h);
            this.setW(c);
            return newRect;
        }else{
            throw new IllegalArgumentException("cut-value must be between 0 and the width of this BasicRect");
        }
    }

    @Override
    public int compareTo(BasicRect br2) {
        BasicRect br1 = this;
        int br1Area = br1.getH()*br1.getW();
        int br2Area = br2.getH()*br2.getW();
        
        if(br1Area<br2Area){
            return -1;
        }else if(br1Area==br2Area){
            return 0;
        }else{
            return 1;
        }
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(String.format("x = %-10s ", x));
        str.append(String.format("y = %-10s ", y));
        str.append(String.format("w = %-10s ", w));
        str.append(String.format("h = %-10s ", h));
        str.append(String.format("Area = %-10s ", h*w));
        return str.toString();
    }
    
    public static ArrayList<BasicRect> genRects(int w, int h, int numRect){
        ArrayList<BasicRect> bRects = new ArrayList<>();
        BasicRect b0 = new BasicRect(0, 0, w, h);
        bRects.add(b0);
        int c = 0;
        Random rand = new Random();
        while(bRects.size()<numRect){
            int i = rand.nextInt((bRects.size()-1)+1);
            int k = (int)(Math.random() * 2);
            if(k==0){
                if(bRects.get(i).getW()>1){
                    c = rand.nextInt(bRects.get(i).getW()-1)+1;
                    bRects.add(bRects.get(i).verticalCut(c));
                }
            }else{
                if(bRects.get(i).getH()>1){
                    c = rand.nextInt(bRects.get(i).getH()-1)+1;
                    bRects.add(bRects.get(i).horizontalCut(c));
                }
            }
        }
        return bRects;
    }
    
    public static PriorityQueue<BasicRect> getQueue(ArrayList<BasicRect> bRects){
        return new PriorityQueue<>(bRects);
    }
    
    public static void main(String[] args) {
        PriorityQueue queue = getQueue(genRects(10000, 10000, 50));
        while(queue.peek()!=null){
            System.out.println(queue.poll());
        }
    }
}

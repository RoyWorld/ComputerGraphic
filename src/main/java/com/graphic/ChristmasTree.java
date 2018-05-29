package com.graphic;

import java.util.Random;

/**
 * Created by RoyChan on 2018/5/25.
 */
public class ChristmasTree {

    float pi = 3.14159265359F;

    float sx, sy;

    float sdCircle(float px, float py, float r){
        float dx = px - sx, dy = py - sy;
        return (float) (Math.sqrt(dx * dx + dy * dy) - r);
    }

    float opUnion(float d1, float d2){
        return d1 < d2 ? d1 : d2;
    }

    boolean ribbon(){
        float x = ((sy % 0.1F) / 0.1F - 0.5F) * 0.5F;
        return sx >= x - 0.05F && sx <= x + 0.05F;
    }

    float f(float px, float py, float theta, float scale, int n){
        float d = 0.0F;
        for (float r = 0.0F; r < 0.8F; r += 0.02F){
            float x = (float) (px + scale * r * Math.cos(theta));
            float y = (float) (py + scale * r * Math.sin(theta));
            d = opUnion(d, sdCircle(x, y, 0.05F * scale * (0.95F - r)));
        }

        if (n > 0){
            for (int t = -1; t <= 1; t+=2) {
                float tt = theta + t * 1.8F;
                float ss = scale * 0.9F;
                for (float r = 0.2F; r < 0.8F; r += 0.1F){
                    float x = (float) (px + scale * r * Math.cos(theta));
                    float y = (float) (py + scale * r * Math.sin(theta));
                    d = opUnion(d, f(x, y, tt,ss * 0.5F, n - 1));
                    ss *= 0.8F;
                }
            }
        }

        return d;
    }

    public void test(int n, float zoom) {
        String s = "............................#j&o";
        Random random = new Random();
        for (sy = 0.8F; sy > 0.02F; sy -= 0.02F / zoom){
            System.out.println();
            for (sx = -0.35F; sx < 0.35F; sx += 0.01F / zoom){
                if (f(0, 0, (float) (pi * 0.5), 1.0F, n) < 0){
                    if (sy < 0.1F){
                        System.out.printf(".");
                    }else {
                        if (ribbon()){
                            System.out.printf(".");
                        }else {
                            System.out.printf(s.charAt(random.nextInt(100000) % 32) + "");
                        }
                    }
                }else {
                    System.out.printf(" ");
                }

            }
        }
    }

    public static void main(String[] args) {
        ChristmasTree christmasTree = new ChristmasTree();
        christmasTree.test(6, 1.2F);
    }
}

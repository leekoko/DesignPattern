package com.geely.design.pattern.creational.simplefactory;
import main.java.geely.design.pattern.creational.simplefactory.Video;
import main.java.geely.design.pattern.creational.simplefactory.JavaVideo;

public class Test {
    public static void main(String[] args) {
        //最简单工厂模式
/*        VideoFactory videoFactory = new VideoFactory();
//        Video video = videoFactory.getVideo("java");
        Video video = videoFactory.getVideo("python");
        if(video == null){
            return;
        }
        video.produce();*/

        //带反射简单工厂模式
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(JavaVideo.class);
        if(video == null){
            return;
        }
        video.produce();

    }
}

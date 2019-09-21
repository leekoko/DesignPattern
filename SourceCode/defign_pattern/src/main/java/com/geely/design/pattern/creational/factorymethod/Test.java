package com.geely.design.pattern.creational.factorymethod;

public class Test {
    public static void main(String[] args) {
        //最简单工厂模式
/*        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo("python");
        if(video == null){
            return;
        }
        video.produce();*/

        //带反射简单工厂模式
/*        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(JavaVideo.class);
        if(video == null){
            return;
        }
        video.produce();*/

        VideoFactory videoFactory = new JavaVideoFactory();
        VideoFactory videoFactory2 = new PythonVideoFactory();
        VideoFactory videoFactory3 = new FEVideoFactory();
        Video video = videoFactory.getVideo();
        video.produce();

    }
}

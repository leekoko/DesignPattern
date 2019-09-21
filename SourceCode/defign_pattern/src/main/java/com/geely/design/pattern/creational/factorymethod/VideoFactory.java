package com.geely.design.pattern.creational.factorymethod;

public abstract class VideoFactory {
    //将创捷对象的职能移交到子类
    public abstract Video getVideo(); //也可以用interface，但抽象方法可能有已知方法

    /*    public Video getVideo(Class c){
        Video video = null;
        try {
            video = (Video) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return video;
    }*/


/*    public Video getVideo(String type){
        //最简单工厂模式
        if("java".equalsIgnoreCase(type)){
            return new JavaVideo();
        }else if("python".equalsIgnoreCase(type)){
            return new PythonVideo();
        }
        return null;

    }*/
}

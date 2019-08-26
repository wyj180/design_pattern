package com.geely.design.pattern.creational.simplefactory;

// 简单工厂
public class VideoFactory {

    // 版本二：可以解决新增类，不修改代码问题
    // 该方法可以写成静态方法
    public Video getVideo(Class c) {
        Video video = null;
        try {
            // video = (Video) Class.forName(c.getName()).newInstance(); // 视频老师的版本，感觉有问题，写的太多
            video = (Video) c.newInstance(); // 我的版本
        } catch (Exception e) {
            e.printStackTrace();
        }
        return video;
    }

    // 版本一：新增课程时，需要修改代码
    // 该方法可以写成静态方法
    public Video getVideo(String type) {
        if ("java".equalsIgnoreCase(type)) {
            return new JavaVideo();
        } else if ("python".equalsIgnoreCase(type)) {
            return new PythonVideo();
        }
        return null;
    }
}

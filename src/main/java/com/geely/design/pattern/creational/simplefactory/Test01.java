package com.geely.design.pattern.creational.simplefactory;

import org.junit.Test;

public class Test01 {

    // 版本一
    @Test
    public void test01() {
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo("java");
        if (video == null) {
            return;
        }
        video.produce();
    }

    // 版本二
    @Test
    public void test02() {
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideo(PythonVideo.class);
        if (video == null) {
            return;
        }
        video.produce();
    }
}

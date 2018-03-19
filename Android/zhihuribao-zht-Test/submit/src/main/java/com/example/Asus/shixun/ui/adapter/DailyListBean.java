package com.example.Asus.shixun.ui.adapter;

import java.util.List;

/**
 * Created by Lenovo on 2018/1/12.
 */

class DailyListBean {
    private String date;
    private List<StoriesBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    class StoriesBean {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> image;
        private boolean readSate;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImage() {
            return image;
        }

        public void setImage(List<String> image) {
            this.image = image;
        }

        public boolean isReadSate() {
            return readSate;
        }

        public void setReadSate(boolean readSate) {
            this.readSate = readSate;
        }
    }


}




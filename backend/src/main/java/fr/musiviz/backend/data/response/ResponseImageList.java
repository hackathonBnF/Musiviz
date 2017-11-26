package fr.musiviz.backend.data.response;

import fr.musiviz.backend.db.entity.Image;

import java.util.List;

/**
 * Created by kemkem on 11/26/17.
 */
public class ResponseImageList {
    private int count;
    private List<Image> listImage;

    public static ResponseImageList init() {
        return new ResponseImageList();
    }

    public int getCount() {
        return count;
    }

    public ResponseImageList withCount(int count) {
        this.count = count;
        return this;
    }

    public List<Image> getListImage() {
        return listImage;
    }

    public ResponseImageList withListImage(List<Image> listImage) {
        this.listImage = listImage;
        return this;
    }
}

package com.anningtex.imitatecircleoffriengds.bean;

import lombok.Data;

/**
 * @author Song
 * desc:
 */
@Data
public class Friend {
    private int imageId;

    public Friend(int imageId) {
        this.imageId = imageId;
    }
}

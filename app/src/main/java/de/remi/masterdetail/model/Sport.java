package de.remi.masterdetail.model;

import de.remi.masterdetail.R;

public class Sport {

    public int id;
    public int titleResourceId;
    public int subTitleResourceId;
    public int imageResourceId;
    public int sportsImageBanner;
    public int newsDetails = R.string.sports_news_detail_text;

    public Sport(int id, int titleResourceId, int subTitleResourceId, int imageResourceId,
                 int sportsImageBanner) {
        this.id = id;
        this.titleResourceId = titleResourceId;
        this.subTitleResourceId = subTitleResourceId;
        this.imageResourceId = imageResourceId;
        this.sportsImageBanner = sportsImageBanner;
    }
}

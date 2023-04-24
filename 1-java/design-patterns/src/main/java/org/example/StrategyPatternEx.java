package org.example;

import java.util.ArrayList;
import java.util.List;

class Track {
    private String title;
    private String duration;

    public Track(String title, String duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }
}


@FunctionalInterface
interface NextTrackStrategy {
    Track getNextTrack(List<Track> tracks);
}

class FirstIn implements NextTrackStrategy {
    public Track getNextTrack(List<Track> tracks) {
        return tracks.get(0);
    }
}

class LastIn implements NextTrackStrategy {
    public Track getNextTrack(List<Track> tracks) {
        return tracks.get(tracks.size() - 1);
    }
}


class PlayList {

    private NextTrackStrategy nextTrackStrategy;
    private List<Track> tracks = new ArrayList<>();

    public void setNextTrackStrategy(NextTrackStrategy nextTrackStrategy) {
        this.nextTrackStrategy = nextTrackStrategy;
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    public Track getNextTrack() {
        return this.nextTrackStrategy.getNextTrack(tracks);
    }

}


public class StrategyPatternEx {
    public static void main(String[] args) {

        PlayList playList = new PlayList();
        //playList.setNextTrackStrategy(new FirstIn());
        playList.setNextTrackStrategy(tracks -> tracks.get(0));  // FI
        playList.addTrack(new Track("Track 1", "10:00"));
        playList.addTrack(new Track("Track 2", "20:00"));
        playList.addTrack(new Track("Track 3", "30:00"));
        playList.addTrack(new Track("Track 4", "40:00"));

        //playList.setNextTrackStrategy(new LastIn());


        System.out.println(playList.getNextTrack().getTitle());


    }
}

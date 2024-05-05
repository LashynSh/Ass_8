package Iterator_Pattern_discussion;

import java.util.ArrayList;
import java.util.List;


interface PlaylistIterator {
    boolean hasNext();
    Song next();
}

interface Playlist {
    PlaylistIterator createIterator();
    void addSong(Song song);
}

class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}

class ConcretePlaylistIterator implements PlaylistIterator {
    private List<Song> songs;
    private int position = 0;

    public ConcretePlaylistIterator(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public boolean hasNext() {
        return position < songs.size();
    }

    @Override
    public Song next() {
        Song song = songs.get(position);
        position++;
        return song;
    }
}

class PlaylistImpl implements Playlist {
    private List<Song> songs;

    public PlaylistImpl() {
        songs = new ArrayList<>();
    }

    @Override
    public PlaylistIterator createIterator() {
        return new ConcretePlaylistIterator(songs);
    }

    @Override
    public void addSong(Song song) {
        songs.add(song);
    }
}

public class Main_1 {
    public static void main(String[] args) {
        Playlist playlist = new PlaylistImpl();
        playlist.addSong(new Song("Erikpe", "Darkhan Juzz"));
        playlist.addSong(new Song("Tugan jer tolgauy", "Dudeontheguitar and HeyMonro"));
        playlist.addSong(new Song("Sybyrlayin", "Ayau"));

        PlaylistIterator iterator = playlist.createIterator();
        System.out.println("Playlist:");
        while (iterator.hasNext()) {
            Song song = iterator.next();
            System.out.println("Playing: " + song.getTitle() + " by " + song.getArtist());
        }
    }
}

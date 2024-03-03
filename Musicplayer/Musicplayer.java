import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    @Override
    public String toString() {
        return title + " by " + artist;
    }
}

class Playlist {
    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public void displaySongs() {
        System.out.println("Songs in playlist '" + name + "':");
        for (int i = 0; i < songs.size(); i++) {
            System.out.println((i + 1) + ". " + songs.get(i));
        }
    }
}

public class MusicPlayer {
    private List<Song> library;
    private List<Playlist> playlists;
    private boolean isPlaying;
    private int currentSongIndex;
    private int volume;

    public MusicPlayer() {
        this.library = new ArrayList<>();
        this.playlists = new ArrayList<>();
        this.isPlaying = false;
        this.currentSongIndex = -1;
        this.volume = 50; // Default volume
    }

    public void addSongToLibrary(Song song) {
        library.add(song);
    }

    public void createPlaylist(String name) {
        playlists.add(new Playlist(name));
    }

    public void addSongToPlaylist(int playlistIndex, int songIndex) {
        playlists.get(playlistIndex).addSong(library.get(songIndex));
    }

    public void playSong(int songIndex) {
        if (songIndex >= 0 && songIndex < library.size()) {
            currentSongIndex = songIndex;
            isPlaying = true;
            System.out.println("Now playing: " + library.get(songIndex));
        } else {
            System.out.println("Invalid song index.");
        }
    }

    public void pauseSong() {
        isPlaying = false;
        System.out.println("Song paused.");
    }

    public void stopSong() {
        isPlaying = false;
        currentSongIndex = -1;
        System.out.println("Playback stopped.");
    }

    public void adjustVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("Volume adjusted to " + volume);
        } else {
            System.out.println("Volume should be between 0 and 100.");
        }
    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        Scanner scanner = new Scanner(System.in);

        player.addSongToLibrary(new Song("Song1", "Artist1"));
        player.addSongToLibrary(new Song("Song2", "Artist2"));
        player.addSongToLibrary(new Song("Song3", "Artist3"));

        player.createPlaylist("My Playlist");
        player.addSongToPlaylist(0, 0);
        player.addSongToPlaylist(0, 1);

        while (true) {
            System.out.println("\n1. Play\n2. Pause\n3. Stop\n4. Adjust Volume\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter song index to play: ");
                    int songIndex = scanner.nextInt();
                    player.playSong(songIndex);
                    break;
                case 2:
                    player.pauseSong();
                    break;
                case 3:
                    player.stopSong();
                    break;
                case 4:
                    System.out.print("Enter volume (0-100): ");
                    int volume = scanner.nextInt();
                    player.adjustVolume(volume);
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}


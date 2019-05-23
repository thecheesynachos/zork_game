package muic.ooc.zork.gameplay;

import javax.sound.sampled.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * I took this code from StackOverflow with some of my own edits to fit what I'm doing.
 */
public class Sound implements Runnable{

    private AudioInputStream stream;
    private AudioFormat format;
    private DataLine.Info info;
    private Clip clip;
    private boolean isPlaying;
    private boolean playToggle;
    private Thread thread;
    private Random random = new Random(1688);

    private static final ArrayList<String> SONGS_LIST = new ArrayList<String>(){{
        add("src/res/tetris.wav");
        add("src/res/conan.wav");
        add("src/res/halo.wav");
    }};

    // Singleton
    private static Sound sound = new Sound();

    public static Sound getInstance() {
        return sound;
    }

    public void start(){
        thread = new Thread(sound);
        thread.start();
        playToggle = true;
    }

    public Observation toggleSound(){
        playToggle = !playToggle;
        if (playToggle) {
            thread = new Thread(sound);
            thread.start();
            return new Observation("Music starts");
        } else {
            stopSound();
            return new Observation("Music stopped");
        }
    }

    public void playSound(String fileName) {

        if(!isPlaying) {
            try {
                stream = AudioSystem.getAudioInputStream(new File(fileName));
                format = stream.getFormat();
                info = new DataLine.Info(Clip.class, format);
                clip = (Clip) AudioSystem.getLine(info);
                clip.addLineListener(new LineListener() {
                    public void update(LineEvent event) {
                        if (event.getType() == LineEvent.Type.STOP) {
                            clip.close();
                            isPlaying = false;
                        }
                    }
                });
                clip.open(stream);
                clip.start();
                isPlaying = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void stopSound(){
        clip.stop();
        clip.close();
        isPlaying = false;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void run() {
        do {
            String song = SONGS_LIST.get(random.nextInt(SONGS_LIST.size()));
            playSound(song);
        } while(playToggle);
    }

}
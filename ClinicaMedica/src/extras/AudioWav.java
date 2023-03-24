package extras;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioWav extends Thread {
    
    private String arquivo;
    private Position posicao;

    private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb 

    enum Position { 
        LEFT, RIGHT, NORMAL
    };

    public AudioWav(String wavfile) { 
        arquivo = wavfile;
        posicao = Position.NORMAL;
    } 

    public AudioWav(String wavfile, Position p) { 
        arquivo = wavfile;
        posicao = p;
    } 

    public void run() { 

        File som = new File(arquivo);
        if (!som.exists()) { 
            System.err.println("Arquivo WAV não encontrado: " + arquivo);
            return;
        } 

        AudioInputStream ais = null;
        try { 
            ais = AudioSystem.getAudioInputStream(som);
        } catch (UnsupportedAudioFileException | IOException e1) { 
            e1.printStackTrace();
            return;
        } 

        AudioFormat formato = ais.getFormat();
        SourceDataLine auline = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, formato);

        try { 
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(formato);
        } catch (LineUnavailableException e) { 
            e.printStackTrace();
            return;
        } catch (Exception e) { 
            e.printStackTrace();
            return;
        } 

        if (auline.isControlSupported(FloatControl.Type.PAN)) { 
            FloatControl pan = (FloatControl) auline
                    .getControl(FloatControl.Type.PAN);
            if (posicao == Position.RIGHT) 
                pan.setValue(1.0f);
            else if (posicao == Position.LEFT) 
                pan.setValue(-1.0f);
        } 

        auline.start();
        int nBytesRead = 0;
        byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

        try { 
            while (nBytesRead != -1) { 
                nBytesRead = ais.read(abData, 0, abData.length);
                if (nBytesRead >= 0) 
                    auline.write(abData, 0, nBytesRead);
            } 
        } catch (IOException e) { 
            e.printStackTrace();
            return;
        } finally { 
            auline.drain();
            auline.close();
        } 

    } 
    
}

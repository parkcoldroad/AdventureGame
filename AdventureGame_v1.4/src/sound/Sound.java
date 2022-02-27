package sound;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

public class Sound {

	static Clip bgmclip;
	static Clip soundclip;
	
	AudioInputStream ais;
	@SuppressWarnings("static-access")
	public void playBgm(String files, float vol, boolean repeat) {
		try {
			// BGM은 임의의 시점에서 정지시킬 수 있어야 하므로 전역으로 전용 Clip을 사용한다
			ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(files)));
			bgmclip = (Clip) AudioSystem.getClip();
			bgmclip.open(ais);
			bgmclip.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event) {
					// TODO Auto-generated method stub
					if (event.getType() == LineEvent.Type.STOP) {
						bgmclip.close();
					}
				}
			});
			FloatControl volume = (FloatControl) bgmclip.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(vol);
			bgmclip.start();
			if (repeat)
				bgmclip.loop(bgmclip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void stopBgm() {

		if (bgmclip != null && bgmclip.isRunning()) {
			bgmclip.stop();
			bgmclip.close();
		}
	}

	public void playSound(String files, float vol, boolean repeat) {
		try {
			ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(files)));
			soundclip = (Clip) AudioSystem.getClip();
			soundclip.open(ais);
			
			soundclip.addLineListener(new LineListener() {
				@Override
				public void update(LineEvent event) {
					// TODO Auto-generated method stub
					if (event.getType() == LineEvent.Type.STOP) {
						// 이 부분이 없으면 효과음이 메모리에 점점 쌓여서 언젠가 크래시된다
						soundclip.close();
					}
				}
			});
			FloatControl volume = (FloatControl) soundclip.getControl(FloatControl.Type.MASTER_GAIN);
			volume.setValue(vol);
			soundclip.start();
			if (repeat)
				soundclip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

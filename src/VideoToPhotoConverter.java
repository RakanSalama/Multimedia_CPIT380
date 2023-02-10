
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;

public class VideoToPhotoConverter {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        VideoCapture capture = new VideoCapture("inputVidtoP\\input.mp4");
        Mat frame = new Mat();

        int i = 0;
        while (capture.read(frame)) {
            Imgcodecs.imwrite("outputVidtoP\\photo" + i + ".jpg", frame);
            i++;
        }

        capture.release();
    }
}

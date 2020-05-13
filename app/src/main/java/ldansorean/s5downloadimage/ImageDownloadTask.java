package ldansorean.s5downloadimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

public class ImageDownloadTask extends AsyncTask<String, Void, Bitmap> {
    @Override
    protected Bitmap doInBackground(String... urls) {
        Bitmap image = null;

        try {
            InputStream imageInputStream = (new URL(urls[0])).openConnection().getInputStream();
            image = BitmapFactory.decodeStream(imageInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return image;
    }
}

package ldansorean.s5downloadimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private static final String IMAGE_URL = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Cinnamon_seedling.jpg/565px-Cinnamon_seedling.jpg";

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
    }

    public void downloadImage(View view) {
        findViewById(R.id.button).setVisibility(View.INVISIBLE);
        try {
            Bitmap imageBitmap = new ImageDownloadTask().execute(IMAGE_URL).get();
            image.setImageBitmap(imageBitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

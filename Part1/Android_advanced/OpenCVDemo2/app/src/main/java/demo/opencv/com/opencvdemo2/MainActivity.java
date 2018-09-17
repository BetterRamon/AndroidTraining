package demo.opencv.com.opencvdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button grayBtn;
    private Button originalBtn;

    OpenCvHelper helper = new OpenCvHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    protected  void initView(){
        imageView = findViewById(R.id.img);
        grayBtn = findViewById(R.id.gray_button);
        originalBtn = findViewById(R.id.original_button);

        grayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                greyImage();
            }
        });

        originalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                originalImage();
            }
        });
    }

    /*显示原图*/
    protected  void originalImage(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.food);
        imageView.setImageBitmap(bitmap);
    }

    /*灰度化显示图片*/
    protected  void greyImage(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.food);

        /*以下进行灰度化处理*/
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        int[] pix = new int[w * h];
        bitmap.getPixels(pix, 0, w, 0, 0, w, h);
        int[] resultPixels = OpenCvHelper.gray(pix, w, h);
        Bitmap result = Bitmap.createBitmap(w, h, Bitmap.Config.RGB_565);
        result.setPixels(resultPixels,0,w,0,0,w,h);
        imageView.setImageBitmap(result);
    }
}

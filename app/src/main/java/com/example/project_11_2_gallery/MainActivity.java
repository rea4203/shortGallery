package com.example.project_11_2_gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tosT;
    View tosV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("갤러리 영화 포스터");

        Gallery ga1 = (Gallery) findViewById(R.id.ga1);
        MyGalleryAdapter galA = new MyGalleryAdapter(this);
        ga1.setAdapter(galA);
    }

    public class MyGalleryAdapter extends BaseAdapter {
        Context con;
        Integer[] posterID = { R.drawable.iv1, R.drawable.iv2,
                R.drawable.iv3, R.drawable.iv4, R.drawable.iv5,
                R.drawable.iv6, R.drawable.iv7, R.drawable.iv8,
                R.drawable.iv9, R.drawable.iv10, };
        String[] n1 = { "고양이1", "고양이2", "고양이3",
                "고양이4", "고양이5", "고양이6", "고양이7",
                "고양이8", "고양이9", "고양이10", };

        public MyGalleryAdapter(Context c) {

            con = c;
        }

        public int getCount() {

            return posterID.length;
        }
        public Object getItem(int arg0) {

            return null;
        }
        public long getItemId(int arg0) {

            return 0;
        }
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView img = new ImageView(con);
            img.setLayoutParams(new Gallery.LayoutParams(200,300));
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setPadding(5,5,5,5);

            img.setImageResource(posterID[position]);

            final int pos = position;
            img.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    ImageView ivP = (ImageView) findViewById(R.id.ivPo);
                    ivP.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    ivP.setImageResource(posterID[pos]);

                    Toast.makeText(getApplicationContext(), n1[pos], Toast.LENGTH_SHORT).show();

                    return false;
                }
            });

            return img;
        }
    }
}
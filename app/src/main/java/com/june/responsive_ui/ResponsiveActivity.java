//package com.june.responsive_ui;
//
//import androidx.appcompat.app.AppCompatActivity;
//import android.app.Activity;
//import android.os.Bundle;
//import com.june.R;
//
//public class ResponsiveActivity extends Activity {
//    private Container container;
//    @Override protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.main_activity);
//        container = (Container) findViewById(R.id.container);
//    }
//    public Container getContainer() {
//        return container;
//    }
//    @Override public void onBackPressed() {
//        boolean handled = container.onBackPressed();
//        if (!handled) {
//            finish();
//        }
//    }
//}
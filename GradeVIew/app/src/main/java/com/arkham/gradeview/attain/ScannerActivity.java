package com.arkham.gradeview.attain;


import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.arkham.gradeview.R;
import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
public class ScannerActivity extends AppCompatActivity implements
        DecoratedBarcodeView.TorchListener {

    private CaptureManager capture;
    private DecoratedBarcodeView barcodeScannerView;
    private Button switchFlashlightButton;
    private boolean isFlashLightOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);


        //Initialize barcode scanner view
        barcodeScannerView = findViewById(R.id.zxing_barcode_scanner);

        //set torch listener
        barcodeScannerView.setTorchListener(this);

        //switch flashlight button
        switchFlashlightButton = (Button) findViewById(R.id.btnSwitch);

        // if the device does not have flashlight in its camera,
        // then remove the switch flashlight button...
        if (!hasFlash()) {
            switchFlashlightButton.setVisibility(View.GONE);
        } else {
            switchFlashlightButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switchFlashlight();
                }
            });
        }

        //start capture
        capture = new CaptureManager(this, barcodeScannerView);
        capture.initializeFromIntent(getIntent(), savedInstanceState);
        capture.decode();
    }


    /**
     * Check if the device's camera has a Flashlight.
     *
     * @return true if there is Flashlight, otherwise false.
     */
    private boolean hasFlash() {
        return getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    public void switchFlashlight() {
        if (isFlashLightOn) {
            barcodeScannerView.setTorchOff();
            isFlashLightOn = false;
        } else {
            barcodeScannerView.setTorchOn();
            isFlashLightOn = true;
        }

    }

    @Override
    public void onTorchOn() {
        switchFlashlightButton.setText(R.string.turn_off_flashlight);
    }

    @Override
    public void onTorchOff() {
        switchFlashlightButton.setText(R.string.turn_on_flashlight);
    }

    @Override
    protected void onResume() {
        super.onResume();
        capture.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        capture.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        capture.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        capture.onSaveInstanceState(outState);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return barcodeScannerView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }

}
//
//import android.app.Activity;
//import android.content.DialogInterface;
//import android.content.pm.PackageManager;
//import android.hardware.Camera;
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.app.AlertDialog;
//import android.widget.Toast;
//
//
//import com.ARKHAM.internpro.R;
//import com.journeyapps.barcodescanner.CaptureManager;
//import com.journeyapps.barcodescanner.DecoratedBarcodeView;
//
//public class ScannerActivity extends Activity {
//
//    private CaptureManager capture;
//    private DecoratedBarcodeView barcodeScannerView;
//    private Button btnSwitch;
//    private boolean isFlashLightOn = true;
//
//    private Camera camera;
//    private boolean isFlashOn;
//    private boolean hasFlash;
//    private Camera.Parameters params;
//    private MediaPlayer mp;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_scanner);
//
//        // flash switch button
//        btnSwitch = findViewById(R.id.btnSwitch);
//
//
//        /*
//         * First check if device is supporting flashlight or not
//         */
//        hasFlash = getApplicationContext().getPackageManager()
//                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
//
//        if (!hasFlash) {
//            // device doesn't support flash
//            // Show alert message and close the application
//            AlertDialog alert = new AlertDialog.Builder(ScannerActivity.this)
//                    .create();
//            alert.setTitle("Error");
//            alert.setMessage("Sorry, your device doesn't support flash light!");
//            alert.setButton("OK", new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int which) {
//                    // closing the application
//                    finish();
//                }
//            });
//            alert.show();
//            return;
//        }
//
//        // get the camera
//        getCamera();
//
//        // displaying button image
////        toggleButtonImage();
//
//        /*
//         * Switch button click event to toggle flash on/off
//         */
//        btnSwitch.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                if (isFlashOn) {
//                    // turn off flash
//                    turnOffFlash();
//                } else {
//                    // turn on flash
//                    turnOnFlash();
//                }
//            }
//        });
//    }
//
//    /*
//     * Get the camera
//     */
//    private void getCamera() {
//        if (camera == null) {
//            try {
//                camera = Camera.open();
//                params = camera.getParameters();
//            } catch (RuntimeException e) {
//                Log.e(getString(R.string.error_flash), e.getMessage());
//            }
//
//        }
//    }
//
//    /*
//     * Turning On flash
//     */
//    private void turnOnFlash() {
//        if (!isFlashOn) {
//            if (camera == null || params == null) {
//                return;
//            }
////            // play sound
////            playSound();
//
//            params = camera.getParameters();
//            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
//            camera.setParameters(params);
//            camera.startPreview();
//            isFlashOn = true;
//
//            // changing button/switch image
////            toggleButtonImage();
//        }
//
//    }
//
//    /*
//     * Turning Off flash
//     */
//    private void turnOffFlash() {
//        if (isFlashOn) {
//            if (camera == null || params == null) {
//                return;
//            }
//            // play sound
////            playSound();
//
//            params = camera.getParameters();
//            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
//            camera.setParameters(params);
//            camera.stopPreview();
//            isFlashOn = false;
//
//            // changing button/switch image
////            toggleButtonImage();
//        }
//    }
//
//    /*
//     * Playing sound will play button toggle sound on flash on / off
//     */
////    private void playSound() {
////        if (isFlashOn) {
////            mp = MediaPlayer.create(ScannerActivity.this, R.raw.light_switch_off);
////        } else {
////            mp = MediaPlayer.create(ScannerActivity.this, R.raw.light_switch_on);
////        }
////        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
////
////            @Override
////            public void onCompletion(MediaPlayer mp) {
////                // TODO Auto-generated method stub
////                mp.release();
////            }
////        });
////        mp.start();
////    }
//
//    /*
//     * Toggle switch button images changing image states to on / off
//     */
////    private void toggleButtonImage() {
////        if (isFlashOn) {
////            btnSwitch.setImageResource(R.drawable.btn_switch_on);
////        } else {
////            btnSwitch.setImageResource(R.drawable.btn_switch_off);
//////        }
////    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        // on pause turn off the flash
//        turnOffFlash();
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        // on resume turn on the flash
//        if (hasFlash)
//            turnOffFlash();
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        // on starting the app get the camera params
//        getCamera();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//
//        // on stop release the camera
//        if (camera != null) {
//            camera.release();
//            camera = null;
//        }
//    }
//
//}
package com.example.u3175008.capture_faster;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Capture_Load extends AppCompatActivity {


private static final int REQUEST_TAKE_PHOTO = 0;
private static final int REQUEST_SELECT_IMAGE_IN_ALBUM = 1;
    //private Uri mImageUri;
    //private Bitmap mBitmap;
    //private VisionServiceClient client;
    //private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture__load);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

Button btn = (Button) findViewById(R.id.capturebutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Capture_Load.this, Activityeight.class));
                capture();
            }
        });


        btn = (Button) findViewById(R.id.loadbutton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Capture_Load.this, Activityeight.class));
                load();
            }
        });
//        mTextView = (TextView) findViewById(R.id.textView2);
//        if (client==null){
//            client = new VisionServiceRestClient("813487fb287e48529e9db62391dc663f", "https://westcentralus.api.cognitive.microsoft.com/vision/v1.0");
        }




    public void capture(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
        }
    }

    public void load(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_IMAGE_IN_ALBUM);
        }
    }
}
    //@Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK){
//            Bundle extras = data.getExtras();
//            mBitmap = (Bitmap) extras.get("data");
//        }
//        if (requestCode == REQUEST_SELECT_IMAGE_IN_ALBUM && resultCode == RESULT_OK){
//            // If image is selected successfully, set the image URI and bitmap.
//            mImageUri = data.getData();
//            mBitmap = ImageHelper.loadSizeLimitedBitmapFromUri(
//                    mImageUri, getContentResolver());
//        }
//
//        if (mBitmap != null) {
//            // Show the image on screen.
//            ImageView imageView = (ImageView) findViewById(R.id.imageView7);
//            imageView.setImageBitmap(mBitmap);
//
//            runOCR();
//        }
//    }

//    public void runOCR () {
//        try {
//            new doRequest().execute();
//        } catch (Exception e) {
//            mTextView.setText("Error encountered. Exception is: " + e.toString());
//        }
//    }

//    private class doRequest extends AsyncTask<String, String, String> {
//        // Store error message
//        private Exception e = null;
//
//        public doRequest() {
//        }
//
//        @Override
//        protected String doInBackground(String... args) {
//            try {
//                return process();
//            } catch (Exception e) {
//                this.e = e;    // Store error
//            }
//
//            return null;
//        }
//
//
//        @Override
//        protected void onPostExecute(String data) {
//            super.onPostExecute(data);
//            // Display based on error existence
//            if (e != null) {
//                mTextView.setText("Error: " + e.getMessage());
//                this.e = null;
//            } else {
//                Gson gson = new Gson();
//                OCR r = gson.fromJson(data, OCR.class);
//
//                String result = "Result:\n";
//                for (com.microsoft.projectoxford.vision.contract.Region reg : r.regions) {
//                    for (Line line : reg.lines) {
//                        for (Word word : line.words) {
//                            result += word.text + " ";
//                        }
//                        result += "\n";
//                    }
//                    result += "\n\n";
//                }
//
//                mTextView.setText(result);
//                //Business_Card bc = new Business_Card("title", "RC" , Date );
//            }
//        }
//    }

//    private String process() throws VisionServiceException, IOException {
//        Gson gson = new Gson();
//
//        // Put the image into an input stream for detection.
//        ByteArrayOutputStream output = new ByteArrayOutputStream();
//        mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, output);
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(output.toByteArray());
//
//        OCR ocr;
//        ocr = this.client.recognizeText(inputStream, LanguageCodes.AutoDetect, true);
//
//        String result = gson.toJson(ocr);
//        Log.d("result", result);
//
//        return result;
//    }




//}

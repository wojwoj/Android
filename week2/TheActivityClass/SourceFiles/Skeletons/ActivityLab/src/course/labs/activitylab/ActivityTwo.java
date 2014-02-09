package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	Integer mCreate=0;
	Integer mStart=0;
	Integer mResume=0;
	Integer mRestart=0;
	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called


	TextView mTvCreate;
	TextView mTvStart;
	TextView mTvResume;
	TextView mTvRestart;


	// TODO: Create variables for each of the TextViews, called
        // mTvCreate, etc. 


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		
		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);

		mTvCreate = (TextView) findViewById(R.id.create);
		mTvStart= (TextView) findViewById(R.id.start);
		mTvResume= (TextView) findViewById(R.id.resume);
		mTvRestart= (TextView) findViewById(R.id.restart);



		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO:
				// This function closes Activity Two
				// Hint: use Context's finish() method

				finish();

			
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {

			mCreate = savedInstanceState.getInt("mCreate")+1;
			mStart = savedInstanceState.getInt("mStart");
			mResume = savedInstanceState.getInt("mResume");
			mRestart = savedInstanceState.getInt("mRestart");
		}else{
			mCreate++;
		}

		// TODO: Emit LogCat message



		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method

		Log.i(TAG,"Entered the onCreate method");
		displayCounts();


	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		
		Log.i(TAG,"Entered the onStart method");
		
		//
		// Update the appropriate count variable
		// Update the user interface
		mStart++;
		displayCounts();



	}

	@Override
	public void onResume() {
		super.onResume();

		
		Log.i(TAG,"Entered the onResume method");

		// TODO: Emit LogCat message
		mResume++;
		displayCounts();
		

		// TODO:
		// Update the appropriate count variable
		// Update the user interface




	}

	@Override
	public void onPause() {
		super.onPause();

		// TODO: Emit LogCat message



	}

	@Override
	public void onStop() {
		super.onStop();

		// TODO: Emit LogCat message



	}

	@Override
	public void onRestart() {
		super.onRestart();

		// TODO: Emit LogCat message


		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		mRestart++;
		Log.i(TAG,"Entered the onRestart method");

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TODO: Emit LogCat message

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// TODO:
		// Save counter state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		savedInstanceState.putInt("mCreate", mCreate);
		savedInstanceState.putInt("mStart", mStart);
		savedInstanceState.putInt("mResume", mResume);
		savedInstanceState.putInt("mRestart", mRestart);


	}

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}

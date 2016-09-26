package AsyncTasks;

import android.content.Context;
import android.os.AsyncTask;

import java.net.URLEncoder;

/**
 * Created by cmeehan on 26-Sep-16.
 */

public class GetCourses extends AsyncTask<String, Void, String> {
    public AsyncResponse delegate;
    private final Context CONTEXT;
    private final String LINK = "belong.cbmwebdevelopment.com/ClassSchedule.php";
    private final String SEMESTER, USER_ID;


    public interface AsyncResponse{
        void processFinish(String output);
    }

    public GetCourses(String semester, String userID, Context context){
        this.CONTEXT = context;
        this.SEMESTER = semester;
        this.USER_ID = userID;
    }

    @Override
    protected String doInBackground(String... params) {
        try{
            String data = URLEncoder.encode("USER_ID","UTF-8") + "=" + URLEncoder.encode(USER_ID,"UTF-8");
            data += "&" + URLEncoder.encode("SEMESTER", "UTF-8") + " = " + URLEncoder.encode(SEMESTER, "UTF-8");
            return null;
        }catch(Exception ex){
            return new String(ex.toString());
        }
    }

    @Override
    protected void onPostExecute(String results){
        delegate.processFinish(results);
    }
}

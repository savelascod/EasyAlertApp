package rest;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.params.HttpParams;

import java.util.List;

/**
 * Created by mordreth on 10/2/15.
 */
public class RequestCaller {
    String hostUrl = "http://servicedatosabiertoscolombia.cloudapp.net";
    HttpParams parameters;

    public void getData(String classUriPath, AsyncResponse responseHandler, List<NameValuePair> params) {
        String paramString = URLEncodedUtils.format(params, "utf-8");
        String url = this.hostUrl + "/" + classUriPath;
        url += "?" + paramString;
        GetClient getClient = new GetClient(url, responseHandler);
        getClient.execute();
    }

    public void postData(String classUriPath, AsyncResponse responseHandler, List<NameValuePair> params) {
        String url = this.hostUrl + "/" + classUriPath;
        PostClient postClient = new PostClient(url, responseHandler, params);
        postClient.execute();

    }
}

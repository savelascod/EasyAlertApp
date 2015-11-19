package rest;

import org.apache.http.NameValuePair;
import org.apache.http.params.HttpParams;

import java.util.List;

/**
 * Created by mordreth on 10/2/15.
 */
public class RequestCaller {
    String hostUrl = "http://servicedatosabiertoscolombia.cloudapp.net/v1/superintendencia_de_vigilancia_y_seguridad_privada/directoriodeservicios";
    HttpParams parameters;

    public void getData(String classUriPath, List<NameValuePair> params, AsyncResponse responseHandler) {
        String url = this.hostUrl + "/" + classUriPath;
        GetClient getClient = new GetClient(url, responseHandler, params);
        getClient.execute();
    }

    public void postData(String classUriPath, AsyncResponse responseHandler, List<NameValuePair> params) {
        String url = this.hostUrl + "/" + classUriPath;
        PostClient postClient = new PostClient(url, responseHandler, params);
        postClient.execute();

    }
}

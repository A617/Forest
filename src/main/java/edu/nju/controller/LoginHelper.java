package edu.nju.controller;

import edu.nju.service.vo.SignedInUser;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dora on 2016/9/7.
 */
public class LoginHelper {

    static String jumpTo(String client_id,String redirect_uri){
        //先将参数放入List，再对参数进行URL编码
        List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("client_id", client_id));
        params.add(new BasicNameValuePair("redirect_uri", redirect_uri));
        //对参数编码
        String param = URLEncodedUtils.format(params, "UTF-8");
        return "redirect:https://github.com/login/oauth/authorize?" + param;
    }

    static String jumpBack(String client_id, String client_secret, String code) throws IOException{

        HttpClient client = new DefaultHttpClient();
        String url = "https://github.com/login/oauth/access_token";

        //先将参数放入List，再对参数进行URL编码
        List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
        params.add(new BasicNameValuePair("client_id", client_id));
        params.add(new BasicNameValuePair("client_secret", client_secret));
        params.add(new BasicNameValuePair("code", code));

        //对参数编码
        String param = URLEncodedUtils.format(params, "UTF-8");

        HttpPost request = new HttpPost(url + '?' + param);
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);

        return responseString;

    }

    public static SignedInUser getSignInUser(HttpSession session){
        SignedInUser signedInUser = null;
        if(session.getAttribute("user")!=null)
            signedInUser = (SignedInUser) session.getAttribute("user");
        return signedInUser;
    }
}

package cn.bugjava.demo02;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class getRid {

    public static String getMusicUrl(String rid) {
        String json = null;
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;
        try {
            httpClient = HttpClients.createDefault();
            URIBuilder uriBuilder = new URIBuilder("http://www.kuwo.cn/url");
            uriBuilder.addParameter("rid", rid);
            uriBuilder.addParameter("response", "url");
            uriBuilder.addParameter("type", "convert_url3");
            uriBuilder.addParameter("br", "128kmp3");
            uriBuilder.addParameter("from", "web");
            uriBuilder.addParameter("t", "1621762751283");
            uriBuilder.addParameter("httpsStatus", "1");
            uriBuilder.addParameter("reqId", "ba820650-bbaa-11eb-989c-9d788e166e56");
            System.out.println(uriBuilder.build());
            httpGet = new HttpGet(uriBuilder.build());
            httpGet.setHeader("Accept", "application/json, text/plain, */*");
            httpGet.setHeader("Accept-Encoding", "gzip, deflate");
            httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7,zh-TW;q=0.6");
            httpGet.setHeader("Connection", "keep-alive");
            httpGet.setHeader("Cookie", "_ga=GA1.2.2109536653.1621762693; _gid=GA1.2.1133593484.1621762693; _gat=1; Hm_lvt_cdb524f42f0ce19b169a8071123a4797=1621762694; Hm_lpvt_cdb524f42f0ce19b169a8071123a4797=1621762694; kw_token=RZ1AZXMTAG");
            httpGet.setHeader("Host", "www.kuwo.cn");
            httpGet.setHeader("Referer", "http://www.kuwo.cn/search/list?key=%E6%85%A2%E7%83%AD");
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36");
            CloseableHttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                json = EntityUtils.toString(response.getEntity());
                System.out.println(json);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpGet.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

        }
        return json;
    }

}

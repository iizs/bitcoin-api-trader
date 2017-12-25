package net.iizs.btc.bithumbtrader.interceptor;

import okhttp3.*;
import okio.Buffer;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AuthInterceptor implements Interceptor {
    private String apiKey;
    private String secretKey;

    private AuthInterceptor() { }

    public AuthInterceptor(String apiKey, String secretKey) {
        this.apiKey = apiKey;
        this.secretKey = secretKey;
    }

    // TODO relocate this method
    private byte[] hmacSha512(String value, String key) {
        String DEFAULT_ENCODING = "UTF-8";
        String HMAC_SHA512 = "HmacSHA512";
        try {
            SecretKeySpec keySpec = new SecretKeySpec(
                    key.getBytes(DEFAULT_ENCODING),
                    HMAC_SHA512);

            Mac mac = Mac.getInstance(HMAC_SHA512);
            mac.init(keySpec);

            final byte[] macData = mac.doFinal( value.getBytes( ) );
            byte[] hex = new Hex().encode( macData );

            //return mac.doFinal(value.getBytes(DEFAULT_ENCODING));
            return hex;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO relocate this method
    private String asHex(byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }

    private String formBodyToQueryParameters(FormBody body) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i < body.size(); ++i) {
            stringBuilder.append(body.encodedName(i));
            stringBuilder.append('=');
            stringBuilder.append(body.encodedValue(i));
            stringBuilder.append('&');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        return stringBuilder.toString();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl url = request.url();

        // public API 는 Auth 설정이 불필요하다.
        if ( ! url.encodedPath().startsWith("/public/") ) {
            String nonce = String.valueOf(System.currentTimeMillis());
            String endpoint = url.encodedPath();

            // 이미 FormBody 인 경우와 contentLength == 0 인 경우
            FormBody.Builder formbodyBuilder = new FormBody.Builder();
            formbodyBuilder.add("endpoint", endpoint);
            if ( request.body().contentLength() != 0 ) {
                // TODO add previous form body
            }
            FormBody formbody = formbodyBuilder.build();
            String queryParameters = formBodyToQueryParameters(formbody);
            String str = endpoint + ";" + queryParameters + ";" + nonce;
            String encoded = asHex(hmacSha512(str, secretKey));

            request = request.newBuilder()
                    .header("api-client-type", "2")
                    .header("Api-Key", apiKey)
                    .header("Api-Sign", encoded)
                    .header("Api-Nonce", nonce)
                    .post(formbody)
                    .build();
        }

        return chain.proceed(request);
    }
}

package net.iizs.btc.bithumbtrader;

import net.iizs.btc.bithumbtrader.model.Balance;
import net.iizs.btc.bithumbtrader.model.OrderBook;
import net.iizs.btc.bithumbtrader.model.RecentTransactions;
import net.iizs.btc.bithumbtrader.model.Ticker;
import net.iizs.btc.bithumbtrader.service.BithumbApiService;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;
import retrofit2.Response;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BithumbApiServiceTests {
    @Autowired
    private BithumbApiService bithumbApiService;

    @Test
    public void testGetTicker() throws IOException {
        Call<Ticker> call = bithumbApiService.getTicker("BTC");
        Response<Ticker> response = call.execute();

        Ticker ticker = response.body();
        System.out.println(ticker);
        assertEquals("0000", ticker.getStatus());
    }

    @Test
    public void testGetOrderBook() throws IOException {
        Call<OrderBook> call = bithumbApiService.getOrderBook("BTC");
        Response<OrderBook> response = call.execute();

        OrderBook orderBook = response.body();
        System.out.println(orderBook);
        assertEquals("0000", orderBook.getStatus());
    }

    @Test
    public void testGetRecentTransactions() throws IOException {
        Call<RecentTransactions> call = bithumbApiService.getRecentTransactions("BTC");
        Response<RecentTransactions> response = call.execute();

        RecentTransactions recentTransactions = response.body();
        System.out.println(recentTransactions);
        assertEquals("0000", recentTransactions.getStatus());
    }

    public static byte[] hmacSha512(String value, String key) {
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

    public static String asHex(byte[] bytes) {
        return new String(Base64.encodeBase64(bytes));
    }

    // Defined via command line
    @Value("${net.iizs.btc.bithumbtrader.secretkey}")
    private String secretKey;

    @Test
    public void testGetBalance() throws IOException {
        String apiKey = "daa741e25086439672a1ee123f8dbe87";

        String nonce = String.valueOf(System.currentTimeMillis());
        String endpoint = "/info/balance";
        String str = "/info/balance" + ";" + "endpoint=%2Finfo%2Fbalance" + ";" + nonce;

        String encoded = asHex(hmacSha512(str, secretKey));

        System.out.println(apiKey);
        System.out.println(encoded);
        System.out.println(nonce);

        Call<Balance> call = bithumbApiService.getBalance(apiKey, encoded, nonce, endpoint);
        Response<Balance> response = call.execute();


        Balance balance = response.body();
        System.out.println(balance);
//        System.out.println(response.errorBody().string());

        assertEquals("0000", balance.getStatus());
    }
}

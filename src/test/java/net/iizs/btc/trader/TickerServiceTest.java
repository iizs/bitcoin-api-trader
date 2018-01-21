package net.iizs.btc.trader;

import net.iizs.btc.trader.model.TickerInput;
import net.iizs.btc.trader.service.TickerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TickerServiceTest {
    @Autowired
    private TickerService tickerSerivce;

    private class DummyTickerInput implements TickerInput {
        private String exchangeName;
        private String currency;
        private long currentPrice;
        private Random random;
        private long timestamp;

        public DummyTickerInput(String exchangeName, String currency) {
            this.exchangeName = exchangeName;
            this.currency = currency;
            this.random = new Random();
            this.currentPrice = Math.abs(random.nextLong());
            this.timestamp = System.currentTimeMillis() / 1000L;
        }

        @Override
        public String getCurrency() {
            return this.currency;
        }

        @Override
        public long getTimestamp() {
            return 0;
        }

        @Override
        public long getCurrentPrice() {
            return this.currentPrice;
        }

        @Override
        public String getExchangeName() {
            return this.exchangeName;
        }

        public void next() {
            this.currentPrice = Math.abs(random.nextLong());
            this.timestamp += 1;
        }
    }

    private static long getAvreage(List<Long> list) {
        BigInteger sum = new BigInteger("0");

        for (Long l: list) {
            sum = sum.add(BigInteger.valueOf(l.longValue()));
        }

        BigInteger avr = sum.divide(BigInteger.valueOf(list.size()));
        //System.out.println(list);
        //System.out.println(avr);
        return avr.longValue();
    }

    @Test
    public void testFeedingData() {
        TickerInput tickerInputOneXrp = new DummyTickerInput("one", "xrp");
        TickerInput tickerInputTwoXrp = new DummyTickerInput("two", "xrp");
        TickerInput tickerInputOneBtc = new DummyTickerInput("one", "btc");

        List<Long> valuesOneXrp = new ArrayList<>();
        List<Long> valuesTwoXrp = new ArrayList<>();
        List<Long> valuesOneBtc = new ArrayList<>();

        int feedCount = 200;
        for (int i=0; i<feedCount; ++i) {
            tickerSerivce.add(tickerInputOneBtc);
            tickerSerivce.add(tickerInputOneXrp);
            tickerSerivce.add(tickerInputTwoXrp);

            valuesOneBtc.add(tickerInputOneBtc.getCurrentPrice());
            valuesOneXrp.add(tickerInputOneXrp.getCurrentPrice());
            valuesTwoXrp.add(tickerInputTwoXrp.getCurrentPrice());

            ((DummyTickerInput) tickerInputOneBtc).next();
            ((DummyTickerInput) tickerInputOneXrp).next();
            ((DummyTickerInput) tickerInputTwoXrp).next();
        }

        long avrOneXrp5 = getAvreage(valuesOneXrp.subList(feedCount - 5, feedCount));
        long avrOneXrp20 = getAvreage(valuesOneXrp.subList(feedCount - 20, feedCount));
        long avrOneXrp90 = getAvreage(valuesOneXrp.subList(feedCount - 90, feedCount));
        long avrOneXrp120 = getAvreage(valuesOneXrp.subList(feedCount - 120, feedCount));

        long avrTwoXrp5 = getAvreage(valuesTwoXrp.subList(feedCount - 5, feedCount));
        long avrTwoXrp20 = getAvreage(valuesTwoXrp.subList(feedCount - 20, feedCount));
        long avrTwoXrp90 = getAvreage(valuesTwoXrp.subList(feedCount - 90, feedCount));
        long avrTwoXrp120 = getAvreage(valuesTwoXrp.subList(feedCount - 120, feedCount));

        long avrOneBtc5 = getAvreage(valuesOneBtc.subList(feedCount - 5, feedCount));
        long avrOneBtc20 = getAvreage(valuesOneBtc.subList(feedCount - 20, feedCount));
        long avrOneBtc90 = getAvreage(valuesOneBtc.subList(feedCount - 90, feedCount));
        long avrOneBtc120 = getAvreage(valuesOneBtc.subList(feedCount - 120, feedCount));

        assertEquals(avrOneBtc5, tickerSerivce.getLast("one", "btc").getMovingAverage5CurrentPrice());
        assertEquals(avrOneBtc20, tickerSerivce.getLast("one", "btc").getMovingAverage20CurrentPrice());
        assertEquals(avrOneBtc90, tickerSerivce.getLast("one", "btc").getMovingAverage90CurrentPrice());
        assertEquals(avrOneBtc120, tickerSerivce.getLast("one", "btc").getMovingAverage120CurrentPrice());

        assertEquals(avrOneXrp5, tickerSerivce.getLast("one", "xrp").getMovingAverage5CurrentPrice());
        assertEquals(avrOneXrp20, tickerSerivce.getLast("one", "xrp").getMovingAverage20CurrentPrice());
        assertEquals(avrOneXrp90, tickerSerivce.getLast("one", "xrp").getMovingAverage90CurrentPrice());
        assertEquals(avrOneXrp120, tickerSerivce.getLast("one", "xrp").getMovingAverage120CurrentPrice());

        assertEquals(avrTwoXrp5, tickerSerivce.getLast("two", "xrp").getMovingAverage5CurrentPrice());
        assertEquals(avrTwoXrp20, tickerSerivce.getLast("two", "xrp").getMovingAverage20CurrentPrice());
        assertEquals(avrTwoXrp90, tickerSerivce.getLast("two", "xrp").getMovingAverage90CurrentPrice());
        assertEquals(avrTwoXrp120, tickerSerivce.getLast("two", "xrp").getMovingAverage120CurrentPrice());
    }
}

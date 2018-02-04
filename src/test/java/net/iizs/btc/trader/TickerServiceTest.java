package net.iizs.btc.trader;

import net.iizs.btc.trader.model.*;
import net.iizs.btc.trader.service.TickerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private int feedCount;
    private List<TickerInput> feedValuesOneXrp;
    private List<TickerInput> feedValuesTwoXrp;
    private List<TickerInput> feedValuesOneBtc;

    private static final Logger log = LoggerFactory.getLogger(TickerServiceTest.class);

    private class DummyTickerInput implements TickerInput {
        private String exchangeName;
        private String currency;
        private long currentPrice;
        private Random random;
        private long timestamp;

        public DummyTickerInput(TickerInput tickerInput) {
            this.exchangeName = tickerInput.getExchangeName();
            this.currency = tickerInput.getCurrency();
            this.currentPrice = tickerInput.getCurrentPrice();
            this.timestamp = tickerInput.getTimestamp();
        }

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

    private static long getAvreage(List<TickerInput> list) {
        BigInteger sum = new BigInteger("0");

        for (TickerInput l: list) {
            sum = sum.add(BigInteger.valueOf(l.getCurrentPrice()));
        }

        BigInteger avr = sum.divide(BigInteger.valueOf(list.size()));

        return avr.longValue();
    }

    // JUnit4 test fixture
    // https://github.com/junit-team/junit4/wiki/Test-fixtures

    @Before
    public void setUp() {
        TickerInput tickerInputOneXrp;
        TickerInput tickerInputTwoXrp;
        TickerInput tickerInputOneBtc;

        tickerInputOneXrp = new DummyTickerInput("one", "xrp");
        tickerInputTwoXrp = new DummyTickerInput("two", "xrp");
        tickerInputOneBtc = new DummyTickerInput("one", "btc");

        feedValuesOneXrp = new ArrayList<>();
        feedValuesTwoXrp = new ArrayList<>();
        feedValuesOneBtc = new ArrayList<>();

        feedCount = 200;

        for (int i=0; i<feedCount; ++i) {
            tickerSerivce.add(tickerInputOneBtc);
            tickerSerivce.add(tickerInputOneXrp);
            tickerSerivce.add(tickerInputTwoXrp);

            feedValuesOneBtc.add(new DummyTickerInput(tickerInputOneBtc));
            feedValuesOneXrp.add(new DummyTickerInput(tickerInputOneXrp));
            feedValuesTwoXrp.add(new DummyTickerInput(tickerInputTwoXrp));

            ((DummyTickerInput) tickerInputOneBtc).next();
            ((DummyTickerInput) tickerInputOneXrp).next();
            ((DummyTickerInput) tickerInputTwoXrp).next();
        }
    }

    @After
    public void tearDown() {
        tickerSerivce.reset();
    }


    @Test
    public void testFeedingData() {
        long avrOneXrp5 = getAvreage(feedValuesOneXrp.subList(feedCount - 5, feedCount));
        long avrOneXrp20 = getAvreage(feedValuesOneXrp.subList(feedCount - 20, feedCount));
        long avrOneXrp90 = getAvreage(feedValuesOneXrp.subList(feedCount - 90, feedCount));
        long avrOneXrp120 = getAvreage(feedValuesOneXrp.subList(feedCount - 120, feedCount));

        long avrTwoXrp5 = getAvreage(feedValuesTwoXrp.subList(feedCount - 5, feedCount));
        long avrTwoXrp20 = getAvreage(feedValuesTwoXrp.subList(feedCount - 20, feedCount));
        long avrTwoXrp90 = getAvreage(feedValuesTwoXrp.subList(feedCount - 90, feedCount));
        long avrTwoXrp120 = getAvreage(feedValuesTwoXrp.subList(feedCount - 120, feedCount));

        long avrOneBtc5 = getAvreage(feedValuesOneBtc.subList(feedCount - 5, feedCount));
        long avrOneBtc20 = getAvreage(feedValuesOneBtc.subList(feedCount - 20, feedCount));
        long avrOneBtc90 = getAvreage(feedValuesOneBtc.subList(feedCount - 90, feedCount));
        long avrOneBtc120 = getAvreage(feedValuesOneBtc.subList(feedCount - 120, feedCount));

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

    @Test
    public void testGetRecentValues() {
        List<TickerValue> tickerValues;

        int testSize = 100;

        tickerValues = tickerSerivce.getRecentValues("one", "btc", testSize);
        assertEquals(testSize, tickerValues.size());

        List<TickerInput> feedValues = feedValuesOneBtc.subList(feedCount - testSize, feedCount);

        for (int i=0; i<testSize; ++i) {
            assertEquals(feedValues.get(i).getCurrentPrice(), tickerValues.get(i).getCurrentPrice());
        }
    }

    @Test
    public void testGetStatus() {
        TickerServiceStatus serivceStatus = tickerSerivce.getStatus();

        assertEquals(3, serivceStatus.getTickerSize());
        assertEquals( feedValuesTwoXrp.get(feedCount-1).getTimestamp(), serivceStatus.getLastUpdateTimestamp());
        assertEquals(feedCount * 3, serivceStatus.getTickerValuesSize());

        TickerStatus tickerStatus = serivceStatus.getTickerStatus().get("two").get("xrp");
        assertEquals("two", tickerStatus.getExchangeName());
        assertEquals("xrp", tickerStatus.getCurrency());
        assertEquals( feedValuesTwoXrp.get(feedCount-1).getTimestamp(), tickerStatus.getLastUpdateTimestamp());
        assertEquals( feedValuesTwoXrp.size(), tickerStatus.getSize());
    }

    @Test
    public void testGetTickers() {
        List<Ticker> tickers;
        int size = 100;

        // 모두 반환. 총 3개
        tickers = tickerSerivce.getTickers((String e, String c) -> true, size);
        assertEquals(3, tickers.size());

        // currency == "xrp"만 반환. 2개
        tickers = tickerSerivce.getTickers((String e, String c) -> c.equals("xrp"), size);
        assertEquals(2, tickers.size());
        for(Ticker t : tickers) {
            assertEquals("xrp", t.getCurrency());
        }

        // exchange name == "one"만 반환. 2개
        tickers = tickerSerivce.getTickers((String e, String c) -> e.equals("one"), size);
        assertEquals(2, tickers.size());
        for(Ticker t : tickers) {
            assertEquals("one", t.getExchangeName());
        }

        // exchange name == "one" && currency == "xrp"만 반환. 1개
        tickers = tickerSerivce.getTickers((String e, String c) -> e.equals("one") && c.equals("xrp"), size);
        assertEquals(1, tickers.size());
        for(Ticker t : tickers) {
            assertEquals("one", t.getExchangeName());
            assertEquals("xrp", t.getCurrency());
        }

    }
}

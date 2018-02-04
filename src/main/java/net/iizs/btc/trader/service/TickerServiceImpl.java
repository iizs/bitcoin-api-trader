package net.iizs.btc.trader.service;

import net.iizs.btc.trader.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TickerServiceImpl implements TickerService {
    private static final long MAX_DEQUE_CAPACITY = TimeUnit.DAYS.toSeconds(1);
    private static final Logger log = LoggerFactory.getLogger(TickerServiceImpl.class);

    private Map<String, Map<String, Deque<TickerValue>>> exchangeMap;
    private TickerServiceStatus tickerServiceStatus;

    public TickerServiceImpl() {
        exchangeMap = new HashMap<>();
        tickerServiceStatus = new TickerServiceStatus();
    }

    @Override
    public void add(TickerInput input) {
        Map<String, Deque<TickerValue>> currencyMap = exchangeMap.get(input.getExchangeName());
        if (currencyMap == null) {
            currencyMap = new HashMap<>();
            exchangeMap.put(input.getExchangeName(), currencyMap);
        }

        Deque<TickerValue> tickerValueDeque = currencyMap.get(input.getCurrency());
        if (tickerValueDeque == null) {
            tickerValueDeque = initializeDeque();
            currencyMap.put(input.getCurrency(), tickerValueDeque);
        }

        if (tickerValueDeque.size() == MAX_DEQUE_CAPACITY) {
            tickerValueDeque.removeFirst();
        }

        TickerValue tickerValue = makeTickerValue(input, tickerValueDeque);
        tickerValueDeque.add(tickerValue);
    }

    @Override
    public TickerValue getLast(String exchangeName, String currency) {
        try {
            return exchangeMap.get(exchangeName).get(currency).getLast();
        } catch ( NullPointerException e ) {
            if ( exchangeMap.get(exchangeName) == null || exchangeMap.get(exchangeName).get(currency) == null ) {
                throw new NoSuchElementException("Could not find exchangeName = " + exchangeName + ", currency = " + currency );
            }
            throw e;
        }
    }

    private TickerValue makeTickerValue(TickerInput input, Deque<TickerValue> tickerValueDeque) {
        TickerValue v = new TickerValue();

        v.setTimestamp(input.getTimestamp());
        v.setCurrentPrice(input.getCurrentPrice());
        v.setMovingAverage5CurrentPrice(0);
        v.setMovingAverage20CurrentPrice(0);
        v.setMovingAverage90CurrentPrice(0);
        v.setMovingAverage120CurrentPrice(0);

        // Calculate moving averages including this value
        Iterator<TickerValue> iter = tickerValueDeque.descendingIterator();
        int size = 1;
        BigInteger sum = BigInteger.valueOf(input.getCurrentPrice());
        while_loop:
        while( iter.hasNext() ) {
            TickerValue i = iter.next();
            sum = sum.add(BigInteger.valueOf(i.getCurrentPrice()));
            size += 1;

            switch ( size ) {
                case 5:
                    v.setMovingAverage5CurrentPrice(sum.divide(BigInteger.valueOf(5)).longValue());
                    break;
                case 20:
                    v.setMovingAverage20CurrentPrice(sum.divide(BigInteger.valueOf(20)).longValue());
                    break;
                case 90:
                    v.setMovingAverage90CurrentPrice(sum.divide(BigInteger.valueOf(90)).longValue());
                    break;
                case 120:
                    v.setMovingAverage120CurrentPrice(sum.divide(BigInteger.valueOf(120)).longValue());
                    break while_loop;
            }
        }

        return v;
    }

    private Deque<TickerValue> initializeDeque() {
        return new ArrayDeque<>((int) MAX_DEQUE_CAPACITY);
    }

    @Override
    public List<TickerValue> getRecentValues(String exchangeName, String currency, int size) {
        try {
            Deque<TickerValue> deque =  exchangeMap.get(exchangeName).get(currency);
            List<TickerValue> list = new ArrayList<>(size);

            Iterator<TickerValue> iter = deque.descendingIterator();
            int cnt = 0;
            while( iter.hasNext() && cnt < size ) {
                TickerValue i = iter.next();
                list.add(0, i);
                cnt += 1;
            }

            return list;
        } catch ( NullPointerException e ) {
            if ( exchangeMap.get(exchangeName) == null || exchangeMap.get(exchangeName).get(currency) == null ) {
                throw new NoSuchElementException("Could not find exchangeName = " + exchangeName + ", currency = " + currency);
            }
            throw e;
        }
    }

    @Override
    public TickerServiceStatus getStatus() {
        synchronized ( tickerServiceStatus ) {
            long tickerValuesSize = 0;

            for (Map.Entry<String, Map<String, Deque<TickerValue>>> exchangeEntry : exchangeMap.entrySet()) {
                for (Map.Entry<String, Deque<TickerValue>> currencyEntry : exchangeEntry.getValue().entrySet()) {
                    Deque<TickerValue> values = currencyEntry.getValue();
                    long lastUpdateTimestamp = values.getLast().getTimestamp();

                    TickerStatus tickerStatus = new TickerStatus();
                    tickerStatus.setExchangeName(exchangeEntry.getKey());
                    tickerStatus.setCurrency(currencyEntry.getKey());
                    tickerStatus.setLastUpdateTimestamp(lastUpdateTimestamp);
                    tickerStatus.setSize(values.size());

                    tickerValuesSize += values.size();

                    tickerServiceStatus.addTickerStatus(exchangeEntry.getKey(), currencyEntry.getKey(), tickerStatus);

                    if (lastUpdateTimestamp > tickerServiceStatus.getLastUpdateTimestamp()) {
                        tickerServiceStatus.setLastUpdateTimestamp(lastUpdateTimestamp);
                    }
                }
            }

            tickerServiceStatus.setTickerValuesSize(tickerValuesSize);

            return tickerServiceStatus;
        }
    }

    @Override
    public List<Ticker> getTickers(TickerFilter tickerFilter, int size) {
        List<Ticker> tickers = new ArrayList<>();

        for (Map.Entry<String, Map<String, Deque<TickerValue>>> exchangeEntry : exchangeMap.entrySet()) {
            for (Map.Entry<String, Deque<TickerValue>> currencyEntry : exchangeEntry.getValue().entrySet()) {
                if ( tickerFilter.filter(exchangeEntry.getKey(), currencyEntry.getKey() ) )  {
                    Ticker ticker = new Ticker();
                    ticker.setExchangeName(exchangeEntry.getKey());
                    ticker.setCurrency(currencyEntry.getKey());
                    ticker.setValues(getRecentValues(ticker.getExchangeName(), ticker.getCurrency(), size));
                    tickers.add(ticker);
                }
            }
        }

        return tickers;
    }
}

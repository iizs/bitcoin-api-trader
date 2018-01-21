package net.iizs.btc.trader.service;

import net.iizs.btc.trader.model.TickerInput;
import net.iizs.btc.trader.model.TickerValue;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TickerServiceImpl implements TickerService {
    private Map<String, Map<String, Deque<TickerValue>>> exchangeMap;
    private static final long MAX_DEQUE_CAPACITY = TimeUnit.DAYS.toSeconds(1);

    public TickerServiceImpl() {
        exchangeMap = new HashMap<>();
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
                return null;
            }
            throw e;
        }
    }

    private TickerValue makeTickerValue(TickerInput input, Deque<TickerValue> tickerValueDeque) {
        TickerValue v = new TickerValue();

        v.setExchangeName(input.getExchangeName());
        v.setCurrency(input.getCurrency());
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

}

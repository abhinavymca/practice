package com.practice.dsa.algo;

import java.math.BigDecimal;
import java.util.*;

public class PriorityQueueTest {

    public static void main(String[] args) {
        List<SDCurrency> map = new ArrayList<>();
        map.add(new SDCurrency("GBP", "USD", BigDecimal.ONE));
        map.add(new SDCurrency("GBP", "YEN",BigDecimal.valueOf(2)));
        map.add(new SDCurrency("GBP", "INR", BigDecimal.valueOf(3)));
        map.add(new SDCurrency("GBP", "EURO", BigDecimal.valueOf(4)));

        PriorityQueue<SDCurrency> sorted = new PriorityQueue<>((a,b)->{
           if(a.bg.compareTo(b.bg)<0) return -1;
           else if(a.bg.compareTo(b.bg)>0) return 1;
           else return 0;
        });
        for(int i=0;i<map.size();i++){
            sorted.add(map.get(i));
            if(sorted.size()>3)
                sorted.poll();
        }

        sorted.forEach(System.out::println);
    }


    public static class SDCurrency{
        String source;
        String destination;

        BigDecimal bg;

        public SDCurrency() {
        }

        public SDCurrency(String source, String destination, BigDecimal bg) {
            this.source = source;
            this.destination = destination;
            this.bg=bg;
        }


        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof SDCurrency)) return false;
            SDCurrency that = (SDCurrency) o;
            return Objects.equals(getSource(), that.getSource()) && Objects.equals(getDestination(), that.getDestination());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getSource(), getDestination());
        }

        @Override
        public String toString() {
            return "SDCurrency{" +
                    "source='" + source + '\'' +
                    ", destination='" + destination + '\'' +
                    ", bg=" + bg +
                    '}';
        }
    }
}

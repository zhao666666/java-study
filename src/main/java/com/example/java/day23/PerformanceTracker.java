package com.example.java.day23;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhaojie
 * @Date: 2022/1/18 15:00
 * @Version: 1.0
 * @Description:
 */
public class PerformanceTracker {
    private static class Phase {
        private String name;
        private long duration;

        public Phase(String name, long duration) {
            this.name = name;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return "Phase{" +
                    "name='" + name + '\'' +
                    ", duration=" + duration +
                    '}';
        }
    }
    // ThreadLocal 找不到是找下一个空闲位置
    private static final ThreadLocal<List<Phase>> PHASES = new ThreadLocal<>();
    private static final ThreadLocal<Long> PHASE_START_TIME = new ThreadLocal<>();

    public static void reset() {
        PHASES.set(new ArrayList<Phase>());
        PHASE_START_TIME.set(-1L);
    }

    public static void startPhase() {
        PHASE_START_TIME.set(System.currentTimeMillis());
    }

    public static void endPhase(String phaseName) {
        long start = PHASE_START_TIME.get();
        PHASES.get().add(new Phase(phaseName, System.currentTimeMillis() - start));
    }


    public static void finish() {
        List<Phase> phases = PHASES.get();
        PHASES.set(null);
        PHASE_START_TIME.set(null);
        StringBuffer buffer = new StringBuffer("Thread Execution Phase Durartions");
        phases.forEach(buffer::append);
        buffer.append("\n");
        System.out.println(buffer.toString());

    }
}

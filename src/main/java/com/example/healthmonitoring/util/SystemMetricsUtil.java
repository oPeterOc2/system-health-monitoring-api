package com.example.healthmonitoring.util;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.*;

public class SystemMetricsUtil {

    public static double getProcessCpuLoad() {
        try {
            OperatingSystemMXBean os =
                    (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            double v = os.getProcessCpuLoad();
            return v < 0 ? 0.0 : v;
        } catch (Exception e) {
            return 0.0;
        }
    }

    public static double getSystemCpuLoad() {
        try {
            OperatingSystemMXBean os =
                    (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            double v = os.getSystemCpuLoad();
            return v < 0 ? 0.0 : v;
        } catch (Exception e) {
            return 0.0;
        }
    }

    public static long getHeapUsed() {
        MemoryUsage heap = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        return heap.getUsed();
    }

    public static long getHeapMax() {
        MemoryUsage heap = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        return heap.getMax();
    }

    public static long getNonHeapUsed() {
        MemoryUsage nonHeap = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
        return nonHeap.getUsed();
    }

    public static long getNonHeapMax() {
        MemoryUsage nonHeap = ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage();
        return nonHeap.getMax();
    }

    public static double getLoadAvg(int index) {
        double[] load = ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage() >= 0
                ? new double[]{ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage(), 0, 0}
                : new double[]{0, 0, 0};
        return load[index];
    }

    public static long getYoungGcCount() {
        return getGcCount("Young");
    }

    public static long getOldGcCount() {
        return getGcCount("Old");
    }

    private static long getGcCount(String keyword) {
        return ManagementFactory.getGarbageCollectorMXBeans().stream()
                .filter(gc -> gc.getName().contains(keyword))
                .mapToLong(GarbageCollectorMXBean::getCollectionCount)
                .sum();
    }

    public static int getThreadCount() {
        return ManagementFactory.getThreadMXBean().getThreadCount();
    }

    public static long getUptime() {
        return ManagementFactory.getRuntimeMXBean().getUptime();
    }
}

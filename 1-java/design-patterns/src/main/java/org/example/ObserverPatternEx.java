package org.example;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class DoorEvent {
    private int doorNumber;
    private int floorNumber;

    public DoorEvent(int doorNumber, int floorNumber) {
        this.doorNumber = doorNumber;
        this.floorNumber = floorNumber;
    }

    public int getDoorNumber() {
        return doorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}

interface DoorListener {
    void on(DoorEvent event);

    void off(DoorEvent event);
}


class Light implements DoorListener {
    public void on(DoorEvent event) {
        System.out.println("Light is on - d:" + event.getDoorNumber() + ", f:" + event.getFloorNumber());
    }

    public void off(DoorEvent event) {
        System.out.println("Light is off - d:" + event.getDoorNumber() + ", f:" + event.getFloorNumber());
    }
}

class Fan implements DoorListener {
    public void on(DoorEvent event) {
        System.out.println("Fan is on - d:" + event.getDoorNumber() + ", f:" + event.getFloorNumber());
    }

    public void off(DoorEvent event) {
        System.out.println("Fan is off - d:" + event.getDoorNumber() + ", f:" + event.getFloorNumber());
    }
}

class AC implements DoorListener {
    public void on(DoorEvent event) {
        System.out.println("AC is on - d:" + event.getDoorNumber() + ", f:" + event.getFloorNumber());
    }

    public void off(DoorEvent event) {
        System.out.println("AC is off - d:" + event.getDoorNumber() + ", f:" + event.getFloorNumber());
    }
}


class Door {
    private final List<DoorListener> doorListeners = new ArrayList<>();

    public void addListener(DoorListener listener) {
        doorListeners.add(listener);
    }

    public void removeListener(DoorListener listener) {
        doorListeners.remove(listener);
    }

    public void open() {
        System.out.println("Door is open");
        for (DoorListener listener : doorListeners) {
            listener.on(new DoorEvent(1, 1));
        }
    }

    public void close() {
        System.out.println("Door is closed");
        for (DoorListener listener : doorListeners) {
            listener.off(new DoorEvent(1, 1));
        }
    }
}


public class ObserverPatternEx {
    public static void main(String[] args) throws InterruptedException {
        Door door1 = new Door();
        door1.addListener(new Light());
        door1.addListener(new Fan());
        AC ac = new AC();
        door1.addListener(ac);

        TimeUnit.SECONDS.sleep(3);
        door1.open();
        TimeUnit.SECONDS.sleep(3);
        door1.close();

        // winter season
        door1.removeListener(ac);

        TimeUnit.SECONDS.sleep(3);
        door1.open();
        TimeUnit.SECONDS.sleep(3);
        door1.close();

    }
}
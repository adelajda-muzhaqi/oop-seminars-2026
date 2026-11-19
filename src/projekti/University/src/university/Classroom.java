package university;

public class Classroom {

    private final String roomNumber;
    private final String building;
    private final int capacity;
    private boolean hasProjector;

    public Classroom(String roomNumber, String building, int capacity, boolean hasProjector) {
        this.roomNumber = requireText(roomNumber, "Room number");
        this.building = requireText(building, "Building");
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero: " + capacity);
        }
        this.capacity = capacity;
        this.hasProjector = hasProjector;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getBuilding() {
        return building;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean hasProjector() {
        return hasProjector;
    }
    public void setHasProjector(boolean hasProjector) {
        this.hasProjector = hasProjector;
    }

    public boolean canAccommodate(int numberOfStudents) {
        if (numberOfStudents < 0) {
            throw new IllegalArgumentException("Number of students cannot be negative: " + numberOfStudents);
        }
        return numberOfStudents <= capacity;
    }

    public boolean isLargeRoom() {
        return capacity > 50;
    }

    public String location() {
        return "Building " + building + ", Room " + roomNumber;
    }

    private static String requireText(String value, String label) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(label + " must not be blank: \"" + value + "\"");
        }
        return value;
    }

    @Override
    public String toString() {
        return location() + " (" + capacity + " seats" + (hasProjector ? ", projector" : "") + ")";
    }
} 
package lab6;

import lab5.Appliance;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Arrays;

public class ApplianceSet implements Set<Appliance> {
    private Appliance[] appliances;
    private int size;
    private static final int INITIAL_CAPACITY = 15;
    private static final double GROWTH_FACTOR = 1.3;

    // Default constructor
    public ApplianceSet() {
        appliances = new Appliance[INITIAL_CAPACITY];
        size = 0;
    }

    // Constructor with one Appliance
    public ApplianceSet(Appliance appliance) {
        this(); // Call the default constructor
        if (appliance == null) {
            throw new IllegalArgumentException("The appliance cannot be null.");
        }
        add(appliance);
    }

    // Constructor with a Collection of Appliances
    public ApplianceSet(Collection<Appliance> collection) {
        this(); // Call the default constructor
        if (collection == null) {
            throw new IllegalArgumentException("The collection cannot be null.");
        }
        for (Appliance appliance : collection) {
            if (appliance == null) {
                throw new IllegalArgumentException("The collection cannot contain null elements.");
            }
            add(appliance);
        }
    }

    @Override
    public boolean add(Appliance appliance) {
        if (appliance == null) {
            throw new IllegalArgumentException("Cannot add null appliance.");
        }
        if (contains(appliance)) {
            return false; // Don't add if the appliance is already present
        }
        ensureCapacity(); // Ensure there is enough space to add the new appliance
        appliances[size++] = appliance; // Add the appliance to the array
        return true; // Successfully added
    }

    @Override
    public boolean remove(Object o) {
        if (o == null || !(o instanceof Appliance)) {
            return false; // Reject null or incompatible types
        }
        Appliance appliance = (Appliance) o;
        for (int i = 0; i < size; i++) {
            if (appliances[i].equals(appliance)) { // Find the appliance to remove
                appliances[i] = appliances[size - 1]; // Replace it with the last appliance
                appliances[size - 1] = null; // Clear the last spot
                size--;
                return true; // Successfully removed
            }
        }
        return false; // Appliance not found
    }

    @Override
    public boolean contains(Object o) {
        if (o == null || !(o instanceof Appliance)) {
            return false; // Reject null or incompatible types
        }
        Appliance appliance = (Appliance) o;
        for (int i = 0; i < size; i++) {
            if (appliances[i].equals(appliance)) {
                return true; // Found the appliance
            }
        }
        return false; // Not found
    }

    @Override
    public int size() {
        return size; // Return the current size
    }

    @Override
    public boolean isEmpty() {
        return size == 0; // Check if the set is empty
    }

    @Override
    public void clear() {
        Arrays.fill(appliances, null); // Clear the array
        size = 0; // Reset size
    }

    // Ensure the internal array has enough capacity to add a new element
    private void ensureCapacity() {
        if (size >= appliances.length) {
            int newCapacity = (int) (appliances.length * GROWTH_FACTOR);
            appliances = Arrays.copyOf(appliances, newCapacity); // Resize the array
        }
    }

    @Override
    public Iterator<Appliance> iterator() {
        return new Iterator<Appliance>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size; // Check if there are more elements
            }

            @Override
            public Appliance next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the iterator.");
                }
                return appliances[currentIndex++]; // Return the next appliance
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove operation is not supported by this iterator.");
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size]; // Create a new Object array of the current size
        System.arraycopy(appliances, 0, array, 0, size); // Copy elements from the appliances array to the new array
        return array; // Return the new array
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a == null) {
            throw new IllegalArgumentException("Provided array cannot be null.");
        }
        // Check if the provided array is large enough
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        try {
            System.arraycopy(appliances, 0, a, 0, size);
        } catch (ArrayStoreException e) {
            throw new IllegalArgumentException("The provided array type is not compatible.", e);
        }
        // Fill the remaining part of 'a' with null if 'a' was larger than the size
        if (a.length > size) {
            a[size] = null;
        }
        return a; // Return the array of type T
    }

    @Override
    public boolean addAll(Collection<? extends Appliance> c) {
        if (c == null) {
            throw new IllegalArgumentException("The provided collection cannot be null.");
        }
        boolean isModified = false; // Flag to track if any appliances were added
        for (Appliance appliance : c) {
            if (appliance == null) {
                throw new IllegalArgumentException("The collection cannot contain null elements.");
            }
            // Attempt to add each appliance from the collection
            if (add(appliance)) {
                isModified = true; // Set the flag to true if an appliance was added
            }
        }
        return isModified; // Return true if any appliances were added
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            throw new IllegalArgumentException("The provided collection cannot be null.");
        }
        boolean isModified = false;
        for (int i = size - 1; i >= 0; i--) {
            if (!c.contains(appliances[i])) {
                remove(appliances[i]);
                isModified = true;
            }
        }
        return isModified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null) {
            throw new IllegalArgumentException("The provided collection cannot be null.");
        }
        boolean isModified = false; // Flag to track if any appliances were removed
        for (Object obj : c) {
            if (remove(obj)) { // Remove the appliance if it exists
                isModified = true; // Set the flag to true if an appliance was removed
            }
        }
        return isModified; // Return true if any appliances were removed
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            throw new IllegalArgumentException("The provided collection cannot be null.");
        }
        for (Object obj : c) {
            if (!contains(obj)) { // Let contains() handle the instanceof check
                return false;
            }
        }
        return true; // All appliances are contained in the set
    }
}

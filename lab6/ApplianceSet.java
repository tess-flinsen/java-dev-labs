package lab6;

import lab5.Appliance;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Arrays;

/**
 * A typed collection that stores unique {@link Appliance} objects and implements the {@link Set} interface.
 * It uses an internal array structure to store elements with an initial capacity and a growth factor.
 */
public class ApplianceSet implements Set<Appliance> {
    private Appliance[] appliances;
    private int size;
    private static final int INITIAL_CAPACITY = 15;
    private static final double GROWTH_FACTOR = 1.3;

    /**
     * Constructs an empty {@code ApplianceSet} with an initial capacity.
     */
    public ApplianceSet() {
        appliances = new Appliance[INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Constructs an {@code ApplianceSet} containing a single {@link Appliance}.
     *
     * @param appliance the appliance to be added to the set.
     * @throws IllegalArgumentException if the provided appliance is {@code null}.
     */
    public ApplianceSet(Appliance appliance) {
        this();
        if (appliance == null) {
            throw new IllegalArgumentException("The appliance cannot be null.");
        }
        add(appliance);
    }

    /**
     * Constructs an {@code ApplianceSet} containing all elements from the specified collection.
     *
     * @param collection the collection containing appliances to be added.
     * @throws IllegalArgumentException if the collection or any of its elements are {@code null}.
     */
    public ApplianceSet(Collection<Appliance> collection) {
        this();
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

    /**
     * Ensures that the internal array has enough capacity to add a new element.
     * If the current size has reached the array's capacity, it increases the capacity
     * based on the growth factor.
     */
    private void ensureCapacity() {
        if (size >= appliances.length) {
            int newCapacity = (int) (appliances.length * GROWTH_FACTOR);
            appliances = Arrays.copyOf(appliances, newCapacity); // Resize the array
        }
    }

    @Override
    /**
     * Returns an iterator over the elements in this set.
     *
     * @return an iterator over the elements in this set
     */
    public Iterator<Appliance> iterator() {
        return new Iterator<Appliance>() {
            private int currentIndex = 0;

            @Override
            /**
             * Checks if the iterator has more elements.
             *
             * @return {@code true} if there are more elements, {@code false} otherwise
             */
            public boolean hasNext() {
                return currentIndex < size; // Check if there are more elements
            }

            @Override
            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws NoSuchElementException if the iteration has no more elements
             */
            public Appliance next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the iterator.");
                }
                return appliances[currentIndex++]; // Return the next appliance
            }

            @Override
            /**
             * Unsupported operation for this iterator.
             *
             * @throws UnsupportedOperationException always thrown as this operation is not supported
             */
            public void remove() {
                throw new UnsupportedOperationException("Remove operation is not supported by this iterator.");
            }
        };
    }

    @Override
    /**
     * Returns an array containing all of the elements in this set.
     *
     * @return an array containing all of the elements in this set
     */
    public Object[] toArray() {
        Object[] array = new Object[size]; // Create a new Object array of the current size
        System.arraycopy(appliances, 0, array, 0, size); // Copy elements from the appliances array to the new array
        return array; // Return the new array
    }

    @Override
    @SuppressWarnings("unchecked")
    /**
     * Returns an array containing all of the elements in this set.
     * The runtime type of the returned array is that of the specified array.
     *
     * @param <T> the type of elements in the array
     * @param a the array into which the elements of the set are to be stored, if it is big enough;
     *          otherwise, a new array of the same runtime type is allocated for this purpose.
     * @return an array containing the elements of the set
     * @throws IllegalArgumentException if the provided array is null or of incompatible type
     */
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
    /**
     * Adds all of the elements in the specified collection to this set if they're not already present.
     *
     * @param c the collection containing elements to be added to this set
     * @return {@code true} if this set changed as a result of the call
     * @throws IllegalArgumentException if the specified collection is null or contains null elements
     */
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
    /**
     * Retains only the elements in this set that are contained in the specified collection.
     *
     * @param c collection containing elements to be retained in this set
     * @return {@code true} if this set changed as a result of the call
     * @throws IllegalArgumentException if the specified collection is null
     */
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
    /**
     * Removes from this set all of its elements that are contained in the specified collection.
     *
     * @param c collection containing elements to be removed from this set
     * @return {@code true} if this set changed as a result of the call
     * @throws IllegalArgumentException if the specified collection is null
     */
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
    /**
     * Returns {@code true} if this set contains all of the elements in the specified collection.
     *
     * @param c collection to be checked for containment in this set
     * @return {@code true} if this set contains all of the elements in the specified collection
     * @throws IllegalArgumentException if the specified collection is null
     */
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
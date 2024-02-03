import java.util.Arrays;

public class DynamicArray {
    private Person[] peopleArray;
    private int capacity;

    private final int initialSize = 10;

    public DynamicArray() {
        peopleArray = new Person[initialSize];
        capacity = initialSize;
        System.out.println("Dynamic Array created with initial size: " + initialSize);
    }

    // get(index) method to return person at index
    public Person get(int index) {
        return peopleArray[index];
    }

    // set(index, person) method to set person at index
    public void set(int index, Person person) {
        peopleArray[index] = person;
        printArray();
    }

    // add person to array
    public void add(Person person) {
        if (capacity != 0) {
            // find the first null element in the array and add the person to that index - then decrement capacity
            for (int i = 0; i < peopleArray.length; i++) {
                if (peopleArray[i] == null) {
                    peopleArray[i] = person;
                    capacity--;
                    break;
                }
            }
            printArray();
        } else {
            extendCapacity();
            add(person);
        }
    }

    // add multiple person objects to the array
    public void add(Person... people) {
        for (Person person : people) {
            add(person);
        }
    }

    // insert person at index and shift elements to the right
    public void insert(int index, Person person) {
        if (capacity != 0) {
            // shift elements to the right from index to end of array
            for (int i = peopleArray.length - 1; i > index; i--) {
                peopleArray[i] = peopleArray[i - 1];
            }
            // insert person at index
            peopleArray[index] = person;
            capacity--;
            printArray();
        } else {
            extendCapacity();
            insert(index, person);
        }
    }

    // remove method to remove the last person from the array
    public void remove() {
        int lastPerson = elementsInArray(peopleArray) - 1;

        if (elementsInArray(peopleArray) > 0) {
            peopleArray[lastPerson] = null;
            capacity++;
            printArray();
        } else {
            System.out.println("No person to remove");
        }
        printArray();
        if (capacity >= 10) {
            reduceCapacity();
        }
    }

    // remove(index) from array
    public void remove(int index) {
        if (peopleArray[index] != null) {
            peopleArray[index] = null;
            capacity++;
            printArray();
        } else {
            System.out.println("No person at index " + index);
        }

        if (canReduceCapacity()) {
            reduceCapacity();
        }
    }

    public void remove(Person person) {
        int index = indexOf(person);
        if (index != -1) {
            remove(index);
            // shift elements to the left from index to end of array
            for (int i = index; i < peopleArray.length - 1; i++) {
                peopleArray[i] = peopleArray[i + 1];
            }
        } else {
            System.out.println("Person not found");
        }
    }

    // indexOf(person) method to return index of person
    public int indexOf(Person person) {
        for (int i = 0; i < peopleArray.length; i++) {
            if (peopleArray[i] != null && peopleArray[i].equals(person)) {
                return i;
            }
        }
        return -1;
    }

    // double the capacity of array
    public void extendCapacity() {
        // create a new temporary array with double the capacity
        Person[] tempArray = new Person[size() * 2];
        System.out.println("Extending capacity to: " + tempArray.length);
        System.out.println("--------------------------------------------------");

        // copy elements from old array to temporary array
        copyArray(peopleArray, tempArray, peopleArray.length);

        // assign temporary array to peopleArray
        peopleArray = Arrays.copyOf(tempArray, tempArray.length);

        // update capacity
        capacity = calculateCapacity();
    }

    // determine whether the array can be reduced in size
    public boolean canReduceCapacity() {
        int minimumCapacity = (int) Math.ceil(elementsInArray(peopleArray) / 10.0) * 10;
        return size() > elementsInArray(peopleArray) && capacity > minimumCapacity;
    }

    // reduce capacity of array by 10
    public void reduceCapacity() {
        int minimumCapacity = (int) Math.ceil(elementsInArray(peopleArray) / 10.0) * 10;
        // create a new temporary array with reduced capacity to its minimum
        Person[] tempArray = new Person[minimumCapacity];
        System.out.println("Reducing capacity to: " + tempArray.length);
        System.out.println("--------------------------------------------------");

        // copy elements from old array to temporary array
        copyArray(peopleArray, tempArray, minimumCapacity);

        // assign temporary array to peopleArray
        peopleArray = Arrays.copyOf(tempArray, tempArray.length);

        // update capacity
        capacity = calculateCapacity();
    }

    // clear array
    public void clear() {
        System.out.println("Clearing array");
        System.out.println("--------------------------------------------------");
        // create a new empty array
        peopleArray = new Person[initialSize];
        // update capacity
        capacity = calculateCapacity();
        printArray();
    }

    private void copyArray(Person[] oldArray, Person[] newArray, int length) {
        // copy elements from old array to new array using System.arraycopy
        // (sourceArray, sourceStartIndex, destinationArray, destinationStartIndex, length (number of elements to copy))
        System.arraycopy(oldArray, 0, newArray, 0, length);
    }

    public int size() {
        return peopleArray.length;

    }

    public int elementsInArray(Person[] array) {
        int elements = 0;
        for (Person person : array) {
            if (person != null) {
                elements++;
            }
        }
        return elements;
    }

    private int calculateCapacity() {
        return peopleArray.length - elementsInArray(peopleArray);
    }

    // print persons in array
    public void printPersonsInArray() {
        for (Person person : peopleArray) {
            if (person != null) {
                System.out.println(person.getFullName());
            }
        }
        printArray();
    }

    // print array entries
    public void printArrayEntries() {
        for (Person person : peopleArray) {
            System.out.println(person);
        }
        System.out.println("--------------------------------------------------");
    }

    private void printArray() {
        System.out.println("Array size: " + size());
        System.out.println("Elements in array: " + elementsInArray(peopleArray));
        System.out.println("Capacity: " + capacity);
        System.out.println("--------------------------------------------------");
    }

}


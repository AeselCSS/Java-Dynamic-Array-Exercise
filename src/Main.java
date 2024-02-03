public class Main {
    public static void main(String[] args) {

        // === Create a few Person objects ===
        var p1 = new Person("Harry James Potter");
        var p2 = new Person("Ron Bilius Weasley");
        var p3 = new Person("Hermione", "Jean", "Granger");
        var p4 = new Person("Albus", "Percival Wulfric Brian", "Dumbledore");
        var p5 = new Person("Severus", "Snape");
        var p6 = new Person("Remus", "Lupin");
        var p7 = new Person("Sirius", "Black");
        var p8 = new Person("Peter", "Pettigrew");
        var p9 = new Person("Tom", "Marvolo", "Riddle");
        var p10 = new Person("Ginny", "Weasley");
        var p11 = new Person("Fred", "Weasley");
        var p12 = new Person("George", "Weasley");
        var p13 = new Person("Nymphadora", "Tonks");
        var p14 = new Person("Luna", "Lovegood");
        var p15 = new Person("Cedric", "Diggory");
        var p16 = new Person("Cho", "Chang");
        var p17 = new Person("Draco", "Malfoy");
        var p18 = new Person("Lucius", "Malfoy");
        var p19 = new Person("Narcissa", "Malfoy");
        var p20 = new Person("Bellatrix", "Lestrange");
        var p21 = new Person("Fleur Delacour");
        var p22 = new Person("Gabrielle", "Delacour");
        var p23 = new Person("Victoire", "Weasley");
        var p24 = new Person("Bill", "Weasley");
        var p25 = new Person("Charlie", "Weasley");
        var p26 = new Person("Percy", "Weasley");
        var p27 = new Person("Molly", "Weasley");
        var p28 = new Person("Arthur", "Weasley");
        var p29 = new Person("Neville", "Longbottom");
        var p30 = new Person("Lavender", "Brown");

        // === Create a dynamic array ===
        var peopleArray = new DynamicArray();

        //  === Test the dynamic array and its methods ===
        // add 5 people to the dynamic array
        peopleArray.add(p1, p2, p3, p4, p5);
        // add 5 more people to the dynamic array
        peopleArray.add(p6, p7, p8, p9, p10); // capacity is now 0
        peopleArray.add(p11); // adding an 11th person will extend the capacity of the array
        // insert a person at index 9
        peopleArray.insert(9, p12);
        // remove the last person from the array
        peopleArray.remove();
        // remove the person at index 9
        peopleArray.remove(9);
        // remove specific person from the array
        peopleArray.remove(p2);

        // check the array
        peopleArray.printPersonsInArray();
        peopleArray.printArrayEntries();

        // clear the array
        peopleArray.clear();

        // add 25 people to the dynamic array
        peopleArray.add(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25);
        // get the person at index 7
        System.out.println(peopleArray.get(7));
        // set the person at index 7
        peopleArray.set(7, p26);
        // get the person at index 7 again
        System.out.println(peopleArray.get(7));


    }
}
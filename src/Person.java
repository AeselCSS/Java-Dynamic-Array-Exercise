
    public class Person {
        private String firstName;
        private String middleName;
        private String lastName;
        private int age;

        public Person(String firstName, String middleName, String lastName, int age) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person(String firstName, String middleName, String lastName) {
            this(firstName, middleName, lastName, -1);
        }

        public Person(String firstName, String lastName, int age) {
            this(firstName, null, lastName, age);
        }

        public Person(String firstName, String lastName) {
            this(firstName, null, lastName, -1);
        }

        public Person(String fullName) {
            setFullName(fullName);
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getFullName() {
            return middleName != null ? firstName + " " + middleName + " " + lastName : firstName + " " + lastName;
        }

        public void setFullName(String fullName) {
            int firstSpace = fullName.indexOf(" ");
            int lastSpace = fullName.lastIndexOf(" ");

            this.firstName = fullName.substring(0, firstSpace);
            this.middleName = firstSpace != lastSpace ? fullName.substring(firstSpace + 1, lastSpace) : null;
            this.lastName = fullName.substring(lastSpace + 1);
        }
    }

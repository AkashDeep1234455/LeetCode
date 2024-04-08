class Solution {
    public static boolean check(Queue<Integer>students,int matchValue){
        while (!students.isEmpty()){
            if(matchValue==students.poll()){
                return true;
            }
        }
        return false;
    }
    public int countStudents(int[]students,int[]sandwiches){
        Queue<Integer> student = new LinkedList<>();
        for(int stud:students){
            student.add(stud);
        }
        int j = 0;
        Queue<Integer> copyStudent = new LinkedList<>();
        copyStudent.addAll(student);
        boolean someOneWant = check(copyStudent,sandwiches[j]);
        int size = student.size();
        while(someOneWant&&j<sandwiches.length){
            int availableSandwich = sandwiches[j];
            int studentChoice = student.poll();
            if(availableSandwich==studentChoice){
                j++;
            }else{
                student.add(studentChoice);
            }
            if(student.size()<size&&j<sandwiches.length) {
                copyStudent= new LinkedList<>();
                copyStudent.addAll(student);
                someOneWant = check(copyStudent,sandwiches[j]);
                size = student.size();
            }
        }
        return student.size();
    }
}
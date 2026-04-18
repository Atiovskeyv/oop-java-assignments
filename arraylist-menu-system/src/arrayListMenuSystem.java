// This program demonstrates basic ArrayList operations using a menu system.
// The user can add, delete, display, and search elements in the list with input validation.

void main(){
    boolean loopControl = true;
    ArrayList<String> list = new ArrayList<>();
    int count = 0;

    while(loopControl){
        IO.println("   Add element -> 1\n" +
                "   Remove element -> 2\n" +
                "   Display list -> 3\n" +
                "   Search element -> 4\n" +
                "   Exit -> 5\n");

        int operation;

        try {
            operation = Integer.parseInt(IO.readln("Select operation:"));
        }
        catch (NumberFormatException e) {
            IO.println("Please enter a valid number!");
            continue;
        }

        switch (operation){
            case 1:
                list.add(IO.readln("Enter element:"));
                count++;
                break;

            case 2:
                if (list.remove(IO.readln("Element to delete:"))){
                    IO.println("Item removed.");
                    count--;
                }
                else {
                    IO.println("Item not found.");
                }
                break;

            case 3:
                if (list.isEmpty()){
                    IO.println("List is empty.");
                    break;
                }
                for(int i = 0; i < list.size(); i++){
                    IO.print((i + 1) + "." + list.get(i) + " | ");
                }
                IO.println("\n");
                break;

            case 4:
                String search = IO.readln("Enter element to search:");
                if (list.contains(search)) {
                    IO.println("Element exists in the list.");
                }
                else{
                    IO.println("Element does not exist.");
                }
                break;

            case 5:
                IO.println("Total number of elements: " + count);
                loopControl = false;
                break;

            default:
                IO.println("Invalid input!");
        }
    }
}
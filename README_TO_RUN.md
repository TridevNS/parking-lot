Executable jar in target folder with main class Parking.java:-  E:\project_repository\parking-lot\target\parking-lot.jar
Input data path:-  E:\project_repository\parking-lot\data\input.txt

Note: Change path according to your ENV

How to run parking-lot.jar for interactive mode and for inputFile.

1. For inputFile as input

java  -jar E:\project_repository\parking-lot\target\parking-lot.jar E:\project_repository\parking-lot\data\input.txt

Created a parking lot with 6 slots
Allocated slot number: 1
Allocated slot number: 2
Allocated slot number: 3
Allocated slot number: 4
Allocated slot number: 5
Allocated slot number: 6
Slot number 4 is free
Slot No.        Registration No            Colour
1       KA01HH1234      White
2       KA01HH9999      White
3       KA01BB0001      Black
5       KA01HH2701      Blue
6       KA01HH3141      Black
Allocated slot number: 4
Sorry, parking lot is full
KA01HH1234 KA01HH9999 KA01P333
1 2 4
6
Not found


2. For interactive mode

java  -jar E:\project_repository\parking-lot\target\parking-lot.jar

Input:
create_parking_lot 6
Output:
Created a parking lot with 6 slots
Input:
park KA01HH1234 White
Output:
Allocated slot number: 1
Input:
park KA01HH9999 White
Output:
Allocated slot number: 2
Input:
park KA01BB0001 Black
Output:
Allocated slot number: 3
Input:
park KA01HH7777 Red
Output:
Allocated slot number: 4
Input:
park KA01HH2701 Blue
Output:
Allocated slot number: 5
Input:
park KA01HH3141 Black
Output:
Allocated slot number: 6
Input:
leave 4
Output:
Slot number 4 is free
Input:
status
Output:
Slot No.        Registration No            Colour
1       KA01HH1234      White
2       KA01HH9999      White
3       KA01BB0001      Black
5       KA01HH2701      Blue
6       KA01HH3141      Black
Input:
park KA01P333 White
Output:
Allocated slot number: 4
Input:
park DL12AA9999 White
Output:
Sorry, parking lot is full
Input:
registration_numbers_for_cars_with_colour White
Output:
KA01HH1234 KA01HH9999 KA01P333
Input:
slot_numbers_for_cars_with_colour White
Output:
1 2 4
Input:
slot_number_for_registration_number KA01HH3141
Output:
6
Input:
slot_number_for_registration_number MH04AY1111
Output:
Not found
Input:




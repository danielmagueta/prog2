package GTA.E02;


import static java.lang.System.*;

public class House {

  public House(String houseType,int maxSize,int extensionSize) {
    this.houseType = houseType;
    this.extensionSize = extensionSize;
    rooms = new Room[maxSize];
    size = 0;
    doors = new Door[maxSize];
    numDoors = 0;
  }

  public House(String houseType) {
    this(houseType,8,4);
  } 

  public int size() {
    return size;
  }

  public int maxSize() {
    return rooms.length;
  }

  public Room room(int i) {
    return rooms[i];
  }

  public int addRoom(Room r) {
    if (size == rooms.length) extendHouse();
    rooms[size] = r;
    size++;
    return rooms.length -1;
  }

  private void extendHouse() {
    Room [] newRooms = new Room[rooms.length+extensionSize];
    arraycopy(rooms, 0, newRooms, 0, rooms.length);
    rooms = newRooms;
  } 

  @SuppressWarnings("unused")
  private String houseType;
  private int extensionSize;
  private Room [] rooms;
  private int size;
  private Door [] doors;
  private int numDoors;

  public void addDoor(Door d) {
    if (numDoors == doors.length) {
    	Door[] doorscopy = new Door[doors.length + extensionSize];
    	int i = 0;
    	for (Door dr: doors) {
    		doorscopy[i] = dr;
    		i ++;
    	}
    	doors = doorscopy;	
    }
	doors[numDoors] = d;
    numDoors++;
  }

  public int numDoors() {
    return numDoors;
  }

  public int maxNumDoors() {
    return doors.length;
  }

  public int roomClosestToRoomType(String roomType) {
	
	  double distance = Double.MAX_VALUE;
	  int id = 0;
	  Room rd = null;
	  for (int i = 0; i<size; i++) {
		  rd = rooms[i];
		  if(rd.roomType() == roomType) {
			 break;
		  }
	  }
		  
	  for (int j = 0; j < size(); j++) {
		  Point p1 = rooms[j].geomCenter();
		  Point p2 = rd.geomCenter();
		  double d = p1.distTo(p2);
		  if (d<distance && rooms[j].roomType()!=rd.roomType()) {
			  distance = d;
			  id = j;
		  }
	  }  
	  
	  return id;
	}

  
  public int maxDoorsInAnyRoom() {
	  int maxportas = 0;
	  
	  for (int i = 0; i < numDoors; i++) {
		  int count = 0;
		  int count2 = 0;
		  Door d_a = doors[i];
		  for (int j = 0; j < numDoors; j++){
			  
			  Door d_b = doors[j];
			  if(d_a.getr1()==d_b.getr1()||d_a.getr1()==d_b.getr2()) {
				  count++;
			  }
			  if(d_a.getr2()==d_b.getr1()||d_a.getr2()==d_b.getr2()) {
				  count2++;
			  }
		  }
		  if(count > maxportas) {maxportas = count;}
		  if(count2 > maxportas) {maxportas = count2;}
	  }
	  return maxportas;
  }


}


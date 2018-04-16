package aula03.ex05;

public class House {
	
	@SuppressWarnings("unused")
	private String tipo;
	private Room rooms[];
	private int ext, size;
	
	
	public House(String tipo) {
		this.tipo = tipo;
		rooms = new Room[8];
		this.ext = 4;	
	}
	
	public House(String tipo, int nd, int ext) {
		this.tipo = tipo;
		rooms = new Room[nd];
		this.ext = ext;
	}
	
	public void addRoom(Room r) {
		if(size() == maxSize()) {
			Room copy[] = new Room[maxSize() + ext];
			for (int i = 0; i<rooms.length; i++) {
				copy[i] = rooms[i];
			}
			rooms = copy;
		}
		rooms[size] = r;
		size++;
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
	
	public double area() {
		double area = 0;
		for (int i = 0; i < size(); i++) {
			area += rooms[i].area();
		}
		return area;
	}
	
	public RoomTypeCount[] getRoomTypeCounts() {
		RoomTypeCount rtc[] = new RoomTypeCount[0];
		for (int i = 0; i < size(); i++) {
			int flag = 0;
			for (int j = 0; j < rtc.length; j++) {
				if(rooms[i].roomType()==rtc[j].roomType) {
					rtc[j].count ++;
					flag =1;
				}
			}
			if(flag == 0) {rtc = addRTC(rooms[i].roomType(), rtc);}
		}
		return rtc;
	}
	
	public RoomTypeCount[] addRTC(String type, RoomTypeCount[] rtc) {
		RoomTypeCount copy[] = new RoomTypeCount[rtc.length+ 1];
		for(int i = 0; i < rtc.length; i++) {
			copy[i] = rtc[i];
		}
		RoomTypeCount a = new RoomTypeCount();
		copy[rtc.length] = a;
		copy[rtc.length].roomType = type;
		copy[rtc.length].count = 1;
		return copy;
	}
	
	public Double averageRoomDistance() {
		double somatorio = 0;
		double count = 0;
		for (int i = 0; i < size()-1; i++) {
			for (int j = i+1; j < size; j++) {
				double dist = rooms[i].geomCenter().distTo(rooms[j].geomCenter());
				somatorio += dist;
				count++;
				}	
		}
		double media = somatorio/count;
		return media;
	}
	
	
	
	
	
}

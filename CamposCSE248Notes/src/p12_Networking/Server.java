package p12_Networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ArrayList<String> list = new ArrayList<>();
		list.add("Adam");
		list.add("Bill");
		list.add("Cathy");
		ServerSocket listener = new ServerSocket(1024);
		System.out.println("Waiting for request...");
		Socket socket = listener.accept();
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		System.out.println("Sending out an object");
		oos.writeObject(list);
		oos.flush();
		ArrayList<String> list2 = (ArrayList<String>) ois.readObject();
		System.out.println(list2);
	}

}

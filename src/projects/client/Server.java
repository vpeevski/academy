package projects.client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9000);
        try {
            while (true) {
                Socket socket = listener.accept();
                Thread requestThread = new Thread(new Request(socket));
                requestThread.start();
            }
        }
        finally {
            listener.close();
        }
    }
    
    private static class Request implements Runnable {
    	
    	private Socket socket;
    	
    	public Request (Socket socket) {
    		this.socket = socket;
    	}

		@Override
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				//log here
			}
			
			try {
                ObjectOutputStream out;
				try {
					out = new ObjectOutputStream(socket.getOutputStream());
					out.writeObject(new Date());
				} catch (IOException e) {
					//log here
				}
                
            } finally {
                try {
					socket.close();
				} catch (IOException e) {
					// log here
				}
            }
			
		}
    	
    }
}
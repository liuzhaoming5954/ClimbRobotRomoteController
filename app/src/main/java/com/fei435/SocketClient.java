package com.fei435;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

public class SocketClient {
	static Socket client = null;

	public SocketClient(String site, int port) throws UnknownHostException,IOException{

		//client = new Socket(site, port);
		client = new Socket();
		SocketAddress sa = new InetSocketAddress(site, port);
		client.connect(sa, Constant.SOCKET_TIMEOUT);
		Log.i("socket","Client is created! site:"+site+" port:"+port);
	}

	public void sendMsg(byte[] msg) {
		try {
			OutputStream out = client.getOutputStream();
			out.write(msg);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void closeSocket() {
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public InputStream getInputStream () {
		if (client != null) {
			try {
				return client.getInputStream();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public OutputStream getOutputStream () {
		if (client != null) {
			try {
				return client.getOutputStream();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

//	public static void main(String[] args) throws Exception {
//
//	}

}
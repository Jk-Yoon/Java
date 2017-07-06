package application;

import java.net.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.*;
public class  UploadServer { 
	//���솕紐� , �겢�씪�씠�뼵�듃�쓽 Scoket�씠 ���옣�맂 Map�젙�쓽
	Map<String,Socket> clients;

	public UploadServer(){
		clients=Collections.synchronizedMap(new HashMap<String,Socket>());
	}
	public void sendToAll(String fileName, InputStream is){
		//Map�뿉 ���옣�맂 紐⑤뱺 �궎媛�(���솕紐�)�쓣 援ы븳�떎.
		Iterator<String> it = clients.keySet().iterator();
		
		File f;
		
		// 諛섎났臾몄쓣 �씠�슜�븯�뿬 �궎媛믪뿉 �빐�떦�븯�뒗 �냼耳볦쓣 援ы븯怨�
		// �빐�떦 �냼耳볦뿉 硫붿떆吏�瑜� 蹂대궦�떎.
		while (it.hasNext()) {
			try {
				String name = it.next(); //  �궎媛�(���솕紐�)
				Socket soc = clients.get(name);
				f=new File("D:/A_TeachingMaterial/3.HighJava/workspace/StyleCloset/src/images",fileName);
				FileOutputStream out=new FileOutputStream(f);
				/* 蹂대궡�삩 �뙆�씪�쓽 �걹源뚯� �씫�뼱�꽌 �뙆�씪濡� �� */
				int i=0;
				while((i=is.read())!=-1){
					out.write((char)i);
				}

				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
	}


	public  void serverStart(){
		ServerSocket serverSoc = null;
		Socket socket = null;
		
		try {
			serverSoc = new ServerSocket(8888);
			System.out.println("�꽌踰꾧� �떆�옉�릺�뿀�뒿�땲�떎.");
			
			while (true) {
				//�겢�씪�씠�뼵�듃�쓽 �젒�냽�쓣 湲곕떎由곕떎.
				socket = serverSoc.accept();
				System.out.println("[" +  socket.getInetAddress() + 
						":" + socket.getPort() + "]" + "�뿉�꽌 �젒�냽�븯���뒿�땲�떎.");
			}
		} catch (Exception e) {
			if(serverSoc != null)
				try {
					serverSoc.close();
				} catch (Exception e2) {
					
				}
		}
	}
	class ServerReveiver extends Thread{
		Socket socket;
		InputStream is;
		DataInputStream dis;
		DataOutputStream dos;
		BufferedReader br;
		
		public ServerReveiver(Socket s){
			socket = s;
			try {
				//�겢�씪�씠�뼵�듃 �냼耳볦뿉�꽌 蹂대궡�삩 硫붿떆吏�瑜� 諛쏆쓣 InputStream�깮�꽦
				is =socket.getInputStream();
				dis = new DataInputStream(socket.getInputStream());
				// �겢�씪�씠�뼵�듃 �냼耳볦쑝濡� 硫붿떆吏�瑜� �쟾�넚�븯湲� �쐞�븳 OutputStream�깮�꽦
				br=new BufferedReader(new InputStreamReader(is));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		
		
		public void run(){
			String name = "";
			try {
				// �꽌踰꾩뿉�꽌�뒗 理쒖큹�뿉 �겢�씪�씠�뼵�듃媛� 蹂대궦 ���솕紐낆쓣 諛쏅뒗�떎.
				name = dis.readUTF();
				String fileName=br.readLine();
				// �엯�젰 諛쏆� ���솕紐낆쓣 紐⑤뱺 �겢�씪�씠�뼵�듃�뿉寃� 蹂대궦�떎.
				// Map�뿉 �젒�냽�븳 ���솕紐낃낵 �냼耳볦쓣 ���옣�븳�떎.
				clients.put(name, socket);
				System.out.println("�쁽�옱 �꽌踰� �젒�냽�옄 �닔�뒗 " + clients.size() + "紐� �엯�땲�떎.");
				
				// �겢�씪�씠�뼵�듃媛� �쟾�넚�븳 硫붿꽭吏�瑜� 紐⑤뱺 �겢�씪�씠�뼵�듃�뿉寃� 蹂대궦�떎.
				while (br!=null) {
					sendToAll(fileName,is);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}  finally{
	            //�씠 finally媛� �떎�뻾�맂�떎�뒗 寃껋��겢�씪�씠�뼵�듃媛� �젒�냽�쓣 醫낅즺�뻽�떎�뒗 嫄곗쓣 �쓽誘�
	            //Map�뿉�꽌 �궘�젣�븳�떎.
	            clients.remove(name);
	            System.out.println();
	            System.out.println("["+ socket.getInetAddress()+":"+ socket.getPort()+"]"+"�뿉�꽌 醫낅즺�븯�뀲�뒿�땲�떎.");
	            System.out.println("�쁽�옱 �꽌踰� �젒�냽�옄�닔�뒗 "+ clients.size()+"紐� �엯�땲�떎.");
	            System.out.println();
	         }
		}
		
	}
}

